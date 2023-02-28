
public class Ex05_10_재귀호출 {

	public static void main(String[] args) {
		
		show(3);
	}
	
	static void show(int cnt) { // 노트 그림 참고 
		System.out.println("Hi~" + cnt);
		if(cnt == 1)
			return;
		show(--cnt); 
		// cnt--는 불가 --> 일단 넣고 돌아올 때 빼자 but, 돌아올 수 없음 --> 계속 3
	}
	
}
