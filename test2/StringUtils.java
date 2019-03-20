package test2;

public class StringUtils {
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("12345");
		buffer.delete(buffer.length()-1, buffer.length());
		System.out.println(buffer);
		System.out.println(System.getProperty("line.separator")+"su");
	}
}
