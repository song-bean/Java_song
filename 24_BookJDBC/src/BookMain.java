import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {
	
	Scanner sc = new Scanner(System.in);
	BookDao dao = new BookDao();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public BookMain() {
		System.out.println("BookMain 생성자");
		init();
	}
	
	private void init() {
		while(true) {
			System.out.println("\n=== 메뉴 선택하기 === ");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.조건 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print(">> 메뉴 번호 입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {

			case 1: 
						System.out.println("1.모든 정보 조회");
						getAllBook();
					break;
			case 2: 
						System.out.println("2.조건 조회");
						getBookBySearch();
					break;			
			case 3: 
						System.out.println("3.정보 수정");
						UpdateBook();
					break;		
			case 4: 
						System.out.println("4.정보 삭제");
						DeleteBook();	
					break;
			case 5: 
						System.out.println("5.정보 추가");
						InsertBook();
					break;
			case 6: 
						System.out.println("프로그램 종료합니다.");
						System.exit(0);
					break;
			default : System.out.println("1~6만 입력 가능");
			
			}//switch
		}
	}


	public void showBook(ArrayList<BookBean> lists) {
		System.out.println("번호   책 제목\t저자\t출판사\t가격\t출간일");
		for(BookBean bb : lists) {
			System.out.println(bb.getNo() + "    " + bb.getTitle() + "\t" + bb.getAuthor() + "\t" + bb.getPublisher() + "\t" + bb.getPrice() + "\t" + bb.getPub_day());
		}
	}
	
	private void getAllBook() {
		ArrayList<BookBean> lists = dao.getAllBook();
		showBook(lists);
	}
	
	private void InsertBook() {
		
		try {
			System.out.println("아이디는 시퀀스로 자동 입력됩니다.");
			
			System.out.print("제목 입력 : ");
			String title = null;
			title = br.readLine();
			
			System.out.print("저자 입력 : ");
			String author = null;
			author = br.readLine();
			
			System.out.print("출판사 입력 : ");
			String publisher = null;
			publisher = br.readLine();
			
			System.out.print("가격 입력 : ");
			int price = sc.nextInt();
			
			System.out.print("날짜 입력 : ");
			String pub_day = sc.next();
			
			BookBean bb = new BookBean(0,title,author,publisher,price,pub_day); // 생성자 이용
//			bb.setTitle(title);
//			bb.setAuthor(author);
//			bb.setPublisher(publisher);
//			bb.setPrice(price);
//			bb.setPub_day(pub_day);
			
			int cnt = dao.InsertBook(bb);
			if(cnt > 0) {
				System.out.println("insert 성공");
			}
			else {
				System.out.println("insert 실패");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	private void getBookBySearch() {
		System.out.print("제목:1   저자:2   출판사:3   번호입력>> ");
		String column = null;
		String searchWord = null;
			int searchNum = sc.nextInt();
			
			switch(searchNum) {
			
			case 1 : 
						System.out.print("조회할 제목 입력 : ");
						column = "title";
					break;
			case 2 : 
						System.out.print("조회할 저자 입력 : ");
						column = "author";
					break;
			case 3 : 
						System.out.print("조회할 출판사 입력 : ");
						column = "publisher";
					break;
			default : System.out.println("1~3번만 입력 가능합니다.");
					return;
			}	
			try {
				searchWord = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		ArrayList<BookBean> lists = dao.getBookBySearch(column,searchWord);
		if(lists.size() == 0) {
			System.out.println("해당 단어는 존재하지 않습니다.");
		}
		else {
			showBook(lists);			
		}
	}
	
	private void UpdateBook() {
		
		try {
			System.out.print("교체할 번호 입력 : ");
			int no = sc.nextInt();
			
			System.out.print("교체할 제목 입력 : ");
			String title = null;
			title = br.readLine();
			
			System.out.print("교체할 저자 입력 : ");
			String author = null;
			author = br.readLine();
			
			System.out.print("교체할 출판사 입력 : ");
			String publisher = null;
			publisher = br.readLine();
			
			System.out.print("교체할 가격 입력 : ");
			int price = sc.nextInt();
			
			System.out.print("교체할 날짜 입력 : ");
			String pub_day = sc.next();
			
			BookBean bb = new BookBean(no,title,author,publisher,price,pub_day); // 생성자 이용
//			bb.setNo(no);
//			bb.setTitle(title);
//			bb.setAuthor(author);
//			bb.setPublisher(publisher);
//			bb.setPrice(price);
//			bb.setPub_day(pub_day);
			
			int cnt = dao.UpdateBook(bb);
			if(cnt > 0) {
				System.out.println("Update 성공");
			}
			else if(cnt == 0) {
				System.out.println("조건에 맞는 레코드 없음");
			}
			else {
				System.out.println("Update 실패");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void DeleteBook() {
		System.out.print("삭제할 번호 입력 : ");
		int no = sc.nextInt();
		
		int cnt = dao.DeleteBook(no);
		if(cnt > 0) {
			System.out.println("Delete 성공");
		}
		else if(cnt == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else {
			System.out.println("Delete 실패");
		}
	}

	public static void main(String[] args) {
		new BookMain();
	}

}

