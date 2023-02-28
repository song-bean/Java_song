import java.util.Scanner;

public class Ex03_13_break {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		// 반복 횟수를 알고 있으면 for
		//반복 횟수를 정확히 알 수 없으면 while, do~while
		
		while(true) {
			
			System.out.print("수 입력: ");
			num = sc.nextInt(); // 음수 
			if(num < 0) {
				break;
			}//if문 	
			
		} //while문 
		
		System.out.println("프로그램 끝");	
		
		
		sc.close();
		
		
	}

}
