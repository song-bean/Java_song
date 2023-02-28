class Student2{
	private String name;
	private int kor, eng, math;
	
	public Student2() {
		name = "써니";
		kor = 10;
		eng = 20;
		math = 30;
	}
	public Student2(String name) {
		this.name = name;
		kor = 50;
		eng = 50;
		math = 50;
	}
	public Student2(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void display() {
		System.out.println(name + "," + kor + "," + eng + "," + math);
	}
	
}
public class Ex05_21_객체배열 {
	public static void main(String[] args) {
		
		int[] a = {1, 2, 3}; // int 3개를 배열 
		int[] c = new int[3]; // 기본값 0
		c[0] = 1;
		c[1] = 2;
		c[2] = 3;
		double[] b = {1.1, 2.2, 3.3, 4.4};
		
		Student2 s1 = new Student2(); // 써니,10,20,30
		s1.display();
		
		Student2 s2 = new Student2("태연"); // 태연,50,50,50
		s2.display();
		
		Student2 s3 = new Student2("윤아",70,80,90); //윤아,70,80,90
		s3.display();

		System.out.println("-------------");
		
		
//		Student2[] arr = new Student2[3]; // 기본값 null
//		// 배열에는 주소가 저장됨 (노트 그림 참고)
//		arr[0] = new Student2(); // arr[0] = s1
//		arr[1] = new Student2("태연"); //arr[1] = s2
//		arr[2] = new Student2("윤아",70,80,90); //arr[2] = s3
		
		Student2[] arr = {	
							new Student2(), 
							new Student2("태연"), 
							new Student2("윤아",70,80,90)};
		
		int i;
		for(i=0;i<arr.length;i++) {
			arr[i].display();
		}
		System.out.println("-------------");
		
		for(Student2 s : arr ) {
			s.display();
		}
		
		
		
		
	}

}
