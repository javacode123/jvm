package leetcode.dynamicprogram;

/**
 * 给定一个非负整数 num。
 * 对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class CountBits {

    public static void main(String[] args) {

        CountBits c = new CountBits();
        float startTime = System.nanoTime();
        int[]  res = c.countBitsOptimization(100000);
        System.out.println(System.nanoTime()-startTime + "ns");

    }

    /**
     * 输入: 2
     * 输出: [0,1,1]
     *
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     */
    public int[] countBits(int num) {
        int res[] = new int[num+1];
        int count = 0, temp;

        for (int i=0; i<=num; i++) {
            temp = i;
            while (temp != 0) {
                if (temp%2 != 0) {
                    count++;
                }
                temp /= 2;
            }
            res[i] = count;
            count = 0;
        }

        return res;
    }

    // 时间复杂度为 n
    public int[] countBitsOptimization(int num) {
        int[] res = new int[num+1];

        for (int i=1; i<=num; i++) {
            res[i] = res[i&(i-1)] +1;
        }

        return res;

    }

}
