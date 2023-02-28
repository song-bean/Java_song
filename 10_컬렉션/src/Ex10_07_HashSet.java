import java.util.HashSet;
import java.util.Iterator;

public class Ex10_07_HashSet {
	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		System.out.println(hs.size());
		
		hs.add("수지");
		hs.add("웬디");
		hs.add("수지"); //에러는 아니지만, 중복이어서 알아서 안들어감
		hs.add("윤아");
		
		System.out.println(hs.size()); // 3 --> 수지가 하나만 들어감
		System.out.println(hs.toString()); //[수지, 웬디, 윤아]
		//System.out.println(hs.get(0)); --> 위치가 따로 없음(순서가 없음) --> get 사용 불가
		
		for(String s: hs) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		//hs.elements()도 없음 --> Enumeration불가
		
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		//hs.add(1,"아이유"); 위치를 정해서 넣는 것 불가
		
		boolean result =  hs.contains("웬디"); //웬디가 포함되어 있는가
		System.out.println("result:" + result);
		
		//hs.clear(); // 다 지우는 것
		hs.remove("윤아"); // 일부만 지우는 것
		result = hs.isEmpty(); // 데이터가 없는가 --> 없으면 true, 있으면 false
		System.out.println("result:" + result);
		System.out.println(hs);
	}
}
