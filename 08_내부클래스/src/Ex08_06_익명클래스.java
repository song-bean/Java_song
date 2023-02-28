interface RemoteControll {
	void turnOn();
	void turnOff();
}//RemoteControll
class TV implements RemoteControll{

	@Override
	public void turnOn() {
		System.out.println("TV를 켠다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끈다.");
	}
	
}
public class Ex08_06_익명클래스 {
	public static void main(String[] args) {
		
		TV t = new TV();
		t.turnOn();
		t.turnOff();
		System.out.println();
		
		RemoteControll rc = new RemoteControll() {
			public void turnOn() {
				System.out.println("TV를 켠다.");
			}

			public void turnOff() {
				System.out.println("TV를 끈다.");
			}
		};
		
		rc.turnOn();
		rc.turnOff();
		
		
		
	}

}
