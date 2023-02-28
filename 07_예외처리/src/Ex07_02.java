import java.util.Scanner;

public class Ex07_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		System.out.print("숫자2:");
		int num2 = sc.nextInt();
		
		boolean dap = divider(num1,num2);
		if(dap == true)
			System.out.println("연산 성공");
		else
			System.out.println("연산 실패");
		sc.close();
		
	}
	
	public static boolean divider(int a, int b) {
		int result = 0;
		try {
			result = a/b; // 5/0 new ArithmeticException --> 수학관련 오류일 때
			System.out.println("나눗셈 결과:" + result);
			return true;
			
		}catch(ArithmeticException e) {
			System.out.println("e" + e);
			return false;
		}finally { // return이 있더라도 무조건 finally부분을 처리하고 돌아감
			System.out.println("finally 영역");
		}
	}
	
	
}
