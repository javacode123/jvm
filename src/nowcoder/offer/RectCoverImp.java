package nowcoder.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 */
public class RectCoverImp {

    public static void main(String[] args) {
        System.out.println(new RectCoverImp().RectCover(6));
    }

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int result = 0, pre1 = 1, pre2 = 2;

        for (int i=3; i<=target; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }

        return result;

    }

}
