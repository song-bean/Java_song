
public class Ex05_03_메서드 {

	public static void main(String[] args) { // main 메서드 정의
		//항상 main 메서드가 먼저 실행이 됨
		System.out.println("main 메서드 정의 시작");
		
		display(); // 메서드 호출
		System.out.println("********************");
		display();
		System.out.println("####################");
		display();
		
		System.out.println("main 메서드 정의 끝");
		
	} // main

	static void display() { // display() 메서드 정의, static 리턴타입 메서드이름
		
		System.out.println("자바 공부중");
		System.out.println("클래스 부분 공부중");
		System.out.println("너무 재미있음");
		//return; // 호출한 곳으로 돌아감
		
	}
	
	
	
}
