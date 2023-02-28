package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;

public class FilePrint implements ActionListener{
	
	JTable table;
	
	public FilePrint(JTable table) {
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("파일 출력");
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		int i,j;
		try {
			fw = new FileWriter("/Users/songnayoung/sun/table_write.txt");
			bw = new BufferedWriter(fw);

			for(i=0;i<table.getColumnCount();i++) {
				bw.write(table.getColumnName(i));
				if(i != table.getColumnCount()-1) {
					bw.write("/");
				}
				else {
					bw.newLine(); // 엔터
				}
			}
			
			for(i=0;i<table.getRowCount();i++) {
				for(j=0;j<table.getColumnCount();j++) {
					String str = (String) table.getValueAt(i, j);
					bw.write(str);
					if(j != table.getColumnCount()-1) {
						bw.write("/");
					}
					else {
						bw.newLine();
					}
				}
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				if(bw != null)
					bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
