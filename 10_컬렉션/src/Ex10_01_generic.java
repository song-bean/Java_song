class Top<T> {
	private T data; // T대시 아무거나 써도 됨(아직 확정되지 않은 자료형)
	
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	
}//Top

public class Ex10_01_generic {
	public static void main(String[] args) {
		
		String str = "Generic 방식";
		
		Top<String> t1 = new Top<String>(); // 객체를 만들 때 미지정 자료형이 확정이 됨 
		t1.setData(str);
		System.out.println(t1.getData());
		System.out.println();
		
		Top<Integer> t2 = new Top<Integer>(); // 클래스 타입으로 적어줘야 함 (int 불가) 
		//Integer data = 123 // 123 --> new Inreger(123): autoboxing
		t2.setData(123);
		System.out.println(t2.getData());
		System.out.println();
		
		Top<Double> t3 = new Top<Double>();
		t3.setData(1.1);
		System.out.println(t3.getData());
		
	}

}

//제너릭: 하나의 코드를 재사용할 수 있도록 해주는 기술 (문자열 변수도 됐다가, 정수 변수도 됐다가.. )