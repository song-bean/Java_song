package Pitcher;
import java.awt.Choice;
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


public class Pitcher extends JFrame implements ActionListener {
	private String team, player;

	private String[] columnNames = {"번호","구단", "투수", "등번호", "이름", "평균자책점", "탈삼진"};
	private Object[][] rowData;
	private JTable table = null;
	private JScrollPane scrollPane = null;
	private JButton[] btn = new JButton[4];

	private JTextField txtPno = new JTextField();
	private JTextField txtClub = new JTextField();
	private JTextField txtPplayer = new JTextField();
	private JTextField txtPnum = new JTextField();
	private JTextField txtPname = new JTextField();
	private JTextField txtEra = new JTextField();
	private JTextField txtStrike = new JTextField();
	

	PitcherDao pdao = null;
	ArrayList<PitcherBean> lists = null;

	Container contentPane = null;
	JPanel pEast = null;
	JPanel pBtn = null;
	
	public Pitcher() {

	}

	public Pitcher(String team, String player) {
		this.team = team;
		this.player = player;

		System.out.println("Pitcher 생성자");

		pdao = new PitcherDao();
		lists = pdao.getAllPitcher(team);
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


	private void setevent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtPno.addKeyListener(new KeyHandler());
		txtPnum.addKeyListener(new KeyHandler());
		txtEra.addKeyListener(new KeyHandler());
		txtStrike.addKeyListener(new KeyHandler());

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

		JLabel lbPno = new JLabel("번호");
		JLabel lbClub = new JLabel("구단");
		JLabel lbPplayer = new JLabel("투수");
		JLabel lbPnum = new JLabel("등번호");
		JLabel lbPname = new JLabel("이름");
		JLabel lbEra = new JLabel("평균자책점");
		JLabel lbStrike = new JLabel("탈삼진");

		lbPno.setBounds(110,15,150,20);
		lbClub.setBounds(50,80,150,20);
		lbPplayer.setBounds(175, 80, 150, 20);
		lbPnum.setBounds(45, 140, 150, 20);
		lbPname.setBounds(175, 140, 150, 20);
		lbEra.setBounds(35, 200, 150, 20);
		lbStrike.setBounds(170, 200, 150, 20);

		txtPno.setBounds(75, 40, 100, 20);
		txtClub.setBounds(15, 105, 100, 20);
		txtPplayer.setBounds(135, 105, 100, 20);
		txtPnum.setBounds(15, 165, 100, 20);
		txtPname.setBounds(135, 165, 100, 20);
		txtEra.setBounds(15, 225, 100, 20);
		txtStrike.setBounds(135, 225, 100, 20);

		pEast.add(lbPno);
		pEast.add(lbClub);
		pEast.add(lbPplayer);
		pEast.add(lbPnum);
		pEast.add(lbPname);
		pEast.add(lbEra);
		pEast.add(lbStrike);

		pEast.add(txtPno);
		pEast.add(txtClub);
		pEast.add(txtPplayer);
		pEast.add(txtPnum);
		pEast.add(txtPname);
		pEast.add(txtEra);
		pEast.add(txtStrike);
		txtPno.setBackground(Color.lightGray);
		txtClub.setBackground(Color.lightGray);
		txtPplayer.setBackground(Color.lightGray);
		txtPnum.setBackground(Color.lightGray);
		txtPname.setBackground(Color.lightGray);
		txtEra.setBackground(Color.lightGray);
		txtStrike.setBackground(Color.lightGray);

		txtPno.setText("0");
		txtPno.setEnabled(false);		
		txtClub.setText(team);
		txtClub.setEnabled(false);		
		txtPplayer.setText(player);
		txtPplayer.setEnabled(false);

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

	private void fillData() {
		Object[] arr = lists.toArray();
		int j = 0;
		for(int i=0;i<arr.length;i++) {
			PitcherBean pb = (PitcherBean)arr[i];

			rowData[i][j++] = pb.getPno();
			rowData[i][j++] = pb.getClub();
			rowData[i][j++] = pb.getPplayer();
			rowData[i][j++] = pb.getPnum();
			rowData[i][j++] = pb.getPname();
			rowData[i][j++] = pb.getEra();
			rowData[i][j++] = pb.getStrike();
			j = 0;
		}
	}


	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if(obj == btn[0]) {
			System.out.println("Insert 버튼");
			insertPitcher();
		}
		else if(obj == btn[1]) {
			System.out.println("Update 버튼");
			updatePitcher();
		}
		else if(obj == btn[2]) {
			System.out.println("Delete 버튼");
			deletePitcher();
		}
		else if(obj == btn[3]) {
			System.out.println("Exit 버튼");
			pdao.exit();
			System.exit(0);
		}
	}

