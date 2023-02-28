import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class joinMain {
	
	Scanner sc = new Scanner(System.in);
	ProducerDao pdao = new ProducerDao();
	ConsumerDao cdao = new ConsumerDao();
	JoinDao jdao = new JoinDao();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public joinMain() {
		init();
	}//생성자
	
	private void init() {
		while(true) {
			System.out.println("\n=== 메뉴 선택 ===");
			System.out.println("1. producer 테이블 조회");
			System.out.println("2. consumer 테이블 조회");
			System.out.println("3. Producer 테이블 추가");
			System.out.println("4. Consumer 테이블 추가");
			System.out.println("5. Producer 테이블에서 삭제");
			System.out.println("6. Consumer 테이블에서 삭제");
			System.out.println("7. Producer 테이블에서 수정");
			System.out.println("8. Consumer 테이블에서 수정");
			System.out.println("9. join");
			System.out.println("10. 프로그램 종료");
			
			System.out.print("메뉴번호 선택>> ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1 : 
						System.out.println("1. producer 테이블 조회");
						getAllProducer();
					break;
			case 2 :
						System.out.println("2. consumer 테이블 조회");
						getAllConsumer();
					break;
			case 3 :
						System.out.println("3. Producer 테이블 추가");
						insertProducer();
					break;
			case 4 :
						System.out.println("4. Consumer 테이블 추가");
						insertConsumer();
					break;
			case 5 :
						System.out.println("5. Producer 테이블에서 삭제");
						deleteProducer();
					break;
			case 6 :
						System.out.println("6. Consumer 테이블에서 삭제");
						deleteConsumer();
					break;
			case 7 :
						System.out.println("7. Producer 테이블에서 수정");
						updateProducer();
					break;
			case 8 :
						System.out.println("8. Consumer 테이블에서 수정");
						updateConsumer();
					break;
			case 9 :
						System.out.println("9. join");
						join();
					break;
			case 10 :
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
					break;
			}
		}
	}


	private void getAllProducer() {
		ArrayList<ProducerBean> plist = new ArrayList<ProducerBean>();
		plist = pdao.getAllProducer();
		
		for(ProducerBean pb : plist) {
			System.out.println(pb.getCode() + "/" + pb.getPname() + "/" + pb.getPprice());
		}
	}
	
	private void getAllConsumer() {
		ArrayList<ConsumerBean> clist = new ArrayList<ConsumerBean>();
		clist = cdao.getAllConsumer();
		
		for(ConsumerBean cb : clist) {
			System.out.println(cb.getCode() + "/" + cb.getCname() + "/" + cb.getCprice() + "/" + cb.getCaddr());
		}
	}

	private void insertProducer() {
		String code =  null;
		String pname = null;
		int pprice = 0;
		
		try {
			System.out.print("추가할 CODE : ");
			code = br.readLine();
			System.out.print("PNAME 입력 : ");
			pname = br.readLine();
			
			do {
				try {
					System.out.print("PPRICE 입력 : ");
					pprice = Integer.parseInt(br.readLine());
					break;
				} catch( NumberFormatException e ) {
					System.out.println("가격은 숫자를 입력하세요. ");
				}
			}while(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		ProducerBean pb = new ProducerBean();
		pb.setCode(code);
		pb.setPname(pname);
		pb.setPprice(pprice);
		
		int cnt = pdao.insertProducer(pb);
		if(cnt > 0) {
			System.out.println("Insert 성공");
		}
		else {
			System.out.println("Insert 실패");
		}
		
	}
	
	private void insertConsumer() {
		String code =  null;
		String cname = null;
		int cprice = 0;
		String caddr = null;
		boolean flag = false;
		
		ArrayList<ProducerBean> plist = new ArrayList<ProducerBean>();
		plist = pdao.getAllProducer();
		
		try {
			
			System.out.print("추가할 CODE : ");
			code = br.readLine();
			
//			for(ProducerBean pb : plist) {
//				if(code.equals(pb.getCode())) {
//					flag = true;
//				}
//			}
//			if(flag == false) {
//				System.out.println("부모키가 없습니다.");
//				insertConsumer();
//				return;
//			}
// Dao에서 예외처리 하면 됨			
			
			System.out.print("CNAME 입력 : ");
			cname = br.readLine();
			
			do {
				try {
					System.out.print("PPRICE 입력 : ");
					cprice = Integer.parseInt(br.readLine());
					break;
				} catch( NumberFormatException e ) {
					System.out.println("가격은 숫자를 입력하세요.");
				}
			}while(true);
			
			System.out.print("CADDR 입력 : ");
			caddr = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ConsumerBean cb = new ConsumerBean();
		cb.setCode(code);
		cb.setCname(cname);
		cb.setCprice(cprice);
		cb.setCaddr(caddr);
		
		int cnt = cdao.insertConsumer(cb);
		if(cnt > 0) {
			System.out.println("Insert 성공");
		}
		else {
			System.out.println("Insert 실패");
		}
	}
	
	private void deleteProducer() {
		
		String code =  null;
		
		try {
			System.out.print("삭제할 CODE : ");
			code = br.readLine();
			
			int cnt = pdao.deleteProducer(code);
			if(cnt > 0) {
				System.out.println("Delete 성공");
			}
			else if(cnt == 0) {
				System.out.println("조건에 맞는 레코드 없음");
			}
			else {
				System.out.println("Delete 실패");
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void deleteConsumer() {
		String code =  null;
		
		try {
			System.out.print("삭제할 CODE : ");
			code = br.readLine();
			
			int cnt = cdao.deleteConsumer(code);
			if(cnt > 0) {
				System.out.println("Delete 성공");
			}
			else if(cnt == 0) {
				System.out.println("조건에 맞는 레코드 없음");
			}
			else {
				System.out.println("Delete 실패");
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateProducer() {
		
		System.out.print("수정 전 CODE : ");
		String wcode = sc.next();
		
		System.out.print("수정 후 CODE : ");
		String scode = sc.next();
		
		int cnt = pdao.updateProducer(scode,wcode);
		if(cnt > 0) {
			System.out.println("Update 성공");
		}
		else if(cnt == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else {
			System.out.println("Update 실패");
		}	
		
	}

	private void updateConsumer() {
		
		System.out.print("수정 전 CODE : ");
		String wcode = sc.next();
		
		System.out.print("수정 후 CODE : ");
		String scode = sc.next();
		
		int cnt = cdao.updateConsumer(scode,wcode);
		if(cnt > 0) {
			System.out.println("Update 성공");
		}
		else if(cnt == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else {
			System.out.println("Update 실패");
		}	
	}
	
	private void join() { //code, pname, cname, cprice, caddr
		ArrayList<JoinBean> jlist = new ArrayList<JoinBean>();
		jlist = jdao.join();
		
		for( JoinBean jb : jlist ) {
			System.out.println(jb.getCode() + "/" + jb.getPname() + "/" + jb.getCname() + "/" + jb.getCprice() + "/" + jb.getCaddr());
		}
		
		
	}

	public static void main(String[] args) {
		new joinMain();
	}

}
