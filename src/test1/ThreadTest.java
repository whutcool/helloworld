import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/18
 *******************************************************************************************************/
public class ThreadTest {
    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.print();
    }
    public void print() {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        new Thread(futureTask, "A").start();
    }
    class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName());
            return 1;
        }
    }
}
