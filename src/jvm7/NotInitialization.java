package jvm7;

import java.io.Serializable;

/**
 * 类的加载，加载会生成对应的 Class 对象，放到方法区中，内存分配仅仅包括类变量（static 修饰的变量）
 * 1：遇到 new, getstatic, putsatic 或 invokestatic
 * 2: 初始化一个类时，如果发现父类还没有进行初始化，则先触发其父类的初始化
 */
public class NotInitialization implements Cloneable, Serializable { // 单继承多实现

    public static void main(String[] args) {

        SuperClass[] sca = new SuperClass[10];//不会触发初始化
        // 什么都不输出
        System.out.println("-------------");
        System.out.println(SubClass.value);// 不会触发父类的初始化
        // out: SuperClass Init 123
        // 并没有出发加载子类
        System.out.println("-------------");
        System.out.println(ConstClass.HELLO_WORD);// 不会加载类
        // 已经存储到常量池中
    }

}

class SuperClass {

    static {
        System.out.println("SuperClass Init");
    }

    public static int value = 123;

}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass Init");
    }

}

class ConstClass {

    static {
        System.out.println("ConstClass Init");
    }

    public static final String HELLO_WORD = "hello word";

}

