
public class Ex04_06_2차원 {

	public static void main(String[] args) {
		
		int i,j;
		
		//int[][] arr = { {1,2,3,4} , {5,6,7,8}};
		//int[][] arr = new int[][]{ {1,2,3,4} , {5,6,7,8}};
		int[][] arr = new int[2][4];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;
		arr[1][0] = 5;
		arr[1][1] = 6;
		arr[1][2] = 7;
		arr[1][3] = 8;
		
		
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//확장 for문
		for(int[] x : arr) { 
		// int[] x = {1,2,3,4} --> int[] x = {5,6,7,8,} 한 행이 통째로 들어가는 방식
			for(int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}

	}

}
