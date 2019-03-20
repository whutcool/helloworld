package test1;

/**
 * 参照文章 https://blog.csdn.net/u013256816/article/details/50837863
 * @author jianglu21141
 *
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		staticFunction();
	}
	static ClassLoaderTest sTest = new ClassLoaderTest();
	static {
		System.out.println("1");
	}
	{
		System.out.println("2");
	}
	public ClassLoaderTest() {
		System.out.println("3");
		System.out.println("a="+a+",b="+b);
	}
	public static void staticFunction(){
		System.out.println("4");
	}
	int a=110;
	static int b = 112;
}
