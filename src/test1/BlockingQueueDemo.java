import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/24
 *******************************************************************************************************/
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        addAndRemove(blockingQueue);
    }

    public static void addAndRemove(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.add("111"));
        System.out.println(blockingQueue.add("222"));
        System.out.println(blockingQueue.add("333"));
        System.out.println(blockingQueue.add("444"));
    }

}

