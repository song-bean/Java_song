class Big extends Thread{ // Thread 상속
	//A~Z 출력
	public void run() {
		for(char i='A';i<='Z';i++) {
			System.out.print(i + " ");
			try {
				sleep(100); // static, 1000은 1초 --> 1초 잠자고 깨어나서 다음줄
			}catch(InterruptedException e) { // 잠자는 중에 예외가 발생할 수 있음

			}
		}
	}
}//Big
class Small implements Runnable{ // Runnable
	//a~z 출력 
	public void run() {
		for(char i='a';i<='z';i++) {
			System.out.print(i + " ");

			try {
				Thread.sleep(100); // static, 1000은 1초 --> 1초 잠자고 깨어나서 다음줄
			}catch(InterruptedException e) { // 잠자는 중에 예외가 발생할 수 있음

			}
		}
	}
}//Small

public class Ex11_03_Thread {
	public static void main(String[] args) {

		System.out.println("프로그램 시작");

		Big b = new Big();
		b.start();

		Small s = new Small();
		Thread t = new Thread(s);
		t.start();



		System.out.println("프로그램 끝");

	}
}
