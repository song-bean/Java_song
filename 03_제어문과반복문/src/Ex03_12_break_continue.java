
public class Ex03_12_break_continue {

	public static void main(String[] args) {
		
		int i;
	
	//break, continue: 분기문
		
		//1 2 3 4 <-- 5부터 출력X (i = 5)
		for(i=1; i<=10;i++) {
			if(i == 5) {
				break; // 반복문 빠져나가라 (if문 X)
			}
			System.out.print(i + " ");
			
		}
		System.out.println();
		
		//1 2 3 4 6 7 8 9 10 <-- 5가 없음 
		for(i=1; i<=10;i++) {
			if(i == 5) {
				continue; // 반복문 안에 있는 문장 중 아래 문장 실행하지 말고 넘어가라. 
			}
			System.out.print(i + " ");
			
		}
		System.out.println();
		
		
		
	}

}
