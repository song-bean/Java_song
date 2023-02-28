class Count {
	
	static int a; // 초기값이 없어도 기본값이 들어감
	int b;
	//기본값 정리하기
	
	void increment() { // 노트 그림 참고
		int c = 0; // 지역변수 - 초기값이 있어야 함
		a++;
		b++;
		c++;
		System.out.println("static 변수 a:" + a);
		System.out.println("instance 변수 b:" + b);
		System.out.println("지역 변수 c:" + c);
		System.out.println();
		
	}
	
}//Count
public class Ex05_09_변수 {
	public static void main(String[] args) {
		
		//int x; // 지역변수 
		//System.out.println(x);
		
		Count cnt1 = new Count();
		//System.out.println(cnt1.a);
		//System.out.println(cnt1.b);
		
		cnt1.increment();
		cnt1.increment();
		
		Count cnt2 = new Count();
		cnt2.increment();
		cnt2.increment();
		
		Count cnt3 = new Count();
		cnt3.increment();
		cnt3.increment();
		
		

	}

}

/*
 멤버변수: (a)정적변수/static/class,  --> 기본값 o
 		 	생성시점 --> 클래스 이름이 언급되면 생성
 		 	소멸시점 --> main 메서드 끝날 때(프로그램 종료시) 소멸 
 		 (b)인스턴스 변수 --> 기본값 o
 		 	생성시점 --> 객체가 생성되면 생성
 		 	소멸시점 --> main 메서드 끝날 때(프로그램 종료시) 소멸 
 		 	
 매개변수: 지역변수의 특징을 갖는다. 
 		 사용범위 --> 선언된 {} 안에서만 사용 가능 
 		 
 참조변수
 
 (c)지역변수: 메서드 안에 선언한 변수 --> 기본값 x
 		 생성시점 --> 해당 {} 안으로 들어왔을 때 생성 
 		 소멸시점 --> 해당 {}이 종료시 소멸 
 		 사용범위 --> 선언된 {} 안에서만 사용 가능 
 */
