import java.awt.Frame;

public class Ex13_01 {
	public static void main(String[] args) {
		
		Frame f = new Frame("기본창 만들기");
		
		f.setSize(400, 300); // 창 크기
		f.setLocation(100,300); // 창 위치
		f.setVisible(true);
		
		
		
		
	}
}


//CUI : 명령어를 직접 입력 해야하는 방식 --> 터미널
//GUI : 명령어 위주가 아닌 ICON을 통한 대화방식 --> 이클립스에서 실행 버튼