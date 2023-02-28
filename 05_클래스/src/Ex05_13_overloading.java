
public class Ex05_13_overloading {

	public static void main(String[] args) {
		
		star();
		star(7);
		star(3,7);

	}
	
	/*
	 오버로딩: 하나의 메서드 이름으로 여러 개의 메서드를 만들 수 있게 해주는 기법 
	 			메서드 이름이 같아야 함
				자료형 or 개수가 달라야 함 
				(자료형이 같으면 개수가 달라야하고, 개수가 같으면 타이 달라야 함)
				리턴타입은 오버로딩에서 구분하지 않는다.
	*/
	static void star() { 
		System.out.println("*****");
	}
	
	static void star(int n) { 
		int i;
		for(i=0;i<n;i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	static void star(int n, int m) {
		//return 0;
	}

}
