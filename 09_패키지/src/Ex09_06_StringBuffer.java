public class Ex09_06_StringBuffer {
	public static void main(String[] args) {
		
		String str1 = "Have "; // 수정이 불가능 , append 없음
		String str2 = "a ";
		String str3 = "nice day";
		String str4 = str1 + str2 +str3;
		System.out.println(str4); // .toString() 생략
		str4 = str4.replace("nice", "good"); // 바꾼걸 다시 넣어줘야 함 
		System.out.println(str4);
		System.out.println();
		
		// 수정 가능 , StringBuffer로 문자열을 만드는 것이 더 빠르다.
		StringBuffer sb = new StringBuffer("Have "); // 무조건 이 형태만 가능
		sb.append("a ");
		sb.append("nice day");
		System.out.println("sb:" + sb);
		sb.replace(7, 11, "good"); // 7번째 부터 11번째 '앞'까지, 바꾼걸 다시 넣어줄 필요 없음(자체가 바뀌는 것)
		System.out.println("sb:" + sb);
		
		sb.insert(7, "happy ");
		System.out.println("sb:" + sb);
		
		sb.delete(7, 13);
		System.out.println("sb:" + sb);
		
		String s1= new String("abc");
		String s2= new String("abc");
		
		StringBuffer sb1= new StringBuffer("abc");
		StringBuffer sb2= new StringBuffer("abc");
		
		String ss1 = sb1.toString(); // String으로 바뀜 --> java.lang.StringBuffer.toString() (오버라이딩)
		String ss2 = sb2.toString();
		
		System.out.println(s1.equals(s2)); // java.lang.String.equals --> 문자열 비교(오버라이딩)
		System.out.println(sb1.equals(sb2)); // java.lang.Object.equals --> 참조값(주소) 비교
		System.out.println(ss1.equals(ss2)); // 문자열 비교
		
		
		
	}
}
