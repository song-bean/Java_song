
public class Ex03_09_송나영 {

	public static void main(String[] args) {
		
		int i, j;
		
// 구구단 출력
//2*1=2(tab)3*1=3(tab)...
//2*2=4(tab)3*2=6(tab)...
		for(i=1;i<=9;i++) {
			
			for(j=2;j<=9;j++) {
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );
			}
			
			System.out.println();
		}
		
	}

}