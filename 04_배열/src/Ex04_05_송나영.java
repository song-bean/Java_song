
public class Ex04_05_송나영 {

	public static void main(String[] args) {
		
		int i, j, sum = 0;
		int[][] score = {
							{80,92,72},
							{91,39,20},
							{60,37,10},
							{32,80,40},
							{50,100,90},
						};
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("==================================================");
		
		int [] totalSubject = new int[3];
		
		for(i=0;i<score.length;i++) {// 행, 천천히 
			System.out.print(" " + (i + 1) + "\t");
			for(j=0;j<score[i].length;j++) { // 열, 빨리 
				System.out.print(score[i][j] + "\t");
				sum += score[i][j];
				totalSubject[j] += score[i][j]; 
			}
			System.out.print(sum + "\t");
			System.out.print((float)sum/3);
			sum = 0;
			
			System.out.println();
		}
		
		
		System.out.println("==================================================");
		System.out.print("총점\t");
		for(i=0;i < totalSubject.length;i++) {
			System.out.print(totalSubject[i] + "\t");
		}
		
		
		sum = 0;
		
		//[0][0] + [1][0] + [2][0] + [3][0] + [4][0]
		
		
		
//		for(i=0;i<score[0].length;i++) {
//			for(j=0;j<score.length;j++) {
//				sum += score[j][i];
//			}
//			System.out.print(sum + "\t");
//			sum = 0;
//			
//		}

	}

}

/*
		번호 국어 영어 수학 총점 평균
		========================
		1
		2
		3
		4
		5
		========================
		총점:313 348 232
 */