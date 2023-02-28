import java.util.Scanner;

class Student {
	String name;
	int kor, eng, math;
	
	//합계를 리턴하는 sum 메서드 정의 
	static int sum(int a, int b, int c) {
		return a+b+c; // 매개변수
	}
	int sum2() { // 위에서 정의한 멤버 변수를 사용하기 때문에 굳이 정수를 부르지 않아도 됨
		return kor+eng+math; // 멤버 변수
	}
	
	//평균을 리턴하는 avg 메서드 정의 
	static double avg (int a, int b, int c) {
		return (double)(a+b+c)/3;
	}
	double avg2() {
		//return (kor+eng+math)/3.0;
		return sum2() / 3.0;
	}
	
	void show() {
		System.out.println("name:" + name);
		System.out.println("kor:" + kor);
		System.out.println("eng:" + eng);
		System.out.println("math:" + math);
	}
	
}//student 
public class Ex05_07_송나영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student stu = new Student();
		
		System.out.print("이름 입력:");
		stu.name = sc.next();
		
		System.out.print("국어 입력:");	
		stu.kor = sc.nextInt();
				
		System.out.print("영어 입력:");
		stu.eng = sc.nextInt();
		
		System.out.print("수학 입력:");
		stu.math = sc.nextInt();
		
		//입력 받은 4가지 값 모두 출력
		stu.show();
		//System.out.println("이름:" + stu.name);
		//System.out.println("국어:" + stu.kor);
		//System.out.println("영어:" + stu.eng);
		//System.out.println("수학:" + stu.math);
		
		//합계 출력
		System.out.println("합계:" + Student.sum(stu.kor, stu.eng, stu.math));
		System.out.println("sum2:" + stu.sum2());
		
		//평균 출력(소수 아래 2자리까지 출력)
		System.out.printf("평균:%.2f\n", Student.avg(stu.kor, stu.eng, stu.math));
		System.out.printf("avg2:%.2f\n", stu.avg2());
		sc.close();
	}

}
