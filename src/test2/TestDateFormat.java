import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) throws InterruptedException {
        Date start = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        Thread.sleep(1200);
        Date end = new Date();
        Long s = end.getTime() - start.getTime();
        System.out.println("开始" + format.format(start) + ",结束" + format.format(end));
        System.out.println("总耗时" + s + "毫秒");


        Date date1 = new Date();
        Thread.sleep(1200);
        Date date2 = new Date();
        Long interval = date2.getTime() - date1.getTime();
        System.out.println(interval);
        if (interval > 1200) {
            System.out.println("yes");
        }
    }
}
