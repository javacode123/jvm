package nowcoder.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1Impl {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Impl().NumberOf1(4));
    }

    /**
     * 这种方法速度比较快，其运算次数与输入n的大小无关，只与n中1的个数有关。
     * 如果n的二进制表示中有k个1，那么这个方法只需要循环k次即可。
     * 其原理是不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0，代码如下
     */
    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n &= (n-1);
        }

        return count;

    }

}
