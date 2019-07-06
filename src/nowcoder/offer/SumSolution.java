package nowcoder.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 */
public class SumSolution {

    public int Sum_Solution(int n) {
        int sum = n;
        // 第一个条件为 false 不会执行第二个判断, 短路特性
        boolean b = (n>0) && ((sum += Sum_Solution(n-1)) >0 );
        return sum;
    }

}
