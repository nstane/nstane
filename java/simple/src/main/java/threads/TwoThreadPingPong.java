package threads;

public class TwoThreadPingPong {
    public static void main (String[] args) {
        Object monitor = new Object();

        //Ping ping = new Ping(monitor);
        //Pong pong = new Pong(monitor);

        Thread t1 = new Thread(() -> {
            while(true) {
                synchronized(monitor) {
                    try {
                        System.out.println("Ping");
                        Thread.sleep(2000);
                        monitor.notifyAll();
                        monitor.wait();
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while(true) {
                synchronized(monitor) {
                    try {
                        System.out.println("Pong");
                        Thread.sleep(2000);
                        monitor.notifyAll();
                        monitor.wait();
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        t1.start();

        t2.start();

    }
}

class Ping implements Runnable {

    private Object monitor;

    public Ping(Object monitor) {
        this.monitor = monitor;
    }

    public void run() {
        while(true) {
            synchronized(monitor) {
                try {
                    System.out.println("Ping");
                    Thread.sleep(2000);
                    monitor.notifyAll();
                    monitor.wait();
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}


class Pong implements Runnable {
    private Object monitor;

    public Pong(Object monitor) {
        this.monitor = monitor;
    }

    public void run() {
        while(true) {
            synchronized(monitor) {
                try {
                    System.out.println("Pong");
                    Thread.sleep(2000);
                    monitor.notifyAll();
                    monitor.wait();
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}