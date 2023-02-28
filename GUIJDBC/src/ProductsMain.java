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

public class ProductsMain extends JFrame implements ActionListener{

	private String[] columnNames = {"아이디", "이름", "입고 수량", "단가", "카테고리", "입고일"};
	private Object[][] rowData;
	private JTable table = null;
	private JScrollPane scrollPane = null;
	private JButton[] btn = new JButton[4];

	private JTextField txtId = new JTextField();
	private JTextField txtName = new JTextField();
	private JTextField txtStock = new JTextField();
	private JTextField txtPrice = new JTextField();
	private JTextField txtCategory = new JTextField();
	private JTextField txtInputdate = new JTextField();

	ProductsDao dao = null;
	ArrayList<ProductsBean> lists = null;

	Container contentPane = null;

	JPanel pCenter = null;
	JPanel pSouth = null;

	public ProductsMain(String title) {
		super(title);

		dao = new ProductsDao();
		lists = dao.getAllProducts();
		rowData = new Object[lists.size()][columnNames.length];
		fillData();

		table = new JTable(rowData,columnNames);
		scrollPane = new JScrollPane(table);

		compose(); // 화면을 구성하는 메서드
		setevent();

		//super.setSize(500,530); //super을 안써도 됨(자식테이블이므로)
		setSize(500,530);
		setLocation(350,10);
		setVisible(true);
		setResizable(false); // 창 크기 변경 불가

	}//생성자

	private void setevent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtStock.addKeyListener(new KeyHandler()); //키보드로 입력을 했다가 뗌 
		txtPrice.addKeyListener(new KeyHandler());

