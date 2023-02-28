
public class Ex04_07_정렬 {

	public static void main(String[] args) {
		
		int[] arr = {8,3,5,2,9};
		
		int i, j, temp = 0;
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			}
		System.out.println();
		
		
		// a<-->b
		System.out.println();
		int a =10, b =20;
		System.out.println(a + "," + b);
		temp=b;
		b=a;
		a=temp;
		System.out.println(a + "," + b);
		System.out.println();
		
		//int[] arr2 = {7,5,3,8,4};
		
		//선택정렬(노트 그림 참고)
		//i=0 j=1 2 3 4 
		//i=1 j=2 3 4
		//i=2 j=3 4
		//i=3 j=4		
		//오름차순 정렬
		for(i=0;i<arr.length-1;i++) {
			for(j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			}
		
	}
		
}

