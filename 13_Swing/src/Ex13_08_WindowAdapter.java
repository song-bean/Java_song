import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExWindowAdapter extends Frame {
	
	public ExWindowAdapter() {
		this.addWindowListener(new MyWindow());
	}
	
	class MyWindow extends WindowAdapter{ // 내부클래스
		public void windowClosing(WindowEvent e) {
			System.out.println("창이 닫힘");
			System.exit(0);
		}
		public void windowActivated(WindowEvent e) {
			System.out.println("창이 활성화됨");
		}
	}
}

public class Ex13_08_WindowAdapter {
	public static void main(String[] args) {
		
		Frame ex = new ExWindowAdapter();
		
		ex.setSize(300,300);
		ex.setTitle("WindowAdater 이벤트");
		ex.setVisible(true);
		
		
	}
}
