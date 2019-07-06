package nowcoder.offer;

/**
     把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
     该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int[] array = {3,4,5,6,1,2};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
    }

    // 利用二分查找,
    // 对与 {1,1,0,1,1} 顺序查找
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1, mid;

        while (low < high) {
            mid = (low+high) / 2;
            // 最小值一定在左边
            if (array[mid] < array[high]) {
                high = mid;
            } else if (array[mid] == array[high] && array[low] == array[mid]) {
                return findMinNum(array, low, high);
            } else {
                low = mid+1;
            }
        }

        return array[low];

    }

    private int findMinNum(int[] array, int l, int high) {
        for (int i=l; i<high; i++) {
            if (array[i] > array[i+1]) {
                return array[i+1];
            }
        }

        return array[l];

    }

    // 从后往前寻找最小值
    public int minNumberInRotateArray1(int [] array) {

        if (array.length == 0) {
            return 0;
        }
        int k = array.length - 1;
        for (int i=k-1; i>=0; i--) {
            if (array[k] < array[i]) {
                break;
            }
            k--;
        }

        return array[k];

    }

}
