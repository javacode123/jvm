package concurrency.chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 线程的中断，不同于取消
 */
public class BrokenPrimeProducer extends Thread{

    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    // 不断生产素数
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;

            while (!cancelled) {
                queue.put(p = p.nextProbablePrime());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean needMorePrimes() throws Exception{
        Thread.sleep(1000);
        return true;
    }

    // 消费者
    public static void consumePrimes(BlockingQueue<BigInteger> primes) throws InterruptedException {

        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();

        try {
            while (needMorePrimes()) {
                System.out.println(primes.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // 队列已经没有，取消
            producer.cancel();
        }

    }

    public void cancel() {
        cancelled = true;
    }

    public static void main(String[] args) throws  Exception{
        BlockingQueue<BigInteger> queue = new LinkedBlockingDeque<BigInteger>(5);
      //  BrokenPrimeProducer b = new BrokenPrimeProducer(queue);
        BrokenPrimeProducer.consumePrimes(queue);
    }

}
