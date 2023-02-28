class Person2 {
	private String name;
	private int age;
	
	public Person2() {
		
	}
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;	
	}
	
	public void show() {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}
}//Person2

class Employee2 extends Person2 {
	//private String name;
	//private int age;
	private String company;
	private String part;
	
	public Employee2() {
		super();
	}
	
	public Employee2(String name, int age, String company, String part) {
		super(name, age);
		this.company = company;
		this.part = part;
	}
	
	public void show() { 
		super.show();
		System.out.println("company:" + company);
		System.out.println("part:" + part);
	}
	
}//Employee2

class Teacher extends Employee2 { // 두 개의 부모클래스는 불가, 대를 이러서 상속 받는것은 가능(Per-->Emp-->Tea)
	//private String name;
	//private int age;
	//private String company;
	//private String part;
	private String subject;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, int age, String company, String part, String subject) {
		super(name,age,company,part);
		this.subject = subject;
	}
	public void show() {
		super.show();
		System.out.println("subject:" + subject);
	}
	
	
}//Teacher

public class Ex06_04_상속 {
	public static void main(String[] args) {
		
		Person2 p = new Person2("제니", 20);
		p.show();
		System.out.println("------------------------------");
		
		Employee2 e = new Employee2("지디", 30, "쌍용출판사", "인사부");
		//Person2 e = new Employee2("지디", 30, "쌍용출판사", "인사부");
		e.show();
		System.out.println("------------------------------");
		
		Teacher t = new Teacher("태연", 50, "SM고", "생활지도부", "음악");
		//Person2 t = new Teacher("태연", 50, "SM고", "생활지도부", "음악");
		t.show();
		System.out.println("------------------------------");
		
		System.out.println("*************다형성*************");
		Person2[] arr = { 
							new Person2("제니", 20),
							new Employee2("지디", 30, "쌍용출판사", "인사부"),
							new Teacher("태연", 50, "SM고", "생활지도부", "음악")
						};
		for(int i=0;i<arr.length;i++) {
			arr[i].show();
			System.out.println("------------------------------");
		}
		
		
	}

}
