package nowcoder.offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        ArrayList<Integer> list = new PrintMatrix().printMatrix(array);
        for (Integer num: list) {
            System.out.print(num + ",");
        }
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        // r1:当前行, c1:当前列
        int r1 = 0, r2 = matrix.length-1, c1 = 0, c2 = matrix[0].length-1;

        while (r1<=r2 && c1<=c2) {
            // r1 行从左到右
            for (int i=c1; i<=c2; i++) {
                res.add(matrix[r1][i]);
            }
            // c2 列从上到下
            for (int i=r1+1; i<=r2; i++) {
                res.add(matrix[i][c2]);
            }
            // r2 行从右往左
            if (r1 != r2) {
                for (int i=c2-1; i>=c1; i--) {
                    res.add(matrix[r2][i]);
                }
            }
            // c1 列从下往上
            if (c1 != c2) {
                for (int i=r2-1; i>r1; i--) {
                    res.add(matrix[i][c1]);
                }
            }

            r1++; r2--; c1++; c2--;

        }

        return res;

    }

}
