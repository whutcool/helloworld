import java.util.HashMap;
import java.util.Map;

public class TestEntrySet {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		System.out.println(map.keySet());//遍历两次
		System.out.println(map.entrySet());//遍历一次，效率高
	}
}