import java.util.ArrayList;
import java.util.Iterator;

class Person {
	private String id;
	private String pw;
	
	public Person(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	
	public String toString() {
		return id+"/"+pw;
	}
	
}//Person

public class Ex10_03_ArrayList {
	public static void main(String[] args) {
		
		Person p1 = new Person("kim","1111");
		Person p2 = new Person("park","3333");
		//Person p3 = new Person("choi","5555");
		
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1); // list에 주소가 추가됨
		list.add(p2);
		list.add(new Person("choi","5555"));
		
		// 주소가 출력됨 --> 오버라이딩해서 [kim/1111, park/3333, choi/5555]이렇게 출력되게 바꿈
		System.out.println(list.toString()); 
		System.out.println();

		
		int i;
		for(i=0;i<list.size();i++) {
			Person p = list.get(i);
			System.out.println(p);
		}
		System.out.println();
		
		// 반복자 --> 반복할 준비를 하면 Iterator 타입으로 바뀌어서 iter에 들어감
		Iterator<Person> iter = list.iterator(); 
		while(iter.hasNext()) { // iter변수로 반복할 것이 있냐 --> 있으면 참
			Person p = iter.next(); // 하나 가지고 와서 p에 저장
			//System.out.println(p); //kim/1111 park:3333 choi/5555
			System.out.println(p.getId() + ":" + p.getPw());
		}
		
		
		
		
	}
}
