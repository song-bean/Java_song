import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

class Ex13_02_Sub extends Frame{

	public Ex13_02_Sub(String title) {
		super(title);
		setSize(400,300);
		
		Button east = new Button("east");
		Button west = new Button("west");
		Button south = new Button("south");
		Button north = new Button("north");
		Button center = new Button("center"); // "center"은 버튼위에 올라가는 글자
		
		//setLayout(new FlowLayout()); // 동서남북 무시함
		//setLayout(new BorderLayout()); // 기본 설정
		setLayout(new GridLayout(2,3)); //2행 3열, 동서남북 무시 
		
		
//		add(east,BorderLayout.EAST); // 내가 안갖고 있으면 부모껄로
//		this.add(west,BorderLayout.WEST); //this는 생략 가능
//		super.add(south,BorderLayout.SOUTH);
//		super.add(north,BorderLayout.NORTH);
//		super.add(center,BorderLayout.CENTER);
		
		add("East", east); // 앞에 있는 "East"가 방향 설정
		add("West", west);
		add("South", south);
		add("North", north);
		add("Center", center);
		
		setVisible(true);
	}
	
}//

public class Ex13_02_Layout {
	public static void main(String[] args) {
		
		Ex13_02_Sub ex = new Ex13_02_Sub("Layout 예제");
		
		//ex.setVisible(true); --> 클래스(생성자)에서 써도 됨
		
	}
}

//Layout Manager(배치 관리자)는 FlowLayout, BorderLayout, GridLayout, GridBagLayout, CardLayout의 5가지가 있다.