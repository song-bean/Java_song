import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ExWindow extends Frame implements WindowListener{
	
	public ExWindow() {// 생성자
		this.addWindowListener(this); // new WindowEvent()
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("창이 닫힘");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("창이 활성화됨");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}//ExWindow

public class Ex13_07_WindowEvent {
	public static void main(String[] args) {
		
		ExWindow ex = new ExWindow();
		// 프레임을 만들었다 --> 윈도우창을 만들었다
		
		ex.setSize(300,300);
		ex.setTitle("Window 이벤트");
		ex.setVisible(true);
		
	}
}
