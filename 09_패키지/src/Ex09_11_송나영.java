import java.util.Scanner;

public class Ex09_11_송나영 {
	public static void main(String[] args) {

		int i,j,temp, count = 0;

		//로또 번호 맞추기(1~45)
		int[] lotto = new int[6]; //난수 들어가는 공간

		//앞 방에 있는 같은 수가 나오면 안됨
		for(i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45) + 1;	
			if(i>0) {
				for(j=0;j<i;j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						continue;
					}
				}
			}
		}
		
		//내가 입력하는 로또 번호
		int[] my = new int[6]; // 입력
		Scanner sc = new Scanner(System.in);

		for(i=0;i<my.length;i++) {
			System.out.print("숫자" + (i+1) + ":");
			my[i] = sc.nextInt();
			if(1 > my[i] || my[i] > 45) {
				System.out.println("1~45사이의 수를 입력하세요.");
				i--;
				continue;
			}
			if(i>0) {
				for(j=0;j<i;j++) {
					if(my[i] == my[j]) {
						System.out.println("중복됨");
						i--;
						//continue;
						break;
					}
				}
			}
		}//for
		
		//로또 번호 순서대로 정렬
		for(i=0;i<lotto.length-1;i++) {
			for(j=i+1;j<lotto.length;j++) {
				if(lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		for(i=0;i<my.length-1;i++) {
			for(j=i+1;j<my.length;j++) {
				if(my[i] > my[j]) {
					temp = my[i];
					my[i] = my[j];
					my[j] = temp;
				}
			}
		}
		
		//로또 번호 출력
		System.out.println("컴퓨터가 발생시킨 로또 번호");
		for(i=0;i<lotto.length;i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("내가 선택한 로또 번호");
		for(i=0;i<lotto.length;i++) {
			System.out.print(my[i] + " ");
		}
		System.out.println();
		
		for(i=0;i<my.length;i++) {
			for(j=0;j<lotto.length;j++) {
				if(my[i] == lotto[j]) {
					count++;
				}
			}
		}
		
		System.out.println();
		System.out.println("맞은 개수:" + count);

		if(count == 6) {
			System.out.println("1등입니다.");
		}
		else if(count == 5) {
			System.out.println("2등입니다.");
		}
		else if(count == 4) {
			System.out.println("3등입니다.");
		}
		else {
			System.out.println("꽝!");
		}
		
		switch(count) {
		case 6 : System.out.println("1등입니다.");
				break;
		case 5 : System.out.println("2등입니다.");
				break;
		case 4 : System.out.println("3등입니다.");
				break;
		default : System.out.println("꽝!");
		}
		
	}
}

//맞은 개수
//6개 1
//5개 2
//4개 3
//나머지는 꽝