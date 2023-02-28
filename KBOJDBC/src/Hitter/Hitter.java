package Hitter;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public 
class Hitter extends JFrame implements ActionListener{
	private String team, player;
	private String[] columnNames = {"번호","구단", "타자", "등번호", "이름", "포지션", "타율", "안타"};
	private Object[][] rowData;
	private JTable table = null;
	private JScrollPane scrollPane = null;
	private JButton[] btn = new JButton[4];

	private JTextField txtHno = new JTextField();
	private JTextField txtClub = new JTextField();
	private JTextField txtHplayer = new JTextField();
	private JTextField txtHnum = new JTextField();
	private JTextField txtHname = new JTextField();
	private JTextField txtPosition = new JTextField();
	private JTextField txtBa = new JTextField();
	private JTextField txtHit = new JTextField();

	HitterDao hdao = null;
	ArrayList<HitterBean> lists = null;

	Container contentPane = null;
	JPanel pEast = null;
	JPanel pBtn = null;

	public Hitter() {

	}

	public Hitter(String team, String player) {
		this.team = team;
		this.player = player;
		System.out.println("Hitter 생성자");

		hdao = new HitterDao();
		lists = hdao.getAllHitter(team);
		rowData = new Object[lists.size()][columnNames.length];
		fillData();

		table = new JTable(rowData,columnNames);
		scrollPane = new JScrollPane(table);

		compose();
		setevent();

		setTitle(team + " " +player); 
		setSize(665,500);
		setLocation(750,138);
		setVisible(true);
		setResizable(false);
	}

	private void fillData() {
		Object[] arr = lists.toArray();
		int j = 0;
		for(int i=0;i<arr.length;i++) {
			HitterBean hb = (HitterBean)arr[i];

			rowData[i][j++] = hb.getHno();
			rowData[i][j++] = hb.getClub();
			rowData[i][j++] = hb.getHplayer();
			rowData[i][j++] = hb.getHnum();
			rowData[i][j++] = hb.getHname();
			rowData[i][j++] = hb.getPosition();
			rowData[i][j++] = hb.getBa();
			rowData[i][j++] = hb.getHit();
			j = 0;
		}
	}

	private void setevent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtHno.addKeyListener(new KeyHandler());
		txtHnum.addKeyListener(new KeyHandler());
		txtBa.addKeyListener(new KeyHandler());
		txtHit.addKeyListener(new KeyHandler());
				
