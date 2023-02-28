public class Ex04_02_1차원 {

	public static void main(String[] args) {
		
		int sum = 0, i;
		for(i=1;i<11;i++) {
			sum += i;
		}
		System.out.println("sum= " + sum);
		System.out.println();
		
		sum = 0;
		int[] jumsu = {79, 88, 91, 33, 100, 55, 95};
		
		// 일반for문 
		for(i=0;i<jumsu.length;i++) {
			System.out.print(jumsu[i] + " ");
			sum += jumsu[i];
		}
		System.out.println();
		System.out.println("jumsu sum = " + sum);
		System.out.println("평균: " + sum/jumsu.length);
		System.out.println("평균: " + (double)sum/jumsu.length);
		System.out.printf("평균: %.3f\n", (double)sum/jumsu.length);
		System.out.println("----------------------");
		
		
		// 확장for문 
		sum = 0;
		for(int x : jumsu) {
			System.out.print(x + " ");
			sum += x;
		}
		System.out.println();
		System.out.println("jumsu sum = " + sum);
		System.out.println("평균: " + sum/jumsu.length);
		System.out.println("평균: " + (double)sum/jumsu.length);
		System.out.printf("평균: %.3f\n", (double)sum/jumsu.length);
		System.out.println("----------------------");
		
		
		int max;
		int min;
		max = jumsu[0];
		min = jumsu[0];
		for(i=1;i<jumsu.length;i++) {
			if(max < jumsu[i]) {
				max = jumsu[i]; // 79 88 91 100
			}
			if(min > jumsu[i]) {
				min = jumsu[i]; // 79 33
			}
		}
		
		System.out.println("가장 큰 값: " + max);
		System.out.println("가장 작은 값: " + min);
		
		
		
	}

}
