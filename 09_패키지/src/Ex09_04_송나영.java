import java.util.Scanner;

class Person2 {
	private String id;
	private String passwd;
	private String name;
	
	public Person2(String id, String passwd, String name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getName() {
		return name;
	}
	
}//Person2

public class Ex09_04_송나영 {
	public static void main(String[] args) {
		
		Person2[] arr = {
							new Person2("kim","1234","김연아"),
							new Person2("son","7777","손흥민"),
							new Person2("jo","9876","조규성")
						};
		
		int i,j;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("ID입력:");
			String ln = sc.next();
			if(ln.length() < 2 || ln.length() > 8) {
				System.out.println("2~8글자 사이로 입력해야 합니다.");
				continue;
			}//if
			else {
				j=0;
				for(i=0;i<arr.length;i++) {
					if(arr[i].getId().equals(ln) == true) {
						System.out.print("비밀번호 입력:");
						String pd = sc.next();
						if(arr[i].getPasswd().equals(pd) == true) {
							System.out.println(arr[i].getName() + "님 반갑습니다.");
						}//if
						else {
							System.out.println("비밀번호가 맞지 않습니다.");
						}
					}//if
					else {
						j++;
					}//else	
				}//for
				if(j == arr.length) {
					System.out.println("일치하는 ID가 없습니다.");
					System.out.println("다시 입력하세요.");
				}
				System.out.print("계속?");
				String yon = sc.next();
				if(yon.equals("n")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
		}while(true);
		
		//아이디와 패스워드를 입력하면 --> 이름 님 반갑습니다. 
		//계속? --> y(es) , n --> 종료
		//만약 패스워드가 틀리면 --> 비번이 맞지 않습니다.
		//id가 틀리면 --> 일치하는 id가 없습니다. 다시 입력하세요. 
		//id는 3~8글자 사이로 입력해야 합니다.
		
		
		
	}

}
