//추상클래스는 추상메서드와 정의된 메서드 다 가질 수 있다. 
//생성자를 만들 수 있음
abstract class Shape { // 추상클래스: 상속받게할 목적 
	public Shape() {
		System.out.println("Shape 생성자");
	}
	
	public void make() { //정의 
		System.out.println("도형 그리기");
	}
	
	public abstract void draw(); // 미완성 메서드 --> 추상메서드: 강제로 오버라이딩 시키려는 목적
	public abstract void delete(); 
	
}//Shape

//1. abstract를 앞에 쓰거나
//2. 미완성 메서드를 완성시키기
class Circle extends Shape {
	public Circle() {
		System.out.println("Circle 생성자");
	}
	public void draw() {
		System.out.println("원을 그린다.");
	}
	public void delete() {
		System.out.println("원을 지운다.");
	}
	
}//Circle

class Triangle extends Shape{
	public Triangle() {
		System.out.println("Triangle 생성자");
	}
	public void draw() {
		System.out.println("삼각형을 그린다.");
	}
	public void delete() {
		System.out.println("삼각형을 지운다.");
	}
}

public class Ex06_12_추상 {
	public static void main(String[] args) {
		
		//new Shape(); // 미완성 클래스는 객체를 만들 수 없음
		Circle c = new Circle();
		c.draw();
		c.delete();
		System.out.println();
		
		Triangle t = new Triangle();
		t.draw();
		t.delete();
		System.out.println();
		
		Shape[] arr = { new Circle(), new Triangle()}; //객체 두 개를 만들었기 때문에 생성자가 먼저 호출
		for(int i=0;i<arr.length;i++) { 
			arr[i].draw();
			arr[i].delete();
		}
		
	}

}
