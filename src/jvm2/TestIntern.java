package jvm2;

public class TestIntern {

	public static void main(String[] args) {
		
		String str1 = new StringBuilder("JAVA").toString();
		System.out.println(str1.intern() == str1);
		String str2 = "JAVA";
		System.out.println(str2.intern() == str1.intern());
		
	}

}
