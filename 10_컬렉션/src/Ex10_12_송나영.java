import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
	private String addr;
	private double height;
	private int kor;

	public Student(String addr, double height, int kor) {
		super();
		this.addr = addr;
		this.height = height;
		this.kor = kor;
	}

	public String toString() {
		return addr + "/" + height + "/" + kor;
	}

}//Student


public class Ex10_12_송나영 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String,Student> map = new HashMap<String,Student>();

		while(true) {
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("주소 : ");
			String addr = sc.next();
			System.out.print("키 : ");
			double height = sc.nextDouble();
			System.out.print("국어 : ");
			int kor = sc.nextInt();

			Student s = new Student(addr,height,kor);
			map.put(name, s);

			System.out.print("계속?");
			String input = sc.next();
			if(input.equals("n")) {
				break;
			}
			System.out.println();
		}
		System.out.println(map);
		System.out.println();
		
		while(true) {

			System.out.print("찾는 이름 : ");
			String name = sc.next();
//			if(map.get(name) == null) {
//				System.out.println("찾는 이름 없음");
//			}
//			else {
//				System.out.println(map.get(name));
//			}
			
			if(map.containsKey(name)) {
				System.out.println(map);
			}
			else {
				System.out.println("찾는 이름 없음");
			}
			System.out.print("계속?");
			String input = sc.next();
			if(input.equals("n")) {
				break;
			}
			System.out.println();			
		}
		System.out.println();
		
		while(true) {
			boolean flag = false;
			System.out.print("삭제할 이름 : ");
			String name = sc.next();
			if(map.get(name) == null) {
				System.out.println("찾는 이름 없음");
			}
			else {
				map.remove(name);
				System.out.println(map);
			}
			System.out.println("찾는 이름 없음");
			System.out.println();
			System.out.print("계속?");
			String input = sc.next();
			if(input.equals("n")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		
		sc.close();

	}

}

