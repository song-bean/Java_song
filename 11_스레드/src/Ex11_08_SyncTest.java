class Data2 {
	public int i = 0; // 공유자원 

}//Data2

class AA2 extends Thread {
	public void run() {
		for(int i=0;i<100000;i++) { // 지역변수 i 
			synchronized(Ex11_08_SyncTest.d) { // synchronized 블록의 예
				Ex11_08_SyncTest.d.i++; //공유자원 --> 임계영역
			}
		}
		System.out.println("AA2 : " + Ex11_08_SyncTest.d.i);
	}
}//AA2

class BB2 extends Thread {
	public void run() {
		for(int i=0;i<100000;i++) {
			synchronized(Ex11_08_SyncTest.d) { // 현재 클래스 안에 공유 자원이 있으면 synchronized(this)라고 쓰면 됨
				Ex11_08_SyncTest.d.i++; //공유자원 --> 임계영역
			}
		}
		System.out.println("BB2 : " + Ex11_08_SyncTest.d.i);
	}
}//BB2

public class Ex11_08_SyncTest { // 동기화 한 예제
	public static Data2 d = new Data2(); // i=0을 가지고 있음

	public static void main(String[] args) {

		System.out.println("main 시작");

		AA2 t1 = new AA2();
		BB2 t2 = new BB2();
		t1.start();
		t2.start();


		System.out.println("main 끝");

	}

}
//동기화 처리 (synchronized)
//synchronized 메서드와 블록 형태로 사용 가능
//먼저 나오는 synchronized된 부분이 끝나기 전까지는 뒤에 나오는 synchronized된 부분은 대기상태가 된다.


