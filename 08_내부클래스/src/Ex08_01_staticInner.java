class Car1 {
	 Car1name name;
	 String color;

	static class Car1name { // 클래스도 하나의 멤버처럼
		static String model; 
		int year;
		Car1name(String model, int year) {
			this.model = model;
			this.year = year;
		}
		Car1name(){
			
		}
		
	} // static inner의 끝

	Car1(String model, int year, String color) {
		this.name = new Car1name(model,year);
		this.color = color;
	}
	Car1(){
		
	}
	void OutInfo() {
		System.out.printf("모델 = %s, 년식 = %d, 색상 = %s\n",
				name.model, name.year, color);
	}
}

public class Ex08_01_staticInner {

	public static void main(String[] args) {
		
		Car1 pride = new Car1("프라이드", 2005, "파랑");
		pride.OutInfo(); // 모델 = 프라이드, 년식 = 2005, 색상 = 파랑
		System.out.println(pride.color);
		System.out.println(pride.name.model);
		System.out.println(pride.name.year);
		System.out.println();
		
		Car1 pride2 = new Car1();
		System.out.println(pride2.name.model);   
		
		System.out.println("=====================");
		
		// static class이므로 Car1.Car1name으로 선언해야 함
		Car1.Car1name sonata = new Car1.Car1name("소나타", 2023); 
		System.out.printf("모델 = %s, 년식 = %d\n", sonata.model,sonata.year);
		// 모델 = 소나타, 년식 = 2023

		Car1.Car1name sonata2 = new Car1.Car1name();
		System.out.printf("모델 = %s, 년식 = %d\n", sonata2.model,sonata2.year);

	}

}
