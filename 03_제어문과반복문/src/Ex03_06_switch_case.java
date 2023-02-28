import java.util.Scanner;

public class Ex03_06_switch_case {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("과일 입력 : ");
		String fruit = sc.next();
		
		System.out.println("과일 이름 = " + fruit);
		
		
		switch(fruit) { // 괄호 안에 String 변수도 가능 (실수는 불가능)
		case "apple" : System.out.println("사과");
						break;
		case "banana" : System.out.println("바나나");
						break;
		case "orange" : System.out.println("오렌지");
						break;
		default : System.out.println("그 밖의 과일");
		}
		
		sc.close();
		

	}

}


