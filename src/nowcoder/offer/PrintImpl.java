package nowcoder.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintImpl {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        ArrayList<ArrayList<Integer>> ret = new PrintImpl().Print(root);
        for (ArrayList<Integer> list : ret) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }

    // 思路: 对层遍历的改进
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();
            TreeNode t = null;

            while (count > 0) {
                t = queue.pop();
                if (t == null) {
                    count--;
                   continue;
                } else {
                    list.add(t.val);
                    queue.add(t.left);
                    queue.add(t.right);
                    count--;
                }
            }

            if (reverse) {
                Collections.reverse(list);
            }
            if (list.size() != 0) {
                ret.add(list);
            }
            reverse = !reverse;
        }

        return ret;

    }

}
