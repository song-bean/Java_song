//import java.util.InputMismatchException;
//import java.util.Scanner;
import java.util.*;

public class Ex07_03 {
	public static void main(String[] args) {
		
		
		//1~100사이의 정수 난수 발생: A~B: B-A + 1을 곱하고 A더하기
		//0*100 <= answer < 1*100
		//(int)0*100 <= answer < (int)1*100 --> 0 <= answer < 100: 0+1~99+1 => 1~100 
		int answer = (int)(Math.random()*100) + 1;
		
		//System.out.println("answer:" + answer);
		
		//17~85 사이의 정수 난수 발생 
		//answer = (int)(Math.random()*69) + 17;
		
		int input = 0;
		int count = 0;
		do {
			count++;
			System.out.print("1~100사이의 숫자를 입력:");
			Scanner sc = new Scanner(System.in);
			try {
				input = sc.nextInt(); // 정수대신 실수를 넣으면 new InputMismatchException()
				
				//new InputMismatchException e = new InputMismatchException()
			}catch(InputMismatchException e) {
				System.out.println("유효하지 않은 값입니다. 다시 입력하세요.");
				continue; 
			}
			if(answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			}
			else if(answer < input) {
				System.out.println("더 작은 수를 입력하세요.");
			}
			else {
				System.out.println("맞췄습니다.");
				System.out.println("시도한 횟수는 " + count + "번 입니다.");
				break;
			}
		}while(true);
		
		System.out.println("프로그램을 종료합니다.");
		
	}

}
