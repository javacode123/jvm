package leetcode.strprocess;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> s = new GenerateParenthesis().generateParenthesis(3);
        for (String temp: s) {
            System.out.println(temp);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", n, n);

        return res;
    }
    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res , String ans, int leftCount, int rightCount){

        if(leftCount == 0 && rightCount == 0) res.add(ans);

        if (leftCount > 0){
            generate(res, ans+"(", leftCount-1, rightCount);
        }

        if (leftCount < rightCount) {
            generate(res, ans+")", leftCount, rightCount-1);
        }

    }

}
