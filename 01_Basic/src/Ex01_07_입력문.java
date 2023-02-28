import java.util.Scanner; // Scanner 사용을 위해 무조건 필요함 

public class Ex01_07_입력문 {
	public static void main(String[] args) {
		int a, b;
		//a = 10;
		//b = 20;
		
		 Scanner sc = new Scanner(System.in);
		//System.in: 키보드, System.out: 콘솔창 
		
		//System.out.println("a입력:");
		System.out.print("a입력:"); // 엔터 없이 (ln이 빠짐)
		a = sc.nextInt();
		
		//System.out.println("b입력:"); 
		System.out.print("b입력:"); // 엔터 없이 
		
		b = sc.nextInt();
		
		System.out.println("a+b=" + (a+b));
		
		
		String c;
		//System.out.println("c입력:");
		System.out.print("c입력:"); // 엔터 없이 
		c = sc.next();
		System.out.println("c:" + c);
		
		
		sc.close(); // 더이상 스캐너 사용을 안한다.
		
	}
	
}

