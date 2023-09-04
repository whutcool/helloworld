import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/25
 *******************************************************************************************************/
public class AddOperationPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int sum = 0;
        int threadCount = 5;
        int count = 20;
        List<Future<?>> futures = new ArrayList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            AddOperationPool addOperationPool = new AddOperationPool(i * count + 1, (i + 1) * count);
            Future<?> future = threadPool.submit(addOperationPool);
            futures.add(future);
        }
        if (!futures.isEmpty()) {
            for (Future<?> future : futures) {
                sum = sum + (int) future.get();
            }
        }
        System.out.println(sum);
        threadPool.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("总耗时\t" + (end - start) + "ms");
    }

}
class AddOperationPool implements Callable<Integer> {
    private final int start;
    private final int end;
    private int sum;

    public AddOperationPool(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        for (int i = start; i <= end; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
