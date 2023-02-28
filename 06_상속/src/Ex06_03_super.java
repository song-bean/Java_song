class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("Person() 생성자");
	}
	
	public Person(String name, int age) {
		System.out.println("Person(String name, int age) 생성자");
		this.name = name;
		this.age = age;	
	}
	
	public void show() {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}
	
}// Person

class Student extends Person{
	//private String name;
	//private int age;
	private String school;
	
	public Student() {
		super(); // 부모 생성자는 두 번째 줄 이후에 쓰면 오류남, 안써도 부모 생성자를 부름
		System.out.println("Student() 생성자");
	}
	
	public Student(String name, int age, String school) {
		super(name,age);
		System.out.println("Student() 생성자");
//		this.name = name
//		this.age = age;
		this.school = school;
	}
	
	public void show() {
		super.show();
		System.out.println("school:" + school);
	}
	
}// Student

class Employee extends Person {
	//private String name;
	//private int age;
	private String company;
	private String part;
	
	public Employee(String name, int age, String company, String part) {
		super(name,age);
//		this.name = name
//		this.age = age;
		this.company = company;
		this.part = part;
	}
// 메서드 오버라이딩(overriding) --> 재정의, 상속받는 자식 클래스에 맞게 변경하는 것	
// 선언부가 같아야 함 (메서드 이름, 매개변수 타입, 매개변수 개수, 리턴 타입이 다 같아야 함)	
	public void show() { 
		super.show();
		System.out.println("company:" + company);
		System.out.println("part:" + part);
	}
	
}//Employee

public class Ex06_03_super {
	public static void main(String[] args) {
		
		Person p = new Person("철수", 20);
		p.show();
		
		System.out.println("----------------------------------------");
		Student s = new Student("수영",30,"쌍용고");
		s.show();
		System.out.println("----------------------------------------");
		
		Employee e = new Employee("정국",37,"현대","개발부");
		e.show();
	}

}

