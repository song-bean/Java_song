
public class Ex09_09_Wrapper {
	public static void main(String[] args) {

		String[] str = {"231","78","1.234","97"};
		int i;
		
		try {
			for(i=0;i<str.length;i++) {
				int k =	Integer.parseInt(str[i]);
				System.out.println(k);
			}//for
		}catch(NumberFormatException e) {
			System.out.println("정수 변환 불가능");
		}
		
		System.out.println();
		
		for(i=0;i<str.length;i++) {
			try {
				System.out.println(Integer.parseInt(str[i]));
			}catch(NumberFormatException e) {
				System.out.println("정수 변환 불가능");
			}
		}//for


	}
}

//반복 조건
//조건이 참일 때만 반복할 것인지 