import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Movie {
	private String title;
	private int age;
	public Movie(String title, int age) {
		super();
		this.title = title;
		this.age = age;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return title + "/" + age;
	}
	
	
}//Movie

public class Ex10_10_HashMap {
	public static void main(String[] args) {
		
		Map<String,Movie> map = new HashMap<String,Movie>();
		
		Movie m1 = new Movie("아바타",12);
		Movie m2 = new Movie("압꾸정",15);
		Movie m3 = new Movie("공조",19);
		
		map.put("CGV", m1);
		map.put("롯데시네마", m2);
		map.put("서울극장", m3);
		
		//{서울극장=Movie@23fe1d71, CGV=Movie@28ac3dc3, 롯데시네마=Movie@32eebfca}
		//오버라이딩 해줘야 함 --> {서울극장=공조/19, CGV=아바타/12, 롯데시네마=압꾸정/15}
		System.out.println(map);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 영화관 입력:");
		String theater = sc.next();
		
		
//		Movie m = map.get(theater); // 키를 입력하면 값(Movie)이 나옴
//		System.out.println("m:" + m);
		if(map.get(theater) == null) {
			System.out.println("영화관 잘못 입력");
		}
		else {
			System.out.println(map.get(theater));
		}
		
		Movie m4 = new Movie("관상",12);
		map.replace("서울극장", m4);  //서울극장=공조/19 --> 서울극장=관상/12
		System.out.println(map);
		
		map.remove("CGV"); //map.remove(key)를 입력하면 삭제됨
		System.out.println(map);
		
	}

}
