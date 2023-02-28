class Person { // Person class 선언 (첫 글자는 대문자)
	String name; // 멤버 변수 (인스턴스 변수)
	int age;
	double height;
	static String nation; // 멤버 변수(static 변수/정적 변수/클래스 변수)
	// static을 쓰면 여러 객체에서 공유해서 공통으로 사용 가능
	
	public Person() {
		System.out.println("숨어있는 생성자");
	}
	
}

//노트 그림 참고

// ** 책에서 클래스 부분 읽어보기 (중요)

public class Ex05_01_클래스 {

	public static void main(String[] args) {
		
		//클래스: 내가 만들어 쓰는 자료형(사용자 정의 자료형)
		//int a;
		//double b;
		
		//Orange c;
		//Winter d;
		
		//woman, man : 참조 변수 
		Person woman = new Person(); 
		// 객체를 만든다.(공간을 할당해주는 것), 인스턴스(instance)
		woman.name = "아이유";
		woman.age = 30;
		woman.height = 189.2;
		//woman.nation = "대한민국";
		Person.nation = "대한민국";
		
		System.out.println(woman); // Person@23fe1d71 --> 클래스 이름도 같이 나옴
		System.out.println(woman.name);
		System.out.println(woman.age);
		System.out.println(woman.height);
		//System.out.println(woman.nation);
		System.out.println(Person.nation);
		
		System.out.println("--------------------");
		
		Person man = new Person();
		man.name = "이종석";
		man.age = 40;
		man.height = 162.3;
		
		System.out.println(man);
		System.out.println(man.name);
		System.out.println(man.age);
		System.out.println(man.height);
		//System.out.println(man.nation);
		System.out.println(Person.nation);
		
		
	}

}
