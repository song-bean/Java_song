import java.util.Scanner;

public class Ex02_01_산술연산자 {
	public static void main(String[] args) {
		
		int num1, num2;
		
		//num1 = 30;
		//num2 = 7;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("num1입력:");
		num1 = sc.nextInt();
		
		System.out.print("num2입력:"); 
		num2 = sc.nextInt();
		
		
		System.out.printf("%d + %d = %d\n",num1, num2, (num1+num2));
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
		
		System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		System.out.println(num1 + " / " + num2 + " = " + ((double)num1/num2));
		System.out.printf("%d / %d = %.2f\n",num1, num2, ((double)num1/num2));
		
		System.out.println(num1 + " % " + num2 + " = " + (num1%num2)); //나머지 구하는 연산자
		System.out.printf("%d %% %d = %d\n",num1, num2, (num1%num2)); //%를 출력하고 싶으면 %%
		
		
		sc.close();
	}

}
