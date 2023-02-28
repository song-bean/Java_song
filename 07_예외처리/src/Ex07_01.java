
//컴파일 에러: 컴파일할 댸 발생하는 에러(오타, 자료형 체크,..)
//런타임 에러: 실핼할 때 발생하는 에러(배열의 범위를 넘기는 경우..)
//			에러(error)와 예외(Exception) 두 가지로 구분 됨
//			에러: 프로그램 코드에 의해서 수습될 수 없는 심각한 오류 (메모리 부족, ...)
//			예외: 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
// 예외처리: 발생할 수 있는 예외의 발생에 대비하는 코드를 작성하는 것
//			비정상적인 종료를 막고, 정상적인 실행상태를 유지하기 위해 반드시 넣어야 함
//예외가 발생하면 저절로 관련된 예외객체가 만들어짐(자동으로 생성)
//객체를 가지고 catch로 자동으로 넘어감
//자동으로 넘어오는 객체를 받아줄 변수가 필요함. (왜 에러가 났는 지 알려줌) --> 아래에서 e가 변수

/*try { // 필수
	예외발생 가능성이 있는 코드
}catch() { // 필수
	발생된 예외 처리
}finally { // 필수 아님
	무조건 온다.
}
*/

//자동으로 생성된다.

/* 보통 Exception으로 다 예외 처리 가능
- ArrayIndexOutOfBoundsException --> 배열에 접근할 때 잘못된 인덱스 값을 사용하는 예외상황
- ClassCastException --> 허용할 수 없는 형변환 연산을 하는 경우의 예외상황
- NegativeArraySizeException --> 배열선언 과정에서 배열의 크기를 음수로 지정하는 예외상황
- NegativeNumberException --> 음수를 입력할 때 나타나는 예외상황
- NullPointerException --> 참조변수가 null로 초기화 된 상황에서 메소드를 호출하는 경우의 예외상황
- ArithmeticException --> 0으로 나눗셈을 하는 등의 수학적 연산이 불가능한 예외상황
	등등
 */
/*
 아래 Exception들은 예외처리 필수(Exception으로 예외 처리 불가능)
- 존재하지 않는 파일의 이름을 입력했다.(FileNotFoundException)
– 실수로 클래스의 이름을 잘못적었다.(ClassNotFoundException)
– 입력한 데이터의 형식이 잘못되었다.(DataForamtException)
– I/O에 문제가 발생하였다.(IOException)
– InterruptedException
*/

public class Ex07_01 {
	public static void main(String[] args) {
		
		String str = null;
//		System.out.println(str);
//		System.out.println(str.length());
		
		int[] arr = new int[5];
		
		try { // 에러가 없으면 catch를 안가고 finally로 넘어감, 한번만 시도함
			System.out.println(str);
			System.out.println(str.length());
			// new NullPointerException
			
			arr[0] = 10;
			arr[4] = 40;
			arr[5] = 50; // 이 지점에서
			//ArrayIndexOutOfBoundsException() --> 배열 오류
			
			System.out.println("하하하"); // 예외가 발생하면 즉시 catch로 감 --> 출력 안함(예외가 발생하면 그 밑은 실행 안함)
			
			//NullPointerException e = new NullPointerException();
		}catch(NullPointerException e) {
			System.out.println("예외발생함1");
			System.out.println("e:" + e);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			//ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
			System.out.println("예외발생함2");
			System.out.println("e:" + e);
		}catch(Exception e) { // Exception으로 모든 예외를 다 잡을 수 있음
			//위에 다른 Exception과 같이 쓰고 싶으면 마지막에 써야 같이 사용 가능
			//그렇지 않으면, 이 Exception때문에 다른 Exception들은 사용 불가
			//다형성 개념으로 다른 Exception들을 다 받을 수 있음
		}finally { // 없으면 안써도 됨
			System.out.println("finally 영역");
			System.out.println("여기는 무조건 처리됨");
		}
		
		System.out.println("예외처리");
	}

}

