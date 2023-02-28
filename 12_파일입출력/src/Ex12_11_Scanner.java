import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex12_11_Scanner {
	public static void main(String[] args) throws FileNotFoundException {
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("file.txt")).useDelimiter(",");
		//sc = sc.useDelimiter(","); // ,만나면 구분자로 생각해라
		
		int num, sum =0, count=0;
		while(sc.hasNextInt()) {
			num = sc.nextInt();
			sum += num;
			count++;
			System.out.println(num);
		}
		System.out.println("sum:" + sum);
		System.out.println("avg:" + (double)sum/count);
		
		
		
	}
}
