package nowcoder.offer;

import java.util.Scanner;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class PowerImpl {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int temp = in.nextInt();
            System.out.println(new PowerImpl().Power(temp, -2));
        }

    }

    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent  = -exponent;
            isNegative = true;
        }
        double[] res = new double[exponent+1];
        res[0] = 1.0;
        res[1] = base;

        for (int i=2; i<=exponent; i++) {
            if (i % 2 == 0) {
                res[i] = res[i/2] * res[i/2];
            } else {
                res[i] = res[i-1] * base;
            }
        }

        return isNegative ? 1/res[exponent] : res[exponent];

    }

    public double Power1(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent  = -exponent;
            isNegative = true;
        }
        double res = Power(base*base, exponent/2);
        if (exponent % 2 != 0) {
            res = res*base;
        }
        return isNegative ? 1/res : res;
    }

}
