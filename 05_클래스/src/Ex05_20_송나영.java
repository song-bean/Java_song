class School {
	private String name;
	private int grade, min;
	
	public School() {
		name = "초등학교";
		grade = 6;
		min = 8;
	}
	// setter 메서드
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setMin(int min) {
		this.min = min;
	}
	// getter 메서드
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public int getMin() {
		return min;
	}
	
	public School(String name, int grade, int min) {
		this.name = name;
		this.grade = grade;
		this.min = min;
	}
	
	public void display() {
		System.out.println(name +": "+ grade + "학년까지 있고, 보통 " + min + "살에 입학한다." );
	}
}

public class Ex05_20_송나영 {
	public static void main(String[] args) {
		
		School ele = new School();
		ele.display();
		
		School mid = new School();
		mid.setName("중학교");
		mid.setGrade(3);
		mid.setMin(14);
		System.out.print(mid.getName() + ": ");
		System.out.print(mid.getGrade() + "학년까지 있고, ");
		System.out.println("보통 " + mid.getMin() + "살에 입학한다.");
		
		School high = new School("고등학교",3,17);
		high.display();
		
		
		System.out.println("===============객체배열===============");
		School[] sch = new School[3];
		sch[0] = new School();
		
		sch[1] = new School();
		sch[1].setName("중학교");
		sch[1].setGrade(3);
		sch[1].setMin(14);
		
		sch[2] = new School("고등학교",3,17);
		
		int i;
		for(i=0;i<sch.length;i++) {
			sch[i].display();
		}
		System.out.println("===============확장for문===============");
		for(School s : sch) {
			s.display();
		}
		
		
	}

}


//클래스 새로 만들기 (멤버변수 최소 3개)
//객체 세 개 (생성자 통한 주입 - 객체(), setter통한 주입, 객체(1,2.2,false))
//전체를 출력하는 메서드(1번 객체, 3번 객체)
//2번 객체는 getter 통해서 출력
//객체 배열 추가 