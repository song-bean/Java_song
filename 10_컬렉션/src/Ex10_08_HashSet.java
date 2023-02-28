import java.util.HashSet;

public class Ex10_08_HashSet {
	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		//1~10 정수 난수 5개 발생 Hashset에 넣고 출력하기
//		while(hs.size() != 5) {
//			hs.add((int)(Math.random()*10)+1);
//		}
//		System.out.println(hs);
		
		while(true) {
			int num1 =(int)(Math.random()*10)+1;
			hs.add(num1);
			
			if(hs.size() == 5) {
				break;
			}
		}
		System.out.println(hs);
		
		Object[] arr = hs.toArray(); // 배열로 바꾸기 --> 방 위치가 생김
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		Integer[] arr2 = new Integer[hs.size()];
		hs.toArray(arr2);
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
	}

}
