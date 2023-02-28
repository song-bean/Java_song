import java.util.Scanner;

//class Person2 {
//	private String id;
//	private String passwd;
//	private String name;
//	
//	public Person2(String id, String passwd, String name) {
//		super();
//		this.id = id;
//		this.passwd = passwd;
//		this.name = name;
//	}
//	
//	public String getId() {
//		return id;
//	}
//	public String getPasswd() {
//		return passwd;
//	}
//	public String getName() {
//		return name;
//	}
//	
//}//Person2

public class Ex09_04_풀이 {
	public static void main(String[] args) {
		
		Person2[] arr = {
				new Person2("kim","1234","김연아"),
				new Person2("son","7777","손흥민"),
				new Person2("jo","9876","조규성")
			};
		
		Scanner sc = new Scanner(System.in);
		String id,pw,retry;
		int i;
		boolean flag = false;
		
	 do {
		 System.out.print("ID입력:");
		 id = sc.next();
		if(id.length() < 2 || id.length() > 8) {
			System.out.println("ID는 2글자~8글자 입력해야 합니다.");
			continue;
		}//if
		else { //2~8사이 제대로 입력한 상태
			for(i=0;i<arr.length;i++) {
				if(arr[i].getId().equals(id)) { // 문자열 비교는 ==불가 -->equals 메서드 사용
					flag = true; 	//찾았다 라는 표시
					
				}//if
			}//for
			if(flag == false) {
				System.out.println("일치하는 ID가 없습니다.");
				continue;
			}
		}//else
		
		 System.out.print("pw입력:");
		 pw = sc.next();
		 for(i=0;i<arr.length;i++) {
			 if(arr[i].getId().equals(id)) {
				 if(arr[i].getPasswd().equals(pw)) {
					 System.out.println(arr[i].getName() + "님 반갑습니다.");
				 }
				 else {
					 System.out.println("비밀번호가 맞지 않습니다.");
				 }
			 }//if
		 }//for
		 
		 System.out.print("계속?");
		 retry = sc.next(); // y n
		 if(retry.equals("n")) {
			break; 
		 }
	 }while(true);
		
	}

}

//반복해서 id를 입력
//입력한 id의 길이 조건 비교

