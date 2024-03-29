package leetcode.dynamicprogram;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class MaxProfit {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {1,2,3,4,5};
        System.out.println(s.maxProfit1(prices));
    }

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格
     */
    private static class Solution {

        /**
         * 思路：p[j] 表示第 j 天的利润，max(prices[j]-min(prices[0..j-1]), p[j-1])
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices, int low, int high) {

            if (prices==null || prices.length == 0) {
                return 0;
            }
            int minPrice = prices[low], maxProfit = 0;

            for (int i=low; i<high; i++) {
                maxProfit = Math.max(maxProfit, prices[i]-minPrice);
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }

            }

            return maxProfit;

        }

        /**
         * 可以进行两笔交易，但必须出售之后交易
         *
         * 输入: [3,3,5,0,0,3,1,4]
         * 输出: 6
         * 解释: 在第 4 天（股票价格 = 0）的时候买入，
         *      在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
         *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，
         *      这笔交易所能获得利润 = 4-1 = 3 。
         *
         * 输入: [1,2,3,4,5]
         * 输出: 4
         * 解释: 在第 1 天（股票价格 = 1）的时候买入，
         *      在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
         *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
         */
        public int maxProfit1(int[] prices) {
            if (prices==null || prices.length == 0) {
                return 0;
            }

            int maxProfit = 0;
            for (int i=0; i<prices.length; i++) {
                maxProfit = Math.max(maxProfit, maxProfit(prices,0, i)+maxProfit(prices, i, prices.length));
            }

            return maxProfit;

        }

    }

}
