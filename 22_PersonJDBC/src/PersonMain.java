import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {

	Scanner sc = new Scanner(System.in);
	PersonDao dao = new PersonDao();
	
	public PersonMain() {
		System.out.println("PersonMain 생성자");
		init();
	}
	public void init() {
		System.out.println("init");
		int menu;

		while(true) {
			System.out.println("=== 메뉴 선택하기 ===");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.성별로 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");

			System.out.print(">> 메뉴 번호 입력 : ");
			menu = sc.nextInt();
			switch(menu) {

				case 1: 
							System.out.println("1.전체 정보 조회");
							ArrayList<PersonBean> lists = dao.getAllPerson();
							
							System.out.println("전체 레코드 수 : " + lists.size());
							
							for(int i=0; i< lists.size(); i++) {
								PersonBean pb = lists.get(i);
								System.out.println(pb.getNum() + "/"+ pb.getName() + "/"+pb.getAge()+"/"+pb.getGender()+"/"+pb.getBirth());
							}
							
//							//확장 for문
//							for(PersonBean pb2 : lists) {
//								System.out.println(pb2.getNum() + "/"+ pb2.getName() + "/"+pb2.getAge()+"/"+pb2.getGender()+"/"+pb2.getBirth());								
//							}
							
						break;
				case 2: System.out.println("2.성별로 조회");
							getPersonByGender();
						break;	
				case 3: System.out.println("3.정보 수정");
							updatePerson();
						break;
				case 4: System.out.println("4.정보 삭제");
							deletePerson();
						break;		
				case 5: System.out.println("5.정보 추가");
							insertPerson();
						break;
				case 6: System.out.println("프로그램 종료합니다.");
						System.exit(0);
						break;
				default : System.out.println("1~6사이의 번호만 입력 가능함");
				
			}
		}
	}

	public void getPersonByGender() {
		System.out.print("찾는 성별 입력 : ");
		String gender = sc.next();
		ArrayList<PersonBean> lists = dao.getPersonByGender(gender);
		
		for(PersonBean pb : lists) {
		System.out.println(pb.getNum() + "/"+ pb.getName() + "/"+pb.getAge()+"/"+pb.getGender()+"/"+pb.getBirth());								
		}
	}//getPersonByGender
	
	public void insertPerson() {
		System.out.println("번호는 시퀀스로 자동 입력됩니다.");
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 입력 : ");
		String gender = sc.next();
		
		System.out.print("생일 입력 : ");
		String birth = sc.next();
		
		//dao.insertPerson(name, age, gender, birth);
		
		PersonBean pb = new PersonBean();
		pb.setName(name);
		pb.setAge(age);
		pb.setGender(gender);
		pb.setBirth(birth);
		
		int result = dao.insertPerson(pb); // 넘길게 많으면 한묶음으로
		if(result > 0) {
			System.out.println("insert 성공");
		}
		else {
			System.out.println("insert 실패");
		}
		
	}//insertPerson
	
	
	public void updatePerson() {
		
		System.out.print("번호 입력 : ");
		int num = sc.nextInt();
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 입력 : ");
		String gender = sc.next();
		
		System.out.print("생일 입력 : ");
		String birth = sc.next();
		
		PersonBean pb = new PersonBean();
		pb.setNum(num);
		pb.setName(name);
		pb.setAge(age);
		pb.setGender(gender);
		pb.setBirth(birth);
		
		int result = dao.updatePerson(pb); // 넘길게 많으면 한묶음으로
		if(result > 0) {
			System.out.println("insert 성공");
		}
		else if(result == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else {
			System.out.println("insert 실패");
		}
		
	}
	
	public void deletePerson() {
		System.out.print("삭제할 번호를 입력 : ");
		int num = sc.nextInt();
		
		int result = dao.deletePerson(num);
		
		if(result > 0) {
			System.out.println("delete 성공");
		}
		else if(result == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else {
			System.out.println("delete 실패");
		}
	}
	
	
	public static void main(String[] args) {

		new PersonMain();

	}
}
