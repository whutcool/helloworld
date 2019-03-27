import java.util.ArrayList;

/***
 * @author cool
 * test ArrayList in for
 */
public class TestArrayInFor {
    public static void main(String[] args) {
        ArrayList<Aobj> list = new ArrayList<>();
        Aobj a = new Aobj();
        for (int i=0; i<2; i++) {
            a.setAge(String.valueOf(i));
            list.add(a);
        }
        for (Aobj aobj:list) {
            System.out.println(aobj.getAge());
        }
    }

}
