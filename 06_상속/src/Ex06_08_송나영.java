class Sports3 {
	private String spname; 
	private int inwon; 
	
	public Sports3(String name, int inwon) {
		this.spname = name;
		this.inwon = inwon;
	}
	public void display() {
		System.out.println("name:" + spname);
		System.out.println("inwon:" + inwon);
	}
	
}

class Volleyball extends Sports3 {
	private int set;
	private int score;
	
	
	public Volleyball(String spname, int inwon, int set, int score) {
		super(spname, inwon);
		this.set = set;
		this.score = score;
	}
	public void display() {
		super.display();
		System.out.println("set:" + set);
		System.out.println("score:" + score);
		System.out.println("5세트의 경우 15점");
	}
	
}

class Athlete extends Volleyball {
	private String athname;
	private int number;
	private String position;
	
	public Athlete (String spname, int inwon, int set, int score, String athname, int number, String position) {
		super(spname,inwon,set,score);
		this.athname = athname;
		this.number = number;
		this.position = position;
	}
	public void display() {
		super.display();
		System.out.println("선수 이름:" + athname);
		System.out.println("등번호:" + number);
		System.out.println("포지션:" + position);
	}	
	
	
}

public class Ex06_08_송나영 {
	public static void main(String[] args) {
		
		Sports3 s = new Sports3("배구",6);
		s.display();
		System.out.println("------------------------------");
		
		Volleyball v = new Volleyball("배구", 6, 5, 25);
		v.display();
		System.out.println("------------------------------");
		
		Athlete a = new Athlete("배구", 6, 5, 25, "김희진", 4, "Right");
		a.display();
		
	}
}

/*
할아버지 -> 아버지 -> 아들 형식으로 의미 있게
멤버 변수는 최소 2개 이상 (모든 멤버 변수는 private) 
super 사용
*/