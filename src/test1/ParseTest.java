import java.util.LinkedList;
import java.util.Queue;

public class ParseTest {
	public static void main(String[] args) {
		String string = "2";
		Integer integer = Integer.parseInt(string);
		System.out.println("第" + (integer + 1) + "223");

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("sssbbdd");
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		System.out.println(stringBuilder.toString());

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(2);
		queue.add(3);
		System.out.println(queue);
	}
}
