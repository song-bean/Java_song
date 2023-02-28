class Sub1 {
	int x = 5;
	void display() {
		System.out.println("Sub1 x:" + x);
	}
}//Sub1

class Sub2 extends Sub1 {
	void display() { //오버라이딩
		System.out.println("Sub2 x*x:" + x*x);
	}
}//Sub2

public class Ex08_04_익명클래스 {
	public static void main(String[] args) {
		
		Sub1 s1 = new Sub1();
		s1.display();
		
		Sub2 s2 = new Sub2();
		s2.display();
		
		// **익명클래스
		new Sub1() { // 객체를 만들고 정의함과 동시에 호출
			void display() { 
				System.out.println("Sub1 x*x*x:" + x*x*x);
			}//display
		}.display();// new Sub1()
		
	}

}





