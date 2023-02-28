
public class Ex09_07_Wrapper {
	public static void main(String[] args) {
		
		//기본 자료형: boolean, byte, char, short, int, boolean, float, long, double 
		
		//Wrapper class
		Integer it1 = new Integer(11); // 정수를 표현할 수 있는 클래스(정수만 넣을 수 있는 클래스)
		Integer it2 = 12; // 12 --> new Integer(12)
		System.out.println(it1 + it2);
		
		int it3 = new Integer(21); // Integer대신 int로 써도 됨, new Integer(21) --> 21: unboxing
		int it4 = new Integer(22); // Integer대신 int로 써도 됨, new Integer(22) --> 22: unboxing
		System.out.println(it3 + it4);
		
		
		
		double d1 = 1.1;
		Double d2 = new Double(1.1);
		Double d3 = 1.1; // 1.1 --> new Double(1.1): autoboxing
		double d4 = new Double(1.1); // new Double(1.1) --> 1.1: unboxing
		
		int i = Integer.parseInt("100"); // 문자열 --> 정수
		int j = Integer.parseInt("200");
		
		System.out.println("100" + "200");
		System.out.println(i+j); //300
		
		Integer i2 = Integer.valueOf("100");
		int j2 = Integer.valueOf("200");
		System.out.println(i2+j2); // 300
		
		
		
		double d5 = Double.parseDouble("1.1");
		double d6 = Double.parseDouble("2.2");
		System.out.println(d5+d6);
	}

}
