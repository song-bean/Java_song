class Sports2 {
	private String name; 
	private int inwon; 
	
	public Sports2(String name, int inwon) {
		this.name = name;
		this.inwon = inwon;
	}
	public String getName() {
		return name;
	}
	public int getInwon() {
		return inwon;
	}
	
	public void display() {
		System.out.println("name:" + name);
		System.out.println("inwon:" + inwon);
	}
	
}

class Baseball2 {
	Sports2 s;
	//Sports2를 포함하는 형식
	private double ta;
	
	public Baseball2(String name, int inwon, double ta) {
		s = new Sports2(name,inwon);
		this.ta = ta;
	}
	
	public void display() {
		
//		System.out.println("name:" + s.getName());
//		System.out.println("inwon:" + s.getInwon());
		s.display();
		System.out.println("ta:" + ta);
	}
	
}


public class Ex06_07_송나영 {
	public static void main(String[] args) {
		
		Baseball2 b = new Baseball2("야구", 9, 0.567);
		b.display();
		
		int a = 1;
		a = 2;
		a = 3;
		
		final int c = 1; // final이 붙으면 값을 바꿀 수 없음
		//c = 2; // =은 대입 연산자 또는 할당 연산자 

	}

}

