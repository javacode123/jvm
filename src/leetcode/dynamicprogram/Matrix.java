package leetcode.dynamicprogram;

/**
 * 对于矩阵连乘问题，不同的组合会产生不同的次数，使用动态规划计算最优组合
 * A(10*100) B(100*5) C(5*50)
 * 组合1：(A*B)*C 次数 10*100*5 + 10*5*50 = 7500
 * 组合2：A*(B*C) 次数 100*5*50 + 10*100*50 = 75000
 */
public class Matrix {

    public static void main(String[] args) {

        int[][] A = {{2,2},{2,2}}, B = {{3,3},{3,3}};
        int[][] C = matrixMultiply(A, B);
        printMatrix(C);

    }

    /**
     * 矩阵相乘
     * @param A
     * @param B
     */
    public static int[][] matrixMultiply(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length;
        int c[][] = new int[m][n];
        int temp;

        // m 行
        for (int i=0; i<m; i++) {
            // n 列
            for (int j=0; j<n; j++) {
                temp = 0;
                for (int k=0; k<A[0].length; k++) {
                    temp += A[i][k] * B[j][k];
                }
                c[i][j] = temp;
            }
        }

        return c;

    }

    public static void printMatrix(int[][] C) {

        for (int n=0; n<C.length; n++) {
            for (int m=0; m<C[0].length; m++) {
                System.out.print(C[m][n] + " ");
            }
            System.out.println();
        }

    }

}
