
public class Ex07_04_throw {
	static void call() {

		try {
			int a = 3/0;			
		}catch(ArithmeticException e) {
			System.out.println("call메서드에서 ERROR 발생");
			throw e; // 예외가 발생했다는 정보를 메인으로 던짐(전달)
		}
	}


	public static void main(String[] args) {

		try {
			call();
			System.out.println("정상적으로 처리되었습니다.");
		}catch(ArithmeticException e) {
			System.out.println("처리중 에러발생");
		}
	}


}
