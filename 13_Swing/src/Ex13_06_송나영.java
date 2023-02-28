import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Ex06_sub extends Frame {

	String[] 대륙 = {"아시아", "유럽", "아프리카"};
	String[][] 나라 = {
						{"한국","일본","중국"},
						{"영국","스위스","프랑스"},
						{"이집트","콩고","우간다"}
					};
	
	Panel p1, p2, p3;
	
	Label Lb1, Lb2;
	
	Choice c1, c2;
	int i;
	String item1, item2;

	public Ex06_sub(String title) {
		
		super(title); // 프레임의 제목으로 설정
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("창이 닫힘");
				System.exit(0);
			}
			public void windowActivated(WindowEvent e) {
				System.out.println("창이 활성화됨");
			}
		});
		
		Lb1 = new Label("대륙과 나라를 선택하세요");
		Lb2 = new Label();
		
		//Lb2.setText("대륙과 나라를 선택하세요");
		
		c1 = new Choice();
		c2 = new Choice();
		
		for(i=0;i<대륙.length;i++) {
			c1.add(대륙[i]);
		}
		
		//c1.select(0);
		
		c1.addItemListener(new ItemEvent1());
		c2.addItemListener(new ItemEvent2());
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		p1.add(Lb1);
		p2.add(c1);
		p2.add(c2);
		p3.add(Lb2);
		
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.cyan);
		p3.setBackground(Color.pink);
		
		//add("North",Lb1);
		add(p1,"North"); // 위치는 앞 뒤 아무곳에나 써도 상관 없음
		add("Center",p2);
		add("South",p3);
		
		setSize(400,300);
		setLocation(100,300); 
		setVisible(true);

	}// 생성자
	
//내부 클래스
	class ItemEvent1 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

			item1 = c1.getSelectedItem();
			c2.removeAll();
			if(item1.equals("아시아") )  {
				for(i=0;i<나라[0].length;i++) {
					c2.add(나라[0][i]);
				}
			}
			else if(item1.equals("유럽")) {
				for(i=0;i<나라[1].length;i++) {
					c2.add(나라[1][i]);
				}
			}
			else if(item1.equals("아프리카")) {
				for(i=0;i<나라[2].length;i++) {
					c2.add(나라[2][i]);
				}
			}
			revalidate();
		}//itemStateChanged
	}//class ItemEvent1
	
	class ItemEvent2 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

			item2 = c2.getSelectedItem();
			Lb2.setText("선택한 대륙과 나라는:" + item1 + "-" + item2 + "입니다.");
			revalidate();
		}//itemStateChanged
	}//class ItemEvent2

}//Ex06_sub
public class Ex13_06_송나영 {
	public static void main(String[] args) {

		new Ex06_sub("초이스 이벤트");

	}

}

// 첫 번째 초이스(c1)에 변화가 생기면 
// 두 번째 초이스(c2)에 해당 대륙의 나라를 add
// 두 번째 초이스에 변화가 생기면 --> 선택한 대륙과 나라는: 유럽 - 프랑스 입니다. 이런식으로 라벨
