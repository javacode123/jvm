package nowcoder.offer;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,
 * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class InversePairsImpl {

    private int count = 0;

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.print(new InversePairsImpl().InversePairs(array));
    }

    public int InversePairs(int [] array) {
        sort(array, 0, array.length-1);
        return this.count%1000000007;
    }

    public void sort(int[] array, int l, int h) {
        if (l < h) {
            int mid = (l+h)/2;
            sort(array, l, mid);
            sort(array,mid+1, h);
            merg(array, l, mid, h);
        }
    }

    /** 合并两个有序数组 **/
    public void merg(int[] array, int l, int mid, int h) {
        int[] temp = Arrays.copyOf(array, array.length);
        int index = l, l2 = mid+1;

        while (l<=mid && l2<= h) {
            if (temp[l] < temp[l2]) {
                array[index++] = temp[l++];
            } else {
                count += mid-l+1;
                array[index++] = temp[l2++];
            }
        }

        while (l <= mid) {
            array[index++] = temp[l++];
        }

        while (l2 <= h) {
            array[index++] = temp[l2++];
        }

    }

}
