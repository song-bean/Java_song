package JTable성적처리;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{
	
	JTable table = null;
	JScrollPane scrollPane = null;
	Container contentPane = null;
	
	FileReader fr = null;
	BufferedReader br = null;
	
	String str;
	int i, cnt = 1;
	
	JLabel lb;
	String[] caption = {"이름:", "국어:", "영어:", "수학:"};
	JTextField[] tf = new JTextField[4];
	
	JButton btnAdd, btnRemove, btnFout, btnExit;
	
	Vector<String> columnNames = null;
	Vector<Vector<String>> rowData = null;
	
	//생성자
	public Main(String title) {
		super(title);
		
		columnNames = new Vector<String>();
		rowData =  new Vector<Vector<String>>();
		
		getFile();
		compose();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,300);
		setVisible(true);
	}//생성자
	
	private void compose() {
		
		contentPane = getContentPane(); //기본이 BoarderLayout
		contentPane.setLayout(null); // 기본 배열 없다
		table = new JTable(rowData, columnNames);
		scrollPane = new JScrollPane(table);
		
		contentPane.add(scrollPane);
		
		scrollPane.setBounds(250, 30, 400, 200); // 꼭짓점이 250,30위치에 길이 400,200만큼
		
		for(i=0;i<caption.length;i++) {
			lb = new JLabel(caption[i]);
			lb.setBounds(10, (i+1)*30, 50, 20);;
			contentPane.add(lb);
			
			tf[i] = new JTextField();// 입력 받는 부분
			
			tf[i].setBounds(50, (i+1)*30, 90, 20);
			contentPane.add(tf[i]);
		}
		
		btnAdd = new JButton("추가");
		btnRemove = new JButton("삭제");
		btnFout = new JButton("파일 출력");
		btnExit = new JButton("종료");
		
		btnAdd.setBounds(15, 170, 100, 20);
		btnRemove.setBounds(135, 170, 100, 20);
		btnFout.setBounds(15, 200, 100, 20);
		btnExit.setBounds(135, 200, 100, 20);
		
		contentPane.add(btnAdd);
		contentPane.add(btnRemove);
		contentPane.add(btnFout);
		contentPane.add(btnExit);	
		
		//actionPerformed가 있는 클래스 객체를 만드는 것: 괄호안에 new AddScore() 쓴 이유
		btnAdd.addActionListener(new AddScore(table, tf));
		btnRemove.addActionListener(new RemoveScore(table));
		btnFout.addActionListener(new FilePrint(table));
		btnExit.addActionListener(this);
		
	}//compose

	private void getFile() {
		
		try {
			fr = new FileReader("/Users/songnayoung/sun/table.txt");
			br = new BufferedReader(fr);
			
			while((str = br.readLine()) != null ) {
				jTableMake(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
	}//getFile

	private void jTableMake(String str) {
		
		String[] item = str.split("/");
		if(cnt++ == 1) { 
			for(i=0;i<item.length;i++) {
				columnNames.add(item[i]);
			}
		}
		else {
			Vector<String> one = new Vector<String>();
			for(i=0;i<item.length;i++) {
				one.add(item[i]);
			}
			rowData.add(one);
			
		}
	}//jTableMake

	public static void main(String[] args) {
		
		new Main("성적처리 프로그램");
		
	}

	//종료버튼 누름
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
