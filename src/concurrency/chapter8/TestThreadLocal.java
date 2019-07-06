package concurrency.chapter8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池技术，在平常的场景中是直接 new 一个线程来执行任务，
 * 然而它的缺点就是在线程的创建和结束需要很多的时间，有时完全可以考虑创建线程池，
 * 可以节省线程创建的时间，而且任务结束后不用撤销线程直接放入线程池，让它执行下一个任务。
 */
public class TestThreadLocal {

    public static void main(String[] args) {
        // corePoolSize 线程个数，如果线程超过 corePoolSize 则加入缓存队列，如果缓存队列满，加判断是否小于 maximumPoolSize
        // 如果小于则新建线程，如果大于则拒绝服务
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS,  new ArrayBlockingQueue<Runnable>(5));
        // 当线程池中的个数大于 5 时，将任务缓存到队列里，当任务缓存队列满了之后，便创建新的线程，
        // 如果线程数大于 15 可能抛出异常，因为 maimumPoolSize + queue = 15，
        // 当第 16 任务进来，但是没有任务完成，则抛出异常
        for (int i=0; i<15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("i = " + i + ",线程池中线程个数： " + executor.getPoolSize() +
                    ",队列中等待执行的任务数目：" + executor.getQueue().size() +
                    ",已经执行完的人数数目：" + executor.getCompletedTaskCount());
        }

        executor.shutdown();

    }

}

class MyTask implements Runnable {

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    public void run() {
        System.out.println("正在执行 task: " + taskNum);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("task " + taskNum +"执行完毕");

    }

}
