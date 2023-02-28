
public class Ex01_06_출력문 {
	public static void main(String[] args) {
		
		int a = 123;
		char b = 'A';
		float c = 98.765f;
		String d = "아이유"; //자료형이지만 특별한 자료형, 여러 글자(한 글자는 char)
		
		
	//println 출력
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
		System.out.println();
		
		
	//printf 출력문 	
		// 서식문자 - 정수: %d, 문자: %c, 실수:%f, 문자열:%s, \n은 줄바꿈 
		System.out.printf("a=%d\n",a);
		System.out.printf("a=%5d\n",a); // 5칸을 잡고 출력, 자리가 남으면 공백 
		
		System.out.printf("b=%c\n",b);
		System.out.printf("b=%3c\n",b); // 3칸을 잡고 출력 
		System.out.printf("b=%d\n",(int)b); // 문자를 정수형으로 출력 
		
		System.out.printf("c=%f\n",c);
		System.out.printf("c=%10.2f\n",c); // 10칸잡고 출력, 소수점은 둘째까지만 
		
		System.out.printf("d=%s\n",d);
		System.out.printf("d=%5s\n",d);
		
		
	// \,"",\n,\t 출력 설명 
		System.out.println("안녕하세요 저의 이름은 아이유입니다.");
		// \t 탭한 만큼 띄어쓰기, ""안에 \\는 \출력, \"\"를 하면 ""도 출력 가능, ''는 상관 없음 
		System.out.println("안녕\\하세요\t\t 저의 이름은\n\n \"아이유\"입니다.");
	
		
		
	}
	
}
