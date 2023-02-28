import java.util.ArrayList;

public class Ex10_13 {
	public static void main(String[] args) {
		
		int[] arr = new int[1000000];
		int i;
		long start = System.currentTimeMillis();// 1970.1.1/0시0분0초부터 지금까지 흘러온 시간
		System.out.println("start:" + start);
		for(i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		long end = System.currentTimeMillis();
		System.out.println("배열 경과한 시간:" + (end - start));
		
		
		start = System.currentTimeMillis();
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		for(i=0;i<arr.length;i++) {
			list.add(i);
		}
		end = System.currentTimeMillis();
		System.out.println("컬렉션 경과한 시간:" + (end - start));
		
	}
}
