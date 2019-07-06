package concurrency.chapter7;

import java.math.BigInteger;
import java.util.*;

/**
 * 每一秒产生一个素数，线程取消的策略
 */
public class AsecondOfPrimes {

    public static void main(String[] args) {

        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();

        try {
            Thread.sleep(10);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            generator.cancel();
        }

        List<BigInteger> list = generator.get();

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}

class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes
            = new ArrayList<BigInteger>();
    // 用于取消线程，通过 volatile 声明
    private  volatile boolean cancelled = false;

    public void run() {
        BigInteger p = BigInteger.ONE;

        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }

    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

}
