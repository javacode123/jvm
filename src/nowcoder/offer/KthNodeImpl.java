package nowcoder.offer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNodeImpl {

    private int count = 0;
    private TreeNode ret = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        inOrder(node.left, k);

        count++;
        if (count == k) {
            ret = node;
            return;
        }

        inOrder(node.right, k);
    }


}
