import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	public String toString() {
		return name + "," +age; 
	}


}//Person

class Student extends Person{
	//	private String name;
	//	private int age;
	private int java;
	private int jsp;

	public Student(String name, int age, int java, int jsp) {
		super(name,age);
		this.java = java;
		this.jsp = jsp;
	}

	public String toString() {
		return super.toString()+"," + java + "," + jsp + " 평균:" + (java+jsp)/2; 
		//return getName() + "," + getAge() +"," + java + "," + jsp + " 평균:" + (java+jsp)/2; 
	}

	public void setJava(int java) {
		this.java = java;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public int getJava() {
		return java;
	}
	public int getJsp() {
		return jsp;
	}

}//Student

public class Test3_송나영 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		int i,age = 0,java,jsp;

		while(true) {
			System.out.print("이름 입력:");
			String name = sc.next();

			do {
				try {
					System.out.print("나이 입력:");
					age = sc.nextInt();
					break;

				}catch(InputMismatchException e) {
					System.out.println("나이는 숫자로 입력하세요.");
					sc.next(); // 엔터를 날려야 함
				}
			}while(true);

			do {
				try {
					System.out.print("자바 입력:");
					java = sc.nextInt();
					break;
				}catch(InputMismatchException e) {
					System.out.println("자바는 숫자로 입력하세요.");
					sc.next(); // 엔터를 날려야 함
				}
			}while(true);

			do {
				try {
					System.out.print("jsp 입력:");
					jsp = sc.nextInt();
					break;
				}catch(InputMismatchException e) {
					System.out.println("jsp는 숫자로 입력하세요.");
					sc.next(); // 엔터를 날려야 함
				}
			}while(true);

			Student s = new Student(name,age,java,jsp);
			list.add(s);

			System.out.println("*************************************");
			System.out.print("계속? ");
			String input = sc.next();
			if(input.equals("n")) {
				break;
			}
		}//while
		System.out.println("ArrayList 사용한 결과");
		for(i=0;i<list.size();i++) {
			Student s = list.get(i);
			System.out.println(i + ":" + s);
		}
		System.out.println("=====================================");


		while(true) {
			boolean flag = false;
			System.out.print("찾는 이름을 입력 : ");
			String name = sc.next();
			for(i=0;i<list.size();i++) {
				Student s = list.get(i);
				if(s.getName().equals(name)) {
					flag = true;
					System.out.println(s.getAge()+"/"+s.getJava()+"/"+s.getJsp());
				}
			}
			if(flag == false) {
				System.out.println("찾는 이름이 없습니다.");
			}


			System.out.print("계속? ");
			String input = sc.next();
			if(input.equals("n")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}


		sc.close();
	}
}
