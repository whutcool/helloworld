package test2;

public class A {

	private String aString = "a";

	public String getaString() {
		return aString;
	}

	public void setaString(String aString) {
		this.aString = aString;
	}
	
	public static void main(String[] args) {
		A a = null;
		if (a == null) {
			System.out.println("success");
		}
	}
}
