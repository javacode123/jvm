package nowcoder.offer;

import java.util.Scanner;

public class Fibonacc {

    public static void main(String[] args) {
        Fibonacc f = new Fibonacc();
        Scanner s = new Scanner(System.in);
        while (true) {
            int a = s.nextInt();
            System.out.println(f.Fibonacci(a));
            System.out.println(f.Fibonaccii(a));
        }
    }

    public int Fibonaccii(int n) {
        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }

        return a[n];

    }
}