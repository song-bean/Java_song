
public class Ex01_02_정수형 {
	public static void main(String[] args) {
		System.out.println(1+2);
		//자료형(Type) - 정수: byte,short,int,long
		//byte = 1byte, short = 2byte, int = 4byte, long = 8byte
		int a, b; //integer(정수), 선언 
		a = 1; // 초기화 
		b = 2;
		System.out.println("a+b=" + (a+b));
		System.out.println("a+b");
		
		byte b1 = 10;
		short b2 = 20;
		int b3;
		System.out.println("b1=" + b1);
		System.out.println("b2=" + b2);
		b3 = b1 + b2; 
		// byte, short, char 같은 int보다 작은 데이터들의 연산은 int로 바뀜 
		System.out.println("b3=" + b3);
		System.out.println("b1+b2:" + b1+b2); // 이 경우는 +가 연산기호가 아닌 연속해라로 처리 
		System.out.println("b1+b2=" + (b1+b2));
		
		int c = 1000000;
		int d = 2000000;
		long result = (long)c * d; 
		// 2조, (long)-강제적 형변환, 크기가 다른 변수끼리 연산시 큰 변수로 연산 
		System.out.println(result);
		System.out.println("result=" + result);
		// "": 문자열, + : 연속해
		System.out.println(); //공백 한 줄 
		//System.out.println(w);
		// w cannot be resolved to a variable
		// 선언 없이 w변수 사용하려고 할 때 발생하는 에러 메시지 
		
		long k = 1000000000L; 
		//숫자만 쓰면 기본적으로 int형이라고 생각, long형 숫자임을 알려주기 위해 L(l)을 입력 
		
		
	}
}

//ln : 줄바꿈