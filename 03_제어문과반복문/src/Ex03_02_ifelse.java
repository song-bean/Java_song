import java.util.Scanner;

public class Ex03_02_ifelse {

	public static void main(String[] args) {
		
		int num;
		System.out.print("숫자 입력:");
		
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		System.out.println("num = " + num);
		
		//if(num == 1 || num == 2 || ... || num == 10) {
		if(1 <= num && num <= 10) { 
			System.out.println(num + ": 1~10사이의 수 입니다.");
		}
		
		else if(11 <= num && num <= 20) { 
			System.out.println(num + ": 11~20사이의 수 입니다.");
		}
		
		else if(21 <= num && num <= 30) { 
			System.out.println(num + ": 21~30사이의 수 입니다.");
		}
		
	
		
		System.out.println("if~else 공부중..");
		
		//입력한 숫자가 5의 배수이며 출력하라. 
		if(num % 5 == 0) {
			System.out.println(num + ": 5의 배수입니다.");
		}
		
		//입력한 숫자가 10의 배수이며 출력하라.
		if(num % 10 == 0) {
			System.out.println(num + ": 10의 배수입니다.");
		}
		
		
		
		sc.close();

	}

}
