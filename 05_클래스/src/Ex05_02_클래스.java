class Book {
	String title;
	String author;
	int price;
	static String publisher;
}
public class Ex05_02_클래스 {

	public static void main(String[] args) {
		
		Book bk1 = new Book();
		bk1.title = "토지";
		bk1.author = "박경리";
		bk1.price = 5000;
		Book.publisher = "쌍용";
		
		System.out.println(bk1.title);
		System.out.println(bk1.author);
		System.out.println(bk1.price);
		//System.out.println(bk1.publisher);
		System.out.println(Book.publisher);
		
		System.out.println("--------------------");
		
		Book bk2 = new Book();
		bk2.title = "새빨간 거짓말, 통계";
		bk2.author = "대럴 허프";
		bk2.price = 12600;
		
		System.out.println(bk2.title);
		System.out.println(bk2.author);
		System.out.println(bk2.price);
		//System.out.println(bk2.publisher);
		System.out.println(Book.publisher);
	}
}
