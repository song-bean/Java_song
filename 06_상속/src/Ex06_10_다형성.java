class Car {
	String color = "white";
	int door = 4;
	
	void drive() {
		System.out.println("drive~");
	}
	void stop() {
		System.out.println("stop!!");
	}
}// Car 

class FireEngine extends Car {
	int door = 6;
	int wheel = 10;
	void drive() {
		System.out.println("FEdrive~");
	}
	void water() {
		System.out.println("water!!");
	}
}// FireEngine

public class Ex06_10_다형성 {
	public static void main(String[] args) {
		
		Car c = new Car();
		System.out.println(c.color);
		System.out.println(c.door);
		c.drive();
		c.stop();
		System.out.println("--------------------");
		
		FireEngine fe = new FireEngine();
		System.out.println(fe.door); // 6
		System.out.println(fe.wheel); // 10
		System.out.println(fe.color); // white
		fe.drive(); // FEdrive~
		fe.water(); // water!!
		fe.stop(); // stop!!
		System.out.println("--------------------");
		
		System.out.println("***업캐스팅***");
		// **다형성**
		//c = (Car)fe;
		c = fe; // Car 타입 = FireEngine 타입 --> 업캐스팅
		//변수는 오직 부모것만 사용
		//메서드의 경우: 부모가 물려준 것에만 접근 --> 자식의 메서드 호출
		//주소가 바뀜(자식주소로)
		//갖고 있는 것은 자식 주소인데 부모가 갖고 있는 것이 확인이 되어야 자식의 메서드가 호출이 됨
		
		System.out.println(c.color); // 4
		//System.out.println(c.wheel);
		System.out.println(c.door); // white 
		c.drive(); // FEdrive~
		c.stop(); // stop!!
		//c.water(); // 부모가 갖고 있지 않기 때문에 사용 불가
		System.out.println("--------------------");
		System.out.println("***다운캐스팅***");
		
		if(c instanceof FireEngine) { // c변수를 FireEngine 타입으로 바꿀 수 있는 지 물어보는 연산자
			System.out.println("다운캐스팅 가능");
			
			FireEngine fe2;
			fe2 = (FireEngine)c; // 다운캐스팅(직접 해야 됨) 
			//c가 갖고 있던 fe변수가 fe2에도 저장됨 --> 부모에 저장되어 있던 자식 주소가 또 다른 자식 주소에 들어감 
			// 업캐스팅한 기록이 없으면 다운캐스팅도 불가능
			
			System.out.println(fe2.door); // 6
			System.out.println(fe2.wheel); // 10
			System.out.println(fe2.color); // white
			fe2.drive(); // FEdrive~
			fe2.water(); // water!!
			fe2.stop(); // stop!!
		}
		else {
			System.out.println("다운캐스팅 불가능");
		}
		
		
		
		
	}

}
