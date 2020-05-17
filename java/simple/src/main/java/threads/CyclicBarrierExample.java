package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample implements Runnable{
    CyclicBarrier cb;
    int a, b, c;
    public CyclicBarrierExample(CyclicBarrier cb) {
        this.cb = cb;
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3, () -> {
            System.out.println("All Done ");
        });
        Thread t = new Thread(new CyclicBarrierExample(cb));
        Thread t2 = new Thread(new CyclicBarrierExample(cb));
        t.start();
        t2.start();
        System.out.println("TSYSTest");

        cb.await();
    }

    @Override
    public void run() {
        System.out.println("GFG");
        try{
            cb.await();
        } catch (Exception e) {

        }
    }
}

