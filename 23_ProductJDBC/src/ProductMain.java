import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {
	
	Scanner sc = new Scanner(System.in);
	static ProductDao dao = new ProductDao();
	
	public ProductMain() {
		System.out.println("ProductMain 생성자");
		init();
	}
	
	private void init() {
		while(true) {
			System.out.println("\n=== 메뉴 선택하기 === ");
			System.out.println("1.모든 상품 조회");
			System.out.println("2.특정 상품 조회(아이디)");
			System.out.println("3.특정 상품 조회(카테고리)");
			System.out.println("4.상품 추가");
			System.out.println("5.상품 수정");
			System.out.println("6.상품 삭제");
			System.out.println("7.프로그램 종료");
			System.out.print(">>번호 입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {

			case 1: 
						System.out.println("1.모든 상품 조회");
						getAllProduct();
					break;
			case 2: 
						System.out.println("2.특정 상품 조회(아이디)");
						getProductById();
					break;	
			case 3: 
						System.out.println("3.특정 상품 조회(카테고리)");
						getProductByCategory();
					break;
			case 4: 
						System.out.println("4.상품 추가");
						InsertProduct();
					break;		
			case 5: 
						System.out.println("5.상품 수정");
						UpdateProduct();
					break;
			case 6: 
						System.out.println("6.상품 삭제");
						DeleteProduct();
					break;
			case 7: 
						System.out.println("프로그램 종료합니다.");
						System.exit(0);
					break;
			default : System.out.println("1~7만 입력 가능");
			
			}//switch
		}//while
	}//init
	
	public void showProducts(ArrayList<ProductBean> lists) {
		
		for(ProductBean pb : lists) {
			System.out.println(pb.getId() + "/" + pb.getName() + "/" + pb.getStock() + "/" + pb.getPrice() + "/" + pb.getCategory() + "/" + pb.getInputdate());
		}
	}
	
	public void getAllProduct() {
		ArrayList<ProductBean> lists = dao.getAllProducts();
		showProducts(lists);
	}
	
	public void getProductById() {
		System.out.print("찾는 아이디 입력 : ");
		int id = sc.nextInt();
		ArrayList<ProductBean> lists = dao.getProductById(id);
		
		showProducts(lists);
		
	}//getProductById
	
	public void getProductByCategory() {
		System.out.print("찾는 카테고리 입력 : ");
		String category = sc.next();
		ArrayList<ProductBean> lists = dao.getProductByCategory(category.toUpperCase());
		
		showProducts(lists);
		
	}//getProductByCate()
	
	public void InsertProduct() {
		
		System.out.println("아이디는 시퀀스로 자동 입력됩니다.");
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("재고 입력 : ");
		int stock = sc.nextInt();
		
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		
		System.out.print("카테고리 입력 : ");
		String category = sc.next();
		
		System.out.print("날짜 입력 : ");
		String inputday = sc.next();
		
		ProductBean pb = new ProductBean();
		pb.setName(name);
		pb.setStock(stock);
		pb.setPrice(price);
		pb.setCategory(category);
		pb.setInputdate(inputday);
		
		int cnt = dao.InsertProduct(pb);
		if(cnt > 0) {
			System.out.println("insert 성공");
		}
		else {
			System.out.println("insert 실패");
		}
		
		
	}//InsertProduct()
	
	public void UpdateProduct() {
		
		System.out.print("바꿀 아이디 입력 : ");
		int id = sc.nextInt();
		
		System.out.print("바꿀 이름 입력 : ");
		String name = sc.next();
		
		System.out.print("바꿀 재고 입력 : ");
		int stock = sc.nextInt();
		
		System.out.print("바꿀 가격 입력 : ");
		int price = sc.nextInt();
		
		System.out.print("바꿀 카테고리 입력 : ");
		String category = sc.next();
		
		System.out.print("바꿀 날짜 입력 : ");
		String inputday = sc.next();
		
		ProductBean pb = new ProductBean();
		pb.setId(id);
		pb.setName(name);
		pb.setStock(stock);
		pb.setPrice(price);
		pb.setCategory(category);
		pb.setInputdate(inputday);
		
		int cnt = dao.UpdateProduct(pb);
		if(cnt > 0) {
			System.out.println("Update 성공");
		}
		else if(cnt == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else {
			System.out.println("Update 실패");
		}
				
		
	}//UpdateProduct
	
	public void DeleteProduct() {
		System.out.print("삭제할 아이디 입력 : ");
		int id = sc.nextInt();
		
		int cnt = dao.DeleteProduct(id);
		if(cnt > 0) {
			System.out.println("delete 성공");
		}
		else if(cnt == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else {
			System.out.println("delete 실패");
		}
		
	}//DeleteProduct()
	
	public static void main(String[] args) {
		
		new ProductMain();
		
	}
}
