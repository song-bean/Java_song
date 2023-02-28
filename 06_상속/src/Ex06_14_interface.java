//인터페이스: 몸체가 없는 메서드(추상메서드)와 상수(변수x)로만 이루어진 클래스
//완성된 메서드가 있으면 안됨
//인터페이스는 abstract를 안써도 됨(써도 되긴 함)
//public abstract가 자동으로 붙음
//여러 인터페이스를 상속 받을 수 있음 (다중 상속이 가능함)
//생성자를 만들 수 없음
interface Copymachine {
	//public abstract void copy(); 
	void copy(); // public abstract가 자동으로 붙음
	//static final int age = 30;
	int age = 30; // 자동으로 static final이 붙음 --> 상수 취급
//생성자를 만들 수 없음 	
//	public Copymachine() {
//		
//	}
}

interface Printmachine{
	public void print();
}

interface Faxmachine{
	public void fax();
}//Faxmachine

class AA {
	
}//AA

//extends 클래스명
//implements 인터페이스명1, 인터페이스명2
//extends 클래스명 (,쓰면 안됨) implements 인터페이스명1, 인터페이스명2 --> 이 순서대로 써야함 extends를 뒤에 쓰면 에러남
class Compound extends AA implements Copymachine,Printmachine,Faxmachine{
	//int age = 30;
	public Compound() {
		super();
		System.out.println("Compound 생성자");
	}
	public void copy() {
		System.out.println("복사한다.");
	}

	public void fax() {
		System.out.println("팩스보낸다.");
	}

	public void print() {
		System.out.println("프린트한다.");
	}
	
}
public class Ex06_14_interface {
	public static void main(String[] args) {
		
		//new Copymachine // 사용불가능함 미완성이므로
		
		Compound c = new Compound();
		c.copy();
		c.fax();
		c.print();
		System.out.println(c.age); // 밑에 두가지 방식이 더 맞는 방식
		System.out.println(Copymachine.age); //인터페이스명.변수
		System.out.println(Compound.age); // 클래스명.변수
		//c.age = 70; // 인터페이스 안에 수는 상수이므로 값을 못바꿈
		//The final field Copymachine.age cannot be assigned
		System.out.println();
		
		Copymachine c2 = new Compound(); 
		c2.copy();
		//c2.fax(); // 부모가 갖고 있어야 자식 메서드가 호출됨
		//c2.print();

	}

}
