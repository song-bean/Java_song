class Robot {
	
}//Robot

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}//DanceRobot

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 부릅니다.");
	}
}//singRobot

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}//DrawRobot

public class Ex06_11_다형성 {
	public static void main(String[] args) {
		
		Robot a = new DanceRobot(); // 자식클래스를 부모로 관리할 수 있음
		Robot b = new SingRobot();
		Robot c = new DrawRobot();
		
		// 위 셋이 같은 타입이므로 배열로 나타냄
		Robot[] arr = { // 각각의 주소가 배열에 저장됨
						new DanceRobot(), // 100번지
						new SingRobot(), // 200번지
						new DrawRobot() // 300번지
						};
		for(int i =0;i<arr.length;i++) {
			action(arr[i]); 
			// i=0 arr[0]=100번지  
			// i=1 arr[1]=200번지  
			// i=2 arr[2]=300번지  
		}
	}// main
	
//	Robot r = (Robot)new DanceRobot(); // i=0
//	Robot r = (Robot)new SingRobot(); // i=1, r=200번지
//	Robot r = (Robot)new DrawRobot(); // i=2
		
	public static void action (Robot r) {
		//r.dance(); 부모가 갖고 있어야 자식의 댄스메서드가 호출됨, 하지만 없기 때문에 호출이 안됨 
		if(r instanceof DanceRobot) {
			DanceRobot dr = (DanceRobot) r; // 부모가 댄스메서드가 있으면 없어도 되지만, 부모가 댄스메서드가 없기 때문에 댄스로봇에 주소를 넣어줘야 함
			dr.dance();
		}
		else if(r instanceof SingRobot) {
			SingRobot sr = (SingRobot)r;
			sr.sing();
		}
		else if(r instanceof DrawRobot) {
			DrawRobot dw = (DrawRobot)r;
			dw.draw();
		}
	}
	

}


