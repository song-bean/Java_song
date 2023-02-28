import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

class Fruit extends JFrame{ //swing은 JFrame --> x를 눌러도 닫힘 but, 프로그램 종료는 아님
	
	String[] text = { "사과", "바나나", "체리"};
	
	ImageIcon[] image = {	
							new ImageIcon("images/apple.jpg"),
							new ImageIcon("images/banana.jpg"),
							new ImageIcon("images/cherry.jpg"),
						};
	
	JLabel imageLabel = new JLabel(""); // 라벨에는 글자도 쓰고 그림도 가능
	JRadioButton[] radio = new JRadioButton[3];
	
	
	public Fruit() {
	
		setTitle("라디오 버튼");
		
		//이렇게 해야 창닫기를 눌러서 프로그램 종료가 가능 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame.EXIT_ON_CLOSE:3
		
		Container contentPane = getContentPane(); // 작업영역을 가지고 올 때 필요
		//contentPane.setLayout(new BorderLayout()); // BorderLayout()은 기본
		
		JPanel p = new JPanel();
		p.setBackground(Color.gray);
		
		ButtonGroup group = new ButtonGroup();
		
		int i;
		
		Font font = new Font("나눔고딕",Font.BOLD,20);
		
;		for(i=0;i<radio.length;i++) {
			radio[i] = new JRadioButton(text[i]);
			group.add(radio[i]); // 그룹으로 묶어야 하나만 선택 가능, 안하면 여러 개 선택이 됨
			p.add(radio[i]);
			radio[i].setFont(font);
			radio[i].addItemListener(new MyItem()); // 괄호 안은 자동으로 실행되는 메서드의 위치를 적어야 함
			// radio버튼은 아이템이벤트가 발생
			//이벤트가 발생하면 자동으로 객체가 생성 --> 그 객체를 받기위한 메서드가 현재 클래스에 있으므로
		}//for 
		
		radio[1].setSelected(true); // 처음에 바나나 이미지가 선택된 것처럼 해라
		
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // 수평정렬(가운데정렬)
		contentPane.add(p,BorderLayout.NORTH);
		contentPane.add(imageLabel,BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		
	}//Fruit 생성자
	
	class MyItem implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			//System.out.println("라디오 버튼 이벤트 발생");
			
			if(radio[0].isSelected()) { //사과
				imageLabel.setIcon(image[0]);
			}
			else if(radio[1].isSelected()) { //바나나 
				imageLabel.setIcon(image[1]);
			}
			else { //체리
				imageLabel.setIcon(image[2]);
			}
		}
	}
	
}//Fruit
public class Ex13_10 {
	public static void main(String[] args) {
		
		new Fruit();
		
	}
}

