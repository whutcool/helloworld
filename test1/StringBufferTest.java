package test1;

public class StringBufferTest {
	public static void main(String[] args) {
		StringBuilder stringBuffer = new StringBuilder();
		int a = 12;
		stringBuffer.append("test" + a);
		stringBuffer.append("end");
		System.out.println(stringBuffer);
	}
}
