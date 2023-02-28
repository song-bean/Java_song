
public class Ex04_04_2차원 {

	public static void main(String[] args) {
		
		int i,j;
		// 가변배열 
		int[][] arr= {
						{11,22,33}, //0행 
						{44,55}, //1행 
						{13,29,72, 89}, //2행 
						{39,98,31} //3행 
					}; // 2차원 배열 (노트 그림 참고)
		
		System.out.println("arr: " + arr);
		System.out.println("arr[0]: " + arr[0]); // 0행 첫 방의 주소 
		System.out.println("arr[1]: " + arr[1]); // 1행 첫 방의 주소
		System.out.println("arr[2]: " + arr[2]);
		System.out.println("arr[3]: " + arr[3]);
		
		System.out.print(arr[0][0] + " ");
		System.out.print(arr[0][1] + " "); // 0행 1열 
		System.out.println(arr[0][2]);
		
		System.out.print(arr[1][0] + " ");
		System.out.println(arr[1][1] + " ");
		//System.out.println(arr[1][2]);
		
		System.out.print(arr[2][0] + " ");
		System.out.print(arr[2][1] + " ");
		System.out.println(arr[2][2]);
		
		System.out.print(arr[3][0] + " ");
		System.out.print(arr[3][1] + " ");
		System.out.println(arr[3][2]);
		
		System.out.println("arr의 길이: " + arr.length); // 행의 개수 
		System.out.println("arr[0]의 길이: " + arr[0].length); // 0행의 열의 개수
		System.out.println("arr[0]의 길이: " + arr[1].length);
		System.out.println("arr[0]의 길이: " + arr[2].length);
		System.out.println("arr[0]의 길이: " + arr[3].length);
		
		System.out.println("--------------------");
		
		for(i=0;i<arr.length;i++) {
			
			for(j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int[] x: arr) {
			for(int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
		
		
	}
}
