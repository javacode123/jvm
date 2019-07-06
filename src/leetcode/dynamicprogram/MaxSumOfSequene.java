package leetcode.dynamicprogram;

import java.util.Scanner;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class MaxSumOfSequene {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.substring(1, str.length()-1);
        String[] strArr = str.split(",");
        int[] n = new int[strArr.length];

        for (int i=0; i<strArr.length; i++) {
            n[i] = Integer.valueOf(strArr[i].trim());
        }

        System.out.println(Solution.maxSubArray(n));

    }

    private static class Solution {

        public static int maxSubArray(int[] nums) {

            // r[i] 表示以 i 为连续子数组结尾的最大和
            // 如果 r[i-1] < 0, r[i] = nums[i]
            // 否则 r[i] = r[i-1] + nmus[i]
            int[] r = new int[nums.length+1];
            int max = Integer.MIN_VALUE;
            r[0] = 0;

            for (int i=1; i<=nums.length; i++) {
                if (r[i-1] >= 0) {
                    r[i] = r[i-1] + nums[i-1];
                } else {
                    r[i] = nums[i-1];
                }
                max = Math.max(max, r[i]);
            }

            return max;

        }

    }

}
