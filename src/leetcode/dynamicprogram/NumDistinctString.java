package leetcode.dynamicprogram;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * 例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 *      如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 *      (上箭头符号 ^ 表示选取的字母)
 *      rabbbit
 *      ^^^^ ^^
 *      rabbbit
 *      ^^ ^^^^
 *      rabbbit
 *      ^^^ ^^^
 */
public class NumDistinctString {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDistinct("rabbbit", "rabbit"));
    }

    private  static class Solution {

        public int numDistinct(String S, String T) {
            if (S == null || T == null) {
                return 0;
            }

            int slen = S.length();
            int tlen = T.length();
            int[][] count = new int[slen + 1][tlen + 1];
            for (int i = 0; i <= slen; i++) {
                count[i][0] = 1;
            }

            for (int i = 1; i <= slen; i++) {
                for (int j = 1; j <= tlen; j++) {
                    count[i][j] = count[i - 1][j];
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        count[i][j] += count[i - 1][j - 1];
                    }
                }
            }

            return count[slen][tlen];

        }
    }

}
