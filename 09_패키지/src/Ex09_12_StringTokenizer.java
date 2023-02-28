import java.util.StringTokenizer;

public class Ex09_12_StringTokenizer {
	public static void main(String[] args) {
		
		// 끊었을 때 나오는 한 덩어리가 토큰
		StringTokenizer str = new StringTokenizer("2023/01/12,16:01","/,:"); // 문자열,구분자(공백도 가능), 구분자를 안쓰면 기본 구분자는 공백임
		
		int count = str.countTokens();
		System.out.println("count:" + count); // 구분자를 기준으로 문자열을 분리
		
		while(str.hasMoreTokens()) {
			String s = str.nextToken();
			System.out.println(s);
		}
		
		System.out.println();
		
		String str1 = "2023/01/12,16:01";
		String[] arr = str1.split("/"); // 구분자를 하나밖에 못 넣음
		int i;
		for(i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
