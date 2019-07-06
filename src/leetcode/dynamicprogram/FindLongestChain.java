package leetcode.dynamicprogram;

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。
 * 我们用这种形式来构造一个数对链。
 * 给定一个对数集合，找出能够形成的最长数对链的长度。
 * 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 */
public class FindLongestChain {

    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}, {0,1}};
        Solution s = new Solution();
        s.sort(pairs);
        System.out.println(s.findLongestChain(pairs));
    }

    private static class Solution {

        // 使用贪心算法，先对数对的第二项排序，依次选取数对的第一个大于上一个尾部，
        public int findLongestChain(int[][] pairs) {
            // 按照尾部排序
            sort(pairs);
            // 第一次选出一个
            int count = 1;
            int[] pre = pairs[0];

            for (int i=1; i<pairs.length; i++) {
                if (pre[1] < pairs[i][0]) {
                    count++;
                    pre = pairs[i];
                }
            }

            return count;
        }

        // 直接插入排序
        public void sort(int[][] arr) {

            for (int i=1; i<arr.length; i++) {
                // i 向前移动
                if (arr[i][1] < arr[i-1][1]) {
                    int[] temp = arr[i];
                    int j = i-1;
                    for (; j>=0 && arr[j][1]>temp[1]; j--) {
                        arr[j+1] = arr[j];
                    }
                    arr[j+1] = temp;
                }
            }

        }

    }

}
