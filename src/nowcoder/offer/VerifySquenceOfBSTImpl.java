package nowcoder.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBSTImpl {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        System.out.println(new VerifySquenceOfBSTImpl().VerifySquenceOfBST(arr));
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length==0) {
            return false;
        }
        return verify(sequence, 0, sequence.length-1);
    }

    // 根据二叉搜索数的性质, 末尾为子树根节点, 有一个中间位置, low-mid 小于根节点
    // mid-high 大于根节点, 递归寻找
    public boolean verify(int[] sequence, int low, int high) {
        if (low >= high) {
            return true;
        }

        int mid = low;

        while (mid <= high) {
            if (sequence[mid] < sequence[high]) {
                mid++;
            }else {
                break;
            }
        }

        // 判断 mid 后面是否有小于 s[high] 的值
        for (int i=mid; i<high; i++) {
            if (sequence[i] < sequence[high]) {
                return false;
            }
        }

        return verify(sequence, low, mid-1) && verify(sequence, mid, high-1);

    }

}
