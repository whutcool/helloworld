import java.util.*;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/10/26
 *******************************************************************************************************/
public class Test {

    public static void main(String[] args) {
        Deque<Integer> stk = new LinkedList<>();
        stk.add(1);
        stk.add(2);
        stk.removeLast();
        System.out.println(stk.peek());
    }

}
