package nowcoder.offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class StackImpl {

    private Stack<Integer> defaultStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        defaultStack.push(node);
        minStack.push(minStack.empty() ? node : Math.min(node, minStack.peek()));
    }

    public void pop() {
        defaultStack.pop();
        minStack.pop();
    }

    public int top() {
        return defaultStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
