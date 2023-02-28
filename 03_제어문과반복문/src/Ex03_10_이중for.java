
public class Ex03_10_이중for {

	public static void main(String[] args) {
		
		int i, j;
		for(i=0;i<5;i++) {
			for(j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	
		
		System.out.println();
		
		for(i=0;i<5;i++) {
			for(j=4;j>=i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	/*	위와 같은 출력 결과 
		System.out.println();
		
		for(i=5;i>0;i--) {
			for(j=i;j>0;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	*/	
		
		for(i=0;i<5;i++) {
			
			for(j=3;j>=i;j--) { //공백 반복 출력 
				System.out.print(" ");
			
			}
			for(j=0;j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		//	위와 출력 동일 
		/*
		 for(i=0;i<5;i++) {
			for(j=3;j>=i;j--) {
				System.out.print(" ");
			}
			for(j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		
		
	}

}
