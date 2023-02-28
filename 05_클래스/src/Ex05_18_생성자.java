class Member {
	private String id;
	private String passwd;
	
//생성자는 클래스와 이름이 같은 메서드
//생성자는 리턴하지 않는다(void 쓰면 안됨)
//public은 써도 됨
//생성자는 객체를 만들면 자동으로 호출 됨 
//제일 먼저하면 좋을 작업을 보통 생성자에 작성 (ex)값을 초기화 하는 작업)
//매개변수가 있는 생성자가 있으면 default 생성자는 자동으로 생성되지 않음 (그 외에는 자동으로 생성) 

	public Member() {// 생성자(메서드)-constructor
		System.out.println("Member() 생성");
		id = "park";
		passwd = "9876";
	}
//생성자 오버로딩
	public Member(String id, String passwd) { 
		System.out.println("Member(String a, String b) 생성자");
		this.id = id;
		this.passwd = passwd;
	}	
	public Member(String id) { // default 생성자 자동으로 호출x
		System.out.println("Member(String a) 생성자");
		this.id = id;
		this.passwd = "9876";
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	
}

public class Ex05_18_생성자 {
	public static void main(String[] args) {
		
		Member mem1 = new Member(); // 객체 생성 --> 생성자 호출 
		mem1.setId("kim");
		mem1.setPasswd("1234");
		
		
		
		System.out.println("id:" + mem1.getId()); //kim
		System.out.println("passwd:" + mem1.getPasswd()); //1234
		System.out.println("--------------------------------");
		
		Member mem2 = new Member(); // 객체를 만들어서 생성자가 호출 됨
		System.out.println("id:" + mem2.getId()); //park
		System.out.println("passwd:" + mem2.getPasswd()); //9876
		
		mem2.setId("jung");
		mem2.setPasswd("3333");
		System.out.println("id:" + mem2.getId()); //jung
		System.out.println("passwd:" + mem2.getPasswd()); //3333
		System.out.println("--------------------------------");
		
		Member mem3 = new Member("hong","7777");
		System.out.println("id:" + mem3.getId()); 
		System.out.println("passwd:" + mem3.getPasswd()); 
		System.out.println("--------------------------------");
		
		Member mem4 = new Member("choi");
		System.out.println("id:" + mem4.getId()); 
		System.out.println("passwd:" + mem4.getPasswd()); 
		
		System.out.println("================================");
		
		
		//Member[] mem = {new Member(),new Member(),new Member("hong","7777"),new Member("choi")};
		Member[] mem = new Member[4];
		mem[0] = new Member();
		mem[0].setId("kim");
		mem[0].setPasswd("1234");
		
		mem[1] = new Member();
		mem[1].setId("jung");
		mem[1].setPasswd("3333");
		
		mem[2] = new Member("hong","7777");
		
		mem[3] = new Member("choi");
		int i;
		for(i=0;i<mem.length;i++) {
			System.out.println("id:" + mem[i].getId());
			System.out.println("passwd:" + mem[i].getPasswd());
			System.out.println();
		}
		
		
		
	}//main
		
}

