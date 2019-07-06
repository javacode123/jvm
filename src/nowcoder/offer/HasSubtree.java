package nowcoder.offer;

public class HasSubtree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        System.out.println(new HasSubtree().isSubTree(root1, root2));

    }


    public boolean isSubTree(TreeNode t1, TreeNode t2) {

        if (t2 == null) {
            return true;
        }

        if (t1 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        } else {
            return isSubTree(t1.right, t2.right) && isSubTree(t1.left, t2.left);
        }

    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {

        if (root2 == null || root1 == null) {
            return false;
        }

        return isSubTree(root1, root2) && hasSubtree(root1.right, root2.right) &&
                hasSubtree(root1.left, root2.left);

    }

}
