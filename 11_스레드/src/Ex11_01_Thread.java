class Test1 implements Runnable{ //Runnable 인터페이스를 상속받는 클래스 필요 

	@Override
	public void run() {
		for(int i=1;i<=50;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
public class Ex11_01_Thread {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		Test1 t1 = new Test1();
		Thread th1 = new Thread(t1);
		//t1.run();
		th1.start(); //th1.run();을 쓰면 안되고 start();를 쓰면 run메서드를 호출함
		
		
		
		System.out.println("프로그램 끝");
		
	}

}

//두개의 스레드가 동시에 동작하는 것: 멀티스레드
//스레드를 사용하기 위해서는 Runnable 인터페이스를 상속받는 클래스 필요 
