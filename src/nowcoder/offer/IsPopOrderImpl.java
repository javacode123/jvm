package nowcoder.offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrderImpl {

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5}, pop = {4,5,3,0,1};
        System.out.println(new IsPopOrderImpl().IsPopOrder(push, pop));
    }

    // 使用一个栈用来不但压入, 判断是否需要弹出
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();

        for (int pushIndex=0, popIndex=0; pushIndex<pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (popIndex<popA.length && stack.peek().equals(popA[popIndex])) {
                stack.pop();
                popIndex++;
            }
        }


        return stack.isEmpty();

    }

}
