import java.util.concurrent.*;

public class ThreadException {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 1,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        Thread mt = new MyThread();
        Thread mt1 = new MyThread();
//        mt1.start();
        try {
            executor.execute(mt);
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        }
//        mt.start();
        method1();// method2(),method3();
        System.out.println("do work after method");
    }

    public static void method1() {
        try {
            throw new RuntimeException("RuntimeException in method1");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void method2() {
        throw new RuntimeException("RuntimeException in method2");
    }

    public static void method3() throws RuntimeException {
        throw new RuntimeException("RuntimeException in method3");
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        /*try {
            throw new RuntimeException("RuntimeException in MyThread1 run");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int a = 10/0;
        System.out.println("success");
//        throw new NoSuchMethodError();
    }
}
