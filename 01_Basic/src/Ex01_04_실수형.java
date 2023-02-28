
public class Ex01_04_실수형 {
	public static void main(String[] args) {
		
	float a = 1.1f; 
	//실수는 기본적으로 double형 숫자로 생각, float형 숫자임을 알려주기위해 F(f)를 입력 
	//f를 안쓰면 생기는 오류: Type mismatch: cannot convert from double to float
	//float - 4byte, double - 8byte
	double b =2.2; // d는 생략 가능(안써도 에러 X)
	
	System.out.println("a=" + a);
	System.out.println("b=" + b);

	float f1 = 0.0012300f; 
	System.out.println("f1:" + f1); // 유효숫자 뒤 0은 출력 안됨 
	
	float f2 = 1.123456789f;
	System.out.println("f2=" + f2); // 소수점 8번째에서 반올림 
	
	float f3 = 123; // 4 <- 4
	System.out.println("f3=" + f3); // 123.0으로 출력 
	
	//int i4 = 1.23f; // 4 <- 4  but, float을 더 크다고 생각해서 오류 
	int i4 = (int)1.23f;
	System.out.println("i4=" + i4); // 1로 출력, 소수점 버림 
	
	double d1 = 0.123E4; //0.123 * 10^4, double = .123E4;, E(e) 둘 다 가능 
	System.out.println("d1=" + d1);
	
	double d2 = 0.123E-5;  
	System.out.println("d2=" + d2);
	
	
	
	
	}	
	
}
