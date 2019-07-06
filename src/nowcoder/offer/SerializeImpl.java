package nowcoder.offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeImpl {

    private String str;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + " " + Serialize(root.left) + " " +Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        this.str = str;
        return Deserialize();
    }

    TreeNode Deserialize() {
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return null;
        }
        int index = str.indexOf(" ");
        String node = index==-1 ? str : str.substring(0, index);
        str = index==-1 ? "" : str.substring(index+1);
        if (node.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize(str);
        t.right = Deserialize(str);
        return t;
    }

}
