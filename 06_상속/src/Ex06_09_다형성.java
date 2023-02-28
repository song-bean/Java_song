class Animal {
	public void bark() {
		System.out.println("bark bark");
	}
}//Animal

class Dog extends Animal {
	public void bark() {
		System.out.println("멍멍");
	}
}//Dog



public class Ex06_09_다형성 {
	public static void main(String[] args) {
		
		int i = (int)3.7; // double(8) --> int(4)로 다운캐스팅
		System.out.println(i);
		double j = 3; // int (4) --> double(8)로 업캐스팅, 업캐스팅은 굳이 안써도 자동으로 된다.
		System.out.println(j);
		
		Animal a = new Animal();
		a.bark();
		Dog d = new Dog();
		d.bark();
		
		//Animal d2 = (Animal)new Dog(); 
		Animal d2 = new Dog(); // Dog(자식) --> Animal(부모) 업캐스팅 --> 자동
		d2.bark(); // 부모에 같은 메서드가 없으면 자식 클래스에 접근 못함
		
		d = (Dog)d2; // Dog(자식) = Animal(부모)
		d.bark();
		
	}

}
