import java.io.File;

public class Ex12_01_File {
	public static void main(String[] args) {
		
		File f1 = new File("/Users/songnayoung/sun/abc.txt");
		//File f2 = new File();
		
		String a = File.pathSeparator;
		char b = File.pathSeparatorChar;
		String c = File.separator;
		char d = File.separatorChar;
		
		File f2 = new File("/Users" + File.separator + "songnayoung" + File.separator + "sun" + File.separator + "abc.txt");
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
		System.out.println("d:" + d);
		
		
		File f3 = new File("/Users/songnayoung/Sun", "aBc.txt"); // 대소문자 상관 없음
		File f4 = new File("/Users/songnayoung/sun");
		File f5 = new File(f4,"abc.txt");
		
		
		System.out.println(f1.length());
		System.out.println(f2.length());
		System.out.println(f3.length());
		System.out.println(f5.length());
		
		
		
	}
}
