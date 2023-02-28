import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExTctionEvent extends Frame implements ActionListener{

	Button b1, b2, b3, b4; 
	
	public ExTctionEvent() {
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("창이 닫힘");
				System.exit(0);
			}
		});
		
		b1 = new Button("노란색"); // --> actionevent
		b2 = new Button("빨간색");
		b3 = new Button("파란색");
		b4 = new Button("분홍색");

		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		add(b4);

		b1.addActionListener(this); // 버튼을 눌렀는지 듣기위해 보청기를 달아야 함
		b2.addActionListener(this); // this는 현재 클래스
		b3.addActionListener(this);
		b4.addActionListener(this);

		// button이 클릭됐을 때 자동으로 new ActionEvent() 객체 생성

		setVisible(true);
		setSize(400,300);
	}

	@Override // ActionListener
	public void actionPerformed(ActionEvent e) {
		//ActionEvent e = new ActionEvent();
		
		System.out.println("버튼 눌림");

		Object obj = e.getSource(); // 어느 버튼에서 이벤트가 발생한 것인지 obj에 저장
		if(obj == b1) {
			setBackground(Color.yellow);
		}
		else if(obj == b2) {
			setBackground(Color.red);
		}
		else if(obj == b3) {
			setBackground(Color.blue);
		}
		else if(obj == b4) {
			setBackground(Color.pink);
		}
	}

}//ExTctionEvent

public class Ex13_04_ActionEvent {
	public static void main(String[] args) {

		new ExTctionEvent();

	}

}

//Button --> ActionEvent --> addActionListener --> implements ActionListener 상속 받기 --> public void actionPerformed(ActionEvent e)
