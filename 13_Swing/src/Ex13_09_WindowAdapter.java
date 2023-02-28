import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExWindowAdapter2 extends Frame {

	public ExWindowAdapter2() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("창이 닫힘");
				System.exit(0);
			}
			public void windowActivated(WindowEvent e) {
				System.out.println("창이 활성화됨");
			}
			//익명 클래스 형태로 작성이 됨
		});
	}
	
	
	
//	class MyWindow extends WindowAdapter{ // 내부클래스
//		public void windowClosing(WindowEvent e) {
//			System.out.println("창이 닫힘");
//			System.exit(0);
//		}
//		public void windowActivated(WindowEvent e) {
//			System.out.println("창이 활성화됨");
//		}
//	}
	
}
public class Ex13_09_WindowAdapter {
	public static void main(String[] args) {

		Frame ex = new ExWindowAdapter2();

		ex.setSize(300,300);
		ex.setTitle("WindowAdater 이벤트");
		ex.setVisible(true);

	}
}
