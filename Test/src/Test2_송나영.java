class Product_sny {
	private String code;
	private String name;
	
	public Product_sny(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public void display() {
		System.out.print(code + "," + name);
	}
	
}

class Book_sny extends Product_sny{
//	private String code;
//	private String name;
	private int price;
	private String publisher;
	
	public Book_sny(String code, String name, int price, String publisher) {
		super(code,name);
		this.price = price;
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void display() {
		super.display();
		System.out.print("," + price + "," + publisher);
	}

	
}

class NoteBook_sny extends Product_sny{
//	private String code;
//	private String name;
	private String os;
	private String ram;
	
	public NoteBook_sny(String code, String name, String os, String ram) {
		super(code,name);
		this.os = os;
		this.ram = ram;
	}
	public String getOs() {
		return os;
	}
	public String getRam() {
		return ram;
	}
	public void display() {
		super.display();
		System.out.println("," + os + "," + ram);
	}
	
	
}
public class Test2_송나영 {
	public static void main(String[] args) {
		
		Product_sny p = new Product_sny("P1","제품명");
		System.out.println(p.getCode() + "," + p.getName());
		
		Book_sny b = new Book_sny("B2","재미있는자바",3000,"쌍용출판사");
		System.out.println(b.getCode() + "," + b.getName()+ "," + b.getPrice() + "," + b.getPublisher());
		
		NoteBook_sny n = new NoteBook_sny("N3","갤럭시북","window10","16GB");
		System.out.println(n.getCode() + "," + n.getName()+ "," + n.getOs() + "," + n.getRam());
		
		//배열
		System.out.println();
		System.out.println("배열");
		Product_sny[] arr = { 
								new Product_sny("P1","제품명"),
								new Book_sny("B2","재미있는자바",3000,"쌍용출판사"),
								new NoteBook_sny("N3","갤럭시북","window10","16GB")
								};
		
		for(int i=0;i<arr.length;i++) {
			arr[i].display();
			System.out.println();
		}
		
		
		
//		new Product_sny("P1","제품명");
//		new Book_sny("B2","재미있는자바",3000,"쌍용출판사");
//		new NoteBook_sny("N3","갤럭시북","window10","16GB");
//		
//		객체를 배열로 만들기
//		반복해서 출력
		
	}
	
}
