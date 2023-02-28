import java.util.Scanner;

public class Ex03_01_ifelse {

	public static void main(String[] args) {
		
		int a, b;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a입력:");
		a = sc.nextInt();
		
		System.out.print("b입력:");
		b = sc.nextInt();

		System.out.println("a = " + a + ", b = " + b);
		
		/*
		if(조건문) {
			참일 때, 실행할 문장1; 
			참일 때, 실행할 문장2; 
		}
		else { // 조건문이 참이 아닐 때 처리되는 부분 
			조건이 참이 아닐 때 실행할 문장1;
			조건이 참이 아닐 때 실행할 문장2;
		
		}
		*/
		
		if(a>b) {
			System.out.println("a가 b보다 크다.");
		}
		else if(a<b) { // a <= b
			System.out.println("a가 b보다 작다.");
		}
		else { // a == b
			System.out.println("a랑 b는 같다.");
		}	
		
		System.out.println("if문 공부중..");
		
		
		sc.close();
		
		
	}

}
