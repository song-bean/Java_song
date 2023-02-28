import java.util.HashMap;
import java.util.Scanner;

public class Ex10_11_HashMap {
	public static void main(String[] args) {
		
		HashMap dic = new HashMap<String,String>();
		
		dic.put("pencil","연필");
		dic.put("sky","하늘");
		dic.put("elephant","코끼리");
		dic.put("apple","사과");
		dic.put("eraser","지우개");
		
		System.out.println(dic);
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("찾는 단어는?(q입력시 종료) ");
			String word = sc.next();
			word = word.toLowerCase();
			
			if(word.equals("q")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			if(dic.get(word) == null) {
				System.out.println("없는 단어입니다.");
			}
			else {
				System.out.println("뜻 : " + dic.get(word));
			}
			
		}
		
		
		sc.close();
	}
}
