import java.util.StringTokenizer;

public class Ex09_13_StringTokenizer {
	public static void main(String[] args) {
		
		
		StringTokenizer str = new StringTokenizer("3+2+7+9","+");
		int count = str.countTokens();
		System.out.println(count);
		
		int sum=0;
		while(str.hasMoreTokens()) {
			String s = str.nextToken();
			sum += Integer.parseInt(s);
		}
		System.out.println(sum);
		
	}

}
