package jvm12;

public class TestFor {

    public static void main(String[] args) {
        int i = 100;
        // 先判断后执行
        for (; i<100; i++) {
            System.out.println(i);
        }

    }

}
