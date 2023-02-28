import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Ex10_06_Vector {
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		System.out.println(v.size());
		
		v.add("봄");
		v.add("여름");
		v.add("봄");
		v.add("겨울");
		
		System.out.println("v:" + v); // [봄, 여름, 봄, 겨울]
		System.out.println(v.size());
		System.out.println(v.get(0)); // 여기까지는 ArrayList와 같음 
		
		System.out.println();
		System.out.println("for문");
		int i;
		for(i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		System.out.println();
		
		System.out.println("확장for문");
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		
		System.out.println("Iterator");
		Iterator<String> iter = v.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("Enumeration");
		Enumeration<String> en = v.elements(); // ArrayList에는 없음, Vector에서 사용 가능
		while(en.hasMoreElements()) {
			String s = en.nextElement();
			System.out.print(s + " ");
		}
		
		
	}
}

//중복 되고, 순서 있음
