interface TV {
	void viewTv();
}
interface Camera {
	public abstract void takePhoto();
}
interface Music {
	void playMusic();
}

class Shape2 {
	private int size;
	private String color;
	
	public Shape2(int size, String color) {
		this.size = size;
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public String getColor() {
		return color;
	}
	void display() {
		System.out.println("사이즈: " + size);
		System.out.println("color: " + color);
	}
}
class Phone extends Shape2 implements TV, Camera, Music {

	public Phone(int size, String color) {
		super(size,color);
	}
	public void playMusic() {
		System.out.println("음악을 듣는다.");
	}

	public void takePhoto() {
		System.out.println("사진을 찍는다.");
	}

	public void viewTv() {
		System.out.println("TV를 본다.");
	}
	
	
}

public class Ex06_15_interface {
	public static void main(String[] args) {
		
		Phone p = new Phone(7,"blue");
		//사이즈: 7 출력
		//color: blue 출력
		//p.display();
		System.out.println("사이즈: " + p.getSize());
		System.out.println("color: " + p.getColor());
		p.viewTv(); //TV를 본다.
		p.takePhoto();//사진을 찍는다.
		p.playMusic();//음악을 듣는다.
	}

}
