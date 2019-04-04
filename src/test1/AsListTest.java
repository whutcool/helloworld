import java.util.Arrays;
import java.util.List;

public class AsListTest {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};

        List list = Arrays.asList(data);

        System.out.println("列表中的元素数量是：" + list.get(0).getClass());
    }
}
