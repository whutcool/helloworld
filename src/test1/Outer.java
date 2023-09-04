import java.util.ArrayList;
import java.util.List;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/30
 *******************************************************************************************************/
public class Outer {

    private int[] data;

    public Outer(int size) {
        this.data = new int[size];
    }

    static class Inner {

    }

    Inner createInner() {
        return new Inner();
    }

}

class Demo {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int count = 0;
        while (true) {
            list.add(new Outer(1000).createInner());
            System.out.println(count++);
        }
    }
}