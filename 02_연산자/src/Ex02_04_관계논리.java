
public class Ex02_04_관계논리 {

	public static void main(String[] args) {
		
		int a = 20, b = 20;
		
		boolean c = a <= b; // <, >, <=, >=. ==, != : 관계 연산자 
		System.out.println("c : " + c);
		System.out.println("c : " + (a<b)); // 괄호 주의 
		System.out.println(a == b); // 같으면 참, 다르면 거짓 
		System.out.println(a != b); // 같으면 거짓, 다르면 참 
		
	//논리연산자 : &&(and), ||(or), !(not) 	
		
	//and 연산자
		c = a > 10 && b > 10; // &&: a와b 모두 참이면 참 (and 연산자)
		System.out.println("c : " + c);
		c = a > 100 && b > 10; // &&: a와b 모두 참이면 참, 하나라도 거짓이면 거짓 
		System.out.println("c : " + c);
		
	//or 연산자
		c = a > 100 || b > 10; // 하나라도 참이면 참 
		System.out.println("c : " + c);
		
	//not 연산자
		c = !(a > 100); // 20 > 100 !(false) --> true
		System.out.println("c : " + c);
		
		
		
		
	}

}
