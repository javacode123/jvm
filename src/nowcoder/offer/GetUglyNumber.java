package nowcoder.offer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {

    /**
     * 思路: 丑数是由丑数 * 2,3,5 组成, 使用动态规划思想, 逐渐 * 2,3,5
     * 要求从小到大排列, 需要三个指针, 跟别表示当前丑数 * 2,3,5 获取最小值,
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;
        // 记录当前丑数所在位置
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i=1; i<index; i++) {
            int r1 = res[p2]*2, r2 = res[p3]*3, r3 = res[p5]*5;
            // 比较丑数 * 2,3,5 的最小值
            res[i] = Math.min(r1, Math.min(r2, r3));
            // 每一条都要判断, 保证三个指针都移动
            if (res[i] == r1) {
                p2++;
            }
            if (res[i] == r2) {
                p3++;
            }
            if (res[i] == r3) {
                p5++;
            }
        }

        return res[index-1];
    }

}