		table.addMouseListener(new MouseHandler());
	}

	private void compose() { // 화면을 구성하는 메서드
		contentPane = getContentPane(); // 작업 영역
		contentPane.setLayout(null);
		scrollPane.setBounds(0,0,500,200);
		contentPane.add(scrollPane);

		//Frame : borderLayout, Panel : FlowLayout
		pCenter = new JPanel(); // label, textfield, button
		pCenter.setLayout(null); // 기본 배치 관리자 안쓴다.
		pCenter.setBounds(0,220,490,200); // 위치 선정
		pCenter.setBackground(Color.GRAY);
		contentPane.add(pCenter);


		JLabel lbId = new JLabel("아이디");
		JLabel lbName = new JLabel("이름");
		JLabel lbStock = new JLabel("입고 수량");
		JLabel lbPrice = new JLabel("단가");
		JLabel lbCategory = new JLabel("카테고리");
		JLabel lbInputdate = new JLabel("입고일자(yyyy/mm/dd)");

		int vertical_position = 20;
		lbId.setBounds(20,1*vertical_position,150,20); // pCenter의 끝이 0,0
		lbName.setBounds(20,2*vertical_position,150,20);
		lbStock.setBounds(20,3*vertical_position,150,20);
		lbPrice.setBounds(20,4*vertical_position,150,20);
		lbCategory.setBounds(20,5*vertical_position,150,20);
		lbInputdate.setBounds(20,6*vertical_position,150,20);

		txtId.setBounds(200, 1*vertical_position,150,20);
		txtName.setBounds(200,2*vertical_position,150,20);
		txtStock.setBounds(200,3*vertical_position,150,20);
		txtPrice.setBounds(200,4*vertical_position,150,20);
		txtCategory.setBounds(200,5*vertical_position,150,20);
		txtInputdate.setBounds(200,6*vertical_position,150,20);

		txtId.setText("0"); // 0으로 설정
		txtId.setEnabled(false); // 0으로 설정한 것 못건드리게 함 --> 입력 못함

		pCenter.add(lbId);
		pCenter.add(lbName);
		pCenter.add(lbStock);
		pCenter.add(lbPrice);
		pCenter.add(lbCategory);
		pCenter.add(lbInputdate);

		pCenter.add(txtId);
		pCenter.add(txtName);
		pCenter.add(txtStock);
		pCenter.add(txtPrice);
		pCenter.add(txtCategory);
		pCenter.add(txtInputdate);

		pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1,4)); // 1행 4열 형태로 배치
		pSouth.setBounds(0,420,500,40); // 위치 선정
		//pSouth.setBackground(Color.orange);
		contentPane.add(pSouth);


		String[] btnTitle = {"등록", "수정", "삭제", "종료"};

		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(btnTitle[i]);
			btn[i].addActionListener(this);
			pSouth.add(btn[i]);
		}

	}//compose

	private void fillData() { //rowData 2차원 배열 내용 채우기
		//ArrayList --> 2차원 배열
		Object[] arr = lists.toArray(); 
		int j = 0;
		for(int i=0;i<arr.length;i++) {
			ProductsBean pb = (ProductsBean)arr[i];
			//pb.getId();
			rowData[i][j++] = pb.getId();
			rowData[i][j++] = pb.getName();
			rowData[i][j++] = pb.getStock();
			rowData[i][j++] = pb.getPrice();
			rowData[i][j++] = pb.getCategory();
			rowData[i][j++] = pb.getInputdate();
			j = 0;
		}
	}


	public static void main(String[] args) {
		new ProductsMain("상품 관리 프로그램");
	}

	public void actionPerformed(ActionEvent e) {

		//System.out.println("버튼 눌림");		
		Object obj = e.getSource();
		if(obj == btn[0]) {
			System.out.println("등록 버튼");
			insertData();
		}
		else if(obj == btn[1]) {
			System.out.println("수정 버튼");
			updateData();
		}
		else if(obj == btn[2]) {
			System.out.println("삭제 버튼");
			deleteData();
		}
		else if(obj == btn[3]) {
			System.out.println("종료 버튼");
			dao.exit();
			System.exit(0);
		}
	}//actionPerformed

	private void deleteData() {
		
		int row = table.getSelectedRow();
		System.out.println("deleteData row : " + row );

		int id = Integer.valueOf(table.getValueAt(row, 0).toString());

		if(row == -1) {
			JOptionPane.showMessageDialog(this,"삭제할 대상을 클릭하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
		}
		else {
			int cnt = dao.deleteProducts(id);
			if(cnt > 0) {
				System.out.println("Delete 성공");
				clearTextField();
				getAllProducts();
			}
			else {
				System.out.println("Delete 실패");
			}	
		}
	}


	private void updateData() {
		//누락체크, 숫자만 입력 체크, DB에 업데이트, JTable에 수정된 정보 가져오기
		boolean result = checkData();

		if(result == true) {
			ProductsBean pb = new ProductsBean();
			pb.setId(Integer.valueOf(txtId.getText()));
			pb.setName(txtName.getText());
			pb.setStock(Integer.valueOf(txtStock.getText()));
			pb.setPrice(Integer.valueOf(txtPrice.getText()));
			pb.setCategory(txtCategory.getText());
			pb.setInputdate(txtInputdate.getText());

			int cnt = dao.updateProducts(pb);
			if(cnt > 0) {
				System.out.println("Update 성공");
				clearTextField();
				getAllProducts();
			}
			else {
				System.out.println("Update 실패");
			}	
		}

	}

	private void insertData() { // 등록 버튼 클릭

		boolean result = checkData(); // txtField에 입력한 값이 유효한 입력값인지 체크

		//id는 시퀀스로 넣을거라 없어도 됨
		String name = txtName.getText();
		int stock = Integer.valueOf(txtStock.getText());
		int price = Integer.valueOf(txtPrice.getText());
		String category = txtCategory.getText();
		String inputdate = txtInputdate.getText();

		if(result == true) {
			ProductsBean pb = new ProductsBean(0,name,stock,price,category,inputdate);
			int cnt = dao.insertProducts(pb);
			if(cnt > 0) {
				System.out.println("Insert 성공");
				clearTextField();
				getAllProducts(); //한 줄 추가한 레코드를 포함해서 테이블에 나오게 함
			}
			else {
				System.out.println("Insert 실패");
			}
		}
		//		System.out.println(name);
		//		System.out.println(stock);
		//		System.out.println(price);
		//		System.out.println(category);
		//		System.out.println(inputdate);
	}//insertData

	private boolean checkData() { // txtField에 입력한 값이 유효한 입력값인지 체크

		if(txtName.getText().length() == 0) {
			//this는 현재 프레임의 텍스트 필드, 에러발생은 창 제목, 이름을 입력하세요는 에러 내용, 메시지마다 아이콘이 달라짐
			JOptionPane.showMessageDialog(this,"이름을 입력하세요","에러 발생", JOptionPane.INFORMATION_MESSAGE);
			txtName.requestFocus();
			return false;
		}

		if(txtStock.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"입고 수량을 입력하세요","에러 발생", JOptionPane.ERROR_MESSAGE);
			txtStock.requestFocus();
			return false;
		}

		if(txtPrice.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"단가를 입력하세요","에러 발생", JOptionPane.WARNING_MESSAGE);
			txtPrice.requestFocus();
			return false;
		}

		if(txtCategory.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"카테고리를 입력하세요","에러 발생", JOptionPane.YES_NO_CANCEL_OPTION);
			txtCategory.requestFocus();
			return false;
		}

		if(txtInputdate.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,"입고 일자를 입력하세요","에러 발생", JOptionPane.INFORMATION_MESSAGE);
			txtInputdate.requestFocus();
			return false;
		}

		return true;
	}

	private void clearTextField() {
		txtName.setText("");
		txtStock.setText("");
		txtPrice.setText("");
		txtCategory.setText("");
		txtInputdate.setText("");
	}

	private void getAllProducts() {

		lists = dao.getAllProducts();
		rowData = new Object[lists.size()][columnNames.length];
		fillData();

		table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);

		//setevent();
		table.addMouseListener(new MouseHandler()); // 수정(삭제)한 뒤 다시 마우스이벤트 처리를 해줘야 함

	}//getAllProducts

	class KeyHandler extends KeyAdapter{

		public void keyReleased(KeyEvent e) { 
			//System.out.println("keyReleased");
			Object obj = e.getSource();
			if(obj == txtStock) {
				//System.out.println("입고 수량");
				try {
					Integer.parseInt(txtStock.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtStock, "숫자로 입력하세요","에러 발생", JOptionPane.YES_NO_CANCEL_OPTION);
					txtStock.setText("");
					txtStock.requestFocus();
				}
			}
			else {
				//System.out.println("가격");
				try {
					Integer.parseInt(txtPrice.getText());
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtPrice, "숫자로 입력하세요","에러 발생", JOptionPane.YES_NO_CANCEL_OPTION);
					txtPrice.setText("");
					txtPrice.requestFocus();
				}
			}
		}//keyReleased
	}//KeyHandler

	class MouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//System.out.println("mouseClicked");

			int row = table.getSelectedRow();
			System.out.println("row : " + row);

			//String id = (String)table.getValueAt(row, 0);
			//txtId.setText(id);

			txtId.setText(table.getValueAt(row, 0).toString());
			txtName.setText(String.valueOf(table.getValueAt(row, 1)));
			txtStock.setText(String.valueOf(table.getValueAt(row, 2)));
			txtPrice.setText(String.valueOf(table.getValueAt(row, 3)));
			txtCategory.setText(String.valueOf(table.getValueAt(row, 4)));
			txtInputdate.setText(String.valueOf(table.getValueAt(row, 5)));

		}
	}//MouseHandler

}
