public class ExceptionTest {
	public static int a = 1;
	public static void main(String[] args) throws Exception {
		try{
		    throw new Exception("参数越界"); 
		}catch(Exception e) {
			a = 2;
		    System.out.println("catch语句");
		    throw new Exception(e.getMessage());
		}finally {
			System.out.println("finally语句" + a);
		}
	}
}
