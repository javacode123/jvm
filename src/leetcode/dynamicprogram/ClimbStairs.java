package leetcode.dynamicprogram;

import java.util.Scanner;

public class ClimbStairs {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        str = str.substring(1, str.length()-1);
        String[] strArr = str.split(",");
        int[] n = new int[strArr.length];

        for (int i=0; i<strArr.length; i++) {
            n[i] = Integer.valueOf(strArr[i].trim());
        }

        System.out.println(Solution.minCostClimbingStairs(n));

    }

    private static class Solution {

        /**
         * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
         * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
         * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
         * 输出: 6
         * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
         */
        public static int minCostClimbingStairs(int[] cost) {
            // r[i] 表示最后一步踩到第 i 个阶梯的花费值
            int[] r = new int[cost.length+1];
            r[0] = 0;
            r[1] = cost[0];

            for (int i=2; i<=cost.length; i++) {
                // 判断第 i-1 个楼梯是否还需要踩
                r[i] = Math.min(r[i-1]+cost[i-1], r[i-2]+cost[i-1]);
            }

            return r[r.length-1] > r[r.length-2] ? r[r.length-2] : r[r.length-1];

        }

        /**
         * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
         * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
         * 注意：给定 n 是一个正整数。
         * 输入： 3
         * 输出： 3
         * 解释： 有三种方法可以爬到楼顶。
         * 1.  1 阶 + 1 阶 + 1 阶
         * 2.  1 阶 + 2 阶
         * 3.  2 阶 + 1 阶
         */
        public static int climbStairs(int n) {

            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            int[] m = new int[n+1];
            m[1] = 1; m[2] = 2;

            for (int i=3; i<=n; i++) {
                m[i] = m[i-1] + m[i-2];
            }

            return m[n];

        }

    }


}
