package sort;

/**
 * 折半插入排序：对直接插入排序的优化，减少插入排序的比较次数，但是移动次数并没有变化
 */
public class binarySort {

    public static void main(String[] args) {
        int arr[] = new int[]{13,5,3,1,0,20};
        sort(arr);
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 折半插入排序
    public static void sort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int low = 0, high = i-1, mid, temp = arr[i];
            while (low <= high) {
                mid = (low+high)/2;
                if (arr[mid] > temp) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            // 得到的low是第一个大于关键字的位置
            for (int j=i; j>low; j--) {
                arr[j] = arr[j-1];
            }

            arr[low] = temp;

        }
    }

}
