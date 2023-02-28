import java.util.Scanner;

public class Ex04_03_1차원 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		//국어,영어,수학 점수 정수로 입력 받아서 출력
		System.out.print("국어 점수 =>");
		int kor = sc.nextInt();
	
		System.out.print("영어 점수 =>");
		int eng = sc.nextInt();
		
		System.out.print("수학 점수 =>");
		int math = sc.nextInt();
		
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		*/
		
		int i;
		int[] score = new int[3];
		String[] subject ={"국어 점수: ", "영어 점수: ", "수학 점수: "}; 
		for(i=0;i<score.length;i++) {
			System.out.print(subject[i]);
			score[i] = sc.nextInt();
		}
		
		for(i=0;i<score.length;i++) {
			System.out.println(subject[i] + score[i]);
		}
		
		
		sc.close();

	}

}