		table.addMouseListener(new MouseHandler());
	}

	private void compose() {
		contentPane = getContentPane(); 
		contentPane.setLayout(null);
		scrollPane.setBounds(10,30,380,400);
		contentPane.add(scrollPane);
		scrollPane.setBackground(Color.DARK_GRAY);

		pEast = new JPanel(); 
		pEast.setLayout(null); 
		pEast.setBounds(400,0,300,300); 
		contentPane.add(pEast);

		JLabel lbHno = new JLabel("번호");
		JLabel lbClub = new JLabel("구단");
		JLabel lbHplayer = new JLabel("타자");
		JLabel lbHnum = new JLabel("등번호");
		JLabel lbHname = new JLabel("이름");
		JLabel lbPosition = new JLabel("포지션");
		JLabel lbBa = new JLabel("타율");
		JLabel lbHit = new JLabel("안타");

		lbHno.setBounds(50,30,150,20);
		lbClub.setBounds(172,30,150,20);
		lbHplayer.setBounds(50, 90, 150, 20);
		lbHnum.setBounds(165, 90, 150, 20);
		lbHname.setBounds(50, 150, 150, 20);
		lbPosition.setBounds(165, 150, 150, 20);
		lbBa.setBounds(50, 210, 150, 20);
		lbHit.setBounds(173, 210, 150, 20);

		txtHno.setBounds(15, 55, 100, 20);
		txtClub.setBounds(135, 55, 100, 20);
		txtHplayer.setBounds(15, 115, 100, 20);
		txtHnum.setBounds(135, 115, 100, 20);
		txtHname.setBounds(15, 175, 100, 20);
		txtPosition.setBounds(135, 175, 100, 20);
		txtBa.setBounds(15, 235, 100, 20);
		txtHit.setBounds(135, 235, 100, 20);

		pEast.add(lbHno);
		pEast.add(lbClub);
		pEast.add(lbHplayer);
		pEast.add(lbHnum);
		pEast.add(lbHname);
		pEast.add(lbPosition);
		pEast.add(lbBa);
		pEast.add(lbHit);

		pEast.add(txtHno);
		pEast.add(txtClub);
		pEast.add(txtHplayer);
		pEast.add(txtHnum);
		pEast.add(txtHname);
		pEast.add(txtPosition);
		pEast.add(txtBa);
		pEast.add(txtHit);
		txtHno.setBackground(Color.lightGray);
		txtClub.setBackground(Color.lightGray);
		txtHplayer.setBackground(Color.lightGray);
		txtHnum.setBackground(Color.lightGray);
		txtHname.setBackground(Color.lightGray);
		txtPosition.setBackground(Color.lightGray);
		txtBa.setBackground(Color.lightGray);
		txtHit.setBackground(Color.lightGray);

		txtHno.setText("0");
		txtHno.setEnabled(false);
		txtClub.setText(team);
		txtClub.setEnabled(false);
		txtHplayer.setText(player);
		txtHplayer.setEnabled(false);

		pBtn = new JPanel();
		pBtn.setLayout(new GridLayout(2,2));
		pBtn.setBounds(403, 280, 250, 150);
		contentPane.add(pBtn);

		String[] btnTitle = {"Insert", "Update", "Delete", "Exit"}; 
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(btnTitle[i]);
			btn[i].addActionListener(this);
			pBtn.add(btn[i]);
		}

	}

	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if(obj == btn[0]) {
			System.out.println("Insert 버튼");
			insertHitter();
		}
		else if(obj == btn[1]) {
			System.out.println("Update 버튼");
			updateHitter();
		}
		else if(obj == btn[2]) {
			System.out.println("Delete 버튼");
			deleteHitter();
		}
		else if(obj == btn[3]) {
			System.out.println("Exit 버튼");
			hdao.exit();
			System.exit(0);
		}
	}

	private void insertHitter() {
		boolean result = checkHitter();
		
		int hno = Integer.parseInt(txtHno.getText());
		int hnum = Integer.parseInt(txtHnum.getText());
		String hname = txtHname.getText();
		String position = txtPosition.getText();
		double ba = Double.parseDouble(txtBa.getText());
		int hit = Integer.parseInt(txtHit.getText());
		
		if(result == true) {
			HitterBean hb = new HitterBean(hno,team,player,hnum,hname,position,ba,hit);
			
			int cnt = hdao.insertHitter(hb);
			if(cnt > 0) {
				System.out.println("Insert 성공");
				clearTextField();
				getAllHitter();
			}
			else {
				System.out.println("Insert 실패");
			}
		}
	}
	
	private void updateHitter() {
		boolean result = checkHitter();
		
		int hno = Integer.parseInt(txtHno.getText());
		int hnum = Integer.parseInt(txtHnum.getText());
		String hname = txtHname.getText();
		String position = txtPosition.getText();
		double ba = Double.parseDouble(txtBa.getText());
		int hit = Integer.parseInt(txtHit.getText());
		
		if(result == true) {
			HitterBean hb = new HitterBean(hno,team,player,hnum,hname,position,ba,hit);
			
			int cnt = hdao.updateHitter(hb);
			if(cnt > 0) {
				System.out.println("Update 성공");
				clearTextField();
				getAllHitter();
			}
			else {
				System.out.println("Update 실패");
			}
		}
	}
	
	private void deleteHitter() {
		int row = table.getSelectedRow();
		
		int hno  = Integer.parseInt(txtHno.getText());

		if(row == -1) {
			JOptionPane.showMessageDialog(this,"삭제할 대상을 클릭하세요","에러 발생", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			int cnt = hdao.deleteHitter(hno, team);
			if(cnt > 0) {
				System.out.println("Delete 성공");
				clearTextField();
				getAllHitter();
			}
			else {
				System.out.println("Delete 실패");
			}	
		}
		
	}
	public boolean checkHitter() {
		if(txtHno.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"번호를 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtHno.requestFocus();
			return false;
		}
		if(txtHnum.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"등번호를 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtHnum.requestFocus();
			return false;
		}
		if(txtHname.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"이름을 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtHname.requestFocus();
			return false;
		}
		if(txtPosition.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"포지션을 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtPosition.requestFocus();
			return false;
		}
		if(txtBa.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"타율을 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtBa.requestFocus();
			return false;
		}
		if(txtHit.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"안타 수를 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtHit.requestFocus();
			return false;
		}
		return true;
	}
	
	private void clearTextField() {
		txtHno.setText("0");
		txtHnum.setText("");
		txtHname.setText("");
		txtPosition.setText("");
		txtBa.setText("");
		txtHit.setText("");
	}

	private void getAllHitter() {
		lists = hdao.getAllHitter(team);
		rowData = new Object[lists.size()][columnNames.length];
		fillData();

		table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseHandler()); 
	}//getAllHitter
	
	class KeyHandler extends KeyAdapter{
		public void keyReleased(KeyEvent e) { 
			Object obj = e.getSource();
			if(obj == txtHno) {
				try {
					Integer.parseInt(txtHno.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtHno, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtHno.setText("");
					txtHno.requestFocus();
				}
			}
			else if(obj == txtHnum) {
				try {
					Integer.parseInt(txtHnum.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtHnum, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtHnum.setText("");
					txtHnum.requestFocus();
				}
			}
			else if(obj == txtBa){
				try {
					Double.parseDouble(txtBa.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtBa, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtBa.setText("");
					txtBa.requestFocus();
				}
			}
			else if(obj == txtHit){
				try {
					Integer.parseInt(txtHit.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtHit, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtHit.setText("");
					txtHit.requestFocus();
				}
			}
		}//keyReleased
	}//KeyHandler

	class MouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {

			int row = table.getSelectedRow();
			System.out.println("row : " + row);

			txtHno.setText(String.valueOf(table.getValueAt(row, 0)));
			txtClub.setText(team);
			txtHplayer.setText(player);
			txtHnum.setText(String.valueOf(table.getValueAt(row, 3)));
			txtHname.setText(String.valueOf(table.getValueAt(row, 4)));
			txtPosition.setText(String.valueOf(table.getValueAt(row, 5)));
			txtBa.setText(String.valueOf(table.getValueAt(row, 6)));
			txtHit.setText(String.valueOf(table.getValueAt(row, 7)));
		}
	}//MouseHandler
}
