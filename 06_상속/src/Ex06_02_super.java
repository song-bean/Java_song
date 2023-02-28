class Parent {
	int x = 10; // 인스턴스 변수
	void method() {
		System.out.println("P_x:" + x);
	}
}

class Child extends Parent{
	int x =20; //인스턴스 변수
	void method() {
		int x =30; // 지역변수
		System.out.println("x=" + x);// 없으면 인스턴스 변수로 이것도 없으면 부모 변수
		System.out.println("this.x=" + this.x); // 나한테 있으면 내꺼 출력, 없으면 부모에서 찾아서 출력
		System.out.println("super.x=" + super.x); // 부모꺼 출력
		
		super.method(); // 부모 method에 접근
	}
	
	
}

public class Ex06_02_super {
	public static void main(String[] args) {
		
		Child c = new Child();
		c.method();
		
//		Parent p = new Parent();
//		p.method();
		
	}

}
