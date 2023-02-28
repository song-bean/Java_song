import java.util.Scanner;

public class Ex03_03_풀이 {
	
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
		double avg = (double)sum/3; // double avg = sum/3.0
		System.out.println("총점:" + sum);
		System.out.printf("평균:%.2f\n", avg);
		
	//else if 없는 if문 
		if(avg >= 90) {
			System.out.println("A학점");
		}
		if (avg >= 80 && avg < 90) {
			System.out.println("B학점");
		}
		if (avg >= 70 && avg < 80) {
			System.out.println("C학점");
		}
		if (avg >= 60 && avg < 70) {
			System.out.println("D학점");
		}
		if (avg < 60) {
			System.out.println("F학점");
		}
		
		System.out.println("---------------------------");

	//else if 있는 if문 	
		if(avg >= 90) {
			System.out.println("A학점");
		}
		else if (avg >= 80) { // else if이기 때문에 && avg < 90를 안적어도 됨 
			System.out.println("B학점");
		}
		else if (avg >= 70) {
			System.out.println("C학점");
		}
		else if (avg >= 60) {
			System.out.println("D학점");
		}
		else { // 위 조건이 모두 참이 아닐 때 실행 
			System.out.println("F학점");
		}
		
		System.out.println("---------------------------");
		
		//double --> int로 바꾸는 소수점은 다 버림
		switch((int)avg/10) {
		//case 10:System.out.println("A학점");
		//		break;
		case 10: //아래 케이스와 실행 결과가 같으면 굳이 안써도 됨. break가 없기 때문에 어차피 다음걸 실행함 
		case 9:System.out.println("A학점");
				break;
		case 8:System.out.println("B학점");
				break;
		case 7:System.out.println("C학점");
				break;
		case 6:System.out.println("D학점");
				break;
		default : System.out.println("F학점");
		
		}
		
		
		
		sc.close();
		
	}
	
}
