class Test2 extends Thread{
	public void run() {
		for(int i=1;i<=50;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}//Test2

public class Ex11_02_Thread {
	public static void main(String[] args) {

		System.out.println("프로그램 시작");

		Test2 t2 = new Test2();
		t2.start(); //start를 호출하면 run메서드가 호출 됨



		System.out.println("프로그램 끝");

	}
}
