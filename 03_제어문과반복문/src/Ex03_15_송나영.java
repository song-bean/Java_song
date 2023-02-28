
public class Ex03_15_송나영 {

	public static void main(String[] args) {
		
		//1~10 = 55
		//1~20 =
		// ...
		//1~100까지 반복하면서 i가 10의 배수가 될 때마다 출력 
		
		int sum, i;
		
		sum = 0;
		
		//10의 배수마다 출력하기 
		System.out.println("10의 배수마다 합 구하기");
		for(i=1;i<=100;i++) {
			
			sum += i;             
			if(i%10 == 0) {
				System.out.println("1"+ "~" + i + "=>" + sum);
			}
		}
		System.out.println("--------------------");

		/* 10의 배수마다 출력하기(continue 버전) 
		sum =0;
		for(i=1; i<=100; i++) {
			sum += i;
			if(i%10 != 0) {
				continue;
			}
			System.out.println(1 + "~" + i + "=" + sum);
		}
		System.out.println();
		System.out.println("============");
		System.out.println();
		*/
		
		
		//10개씩 합 구하기
		System.out.println("10개씩 합 구하기");
		sum = 0;
		
		for(i=1;i<=100;i++) {
			
			sum += i;
			if(i%10 == 0) {
				System.out.println((i-9)+ "~" + i + "=>" + sum);
				sum = 0;
			}
		}
		
		System.out.println("--------------------");
		
		
	}

}
/*
1~10=55
1~20=210
1~30=465
1~40=820
1~50=1275
1~60=1830
1~70=2485
1~80=3240
1~90=4095
1~100=5050

1~10=55
11~20=155
21~30=255
31~40=355
41~50=455
51~60=555
61~70=655
71~80=755
81~90=855
91~100=955
*/


