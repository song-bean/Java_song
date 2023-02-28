import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbumsMain {
	
	Scanner sc = new Scanner(System.in);
	AlbumsDao dao = new AlbumsDao();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public AlbumsMain() {
		System.out.println("AlbumsMain 생성자");
		init();
	}
	
	private void init() {
		while(true) {
			System.out.println("\n=== 메뉴 선택하기 === ");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.조건 검색");
			System.out.println("3.가격 범위 조건 검색(가격:내림차순, 가수:오름차순)");
			System.out.println("4.앨범 수정");
			System.out.println("5.앨범 삭제");
			System.out.println("6.앨범 추가");
			System.out.println("7.정렬");
			System.out.println("8.그룹화");
			System.out.println("9.프로그램 종료");
			System.out.print(">> 메뉴 번호 입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {

			case 1: 
						System.out.println("1.모든 정보 조회");
						getAllAlbums();
					break;
			case 2: 
						System.out.println("2.조건 검색");
						getAlbumsBySearch();
					break;			
			case 3: 
						System.out.println("3.가격 범위 조건 검색(가격:내림차순, 가수:오름차순)");
						priceAlbums();
						break;			
			case 4: 
						System.out.println("4.앨범 수정");
						updateAlbums();
					break;		
			case 5: 
						System.out.println("5.앨범 삭제");
						deleteAlbums();	
					break;
			case 6: 
						System.out.println("6.앨범 추가");
						insertAlbums();
					break;
			case 7: 
						System.out.println("7.정렬");
						orderByAlbums();
					break;
			case 8: 
						System.out.println("8.그룹화");	
						groupByAlbums();
					break;
			case 9: 
						System.out.println("프로그램 종료합니다.");
						System.exit(0);
					break;
			default : System.out.println("1~9만 입력 가능");
			
			}//switch
		}
	}

	

	public void showAlbums(ArrayList<AlbumsBean> lists) {
		System.out.println("번호   노래 제목\t가수\t회사\t가격\t발매일");
		for( AlbumsBean ab : lists ) {
			System.out.println(ab.getNum() + "   " + ab.getSong() + "\t" + ab.getSinger() + "\t" + ab.getCompany() + "\t" + ab.getPrice() + "\t" + ab.getPub_day());
		}
	}
	
	private void getAllAlbums() {
		ArrayList<AlbumsBean> lists = dao.getAllAlbums();
		showAlbums(lists);
	}
	
	private void getAlbumsBySearch() {
		System.out.print("노래 제목:1   가수:2   회사:3   번호입력>> ");
		String column = null;
		String searchWord = null;
		int searchNum = sc.nextInt();
			
			switch(searchNum) {
			
			case 1 : 
						System.out.print("조회할 노래 제목 입력 : ");
						column = "song";
					break;
			case 2 : 
						System.out.print("조회할 가수 입력 : ");
						column = "singer";
					break;
			case 3 : 
						System.out.print("조회할 회사 입력 : ");
						column = "company";
					break;
					
			default : System.out.println("1~3번만 입력 가능합니다.");
					//return;
					getAlbumsBySearch();
					return;
			}	
			try {
				searchWord = br.readLine().toLowerCase();
				column = column.toLowerCase();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		ArrayList<AlbumsBean> lists = dao.getAlbumsBySearch(column,searchWord);
		if(lists.size() == 0) {
			System.out.println("해당 단어는 존재하지 않습니다.");
		}
		else {
			showAlbums(lists);			
		}
	}
	
	private void insertAlbums() {
		
		String song = null, singer = null, company = null, pub_day = null;
		int price = 0;
		
		try {
			System.out.println("아이디는 시퀀스로 자동 입력됩니다.");

			System.out.print("노래 입력 : ");
			song = br.readLine();

			System.out.print("가수 입력 : ");
			singer = br.readLine();

			System.out.print("회사 입력 : ");
			company = br.readLine();
			do {
				try {
					System.out.print("가격 입력 : ");
					price = Integer.parseInt(br.readLine());
					break;
				} catch( NumberFormatException e ) {
					System.out.println("가격은 숫자를 입력하세요. ");
				}
			}while(true);
			
			System.out.print("발매일 입력 : ");
			pub_day = br.readLine();

			AlbumsBean ab = new AlbumsBean();
			ab.setSong(song);
			ab.setSinger(singer);
			ab.setCompany(company);
			ab.setPrice(price);
			ab.setPub_day(pub_day);

			int cnt = dao.insertAlbums(ab);
			if(cnt > 0) {
				System.out.println("Insert 성공");
			}
			else {
				System.out.println("Insert 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void updateAlbums() {
		
		String song = null, singer = null, company = null, pub_day = null;
		int num = 0, price = 0;
		
		try {
			System.out.print("교체할 번호 입력 : ");
			num = Integer.parseInt(br.readLine());
			
			System.out.print("교체할 노래 입력 : ");
			song = br.readLine();
			
			System.out.print("교체할 가수 입력 : ");
			singer = br.readLine();
			
			System.out.print("교체할 회사 입력 : ");
			company = br.readLine();
			
			do {
				try {
					System.out.print("가격 입력 : ");
					price = Integer.parseInt(br.readLine());
					break;
				} catch( NumberFormatException e ) {
					System.out.println("가격은 숫자를 입력하세요. ");
				}
			}while(true);
			
			System.out.print("교체할 발매일 입력 : ");
			pub_day = br.readLine();
			
			AlbumsBean ab = new AlbumsBean();
			ab.setNum(num);
			ab.setSong(song);
			ab.setSinger(singer);
			ab.setCompany(company);
			ab.setPrice(price);
			ab.setPub_day(pub_day);
			
			int cnt = dao.updateAlbums(ab);
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
	
	private void deleteAlbums() {
		
		System.out.print("삭제할 번호 입력 : ");
		int num = sc.nextInt();
		
		int cnt = dao.deleteAlbums(num);
		
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
	
	private void priceAlbums() {
		System.out.print("시작 등수 입력 : ");
		int start = sc.nextInt();
		
		System.out.print("끝 등수 입력 : ");
		int end = sc.nextInt();
		
		ArrayList<AlbumsBean> lists = dao.priceAlbums(start,end);
		showAlbums(lists);
	}
	
	
	private void orderByAlbums() {
		
		System.out.println("정렬할 항목을 선택하세요.");
		System.out.print("번호:1   노래 제목:2   가수:3   회사:4   번호입력>> ");
		String column = null;
		String order = null;
		int num = 0;
		int colNum = sc.nextInt();
			
			switch(colNum) {
			
			case 1 : column = "num";	
					break;
			case 2 : column = "song";
					break;
			case 3 : column = "singer";
					break;
			case 4 : column = "company";
					break;
			default : System.out.println("1~4번만 입력 가능합니다.");
					orderByAlbums();
					return;
			}	
			
			System.out.println("정렬할 방법을 선택하세요.");
			System.out.print("오름차순:1   내림차순:2   번호입력>> ");
			int orderNum = sc.nextInt();
			switch(orderNum) {
			
			case 1 : order = "asc";
						break;
			case 2 : order = "desc";
						break;
			default : 
					System.out.println("1~2번만 입력 가능합니다.");
					orderByAlbums();
						return;
			}
		
			ArrayList<AlbumsBean> lists = dao.orderByAlbums(column,order);
			showAlbums(lists);			
			
			
	}

	private void groupByAlbums() {
		try {
			System.out.print("그룹화할 회사명 입력 : ");
			String company = br.readLine();
			
			AlbumsBean ab = dao.groupByAlbums(company);
			if(ab != null) {
				System.out.println(ab.getCompany() + "\t" + ab.getPrice());
			}
			else {
				System.out.println("입력한 회사가 존재하지 않습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new AlbumsMain();

	}

}
