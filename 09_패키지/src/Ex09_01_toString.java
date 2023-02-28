class Student { //extends Object 
	private String name;
	private int hakbun;

	public Student(String name, int hakbun) {
		super();
		this.name = name;
		this.hakbun = hakbun;
	}

	public String toString() {
		return name + "/" + hakbun;
	}
	
	// 객체가 받겠다 하는 경우 정수는 Integer 숫자 형식으로 해야 됨 --> 사실 autoboxing 기능이 있어서 숫자만 써도 되긴 함
	public boolean equals(Object obj) { // this가 숨어있다. 
		//Object obj = new Student("슈가",2000) --> 업캐스팅
		//System.out.println(obj instanceof Student);
		
		if(obj instanceof Student) { // 업캐스팅 한 적이 있으면 true --> 다운캐스팅 가능
			Student s = (Student)obj;
			return this.hakbun == s.hakbun && this.name.equals(s.name);//s1의 학번 == s2의 학번 
		}
		else {
			return false;
		}
	}


}//Student
public class Ex09_01_toString {
	public static void main(String[] args) {

		Student s1 = new Student("정국",2000);
		Student s2 = new Student("슈가",2000);  

		//		System.out.println(s1.str());
		//		System.out.println(s2.str());

		System.out.println(s1.toString()); 
		System.out.println(s1); // 참조변수만 써도 toString()이 자동으로 붙음
		System.out.println(s2.toString());
		System.out.println(s2);
		boolean result = s1.equals(s2); // 둘의 주소가 같은 지 비교하는 것(원래 기능) --> false 
		System.out.println("result:" + result);
	}

}

//Object --> toString()의 기능: 주소를 리턴 
//public boolean equals(Object obj)의 기능; 주소 비교