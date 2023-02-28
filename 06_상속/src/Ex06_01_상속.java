class Sports { // 부모 클래스 
	private String name; // 스포츠 
	private int inwon; // 10
	
	public Sports() {
		
	}

	public Sports(String name, int inwon) {
		this.name = name;
		this.inwon = inwon;
	}
	public void display() {
		System.out.println(name + "," + inwon);
	}
	
}//Sports
class Baseball extends Sports{ // class 자식클래스명 extends 부모클래스명
	//	String name; //야구
	//	int inwon;
	private double ta;

	public Baseball() {
		super("야구", 9);
		ta = 0.567;
	}

	public Baseball (String name, int inwon, double ta) {
		//this.name = name;
		//this.inwon = inwon;
		super(name,inwon);
		this.ta = ta;
	}
	public void display() {
		//System.out.println(name + "," + inwon + "," + ta);
		super.display();
		System.out.println(ta);
	}

}//Baseball

class Football extends Sports{ // extends Sports를 쓰면 상속을 받게 됨 
	//	String name; // 축구
	//	int inwon;
	private int goal;

	public Football() {
		super("축구", 11);
		goal= 3;
	}

	public Football(String name, int inwon, int goal) {
		//this.name = name;
		//this.inwon = inwon;
		super(name,inwon);
		this.goal = goal;
	}

	public void display() {
		//System.out.println(name + "," + inwon + "," + goal);
		super.display();
		System.out.println(goal);
	}

}//Football

//상속: 기존에 만들어 놓은 클래스에 무언가를 추가하여 새로운 클래스를 만드는 것 
//상위클래스 = 조상클래스 = base 클래스
//하위클래스 = 자손클래스 derived 클래스 
public class Ex06_01_상속 {
	public static void main(String[] args) {

		Sports s = new Sports();
//		s.name = "스포츠";
//		s.inwon = 10;
//		System.out.println(s.name);
//		System.out.println(s.inwon);
		
		Sports s2 = new Sports("스포츠", 10);
		s2.display();
		System.out.println();
		System.out.println("-------------------");

		Baseball b = new Baseball();
//		b.name = "야구";
//		b.inwon = 9;
//		b.ta = 0.567;
//		System.out.println(b.name);
//		System.out.println(b.inwon);
//		System.out.println(b.ta);
		b.display();
		
		Baseball b2 = new Baseball("야구", 9, 0.567);
		b2.display();

		System.out.println("-------------------");

		Football f = new Football();
//		f.name = "축구";
//		f.inwon = 11;
//		f.goal = 3;
//		System.out.println(f.name);
//		System.out.println(f.inwon);
//		System.out.println(f.goal);
		f.display();
		
		Football f2 = new Football("축구", 11, 3); // 괄호안을 인자(parameter)라고 함
		f2.display();

		
		System.out.println("-------------------");
		System.out.println("***다형성***");
		
//		Sports s2 = new Sports("스포츠", 10);
//		Sports b3 = new Baseball("야구", 9, 0.567);
//		Sports f3 = new Football("축구", 11, 3);
		
		Sports[] arr = {
							new Sports("스포츠", 10),
							new Baseball("야구", 9, 0.567),
							new Football("축구", 11, 3)
						};
		
		for(int i=0;i<arr.length;i++) {
			arr[i].display();
		}
		
	}

}
