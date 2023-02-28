
public class Ex02_02_복합대입 {

	public static void main(String[] args) {
		
		int a = 10, b = 20, c = 30, d = 40, e = 50;
		
		// = : 대입연산자
		//+=, -=, *=, /=, %= : 복합대입연산
		System.out.println("a = " + a);
		//a = a + 3;
		a += 3;
		System.out.println("a = " + a);
		
		System.out.println("b = " + b);
		b -= 3;
		System.out.println("b = " + b);
		
		System.out.println("c = " + c);
		c *= 7;
		System.out.println("c = " + c);
		
		System.out.println("d = " + d);
		d /= 8;
		System.out.println("d = " + d);
		
		System.out.println("e = " + e);
		e %= 6;
		System.out.println("e = " + e);
	
		
		System.out.println();
		
		
		char ch1 = 'a'; //97
		System.out.println("ch1 = " + ch1);
		
		//ch1 = (char)(ch1+2); // 2+4 = 4(byte) --> 97+2=99
		ch1 += 2; // 복합대입연산자는 위 과정을 안해도 자동으로 처리해줌 
		System.out.println("ch1 = " + ch1);
		
		String fruit = "apple";
		System.out.println("fruit= " + fruit);
		//fruit = fruit + "banana";
		fruit += "banana";
		System.out.println("fruit= " + fruit);
		
		
	}
	
}
