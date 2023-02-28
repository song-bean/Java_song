import java.util.Scanner;

public class Ex03_03_송나영 {
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in); 
			
			System.out.print("이름 입력 =>");
			String name = sc.next();
		
			System.out.print("국어 점수 =>");
			int kor = sc.nextInt();
		
			System.out.print("영어 점수 =>");
			int eng = sc.nextInt();
		
			System.out.print("수학 점수 =>");
			int math = sc.nextInt();
		
			System.out.println("---------------------------");
			System.out.println("이름\t국어\t영어\t수학");
			System.out.println("---------------------------");
			System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math);
			
			System.out.println("---------------------------");
			
			int sum = kor + eng + math;
			System.out.println("총점: " + sum);
			
			//double avg = sum/3.0;
			double avg = (double)sum/3;
			System.out.printf("평균: %.2f\n", avg);
			
			
			System.out.println("---------------------------");
			
			if(90 <= avg && avg <= 100) {
				System.out.println("학점 = A");
			}
			else if(80 <= avg && avg < 90) {
				System.out.println("학점 = B");
			}
			else if(70 <= avg && avg < 80) {
				System.out.println("학점 = C");
			}
			else if(60 <= avg && avg < 70) {
				System.out.println("학점 = D");
			}
			else if(0 <= avg && avg < 60) {
				System.out.println("학점 = F");
			}
			
			
			int avg2 = (int)avg;
					
			switch(avg2 / 10) {
			
			case 10 : System.out.println("학점2 = A");
						break;
			case 9 : System.out.println("학점2 = A");
						break;
			case 8 : System.out.println("학점2 = B");
						break;
			case 7 : System.out.println("학점2 = C");
						break;
			case 6 : System.out.println("학점2 = D");
						break;			
			default : System.out.println("학점2 = F");
			}
			
			
			sc.close();

	}
}
