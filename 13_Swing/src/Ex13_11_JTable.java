import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

class ExJTable extends JFrame {

	String[] title = { "사번", "성명", "부서" };
	String[][] data = {
						{"1","유재석", "영업부"},
						{"2", "정형돈", "연구부"},
						{"3", "이영자", "총무부"}
					};
	
	public ExJTable() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		
		JTable table = new JTable(data, title); //(2차원 배열, 1차원 배열) 
		//contentPane.add(table);
		
		//int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; // 항상 세로 스크롤바
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; // 필요할 때 세로 스크롤바 --> 안써도 필요하면 나옴
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; // 항상 가로 스크롤바
		System.out.println(v + "/" + h);
		
		//스크롤바를 갖는 패널
		JScrollPane scroll = new JScrollPane(table, v, h);
		contentPane.add(scroll);
		
		setTitle("Table");
		setSize(300,200);
		setVisible(true);
		
	}

	
}
public class Ex13_11_JTable {
	public static void main(String[] args) {

		new ExJTable();

	}
}
