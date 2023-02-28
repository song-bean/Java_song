import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class ExItemEvent extends Frame implements ItemListener{
	
	Choice ch;
	
	public ExItemEvent() {
		
		ch = new Choice(); // --> itemevent
		ch.add("진달래");
		ch.add("개나리");
		ch.add("장미");
		ch.add("국화");
		ch.add("벚꽃");
		
		add(ch);// = super.add(ch); ,this.add(ch); 다 같음
		ch.addItemListener(this); // 현재 클래스 안에 itemStateChanged가 있으니 찾아봐라 --> (this)
		
		
		setVisible(true);
		setSize(500,300);
		setLocation(100,300); // 창 위치
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//ItemEvent e = new ItemEvent();
		
		System.out.println("초이스에 변화 생김");
		int index = ch.getSelectedIndex(); // 선택한 항목 위치 번호 
		String item = ch.getSelectedItem(); // 선택한 항목 이름
		System.out.println(index + "/" + item);
		
		
		
	}
}
public class Ex13_05_ItemEvent {
	public static void main(String[] args) {
		
		new ExItemEvent(); // 참조변수가 없어도 객체를 만들면 생성자로 넘어감
		
	}
}

//Choice -->ItemEvent --> ch.addItemListener(this) --> ItemListener 상속받기 --> public void itemStateChanged(ItemEvent e)

