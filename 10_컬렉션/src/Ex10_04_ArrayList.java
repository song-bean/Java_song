import java.util.ArrayList;
import java.util.Scanner;

class Music {
	private String title;
	private String singer;
	private int price;
	
	public Music(String title, String singer, int price) {
		super();
		this.title = title;
		this.singer = singer;
		this.price = price;
	}
	
	
	public String getTitle() {
		return title;
	}
	public String getSinger() {
		return singer;
	}
	public int getPrice() {
		return price;
	}
	
	
	public String toString() {
		return title+"/"+singer+"/"+price;
	}
	
	
}//Music

public class Ex10_04_ArrayList {
	public static void main(String[] args) {
		
		Music[] arr = {
						new Music("ditto","newjeans",11000),
						new Music("일어나","김광석",5000),
						new Music("Goodbye","소녀시대",8000),
						};
		
		ArrayList<Music> list = new ArrayList<Music>();
		int i;
		for(i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		
		String retry;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("제목:");
			String title = sc.next();

			System.out.print("가수명:");
			String singer = sc.next();

			System.out.print("가격:");
			int price = sc.nextInt();

			Music input = new Music(title,singer,price);
			list.add(input);
			
			System.out.print("계속?");
			retry = sc.next();
			if(retry.equals("n")) {
				break;
			}
			
		}
		
		System.out.println(list.toString()); // 오버라이딩 --> 안하면 주소 출력됨
		System.out.println();
		
		for(i=0;i<list.size();i++) {
			Music m = list.get(i);
			//System.out.println(m.toString());
			System.out.println(m.getTitle());
			System.out.println(m.getSinger());
			System.out.println(m.getPrice());
			System.out.println();
		}
		
		System.out.println("확장 for문");
		//확장 for문
		for(Music m : list) {
			//System.out.println(m.toString());
			System.out.println(m.getTitle());
			System.out.println(m.getSinger());
			System.out.println(m.getPrice());
			System.out.println();
		}
		
	}

}
