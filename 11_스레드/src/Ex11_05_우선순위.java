class Horizontal extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			if(i%50 == 0) {
				System.out.println();
			}
		}
	}
}//Horizontal

class Vertical extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			if(i%50 == 0) {
				System.out.println();
			}
		}
	}
}//Horizontal

public class Ex11_05_우선순위 {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		Horizontal h = new Horizontal();
		Vertical v = new Vertical();
		
		System.out.println(h.getName()); // Thread-0 자동으로 스레드 이름이 설정됨
		System.out.println(v.getName()); // Thread-1
		
		System.out.println("h.getPriority():" + h.getPriority()); // h의 우선순위 
		System.out.println("v.getPriority():" + v.getPriority());
		
		v.setPriority(7);
		h.start();
		v.start();
		
		System.out.println("프로그램 끝");
		
	}
}

//숫자가 클수록 우선순위가 높다(1~10)
//우선순위는 상대적
//기본 우선순위는 5