package nowcoder.offer;

import nowcoder.T;

import java.util.IllegalFormatCodePointException;

public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    private class Solution {

        // 二叉树的深度
        public int TreeDepth(TreeNode root) {

            if (root==null) {
                return 0;
            } else {
                return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
            }

        }

        // 判断二叉树是不是平衡二叉树
        public boolean IsBalanced_Solution(TreeNode root) {

            if (root == null) {
                return true;
            }

            if (Math.abs(TreeDepth(root.left)-TreeDepth(root.right)) > 1) {
                return false;
            }

            return IsBalanced_Solution(root.right) && IsBalanced_Solution(root.left);

        }

        public void Mirror(TreeNode root) {

            if (root == null) {
                return;
            }

            Mirror(root.left);
            Mirror(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

        }

        // 二叉树是不是对称的
        public boolean isSymmetrical(TreeNode pRoot) {
            if (pRoot == null) {
                return true;
            }
            return f(pRoot.left, pRoot.right);
        }

        public boolean f(TreeNode right, TreeNode left) {
            if (right==null && left==null) {
                return true;
            }
            if (right!=null && left!=null) {
                return right.val==left.val && f(right.right, left.left) &&
                        f(right.left, left.right);
            }
            return false;
        }

    }

}

