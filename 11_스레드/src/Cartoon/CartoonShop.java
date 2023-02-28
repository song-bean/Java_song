package Cartoon;

import java.util.Vector;

public class CartoonShop {
	
	Vector<String> v = new Vector<String>();
	
	public CartoonShop() {
		v.addElement("슬램덩크"); // 0
		v.addElement("명탐정 코난"); // 1
		v.addElement("원피스"); // 2
	}
	
	public synchronized String lendCartoon() throws InterruptedException { // InterruptedException를 lendCartoon() 호출한 쪽에서 처리하도록 던짐
		
		Thread t = Thread.currentThread(); // 현재 접속한 스레드가 어떤거냐
		if(v.size() == 0) {
			System.out.println(t.getName() + ": 번호표 받음");
			wait(); //InterruptedException, notify하기 전까지는 다음으로 안 넘어감
			System.out.println(t.getName() + ": 다음 순서");
		}
		
		String str = v.remove(v.size()-1); // 2
		return str;
	}//lendCartoon
	
	public synchronized void returnCartoon(String cartoon) {
		v.addElement(cartoon);
		notify(); // wait한테 알려줌
	}//returnCartoon
	
}
