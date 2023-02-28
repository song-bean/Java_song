
public class Ex05_08_배열넘기기 {

	public static void main(String[] args) {
		
		int[] arr = {30,40,50};
		int i;
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		sub(arr[0], arr[1], arr[2]);
		sub2(arr);
		System.out.println("-------------------");
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}//main

	static void sub(int x, int y, int z) {
		System.out.println("sub 메서드 정의");
		System.out.println(x + "," + y + "," + z);
	}
	
	static void sub2(int[] des) {
		System.out.println("sub2 메서드 정의");
		int i;
		for(i=0;i<des.length;i++) {
			System.out.print(des[i] + " ");
		}
		System.out.println();
		des[1] = 999;
		//return;
	}
	
}
