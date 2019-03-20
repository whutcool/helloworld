import java.util.ArrayList;
import java.util.List;

public class TestCopyList {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("12");
		list1.add("23");
		list1.add("34");
		String str = new String();
		for (String string : list1) {
			str = string;
			list2.add(str);
		}
		System.out.println(list2);
 	}
}
