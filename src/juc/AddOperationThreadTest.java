import java.util.concurrent.CountDownLatch;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 多线程计算1-100之间的和
 * @AUTHOR jianglu
 * @DATE 2022/11/25
 *******************************************************************************************************/
public class AddOperationThreadTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int sum = 0;
        int threadCount = 5;
        int count = 20;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        AddOperationThread[] threads = new AddOperationThread[threadCount];
        for (int i = 1; i <= threadCount; i++) {
            threads[i - 1] = new AddOperationThread((i - 1) * count + 1, count * i, countDownLatch);
            new Thread(threads[i - 1]).start();
        }
        countDownLatch.await();
        for (int i = 0; i < threadCount; i++) {
            sum = sum + threads[i].getSum();
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("总耗时\t" + (end - start) + "ms");
    }
}
class AddOperationThread implements Runnable {
    private int start;
    private int end;
    private CountDownLatch countDownLatch;
    private int sum;

    public AddOperationThread(int start, int end, CountDownLatch countDownLatch) {
        this.start = start;
        this.end = end;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum = sum + i;
        }
        countDownLatch.countDown();
    }

    public int getSum() {
        return sum;
    }
}
