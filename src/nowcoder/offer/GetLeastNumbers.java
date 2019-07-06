package nowcoder.offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {

    // 利用快排的思想, 快排可以确定第 j 个位置, 第 j 个前面都是比 j 小的
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (k > input.length || k <= 0)
            return arr;
        finKmin(input, k);

        for (int i=0; i<k; i++) {
            arr.add(input[i]);
        }

        return arr;
    }

    private void finKmin(int[] nums, int k){
        int l = 0, h = nums.length-1;
        while (l < h) {
            int p = partion(nums, l, h);
            if (k == p)
                break;
            if (p < k) {
                l = p+1;
            } else {
                h = h-1;
            }
        }
    }

    private int partion(int[] nums, int low, int high) {
        int temp = nums[low];

        while (low < high) {
            while (low<high && nums[high]>=temp)
                high--;
            nums[low] = nums[high];
            while (low<high && nums[low]<=temp)
                low++;
            nums[high] = nums[low];
        }

        nums[low] = temp;

        return low;

    }

}
