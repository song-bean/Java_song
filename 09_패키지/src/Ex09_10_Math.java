import static java.lang.Math.*; // 이걸 써주면 Math를 생략하고 random()이런식으로도 사용이 가능


public class Ex09_10_Math { //Math 클래스 안은 다 static
	public static void main(String[] args) {

		// 3~8사이의 정수 난수
		double d = Math.random(); // 0<= d <1
		System.out.println(d);

		for(int i=1;i<=10;i++) {
			int n = (int)(Math.random() * 6)+3; // *((8-3)+1)) + 3
			System.out.println(n);
		}
		//A(65)~Z(90)
		char x = (char)((Math.random()*26) + 'A');
		System.out.println(x);
		
		
		System.out.println(1.1);
		//PrintStream
		
		System.out.println();
		
		long m1 = Math.round(4.3); // 반올림해서 정수로 변환
		System.out.println(m1);
		
		m1 = Math.round(4.9);
		System.out.println(m1);
		
		double m2 = Math.ceil(4.3);
		System.out.println(m2);
		
		m2 = Math.ceil(4.9); // 무조건 올림하는 함수
		System.out.println(m2);
		
		double m3 = Math.floor(4.9); // 무조건 내림하는 함수
		System.out.println(m3);
		
	}
}


