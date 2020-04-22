package threads;

import java.util.Collections;

import static java.lang.System.out;

public class DeadLock {
    public static void main(String[] args) {

        Collections.emptyList();

        Resource resource = new Resource();

        Thread t = new Thread(
                () -> {
                    resource.callMeOne();
                }
        );
        Thread t2 = new Thread(
                () -> {
                    resource.callMeTwo();
                }
        );

        t.start();
        t2.start();
    }
}



class Resource {
    int counter;
    Object writeLock = new Object();
    Object readLock = new Object();

    void callMeOne() {
        synchronized (writeLock) {
            counter++;
            out.println("Resource.callMeOne() called " + counter);
            callA();
        }

    }

    void callMeTwo() {
        synchronized (readLock) {
            out.println("Resource.callMeTwo() called " + counter);
            callB();
        }
    }

    void callA() {
        synchronized (readLock) {
            out.println("Resource.callMeTwo() called " + counter);
        }
    }

    void callB() {
        synchronized (writeLock) {
            out.println("Resource.callMeTwo() called " + counter);
        }
    }
}
