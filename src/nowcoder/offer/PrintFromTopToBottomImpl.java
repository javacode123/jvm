package nowcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottomImpl {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
       // root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        ArrayList<Integer> a = new PrintFromTopToBottomImpl().PrintFromTopToBottom(root);
        for (Integer num : a) {
            System.out.println(num);
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);
        TreeNode temp;

        while (!q.isEmpty()) {
            temp = q.pop();
            if (temp != null) {
                list.add(temp.val);
                q.addLast(temp.left);
                q.addLast(temp.right);
            }
        }

        return list;

    }

}
