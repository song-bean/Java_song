class DaemonTest extends Thread{
	public void run() {
		
		while(true) {
			try {
				sleep(3000); //Thread를 상속받아서 Thread.sleep를 쓸 필요 없음 --> sleep만 쓰면 됨
			}catch(InterruptedException e) {
				e.printStackTrace(); //왜 예외가 발생한건지 경로를 역추적
			}
			
			if(Ex11_06_Daemon.autoSave) { // 변수, autoSave의 값이 true이면 autoSave()를 호출한다.
				autoSave(); // 메서드
			}
			
		}//while
	}//run()
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
	
}//DaemonTest

public class Ex11_06_Daemon {
	
	static boolean autoSave = false; //	= false를 안써도 자동으로 false가 들어가 있음
	
	public static void main(String[] args) {
		
		DaemonTest t = new DaemonTest();
		t.setDaemon(true); // t로 관리하는 run메서드를 데몬스레드로 설정, 이 부분이 없으면 종료되지 않음
		t.start();
		
		for(int i=1;i<=20;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(i);
			
			if(i == 5) {
				autoSave = true;
			}
		}//for
		
		System.out.println("프로그램을 종료합니다.");
		// System.exit(0); // t.setDaemon(true);으로 된 문장이 없으면 이 문장을 통해 종료해야 함
	}

}
//데몬스레드: 다른 일반스레드의 작업을 돕는 보조 스레드