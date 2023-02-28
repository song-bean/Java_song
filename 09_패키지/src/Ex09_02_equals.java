class Person {
	private String name;
	private int age;
	private char bloodType;

	public Person(String name, int age, char bloodType) {
		super();
		this.name = name;
		this.age = age;
		this.bloodType = bloodType;
	}

	public boolean equals(Object o) {

		if(o instanceof Person) { 
			Person p = (Person)o;
			if(this.age == p.age && this.bloodType == p.bloodType) {
				
				return true;
			}
			else {
				return false;
			}
		}
		else return false;
	}


}//Person
public class Ex09_02_equals {
	public static void main(String[] args) {

		Person p1 = new Person("윤아",30,'A');
		Person p2 = new Person("태연",50,'O');
		boolean result = p1.equals(p2);
		System.out.println("result:" + result);

		if(p1.equals(p2) == true) {
			System.out.println("나이와 혈액형이 같습니다.");
		}
		else {
			
			System.out.println("나이와 혈액형이 같지 않습니다.");
		}
	}

}
