import java.util.Scanner;

class Calculator { // 변수뿐만아니라 메서드도 들어갈 수 있음 
	
	int sum(int x, int y) { // 정의 
		return x + y;
	}
	/*
	int sub(int x, int y) {
		return x - y;
	}
	*/
	static int sub(int x, int y) {
		return x - y;
	}
	
	static int max(int x, int y) {
		if(x>y) 
			return x;
		else
			return y;
	}
	
	
}//Calculator

public class Ex05_05_메서드 { // 메서드는 클래스 안에 있어야 함 

	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		
		System.out.print("숫자2:");
		int num2 = sc.nextInt();
		
		
		Calculator cal = new Calculator();
		//sum(num1,num2); // sum 메서드 호출 --> 같은 클래스 안에서만 찾음
		int result = cal.sum(num1,num2); // sum 메서드 호출 
		System.out.println("add:" + result);
		
//		result = cal.sub(num1, num2);
//		System.out.println("sub:" + result);	
//		System.out.println("sub:" + cal.sub(num1, num2));
		result = Calculator.sub(num1, num2);
		System.out.println("sub:" + result);
		//System.out.println("sub:" + Calculator.sub(num1, num2));
		
		System.out.println("max:" + Calculator.max(num1, num2));
		
		
		sc.close();
		
	}

}
