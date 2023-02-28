import java.util.Scanner;

class Person3 {
	
	private String name;
	private int age;
	
	public Person3() {
		
	}
	
	public Person3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void display() {
		System.out.println(name + "," + age);
	}
	
	public String toString() {
		return name + "," + age;
	}
}
	
	
public class Ex05_22_객체배열입력 {
	public static void main(String[] args) {
		
		//Person3 p2 = new Person3();
		//Person3 p3 = new Person3();
		
		Scanner sc = new Scanner(System.in);
		Person3[] p = new Person3[3];
		
		int i;
		for(i=0;i<p.length;i++) {
		
			System.out.print("이름입력:");
			String name = sc.next();
		
			System.out.print("나이 입력:");
			int age = sc.nextInt();
		
			p[i] = new Person3(name,age);
		}
		
		for(i=0;i<p.length;i++) {
			p[i].display();
		}
		System.out.println("--------------------");
		for(i=0;i<p.length;i++) {
			//System.out.println(p[i].toString());
			System.out.println(p[i]); // 참조값 == 참조값.toString()일때만 
		}
		
		sc.close();
		
		
		
	}

}
