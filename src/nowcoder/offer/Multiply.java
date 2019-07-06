package nowcoder.offer;

import java.io.FileOutputStream;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {

    // 思路： 画出相乘矩阵
    public int[] multiply(int[] A) {
        if (A==null || A.length==0) {
            return A;
        }
        int[] B = new int[A.length];
        // 从右往左乘
        for (int i=0, product=1; i<A.length; product*=A[i],i++) {
            B[i] = product;
        }
        // 从左往右乘
        for (int i=A.length-1, product=1; i>=0; product*=A[i],i--) {
            B[i] *= product;
        }
        return B;
    }

}
