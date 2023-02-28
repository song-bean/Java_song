package Cartoon;

public class Main {
	
	static CartoonShop cshop = new CartoonShop();
	
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		Person p1 = new Person("제니"); //Thread-0
		Person p2 = new Person("지수"); //Thread-1
		Person p3 = new Person("로제"); //Thread-2
		Person p4 = new Person("리사"); //Thread-3
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		System.out.println("프로그램 종료");
	}

}
