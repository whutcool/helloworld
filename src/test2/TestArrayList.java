

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = null;
		for(String str: list) {
			System.out.println(str);
		}
	}
}
