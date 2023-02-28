
public class Ex05_04_메서드 {

	public static void main(String[] args) {
		
		int result = add(3,9); // add 메서드 호출
		System.out.println("result: " + result);
		
		result = add(200,193);
		System.out.println("result: " + result);
		
		result = add(123,456);
		System.out.println("result: " + result);
		
		System.out.println(add(100,200));
		System.out.println("--------------------");
		
		mul(2,3.9,7);
		mul(4,9,10);
		
		Ex05_04_메서드 ex = new Ex05_04_메서드();
		ex.show();
		
	}
	

	static int add(int a, int b) { // add 메서드 정의 int 리턴타입 메서드 이름
	//static 메서드에서는 static 메서드만 호출할 수 있다.	
		int sum = a + b;
		return sum; // 호출한 곳으로 돌아감
	}// add 메서드 정의
	
	static void mul(int a, double b, int c) { // mul() 메서드 정의
		
		System.out.println("세 수의 곱: " + (a*b*c));
		//return;
	}
	
	void show() {
		System.out.println("show 메서드 정의 부분");
	}
	
}
