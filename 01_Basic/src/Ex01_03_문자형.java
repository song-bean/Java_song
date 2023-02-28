
public class Ex01_03_문자형 {
	public static void main(String[] args) {
		System.out.println(1);
		//character (문자)
		char ch = 'B'; 
		//char ch = 66;
		System.out.println(ch);
		System.out.println("ch=" + ch + "입니다.");
		System.out.println(ch+1); // 숫자와 연산을 할 때는 아스키 코드 값으로 계산 
		// 'B' + 1 --> char(2) + int(4) --> int(4)
		System.out.println((char)(ch+1)); 
		// 아스키 코드 값으로 연산을 한뒤 다시 문자형으로 변환 
		System.out.println((char)67); // 67을 문자형으로 변환 
		
		/* 
		아스키 코드 값 (알아두기)
		A:65, B:66, ... , (1씩 커짐)
		a:97, b:98, ... , (1씩 커짐)
		*/
		
		
	}
}
