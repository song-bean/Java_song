import java.util.Scanner;

public class Ex04_08_송나영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int studentNum, i, j, max, min, sum, temp;
		int[] scores = null; // 참조 변수(관리자)
		
		while(true) {
			
			System.out.println("======================================");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("======================================");
			System.out.print("선택>");
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				System.out.print("학생수>");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
			}
			else if(selectNo == 2) {
				if(scores == null) {
					System.out.println("1.학생 수 먼저 입력하세요.");
					continue; // for: 증감식, while or do~while: 조건식 으로 넘어감 
				}
				for(i=0;i<scores.length;i++) {
					System.out.print("scores[" + i + "]>" );
					scores[i] = sc.nextInt();
				}
				
			}
			else if(selectNo == 3) {
				if(scores == null) {
					System.out.println("1.학생 수 먼저 입력하세요.");
					continue; 
				}
				for(i=0;i<scores.length;i++) {
					System.out.println("scores[" + i + "]" + ":" + scores[i]);
				}
				
			}
			else if(selectNo == 4) {
				if(scores == null) {
					System.out.println("1.학생 수 먼저 입력하세요.");
					continue; 
				}
				max = scores[0];
				min = scores[0];
				for(i=1;i<scores.length;i++) {
					if(max<scores[i]) {
						max = scores[i];
					}
					if(min>scores[i]) {
						min = scores[i];
					}
				}
				sum = 0;
				for(i=0;i<scores.length;i++) {
					sum += scores[i];
				}
				temp = 0;
				for(i=0;i<scores.length-1;i++) {
					for(j=i+1;j<scores.length;j++) {
						if(scores[i]>scores[j]) {
							temp = scores[i];
							scores[i] = scores[j];
							scores[j] = temp;
						}
					}
				}
				System.out.println("최고점수: " + max);
				System.out.println("최하점수: " + min);
				System.out.println("평균: " + sum/scores.length);
				System.out.println();
				System.out.println("정렬한 결과");
				for(i=0;i<scores.length;i++) {
					System.out.print(scores[i] + " ");
				}
				System.out.println();
					
			}
			else if(selectNo == 5) {
				break;
			}
			else {
				System.out.println("1~5만 입력하세요.");
			}
			
		}//while
		System.out.println("프로그램을 종료합니다.");
		
		
		
		sc.close();
		
		

	}

}


