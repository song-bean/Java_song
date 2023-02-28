import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;

class ExPanel extends Frame {
	public ExPanel() {
		setTitle("3번 예제"); // 제목 설정
		setSize(300,400);
		
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		Button b3 = new Button("버튼3");
		
		b1.setBackground(Color.cyan);
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		
		//setLayout(new FlowLayout());
		p1.add(b1); // 패널에 올라가는건 자동으로 FlowLayout , 프레임에 올라가는 건 자동으로 BorderLayout
		p2.add(b2);
		p3.add(b3);
		
		p1.setBackground(Color.green);
		p2.setBackground(Color.yellow);
		p3.setBackground(Color.pink);
		
		add("North",p1);
		this.add("Center",p2);
		super.add("South",p3);
		
		setVisible(true);
	}
}
public class Ex13_03_Panel {
	public static void main(String[] args) {

		new ExPanel();

	}
}
