package basic;

/**
 * 基本类型对应缓冲池
 * boolean true | false
 * all byte values
 * short -128 - 128
 * int -128 - 128
 * char \u0000 - \u007F
 */
public class BufferPool {

    // 缓存池: 在程序运行过程中, 对于基本类型会经常的装箱, 使用缓冲池防止重复创建常用对象
    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        // 使用 new 创建对象, 所以不相等
        System.out.println(x == y); // false
        // 如果参数在 -128 128 之间, 返回缓冲池的引用, 即表示同一个对象
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k); // true
        Integer a = Integer.valueOf(1234);
        Integer b = Integer.valueOf(1234);
        System.out.println(a == b); // false
        // 编译器自动装箱调用的是 valueOf 方法, 因此判断 Integer 是否相同, 需要调用 equals 方法
        Integer m = 123;
        Integer n = 123;
        System.out.println(m == n); // true
        Integer o = 1234;
        Integer p = 1234;
        System.out.println(o == p); // false
    }

}
