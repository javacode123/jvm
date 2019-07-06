package jvm8;

// 重写
public class StaticDispatch1 {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        public void sayHello() {
            System.out.println("man guy!");
        }
    }

    static class Woman extends Human {
        public void sayHello() {
            System.out.println("woman guy!");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }

}
