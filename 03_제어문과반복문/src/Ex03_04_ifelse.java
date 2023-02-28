import java.util.Scanner;

public class Ex03_04_ifelse {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력:");
		int num = sc.nextInt();
		System.out.println("입력한 숫자:" + num);
		
		if(num % 5 == 0) {
			System.out.println(num + ":5의 배수입니다.");
			
			if(num % 10 == 0) {
				System.out.println(num + ":10의 배수입니다.");
			}
			else { // 10의 배수가 아니면 
				System.out.println(num + ":10의 배수가 아닙니다.");
			}
			
		}
		else { // 5의 배수가 아니면 
			System.out.println(num + ":5의 배수가 아닙니다.");
		}
		
		sc.close();
	
	}

}
