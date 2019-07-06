package nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class PermutationImpl {

    public static void main(String[] args) {
        System.out.println(new PermutationImpl().Permutation("acc"));
    }


    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str==null || str.length()==0) {
            return ret;
        }
        boolean[] hasUsed = new boolean[str.length()];
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTrack(new StringBuilder(), hasUsed, chars);
        return ret;

    }

    private void backTrack(StringBuilder s, boolean[] hasUsed, char[] chars) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }

        for (int i=0; i<chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 字符串中间有重复, 重复字母的前一个字母没有在序列中, 则表示第二次排序
            if (i!=0 && chars[i]==chars[i-1] && !hasUsed[i-1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backTrack(s, hasUsed, chars);
            s.deleteCharAt(s.length()-1);
            hasUsed[i] = false;
        }

    }

}
