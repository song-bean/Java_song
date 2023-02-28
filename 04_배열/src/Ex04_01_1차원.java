
public class Ex04_01_1차원 {

	public static void main(String[] args) {
		
		int a=10, b=20, c=30, d=40, e=50;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		System.out.println();
		
		//배열: 같은 자료형을 갖는 변수들을 하나로 묶어 놓은 것 (노트 그림참고)
		
		//배열의 방법은 3가지(꼭 외우기!)
		//int[] arr1 = {10,20,30,40,50}; // 메모리 공간이 연속적으로 잡힘
		//int[] arr1 = new int[]{10,20,30,40,50};
		int[] arr1 = new int[5]; // {0,0,0,0,0}
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		arr1[3] = 40;
		arr1[4] = 50;
		
		
		//arr1에는 첫 방의 주소(참조값)가 들어감 
		System.out.println("arr1: " + arr1);
		System.out.println("방의 개수: " + arr1.length);
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println(arr1[3]);
		System.out.println(arr1[4]);
				
		
		System.out.println();
		int i;
		
		// 방번호: 방의 개수 - 1까지만 존재 
		for(i=0;i<arr1.length;i++) { // 일부 요소에 접근할 때(전체도 가능)
			System.out.println("arr1[" + i + "]" + "= " + arr1[i]);
		}
		System.out.println();
		
		System.out.println("확장 for문(arr1)");
		for(int y: arr1) { // 전체방에 접근할 때만 사용
			System.out.println(y);
		}
		System.out.println("---------------------");
		
		//double[] arr2 = {1.1, 2.2, 3.3};
		//double[] arr2 = new double[]{1.1, 2.2, 3.3};
		double[] arr2 = new double[3]; // {0.0, 0.0, 0.0}
		arr2[0] = 1.1;
		arr2[1] = 2.2;
		arr2[2] = 3.3;	
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		System.out.println();
		
		
		System.out.println("요소의 개수: " + arr2.length);
		for(i=0;i<arr2.length;i++) {
			System.out.println("arr2[" + i + "]" + "= " + arr2[i]);
		}
		System.out.println();
		
		System.out.println("확장 for문(arr2)");
		// 확장 for문 (배열에서만 가능)
		//맨 앞방부터 순서대로 x에 넣어라, 굳이 조건식 증감식이 없어도 알아서 됨 
		for(double x : arr2) { //for(double 변수 아무거나 : 배열명) {
			System.out.println(x);
		}
		System.out.println();
		
	}

}
