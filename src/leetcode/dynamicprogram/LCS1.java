package leetcode.dynamicprogram;

import java.util.Stack;

/**
 * 最长单调递增子序列
 * 是否具有最优子结构，是否重复子解
**/
public class LCS1 {

    public static void main(String[] args) {
        int arry[] = {9,1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arry));
        print(arry, getR(arry));
    }

    // r[i] 表示数组 a[i] 结尾的最长递增单调子序列
    // r[0] 即表示 arry[0] 为 1
    // r[i] 就等于在 arry[0...i-1] 中选出比 arry[i] 小且长度最长的 r[j], r[i] = max(r[0...i-1], r[j]+1)
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int r[] = new int[nums.length];
        r[0] = 1;

        for (int i=1; i<nums.length; i++) {
            r[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) { // 选出比 arry[i] 小的数且 r[j] 最大
                    r[i] = Math.max(r[j]+1, r[i]);
                }
            }
        }

        int k = 1;
        for (int i=0; i<r.length; i++) {
            if (r[i] > k) {
                k = r[i];
            }
        }

        return k;
    }

    public static int[] getR(int[] nums) {

        int r[] = new int[nums.length];
        r[0] = 1;

        for (int i=1; i<nums.length; i++) {
            r[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) { // 选出比 arry[i] 小的数且 r[j] 最大
                    r[i] = Math.max(r[j]+1, r[i]);
                }
            }
        }

        return r;
    }

    /**
     *
     * @param nums 数列数组
     * @param r 更新表
     */
    public static void print(int[] nums, int r[]) {
        int k = 0; // 最大值下标
        Stack<Integer> s = new Stack<Integer>();

        for (int i=0; i<r.length; i++) {
            if (r[i] > r[k]) {
                k = i;
            }
        }

        s.push(nums[k]);

        for (int i=k; i>0; i--) {
            if (nums[i]>nums[i-1] && r[i]==(r[i-1]+1)) {
                s.push(nums[i]);
            }
        }

        // 寻找第一个数
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < s.peek()) {
                s.push(nums[i]);
                break;
            }
        }

        while (!s.empty()) {
            System.out.print(s.pop()+" ");
        }

    }

}
