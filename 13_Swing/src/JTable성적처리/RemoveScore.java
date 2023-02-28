package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemoveScore implements ActionListener{
	
	JTable table;
	
	public RemoveScore(JTable table) {
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("삭제버튼 클릭함");
		
		int row = table.getSelectedRow();
		System.out.println("선택한 행:" + row);
		
		if(row == -1) //행을 찍지 않고 삭제를 누르면 돌아가라
			return;
			
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row);
		
		
	}

}
