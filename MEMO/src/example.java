import java.util.Scanner;

public class example {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("피라미드 층 수 입력:");
		int num = sc.nextInt();
		
		int i,j,k;
		//피라미드
		for(i=0;i<num;i++) {

            for(k=1;k<num-i;k++) {
                System.out.print(" ");
            }
            for(j=0;j<i*2+1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
		
		System.out.println("----------------------------------------------");
		
		//역피라미드
		for(i=num; i>0; i--) {
            for(k=num-i;k>0; k--) {
                System.out.print(" ");
            }
            for(j=i*2-1;j>0;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
		
		
		sc.close();
    }
}
		
		
		
		
		