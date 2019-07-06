package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

/**
 * 对于 java 的参数传递，数据类型为引用类型的变量，
 * 基本类型，直接就是值得复制，对于对象则是将引用变量进行复制，
 * 对于 String 的 swap 函数，x,y 表示引用类型的变量，
 * 并没有对 main 中的变量值进行修改， 所以并没有达到交换的han效果，
 * swap 函数只是对函数体内部的引用变量的值交换了一下，
 * 如果想要达到交换效果只能对对象的属性进行修改，而不是对象的引用
 */

public class Test {

    public static void main(String args[]) {
        int[] arr = {1};
        arr(arr);
        System.out.println(arr[0]);
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);

        Iterator<Integer> it = l.iterator();

        while (it.hasNext()) {
            if (it.next().equals(2)) {
                it.remove();
            }
        }

        for (Integer i: l) {
            System.out.println(i);
        }

        /**
        String x = "5", y = "6";
        swap(x, y);
        // x,y的值并不会交换
        System.out.println(x + ";" + y);
        Obj o1 = new Obj(5);
        Obj o2 = new Obj(8);
        swap(o1, o2);
        System.out.println(o1.value + ";" + o2.value);
         **/
    }

    // 数组修改
    public static void arr(int[] arr) {
        arr[0] = 0;
    }

    public static void swap(Obj o1, Obj o2) {
        int temp = o1.value;
        o1.value = o2.value;
        o2.value = temp;
    }

    public static void swap(int x, int y) {
        System.out.println("use int");
        int temp = x;
        x = y;
        y = temp;
        System.out.println(x + ";" + y);
    }

    public static void swap(String x, String y) {
        String temp = x;
        //System.out.println(temp == x);
        x = y;
        y = temp;
        System.out.println(x + ";" + y);
    }

    public static void sort() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5); list.add(6); list.add(3);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > 02) {
                    return -1;
                }

                return 1;
            }
        });

        for (Integer i: list) {
            System.out.println(i);
        }

    }

}

class Obj {

    public Obj(int value) {
        this.value = value;
    }

    public int value ;

}
