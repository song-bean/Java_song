import java.util.Scanner;

public class Ex03_05_switch_case {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력:");
		int num = sc.nextInt();
		System.out.println("num=" + num);
		
		if(num == 1) {
			System.out.println("1입니다.");
		}
		else if (num == 2) {
			System.out.println("2입니다.");
		}
		else if (num == 3) {
			System.out.println("3입니다.");
		}
		else {
			System.out.println("1~3사이의 수가 아닙니다.");
		}
		
		System.out.println();
		
		switch(num) { // num과 일치하는 케이스로 넘어감, ()안에는 정수형 숫자나 수식 가능  
		case 1 : System.out.println("1입니다.");
				break;
		case 2 : System.out.println("2입니다.");
				break;
		case 3 : System.out.println("3입니다.");
				break; 
		default : System.out.println("1~3사이의 수가 아닙니다.");
				break; // 맨 마지막 줄은 break 안 써도 빠져나옴 
		}

		
		System.out.println("switch~case 공부중..");
		
		sc.close();

		
		
	}

}
