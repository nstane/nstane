package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreadsPrintEvenODDInSequence {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        int count = 20;
        AtomicInteger integer = new AtomicInteger();
        Thread t1 = new Thread(new OddPrint(lock, count));

        Thread t2 = new Thread(new EvenPrint(lock, count));

        t1.start();
        //t1.join();
        t2.start();
        //t2.join();

    }

}

class EvenPrint implements Runnable {
    int integer;
    private Object lock;

    public EvenPrint(Object lock, int integer) {
        this.lock = lock;
        this.integer = integer;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 2; i <= integer; i++)
                if (i % 2 == 0) {
                    System.out.println(i);
                    try {
                        lock.notifyAll();
                        if(i < integer)
                        lock.wait();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}

class OddPrint implements Runnable {

    int integer;
    private Object lock;

    public OddPrint(Object lock, int integer) {
        this.lock = lock;
        this.integer = integer;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 1; i <= integer; i++)
                if (i % 2 == 1) {
                    System.out.println(i);
                    try {
                        lock.notifyAll();
                        if (i < integer)
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}

// T1 // odd T2 event

//1...1000


///1,2,3,
