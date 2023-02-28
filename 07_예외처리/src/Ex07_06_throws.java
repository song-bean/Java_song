
public class Ex07_06_throws {

	static void call() throws ArithmeticException{ // 발생된 예외를 자신을 호출한 메서드(메인)로 넘기는 방법
		int a = 3/0;
	}

	public static void main(String[] args) {
		try {
			call();
		}catch(ArithmeticException e) {
			System.out.println("main에서 처리");
		}

	}

}
