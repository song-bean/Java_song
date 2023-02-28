
public class Ex09_03_String {
	public static void main(String[] args) {

		int a;
		double b;
		String c; // String 클래스 = 자료형

		//		String s1 = "Have a nice day";
		//		String s2 = "Have a nice day"; // 주소가 같음

		String s1 = new String("Have a nice day"); // new 할 때마다 새로운 주소 생성
		String s2 = new String("Have a niCe day"); 
		String s3 = "hahaha"; //리터럴 표현법

		System.out.println("s1:" + s1);
		System.out.println("s2:" + s2);
		System.out.println(s1 == s2); // 주소 비교

		System.out.println(s1.length());
		int len = s1.length();
		System.out.println(len);
		boolean result1 = s1.equals(s2); // 문자열 비교(대소문자까지 비교)(boolean)
		System.out.println(result1);

		result1 = s1.equalsIgnoreCase(s2);  //대소문자 무시하고 비교 (boolean)
		System.out.println(result1);
		
		if(result1 == true) {
			System.out.println("두 문자열 같음");
		}
		else {
			System.out.println("두 문자열 같지 않음");
		}

		//int result2 = s1.compareTo(s2); //c(99) C(67)이므로 32출력, 끝까지 완전 똑같으면 0 (대소문자까지 비교) 
		int result2 = s1.compareToIgnoreCase(s2); //대소문자 무시하고 비교 (int) --> 아스키 코드값 비교해고 빼서 정수로 알려줌 
		System.out.println(result2); 
		if(result2 == 0) {
			System.out.println("두 문자열 같음");
		}
		else {
			System.out.println("두 문자열 같지 않음");
		}
		
		System.out.println("----------------------------");
		
		String s4 = s1.concat(s3); // s1에 s3 연결해라
		System.out.println(s1.concat(s3));
		System.out.println(s1+s3);

		int result3 = s1.indexOf("nice"); // nice가 몇 번째 자리(0번째부터 셈)에 있냐, 만약 못찾으면 -1 
		System.out.println(result3);
		
		//result3 = s1.lastIndexOf(97);
		result3 = s1.lastIndexOf('a'); // 뒤에서부터 a가 어디에 있는지 찾음, 마지막 a의 위치가 어디냐
		System.out.println(result3);
		
		System.out.println("----------------------------");
		
		String result4 = s1.substring(3,9); // 3번째부터 9번째 '앞'까지만 가져옴 --> (3~8), 문자열 일부 가지고 올 때 사용하는 메서드
		System.out.println(result4);
		
		result4 = s1.substring(7); // 7번째부터 끝까지 가져옴
		System.out.println(result4);
		
		result4 = s1.replace('a', 'x'); // a --> x로 변경, 옛날 문자 --> 새 문자
		System.out.println(result4);
		System.out.println("----------------------------");
		
		result4 = s1.toString(); // 문자열 리턴
		System.out.println(result4);
		System.out.println(s1);
		System.out.println(s1.toString());
		
		result4 = s1.toLowerCase(); //전부 다 소문자로 바꿔줌
		System.out.println(result4);
		
		result4 = s1.toUpperCase(); //전부 다 대문자로 바꿔줌
		System.out.println(result4);
		
//		boolean result5 = s1.contains("ce")
//		System.out.println(s1.contains(result5));
		System.out.println(s1.contains("ce")); // ce가 포함되어 있으면 true
		
		String s5 = "   abc de  FG  ";
		System.out.println(s5);
		System.out.println(s5.length());
		
		String s6 = s5.trim(); // 첫 글자 앞과 마지막 글자 뒤 공백을 없앰
		System.out.println(s6);
		System.out.println(s6.length());
		
		char ch = s1.charAt(2); // 0부터 셈, 이 위치의 문자 가져옴
		System.out.println(ch);
		
		System.out.println("----------------------------");
		//.의 위치를 찾는 메서드
		//일부를 가져오는 메서드
		String fullName = "Hello.java"; // Picture.jpg
		int index = fullName.indexOf(".");
		String fileName = fullName.substring(0,index) ; // Hello
		String ext = fullName.substring(index+1);// java, 이 문자열부터 마지막까지 저장
		
		System.out.println("파일명:" + fileName);
		System.out.println("확장자:" + ext);
		
		
		
		
	}

}
