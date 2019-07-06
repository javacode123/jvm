package leetcode.dynamicprogram;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring,
 *              "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("ay"));
    }

    public static class Solution {

        // 使用滑动窗口 [i,j), 对于新来的元素 j, 如果窗口包含 j, 继续向右滑动
        public int lengthOfLongestSubstring(String s) {
            if (s==null) {
                return 0;
            }

            int max = 0, i = 0, j = 0;
            Set<Character> set = new HashSet<>();
            while (j<s.length() && i<s.length()) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    max = Math.max(max, set.size());
                } else {
                    set.remove(s.charAt(i++));
                }
            }

            return max;

        }

    }
}
