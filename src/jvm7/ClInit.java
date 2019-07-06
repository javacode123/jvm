package jvm7;

public class ClInit {

    static class Parent { //按照顺序执行

        static {
            A = 2;
        }

        public static int A = 1;

    }

    static class Sub extends Parent{
        public static int B = A;
    }
    
    public  static void main(String[] args) {
        System.out.println(Sub.B);
    }

}


