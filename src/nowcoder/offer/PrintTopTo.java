package nowcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTopTo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        ArrayList<ArrayList<Integer>> ret = new PrintTopTo().Print(root);
        for (ArrayList<Integer> list : ret) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> quene = new LinkedList<>();
        TreeNode t = null;
        quene.add(pRoot);

        while (!quene.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = quene.size();

            while (count > 0) {
                t = quene.pop();
                count--;
                if (t == null) {
                    continue;
                } else {
                    list.add(t.val);
                    quene.add(t.left);
                    quene.add(t.right);
                }
            }
            if (list!=null && list.size() != 0) {
                ret.add(list);
            }

        }

        return ret;

    }

}
