package nowcoder.offer;

import nowcoder.T;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8}, in = {4,7,2,1,5,3,8,6};
        TreeNode root = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
        print(root);
    }

    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            print(root.right);
            System.out.print(root.val + ",");

        }
    }

    // 快速索引指定元素的下标
    private java.util.HashMap<Integer, Integer> h = new java.util.HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        for (int i=0; i<in.length; i++) {
            h.put(in[i], i);
        }

        return conStructBinaryTree(pre, 0, pre.length-1, 0);

    }

    /**
     *
     * @param preL 先序遍历中，树的起点
     * @param preR 先序遍历中，树的终点
     * @param preO 中序遍历中，树的起点
     */
    public TreeNode conStructBinaryTree(int[] pre, int preL, int preR, int preO) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        // 查找索引，在中序遍历中将 root 分为左子树和右子树
        int index = h.get(pre[preL]);
        // 子树的大小
        int leftSize = index - preO;
        root.left = conStructBinaryTree(pre, preL+1, preL+leftSize, preO);
        root.right = conStructBinaryTree(pre, preL+leftSize+1, preR, preO+leftSize+1);

        return root;

    }

}
