class Data {
	public int i = 0; // 공유자원 
	
}//Data

class AA extends Thread {
	public void run() {
		for(int i=0;i<100000;i++) { // 지역변수 i 
			Ex11_07_NotSyncTest.d.i++; //공유자원 --> 임계영역
		}
		System.out.println("AA : " + Ex11_07_NotSyncTest.d.i);
	}
}//AA

class BB extends Thread {
	public void run() {
		for(int i=0;i<100000;i++) {
			Ex11_07_NotSyncTest.d.i++; //공유자원 --> 임계영역
		}
		System.out.println("BB : " + Ex11_07_NotSyncTest.d.i);
		
	}
}//BB

public class Ex11_07_NotSyncTest { // 동기화 안한 예제
	
	public static Data d = new Data(); // i=0을 가지고 있음
	
	public static void main(String[] args) {
		
		System.out.println("main 시작");
		
		AA t1 = new AA();
		BB t2 = new BB();
		t1.start();
		t2.start();
		
		
		System.out.println("main 끝");
		
	}

}
