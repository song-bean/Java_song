class Fruit {
	void apple() {
		System.out.println("apple");
	}
	
	static void banana() {
		System.out.println("banana");
	}
	
}//Fruit 

public class Ex05_06_메서드 {

	public static void main(String[] args) {
		
		//4가지 메서드 호출
		
		Fruit fru = new Fruit();
		fru.apple();
		
		Fruit.banana();
		//fru.banana();
		
		Ex05_06_메서드 fruit = new Ex05_06_메서드();
		fruit.orange();
		
		melon();
		//Ex05_06_메서드.melon();
		//fruit.melon();
		

	}//main

	void orange() {
		System.out.println("orange");
	}
	
	static void melon() {
		System.out.println("melon");
	}
	
}//class

