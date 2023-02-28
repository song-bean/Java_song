import java.util.Scanner; // ctrl + shift + 알파벳 o 

public class Ex01_08_입력문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// 예제 문제 
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("이름 입력 =>");
		String name = sc.next();
	
		System.out.print("국어 점수 =>");
		int kor = sc.nextInt();
	
		System.out.print("영어 점수 =>");
		int eng = sc.nextInt();
	
		System.out.print("수학 점수 =>");
		int math = sc.nextInt();
	
		System.out.println("--------------------------------");
		System.out.println("이름\t국어\t영어\t수학");
		System.out.println("--------------------------------");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math);
		
		int sum = kor + eng + math;
		System.out.println("총점:" + sum);
		
		//double avg = sum/3.0;
		double avg = (double)sum/3;
		System.out.printf("평균: %.2f\n", avg);
		
		sc.close();
		
	}

}


/* 출력 
 
이름 입력 =>아이유
국어 점수 =>77
영어 점수 =>88
수학 점수 =>98
--------------------------------
   이름	국어	영어	수학
--------------------------------
   아이유	77	88	98
총점:263
평균: 87.67

*/
