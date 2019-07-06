package leetcode.dynamicprogram;

/**
 * 求解两个序列的最长公共子序列
 * 例如：bcdb, abcbdab
 * 结果：dcdb
 */

public class MaxLongSequene {

    public static void main(String[] args) {
        String s = "10010101", ss = "010110110";
        // System.out.print(f1(s, ss, s.length(), ss.length()));
        char b[][] = new char[s.length()+1][ss.length()+1];
        int c[][] = f2(s, ss, b);
        System.out.println(c[s.length()][ss.length()]);
        // 打印结果
        print(b, s, s.length(), ss.length());
        // 打印结果
        printV1(s, c, s.length(), ss.length());
    }

    // 递归求解
    public static int f1(String s1, String s2, int m, int n) {

        if (m==0 || n==0) {
            return 0;
        } else {
            // 序列的最后一位相同，转化为子序列 +1
            if (s1.charAt(m-1) == s2.charAt(n-1)) {
                return f1(s1, s2, m-1, n-1) + 1;
            } else {
                // 最后一位不相同，求两个序列分别去掉最后一位的最优解
                return Math.max(f1(s1, s2, m, n-1), f1(s1, s2, m-1, n));
            }
        }

    }

    // 使用动态规划的方法，数组 c[i,j] 存储最优子结构
    // b[i,j] 存储选择的解
    public static int[][] f2(String s1, String s2, char[][] b) {
        int m = s1.length(), n = s2.length();
        int c[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            c[i][0] = 0;
        }

        for (int j=0; j<=n; j++) {
            c[0][j] = 0;
        }
        // 更新最优结构
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = '='; // 取当前位置的字符
                } else if (c[i-1][j] > c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    b[i][j] = '|'; // 向上寻找
                } else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = '-'; // 向左寻找
                }
            }
        }

        return c;

    }

    // 递归打印子序列
    public static void print(char[][] b, String s, int m, int n) {
        if (m==0 || n==0) {
            System.out.println();
            return;
        } else {
            if (b[m][n] == '=' ) {
                print(b, s, m-1, n-1);
                System.out.print(s.charAt(m-1));
            } else if (b[m][n] == '|') { // 向上寻找
                print(b, s, m-1, n);
            } else { // 向左寻找
                print(b, s, m, n-1);
            }
        }
    }

    // 算法改进，将表 b 去掉，节省空间开销
    // 思路：根据表 c 可以推算出 c[i][j] 是来自 c[i-1][j-1], c[i-1][j], c[i][j-1] 的哪一个，从而求出子序列
    public static void printV1(String s, int[][] c, int m, int n) {
        if (m==0 || n==0) {
            System.out.println();
            return;
        } else {
            if (c[m][n] == (c[m-1][n-1]+1)) {
                printV1(s, c, m-1, n-1);
                System.out.print(s.charAt(m-1));
            } else {
                if (c[m][n] == (c[m-1][n])) { // 向上寻找
                    printV1(s, c, m-1, n);
                } else { // 向左寻找
                    printV1(s, c, m, n-1);
                }
            }
        }
    }

}
