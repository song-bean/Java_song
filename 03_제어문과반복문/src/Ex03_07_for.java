import java.util.Scanner;

public class Ex03_07_for {

	public static void main(String[] args) {
		
	/*	
	for(초기식;조건식;증감식) {
		반복할 문장1;
		반복할 문장2;
	}
	*/
		int i;
		
		for(i=1; i<=5 ;i++) { // i=5;i>=5;i--
		// 반복할 문장이 한 줄이면 중괄호 생략 가능 but, for문 시작 줄에 ; 쓰면 안됨 
		
			System.out.println("자바:" + i);
		}
		
		System.out.println("for문 밖:" + i);

		System.out.println("---------------------------");
		
		
		for(i=1; i<=10; i++) { // 1,2, ... , 10
			
			System.out.println("i = " + i);
		}
		
		System.out.println("---------------------------");
		
		for(i=2; i<=10; i=i+2) { // 2,4,6,8,10
			System.out.println("i = " + i);
		}
		
		System.out.println("---------------------------");
		
		for(i=1; i<=10; i++) { // 1,2, ... , 10
			
			if(i%2 == 0) {
			System.out.println("i = " + i);
			} //if
			
		}//for
		
		System.out.println("---------------------------");
		
		int sum = 0+1+2+3+4+5+6+7+8+9+10;
		System.out.println("sum = " + sum);
		
		sum = 0;
		sum = sum + 1; // 1
		sum = sum + 2; // 3
		sum = sum + 3; // 6
		sum = sum + 4; // 10
		sum = sum + 5; // 15
		sum = sum + 6; // 21
		sum = sum + 7; // 28
		sum = sum + 8; // 36
		sum = sum + 9; // 45
		sum = sum + 10; // 55
		System.out.println("sum = " + sum);
		
		sum = 0;
			
		for(i=0;i<=100;i++) {
			
			//sum = sum + i;
			sum += i;
		}
		System.out.println("sum = " + sum);
		
		System.out.println("---------------------------");
		
		//1~100사이의 수 중 5의 배수이면서 7의 배수 출력 
		System.out.print("5와 7의 배수는 ");
		for(i=1;i<=100;i++) {
			
			if(i%5 == 0 && i%7 == 0) {
					System.out.print(i + " ");
			}//if
			
		}//for
		System.out.println("입니다.");
		
		System.out.println("---------------------------");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단입력: ");
		int dan = sc.nextInt();
		
		for(i=1;i<=9;i++) {
			
			System.out.println(dan + "*" + i + "=" + (dan*i));
			//System.out.printf("%d * %d = %d\n" , dan, i, (dan*i));
		}
		
		
		
		sc.close();
		
	}
	
}	