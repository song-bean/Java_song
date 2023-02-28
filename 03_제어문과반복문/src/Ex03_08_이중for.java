
public class Ex03_08_이중for {

	public static void main(String[] args) {
		
		int i, j;
		for(i=1;i<=3;i++) {
			
			for(j=5;j<=8;j++) {
				System.out.println(i+ "," + j);
			}// 안쪽 for 
			
			System.out.println("-----"); // 안쪽 for문이 끝날 때마다 출력 
			
		}// 바깥쪽 for 
		
		System.out.println("######");
		
		//9,3/9,2/9,1/---/7,3/7,2/7,1/---/5,3/5,2/5,1/--- 출력하기
		for(i=9;i>=5;i-=2) {
			
			for(j=3;j>=1;j--) {
				System.out.println(i + "," + j);
			}
			System.out.println("-----");
		}
		
		System.out.println();
		
		System.out.println("-----구구단-----");
		//구구단 출력 
		for(i=2;i<=9;i++) {
			System.out.println("***" + i + "단***");
			
			for(j=1;j<=9;j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			System.out.println();
		}
		
		for(i=1;i<=5;i++) { // 부등호 조심, 
			System.out.println(i);
		}
		
		
		
		
	}

}
