package nowcoder.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPathImpl {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        backTracking(root, target, path);
        return ret;
    }

    public void backTracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        target -= node.val;

        if (target==0 && node.right==null && node.left==null) {
            ret.add(new ArrayList<>(path));
        } else {
            backTracking(node.left, target, path);
            backTracking(node.right, target, path);
        }

        path.remove(path.size()-1);

    }

}
