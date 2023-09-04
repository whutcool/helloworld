import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 实现阻塞队列
 * @AUTHOR jianglu
 * @DATE 2022/11/25
 *******************************************************************************************************/
public class BlockingQueueTest {
    public static void main(String[] args) {
        MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<>(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "往队列添加元素" + i);
                blockingQueue.put(i);
            }
        }, "生产者");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "从队列取元素" + blockingQueue.take());
                System.out.println("当前队列元素为" + blockingQueue);
            }
        }, "消费者");

        thread1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}

class MyBlockingQueue<E> {
    // 用于保护临界区的锁
    private final ReentrantLock lock;
    // 用于唤醒取数据时被阻塞的线程
    private final Condition notEmpty;
    // 用户唤醒放数据时被阻塞的线程
    private final Condition notFull;
    // 用于记录从数组中取数据的位置，也就是队列头的位置
    private int takeIndex;
    // 用于记录从数组中放数据的位置，也就是队列尾的位置
    private int putIndex;
    // 记录队列中有多少个数据
    private int count;
    // 用于存放具体数据的数组；
    private Object[] items;

    public MyBlockingQueue(int size) {
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
        this.takeIndex = 0;
        this.putIndex = 0;
        this.count = 0;
        if (size <= 0) {
            throw new RuntimeException("size can not be less than 1");
        }
        items = new Object[size];
    }

    // 存数据，如果满了阻塞
    public void put(E e) {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            enqueue(e);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    // 存数据，如果满了返回false
    public boolean offer(E e) {
        lock.lock();
        try {
            if (count == items.length) {
                return false;
            } else {
                enqueue(e);
                return true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }
        return false;
    }

    // 存数据，如果满了异常
    public boolean add(E e) {
        if (offer(e)) {
            return true;
        } else {
            throw new RuntimeException("Queue full!");
        }
    }

    // 取数据，取不到返回null
    public E poll() {
        lock.lock();
        try {
            return count == 0 ? null : dequeue();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    // 取数据，取不到则阻塞线程
    public E take() {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return dequeue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        lock.lock();
        try {
            if (count == 0) {
                stringBuilder.append("]");
            } else {
                int cur = 0;
                while (cur != count) {
                    stringBuilder.append(items[(cur + takeIndex) % items.length]).append(",");
                    cur++;
                }
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                stringBuilder.append("]");
            }
        } finally {
            lock.unlock();
        }
        return stringBuilder.toString();
    }

    // 放数据
    private void enqueue(E e) {
        this.items[putIndex] = e;
        if (++putIndex == items.length) {
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
    }

    // 取数据
    private E dequeue() {
        final Object[] items = this.items;
        E e = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length) {
            takeIndex = 0;
        }
        count--;
        notFull.signal();
        return e;
    }

}