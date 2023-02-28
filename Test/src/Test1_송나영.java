//youn1223@daum.net

public class Test1_송나영 {
	public static void main(String[] args) {
		
		int i;
		
		System.out.print("(for문)5와 7의 배수: ");
		for(i=1;i<=100;i++) {
			
			if(i%5 == 0 && i%7 == 0) {
					System.out.print(i + " ");
			}//if
			
		}//for
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.print("(while문)5와 7의 배수: ");
		
		i=1;
		while(i<=100) {
			if(i%5 == 0 && i%7 == 0) {
				System.out.print(i + " ");
			}//if
			i++;
		}//while
		
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.print("(do~while문)5와 7의 배수: ");
		
		i=1;
		do {
			if(i%5 == 0 && i%7 == 0) {
				System.out.print(i + " ");
			}//if
			i++;
		}while(i<=100);
		//do~while
		
		
	}
}

/*
1~100사이의 수 중 5의 배수이면서 동시에 7의 배수인 수 출력(35,70)
for문, while문, do~while
*/