	private void insertPitcher() {
		boolean result = checkPitcher();

		int pno = Integer.parseInt(txtPno.getText());
		int pnum = Integer.parseInt(txtPnum.getText());
		String pname = txtPname.getText();
		double era = Double.parseDouble(txtEra.getText());
		int strike = Integer.parseInt(txtStrike.getText());

		if(result == true) {
			PitcherBean pb = new PitcherBean();
			pb.setPno(pno);
			pb.setClub(team);
			pb.setPplayer(player);
			pb.setPnum(pnum);
			pb.setPname(pname);
			pb.setEra(era);
			pb.setStrike(strike);

			int cnt = pdao.insertPitcher(pb);
			if(cnt > 0) {
				System.out.println("Insert 성공");
				clearTextField();
				getAllPitcher();
			}
			else {
				System.out.println("Insert 실패");
			}
		}
	}

	private void updatePitcher() {
		boolean result = checkPitcher();

		int pno  = Integer.parseInt(txtPno.getText());
		int pnum = Integer.parseInt(txtPnum.getText());
		String pname = txtPname.getText();
		double era = Double.parseDouble(txtEra.getText());
		int strike = Integer.parseInt(txtStrike.getText());

		if(result == true) {
			PitcherBean pb = new PitcherBean(pno,team,player,pnum,pname,era,strike);

			int cnt = pdao.updatePitcher(pb);
			if(cnt > 0) {
				System.out.println("Update 성공");
				clearTextField();
				getAllPitcher();
			}
			else {
				System.out.println("Update 실패");
			}
		}
	}

	private void deletePitcher() {
		
		int row = table.getSelectedRow();

		int pno  = Integer.parseInt(txtPno.getText());

		if(row == -1) {
			JOptionPane.showMessageDialog(this,"삭제할 대상을 클릭하세요","에러 발생", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			int cnt = pdao.deletePitcher(pno, team);
			if(cnt > 0) {
				System.out.println("Delete 성공");
				clearTextField();
				getAllPitcher();
			}
			else {
				System.out.println("Delete 실패");
			}	
		}
	}

	public boolean checkPitcher() {
		if(txtPno.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"번호를 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtPno.requestFocus();
			return false;
		}
		if(txtPnum.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"등번호를 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtPnum.requestFocus();
			return false;
		}
		if(txtPname.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"이름을 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtPname.requestFocus();
			return false;
		}
		if(txtEra.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"평균자책점을 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtEra.requestFocus();
			return false;
		}
		if(txtStrike.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"삼진 수를 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtStrike.requestFocus();
			return false;
		}
		return true;
	}

	private void clearTextField() {
		txtPno.setText("0");
		txtPnum.setText("");
		txtPname.setText("");
		txtEra.setText("");
		txtStrike.setText("");
	}

	private void getAllPitcher() {
		lists = pdao.getAllPitcher(team);
		rowData = new Object[lists.size()][columnNames.length];
		fillData();

		table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseHandler()); 
	}//getAllPitcher

	class KeyHandler extends KeyAdapter{
		public void keyReleased(KeyEvent e) { 
			Object obj = e.getSource();
			if(obj == txtPno) {
				try {
					Integer.parseInt(txtPno.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtPno, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtPno.setText("");
					txtPno.requestFocus();
				}
			}
			else if(obj == txtPnum) {
				try {
					Integer.parseInt(txtPnum.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtPnum, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtPnum.setText("");
					txtPnum.requestFocus();
				}
			}
			else if(obj == txtEra){
				try {
					Double.parseDouble(txtEra.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtEra, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtEra.setText("");
					txtEra.requestFocus();
				}
			}
			else if(obj == txtStrike){
				try {
					Integer.parseInt(txtStrike.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtStrike, "숫자로 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
					txtStrike.setText("");
					txtStrike.requestFocus();
				}
			}
		}//keyReleased
	}//KeyHandler

	class MouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {

			int row = table.getSelectedRow();
			System.out.println("row : " + row);

			txtPno.setText(String.valueOf(table.getValueAt(row, 0)));
			txtClub.setText(team);
			txtPplayer.setText(player);
			txtPnum.setText(String.valueOf(table.getValueAt(row, 3)));
			txtPname.setText(String.valueOf(table.getValueAt(row, 4)));
			txtEra.setText(String.valueOf(table.getValueAt(row, 5)));
			txtStrike.setText(String.valueOf(table.getValueAt(row, 6)));
		}
	}//MouseHandler

}
