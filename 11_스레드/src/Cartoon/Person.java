package Cartoon;

public class Person extends Thread{
	
	
	public Person(String name) {
		super(name); // Thread 생성자로 넘어감, Thread-0 --> 제니로 스레드 이름이 설정되게 바꿈
	}
	
	public void run() {
		
		try { //throws InterruptedException 한 것을 호출했으므로 예외처리 해줘야 함
			String cartoon = Main.cshop.lendCartoon();
			System.out.println(getName() + ": " + cartoon + " 빌린다");
			System.out.println(getName() + ": " + cartoon + " 보는 중..\n");
			
			sleep(3000);
			System.out.println(getName() + ": " + cartoon + " 반납\n");
			Main.cshop.returnCartoon(cartoon);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
	}
}
