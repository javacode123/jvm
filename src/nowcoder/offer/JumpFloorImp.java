package nowcoder.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * （先后次序不同算不同的结果）。
 */
public class JumpFloorImp {

    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1, pre2 = 2, sum = 0;

        for (int i=3; i<=target; i++) {
            sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }

        return sum;

    }

}
