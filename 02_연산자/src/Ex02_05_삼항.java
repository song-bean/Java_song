
public class Ex02_05_삼항 {

	public static void main(String[] args) {
		
		int a = 10, b = 20;
		// 조건식 ? 참 : 거짓 - 조건에 따라 처리하고 싶은게 다를 때 사용 
		int result = a>b ? a: b; // a>b가 거짓이므로 거짓 자리에 있는 b가 출력 
		System.out.println("result: " + result);
		
		// 짝수: 숫자 % 2 == 0
		String str = a % 2 == 0? "짝수" : "홀수";
		System.out.println("str = " + str);

	}

}

//이항연산자 : +, -, *, /, %, &&, ||, >, <, >=, <=, ==, !=
//단항연산자 : ++, --, !, -
//삼항연산자(조건연산자) - 조건식 ? 참 : 거짓 