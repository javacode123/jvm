package leetcode.dynamicprogram;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 * 能够偷窃到的最高金额。
 */
public class Rob {

    public static void main(String[] args) {
        Rob r = new Rob();
        int[]  a = {1, 3, 1, 1, 100};
        System.out.println(r.robOptimization(a));
    }

    /**
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * 难点：相邻两件会报警
     *    ：r[i] = max(r[i-2]+nums[i], r[i-1])
     */
    public int rob(int[] nums) {
        int length = nums.length;
        int[] r = new int[length];

        if (length == 0) {
            return 0;
        }

        if (length >= 1) {
            r[0] = nums[0];
        }

        if (length >= 2) {
            r[1] = Math.max(nums[0], nums[1]);
        }

        for (int i=2; i<length; i++) {
            r[i] = Math.max(r[i-2]+nums[i], r[i-1]);
        }

        return r[length-1];

    }

    /**
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 更改: 房屋是环形
     *    : 切入点是前两个肯定会选择一个最大的
     */
    public int robOptimization(int[] nums) {
        int[] r = new int[nums.length];

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rs(nums, 0, nums.length-2), rs(nums, 1, nums.length-1));

    }

    public int rs(int[] nums, int start, int end) {
        int length = end-start+1;
        int[] r = new int[length];

        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[start];
        }

        if (length == 2) {
            return Math.max(nums[start], nums[start+1]);
        }

        r[0] = nums[start];
        r[1] = Math.max(nums[start], nums[++start]);

        for (int i=2; i<length; i++) {
            r[i] = Math.max(r[i-2]+nums[++start], r[i-1]);
        }

        return r[length-1];

    }

}
