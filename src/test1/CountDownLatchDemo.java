import java.util.concurrent.CountDownLatch;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/15
 *******************************************************************************************************/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上晚自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t班长最后关门走人");
    }
}
