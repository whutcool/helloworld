import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/10/21
 *******************************************************************************************************/
public class JsonParse {
    public HashMap<String, Object> parse(String input) {
        return null;
    }

    public void backtrack(HashMap<String, Object> result, int i, int j, String input) {
        Deque<String> stk = new LinkedList<>();
        String content = input.substring(i, j);
        if (!content.contains("[") && !content.contains("]") && !content.contains(",")) {
            result.put(content.split("=")[0], content.split("=")[1]);
        }
    }

}


