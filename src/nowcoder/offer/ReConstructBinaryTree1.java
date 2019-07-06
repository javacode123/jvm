package nowcoder.offer;

import nowcoder.T;

import java.util.HashMap;

/**
 * 输入某二叉树的后序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的后序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入后序遍历序列{7,4,2,5,8,6,3,1,}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree1 {

    public static void main(String[] args) {
        int[] back = {7,4,2,5,8,6,3,1}, in = {4,7,2,1,5,3,8,6};
        TreeNode root = new ReConstructBinaryTree1().reConstructBinaryTree(back, in, 0,
                in.length-1, 0);
        print(root);
    }

    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + ",");
            print(root.right);


        }
    }

    /**
     *
     * @param back
     * @param in
     * @param left 后序遍历中子树的 起点
     * @param right 后序遍历中字数的 终点
     * @param p 中序遍历子树的起点位置
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] back, int[] in, int left, int right, int p) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(back[right]);
        int i = p;
        for (; i<in.length; i++) {
            if (in[i] == node.val)
                break;
        }
        int leftSize = i-p;
        node.left = reConstructBinaryTree(back, in, left,left+leftSize-1, p);
        node.right = reConstructBinaryTree(back, in, left+leftSize, right-1,p+leftSize+1);
        return node;
    }


}
