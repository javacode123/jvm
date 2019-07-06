package jvm12;

public class TestSynchronized {

    private static Object la = new Object();
    private static Object lb = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("等待la");
                synchronized (la) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (lb) {
                        System.out.println("进程1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("等待la");
                synchronized (lb) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (la) {
                        System.out.println("进程1");
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }

}
