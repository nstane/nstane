public class Test {
    public static void main(String[] args) {
        test2();

    }

    private static void test2() {
        //test();
        //B b = new B();

        //System.out.println(b instanceof B);

        Thread t = new MyThread() {
            public void run() {
                System.out.println("bar3");
            }
        };
        t.start();
    }

    private static void test() {
        StaticClass sc = new StaticClass();
        sc.readme();
        String arr [] = "Hello, Narender. How are you ?"
                .replaceAll("\\W", " ")
                .trim()
                .split("\\s+");

        int totalSecs = 100;

        //int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;

        for(String s: arr) {
            System.out.println(s);
        }
    }

    private static class StaticClass {
        void readme() {}
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("bar1");
    }

    public void run(String s) {
        System.out.println("bar2");
    }
}

class A{

}

class B {

}

class C {

}

