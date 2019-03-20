package test2;

public class TestException {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		int[] arr = { 11, 22, 33, 44, 55 };
		try {
//			System.out.println(a / b);
			System.out.println(arr[10]);
			arr = null;
			System.out.println(arr[1]);
		} catch (ArithmeticException e) {
			System.out.println("除数为0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("索引越界");
		} catch (Exception e) {
			System.out.println("出错了");
		}
		System.out.println("out");
	}
}
