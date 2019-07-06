package jvm12;

public class VolatileTest {

    public static int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i=0; i<THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10000; i++) {
                        increase();
                    }
                }
            });

            threads[i].start();

        }

        // 等待所有线程结束
        while (Thread.activeCount() > 2)
            Thread.yield();
            //System.out.println(Thread.activeCount());



        System.out.println(race);

    }

}
