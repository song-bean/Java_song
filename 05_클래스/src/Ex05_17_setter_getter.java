class Book2 {
	private String title;
	private String author;
	private int price;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		if(price > 0)
			this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
}

public class Ex05_17_setter_getter {
	public static void main(String[] args) {
		
		Book2 bk = new Book2();
		bk.setTitle("토지");
		bk.setAuthor("박경리");
		bk.setPrice(5000);

		System.out.println(bk.getTitle());
		System.out.println(bk.getAuthor());
		System.out.println(bk.getPrice());
		
		
	}

}
