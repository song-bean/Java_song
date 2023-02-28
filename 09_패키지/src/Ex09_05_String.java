
public class Ex09_05_String {
	public static void main(String[] args) {
		
		String str = "Slow And Steady Wins the Race";
		// String str = new String("slow and steady wins the race"); --> 둘은 주소 비교할 때 차이가 남
		
		System.out.println(str.charAt(5));
		char ch = str.charAt(5);
		System.out.println(ch);
		
		int i;
		int[] alpha = new int[26];
		System.out.println(str.length());
		for(i=0;i<str.length();i++) {
			ch = str.charAt(i);
			if('A' <= ch && ch <= 'Z' ) { // 대문자
				alpha[ch-65]++;
			}
			//if(ch > 96) // 공백의 아스키코드 값: 32
			if(ch >= 'a' && ch <= 'z') {
				alpha[ch-97]++;
			}
		}
		
		
		//ch=97;
		for(i=0;i<alpha.length;i++) {
			System.out.println((char)(i+97) + ":" +alpha[i]);
			//ch++;
		}
		
	}

}
//a:3
//b:0
// .
// .
// .
//z:0
