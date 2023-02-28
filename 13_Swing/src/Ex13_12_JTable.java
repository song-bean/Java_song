import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
	

class JTable_Sub extends JFrame {
	
	JTable table = null;
	JScrollPane scrollPane = null;
	Container contentPane = null;
	
	FileReader fr = null;
	BufferedReader br = null;
	String str;
	int i, cnt = 1;
	
	//공간을 만든다 --> 객체 만든다 --> new Vector<String>();
	//NullPointerException
	Vector<String> columnNames = null;
	Vector<Vector<String>> rowData = null;
	
	JButton btn;
	
	public JTable_Sub(String title) {
		super(title);
		
		columnNames = new Vector<String>();
		rowData =  new Vector<Vector<String>>();
		
		getFile();
		compose();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,200);
		setVisible(true);
		
	}

	private void compose() {
		contentPane = getContentPane(); //contentPane이라는 변수로 작업영역을 관리
		table = new JTable(rowData, columnNames);
		scrollPane = new JScrollPane(table);
		
		contentPane.add(scrollPane,BorderLayout.CENTER);
		
		btn = new JButton("출력");
		btn.addActionListener(new TablePrint(table));
		contentPane.add(btn,BorderLayout.SOUTH);
	}

	private void getFile() {
		
		try {
			//File f = new File("/Users/songnayoung/sun/table.txt");
			fr = new FileReader("/Users/songnayoung/sun/table.txt");
			br = new BufferedReader(fr);
			
			while((str = br.readLine()) != null ) {
				//System.out.println(str);
				jTableMake(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null)
					br.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//getFile

	private void jTableMake(String str) {
		
		if(cnt++ == 1) { // cnt = 1 --> 2, cnt++은 비교한 뒤 ++
			String[] item = str.split("/");
			for(i=0;i<item.length;i++) {
				columnNames.add(item[i]);
			}
		}
		else {
			Vector<String> one = new Vector<String>();
			String[] item = str.split("/");
			for(i=0;i<item.length;i++) {
				one.add(item[i]);
			}
			rowData.add(one);
			
		}
		
	}
	
}//JTable_Sub

class TablePrint implements ActionListener{
	
	JTable table;
	int i,j;
	public TablePrint(JTable table) {
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("여기");
		
		//JTable의 내용을 콘솔창에 출력 
		int rowCount = table.getRowCount();
		int columnCount = table.getColumnCount();
		System.out.println(rowCount + "행 " + columnCount + "열"); // 제목은 포함 안됨
		
//		Object obj = table.getValueAt(0, 0);
//		System.out.println(obj);
		
		for(i=0;i<rowCount;i++) {
			for(j=0;j<columnCount;j++) {
				System.out.print(table.getValueAt(i, j) + "\t");
			}
			System.out.println();
		}
	}
	
}

public class Ex13_12_JTable {
	public static void main(String[] args) {
		
		new JTable_Sub("JTable 예제");
		
	}
}
