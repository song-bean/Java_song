
public class Ex03_11_while {

	public static void main(String[] args) {
		
		int i;
		
		for(i=1;i<=5;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/* (while문)
		초기식;
		while(조건) {
			반복할 문장1;
			반복할 문장2;
			증감식;
		}
		*/
		//1 2 3 4 5
		i=1;
		while(i<=5) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println("While문 밖: " + i);
		
		//10 8 6 4 2
		i=10;
		while(i>=2) {
			System.out.print(i + " ");
			i -= 2;
		}
		System.out.println("While문 밖: " + i);

		
		/* (do_while문)
		초기식;
		do {
			 반복할 문장;
			 증감식;
		}while(조건식);	 
		 */
		//1 2 3 4 5
		i = 10;
		do { // 초기값이 조건이랑 안맞아도 일단 처음은 들어옴. 조건비교를 나중에 하기 때문
			System.out.print(i + " ");
			i++;
		}while(i<=5);
		
		System.out.println("do~While문 밖: " + i);
		
		
	}

}
