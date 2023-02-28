package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddScore implements ActionListener{
	
	
	JTable table;
	JTextField[] tf;
	String[] strArr = new String[4];
	
	public AddScore(JTable table, JTextField[] tf) {
		this.table = table;
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(("추가버튼 클릭함"));
		
		for(int i=0; i<strArr.length;i++) {
			strArr[i] = tf[i].getText();
		}
		
		// 테이블 모델을 가지고 옴, TableModel의 자식 DefaultTableModel이므로 다운캐스팅
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.addRow(strArr); // 한 줄 추가
		
		
		for(int i=0;i<tf.length;i++) {
			tf[i].setText("");
		}
		
		
	}

}
