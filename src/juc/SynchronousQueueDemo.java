import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION SynchronousQueueDemo
 * @AUTHOR jianglu
 * @DATE 2022/11/27
 *******************************************************************************************************/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + "put 1");
                blockingQueue.put(2);
                System.out.println(Thread.currentThread().getName() + "put 2");
                blockingQueue.put(3);
                System.out.println(Thread.currentThread().getName() + "put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者").start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "take" + blockingQueue.take());
                System.out.println(Thread.currentThread().getName() + "take" + blockingQueue.take());
                System.out.println(Thread.currentThread().getName() + "take" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();
    }
}
