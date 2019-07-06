package nowcoder.offer;

import java.util.*;

/**
 * 在一个字符串(0<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingCharImpl {

    public static void main(String[] args) {
        String str = "zzzzzzzjzzzza";
        System.out.println(new FirstNotRepeatingCharImpl().FirstNotRepeatingChar(str));
    }

    public int FirstNotRepeatingChar(String str) {

        int[] index = new int[256];

        for (int i=0; i<str.length(); i++) {
            index[str.charAt(i)]++;
        }

        for (int i=0; i<str.length(); i++) {
            if (index[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;

    }

}
