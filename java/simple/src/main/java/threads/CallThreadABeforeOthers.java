package threads;

import java.util.stream.IntStream;

import static java.lang.System.out;

public class

CallThreadABeforeOthers {
    public static void main(String[] args) throws InterruptedException {
        IntStream.rangeClosed(1, 10).forEach(
                i -> {
                    run();
                    out.println();
                }
        );
    }

    private static void run() {
        Foo foo = new Foo();
        Runnable runnable = () -> {
            foo.first();
        };

        Runnable runnable2 = () -> {
            try {
                foo.second();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable3 = () -> {
            try {
                foo.third();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t = new Thread(runnable);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);
        /*t.join();
        t2.join();
        t3.join();*/
        t.start();
        t2.start();
        t3.start();
    }
}


class Foo {
    public volatile boolean firstCalled;

    public void first() {
        synchronized (this) {
            out.print(" first called");
            //firstCalled = true;
            //notifyAll();
        }

    }

    public void second() throws InterruptedException {
        synchronized (this) {
            // if (!firstCalled)
            // wait();
            out.print(" second called");
        }

    }

    public void third() throws InterruptedException {
        synchronized (this) {
            //if (!firstCalled)
            // wait();
            out.print(" third called");
        }

    }
}
