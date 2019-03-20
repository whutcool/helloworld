import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListSize {
	public static void main(String[] args) {
		List<Boolean> list=new ArrayList<Boolean>(Arrays.asList(new Boolean[1]));
		System.out.println(list.size());
	}
}
