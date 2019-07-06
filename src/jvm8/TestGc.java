package jvm8;

public class TestGc {

    public static void main(String[] args) {

        byte[] placeHolder = new byte[64*1024*1024];
        System.gc(); // 变量在作用域中，无法被回收

        {
            byte[] b2 = new byte[64*1024*1024]; // 作用域在 {} 内部
        }
        System.gc(); // 虽然 b2 已经失去作用域，但是垃圾收集器并无法收集，因为没有对局部变量表进行读写操作

        int a = 0; // 对局部变量表更新，垃圾收集器收集 b2
        System.out.println(a); // 局部变量需要初始化，类成员变量不需要初始化，虚拟机会自动初始化
        System.gc();

    }

}
