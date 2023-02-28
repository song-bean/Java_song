class Example {
	static int max(int x, int y) {
		if(x > y) 
			return x;
		else
			return y;
	}
}//

//class Math { // 이미 만들어진 메서드 활용하기 (아래 사이트)
//	static double E;
//	static double PI;
//}

//https://docs.oracle.com/en/java/javase/11/docs/api/index.html

public class Ex05_15_Math {

	public static void main(String[] args) {
		
		int a=30, b=40, c;
		
		c = Example.max(a,b);
		System.out.println("큰 값:" + c);
		
		//Math.max(a, b);
		System.out.println("큰 값:" + Math.max(a, b));
		System.out.println("작은 값:" + Math.min(a, b));
		
		System.out.println(Math.abs(-3.2)); // 절댓값
		System.out.println(Math.abs(-12));
		
		System.out.println(Math.PI);
		System.out.println(Math.E);
	}

}
