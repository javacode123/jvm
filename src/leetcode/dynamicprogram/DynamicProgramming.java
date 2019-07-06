package leetcode.dynamicprogram;

/**
 * 动态规划：通过组合子问题的解来求问题的一个最优解
 * 1：问题可以转化为子问题
 * 2：具有重复子问题，即可以重复利用子问题的解
 */
public class DynamicProgramming {

    // 每段长度对应的价值
    public static int[] value = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    /**
     * 钢条切割问题
     */
    public static void main(String[] args) {

        System.out.println(cut(7));
        System.out.println(bottomUpCut(7));
        extendBottomUpCup(10);
        f(12);

    }

    /**
     * 思路：左边长度为 i, 右边长度为 n-i, 不考虑左边的价值, 需要满足右边为最优解
     * 缺陷：存在重复计算，每次 i 增加 1，都会存在重复计算 cut1(i-2)
     * @param n 钢条的长度
     */
    public static int cut(int n) {
        if (n==0) {
            return 0;
        }

        int q = -1;

        for (int i=1; i<=n; i++) {
            q = Math.max(q, value[i] + cut(n-i));
        }

        return q;

    }

    /**
     * 使用数组来存储子问题的最优解
     */
    public static int bottomUpCut(int n) {
        // 存储子问题的最优解
        int r[] = new int[n+1];
        r[0] = 0;

        // 问题的规模
        for (int j=1; j<=n; j++) {
            int q = -1;
            // 求解子问题
            for (int i=1; i<=j; i++) {
                q = Math.max(q, value[i]+r[j-i]);
            }
            r[j] = q;
        }

        return r[n];
    }

    // 对算法扩展，存储第一段的截取长度
    public static void extendBottomUpCup(int n) {
        // 最优子结构的解
        int r[] = new int[n+1];
        // 对应长度下标的第一次切割长度
        int s[] = new int[n+1];
        // 初始化
        r[0] = 0; s[0] = 0;

        // 求最优子问题
        for (int j=1; j<=n; j++) {
            int q = -1;
            // 构造数组
            for (int i=1; i<=j; i++) {
                if (q < (value[i] + r[j-i])) {
                    s[j] = i;
                    q = value[i] + r[j-i];
                }
            }
            r[j] = q;
        }

        while (n>0) {
            System.out.print(s[n] + " ");
            // 输出对应的第一段长度之后，再次输出子问题的第一段长度
            n = n-s[n];
        }

    }

    // 利用动态规划求解斐波那契数列
    public static void f(int n) {
        // 存贮子解
        int r[] = new int[n+1];
        r[0] = 1; r[1] = 1;

        // 求解数组
        for (int j=2; j<=n; j++) {
            r[j] = r[j-1] + r[j-2];
        }

        for (int temp: r) {
            System.out.print(temp + " ");
        }

    }

}
