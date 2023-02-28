
public class Ex03_14_송나영 {

	public static void main(String[] args) {
		
		//구구단 세로로 전체 출력
		
		int i,j;
		
		for(i=2;i<10;i++) { //i++ 바꾸지 않기 
			
			System.out.println("***" + i + "단***");
			for(j=1;j<10;j++) {
				
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			System.out.println("----------");
		}
		System.out.println();
		
		System.out.println("---짝수단 출력---");
		
		//짝수단만 출력하기, 2단은 2까지, 4단은 4까지, ...
		
		for(i=2;i<10;i++) { //i++ 바꾸지 않기 
			if(i%2 == 1) { // if(1%2 != 0) { 
				continue;
			}
			System.out.println("***" + i + "단***");
			
			for(j=1;j<10;j++) {
				if(i+1 == j) { // if(i<j) { --> 이 경우는 continue; 가능
					break;
				}
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			System.out.println("----------");
		}
		
	}
		
	
}
