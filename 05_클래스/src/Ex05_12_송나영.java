import java.util.Scanner;

public class Ex05_12_송나영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		
		System.out.print("숫자2:");
		int num2 = sc.nextInt();
		
		int result = pow(num1, num2);
		System.out.println("result:" + result);
		
		System.out.println(num1 + "의 " + num2 + "제곱은 " + result + "입니다.");
		
		int result2 = 1;
		for(int i=1;i<=num2;i++) {
			result2 *= num1;
		}
		System.out.println(num1 + "의 " + num2 + "제곱은 " + result2 + "입니다.");

		//static double pow(double a, double b)
		double result3 = Math.pow(num1, num2);
		System.out.println(num1 + "의 " + num2 + "제곱은 " + result3 + "입니다.");
		
	}//main
	
	static int pow(int a, int b) {
		if(b == 0)
			return 1;
		else 
			return a * pow(a, b-1);
	}

}

//숫자 입력 2개
//숫자 1의 숫자 2 제곱은 result입니다. 
//재귀호출로 