class Data3 {
	public int i = 0; // 공유자원 
	
	public synchronized void a() { // synchronized 메서드의 예
		for(int i=0;i<100000;i++) { // 지역변수 i 
			this.i++;
		}
		System.out.println("Data3 a() i : " + i);
	}
	
	//먼저 나오는 synchronized된 a()부분이 끝나기 전까지는 뒤에 나오는 synchronized된 b()부분은 대기상태가 된다.
	public synchronized void b() { // synchronized 메서의 예
		for(int i=0;i<100000;i++) { // 지역변수 i 
			this.i++;
		}
		System.out.println("Data3 b() i : " + i);
	}
	
}//Data2

class AA3 extends Thread {
	public void run() {
		Ex11_09_SyncTest.d.a();
	}
}//AA3

class BB3 extends Thread {
	public void run() {
		Ex11_09_SyncTest.d.b();
	}
}//BB3

public class Ex11_09_SyncTest {
	public static Data3 d = new Data3(); // i=0을 가지고 있음

	public static void main(String[] args) {

		System.out.println("main 시작");

		AA3 t1 = new AA3();
		BB3 t2 = new BB3();
		t1.start();
		t2.start();
		
		


		System.out.println("main 끝");

	}
}
