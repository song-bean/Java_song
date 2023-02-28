import java.util.ArrayList;
import java.util.Scanner;

class Card {
	private String name;
	private String tel;

	public Card(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}//Card
public class Ex10_05_송나영 {
	public static void main(String[] args) {

		ArrayList<Card> list = new ArrayList<Card>();
		Scanner sc = new Scanner(System.in);
		int i;
		boolean flag = false;
		while(true) {
			System.out.print("1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.print("이름을 입력하세요 : ");
				String name = sc.next();
				System.out.print("전화번호를 입력하세요 : ");
				String tel = sc.next();

				Card c = new Card(name,tel);
				list.add(c);
				System.out.println();
			}
			else if(num == 2) {
				System.out.print("삭제할 이름을 입력하세요 : ");
				String name = sc.next();
				for(i=0;i<list.size();i++) {
					Card c = list.get(i);
					if(c.getName().equals(name)) {
						flag = true;
						list.remove(i);
					}
				}
				if(flag == true) {
					System.out.println("삭제되었습니다.");
				}
				else {
					System.out.println("이름을 잘못입력하셨습니다.");
				}
				System.out.println();
			}
			else if(num == 3) {
				flag = false;
				System.out.print("수정할 이름을 입력하세요 : ");
				String name = sc.next();
				for(i=0;i<list.size();i++) {
					Card c = list.get(i);
					if(c.getName().equals(name)) {
						flag = true;
						System.out.print("수정하실 전화번호는 : ");
						String tel = sc.next();
						c.setTel(tel);
					}
				}
				if(flag == true) {
					System.out.println("수정되었습니다.");
				}
				else {
					System.out.println("이름을 잘못입력하셨습니다.");
				}
				System.out.println();
			}
			else if(num == 4) {
				System.out.println("이름" + "\t" + "전화번호");
				for(i=0;i<list.size();i++) {
					Card c = list.get(i);
					System.out.println(c.getName() + "\t" + c.getTel());
				}
				System.out.println();
			}
			else if(num == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;	
			}
			else {
				System.out.println("번호를 잘못입력하셨습니다.");
			}
			System.out.println();
		}

		sc.close();
		
	}

}
