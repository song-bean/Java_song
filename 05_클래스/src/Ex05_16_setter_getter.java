//** 아주 중요한 내용 ** 

//class Person { //이미 같은 프로젝트 안에 클래스를 만들었으면 사용가능(새로 정의 불가)
//	
//}

class Person2 {
	private String name; // private를 쓰면 다른 클래스에서는 사용 불가
	private int age;
	private double height;
	
	//setter 메서드 
	public void setName(String name) { 
		this.name = name; // this.name --> 멤버변수 
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//getter 메서드 
	public String getName() { 
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
}


public class Ex05_16_setter_getter {

	public static void main(String[] args) {
		
		Person2 p = new Person2(); 
		p.setName("이승기");
		p.setAge(40);
		p.setHeight(178.3);
		
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getHeight());
		
//		p.name = "이승기";
//		p.age = 40;
//		p.height = 178.3;
//		
//		System.out.println(p.name);
//		System.out.println(p.age);
//		System.out.println(p.height);
		
	}

}
