import java.util.ArrayList;
import java.util.Scanner;

public class Ex10_02_ArrayList {
	public static void main(String[] args) {
		
		int[] a = {1,2,3};
		int[]b = new int[5]; // 배열은 필요할 때마다 공간을 늘려줘야 함
		
		
		ArrayList<String> s1 = new ArrayList<String>(); // 객체 만들 때 요소들의 타입 확정 짓기
		int size = s1.size();
		System.out.println("size:" + size);
		
		s1.add("태연"); // 요소(element) , 0번 쨰
		s1.add("수영");
		s1.add("유리");
		s1.add("수영"); // 중복 허용
		
		size = s1.size();
		System.out.println("s1 size:" + size);
		
		s1.add(1,"써니"); // 중간에 넣고 싶으면 넣고 싶은 위치, 문자열
		
		System.out.println(s1.toString()); // [태연, 수영, 유리, 수영]의 형태로 출력되도록 오버라이딩 되어있음
		//[ , , , ] (요소)String의 toString()이 호출되어 리턴 되어서 사이 사이에 출력됨
		//System.out.println(s1); 
		
		String g = s1.get(0);
		System.out.println("g:" + g);
		
		ArrayList<String> add = new ArrayList<String>();
		add.add("웬디");
		add.add("슬기");
		
		s1.addAll(add); // 
		System.out.println(s1.toString());
		size = s1.size();
		System.out.println("s1 size:" + size);
		
		//s1.remove(1);
		//s1.remove("써니");
		//s1.remove("수영"); // 두 수영 중 하나만 지워짐
		ArrayList<String> delete = new ArrayList<String>();
		delete.add("수영");
		delete.add("유리");
		s1.removeAll(delete); // 이 과정을 해야 다 지울 수 있음
		System.out.println(s1.toString());
		
		s1.add("웬디");
		System.out.println(s1.toString());
		
		int index1 = s1.indexOf("웬디"); // 처음에 만난 웬디의 위치, 없는 것의 위치를 찾으라고 하면 -1 
		int index2 = s1.lastIndexOf("웬디"); // 마지막에 만난 웬디의 위치
		System.out.println(index1 + "," + index2);
		if(index1 == -1) {
			System.out.println("웬디가 없습니다.");
		}
		
		boolean result = s1.contains("슬기"); // 포함하고 있으면 true, 없으면 false
		System.out.println("result:" + result);
		if(result == false) {
			System.out.println("슬기가 없습니다.");
		}
		
		System.out.println(s1);
		
		s1.set(2, "윤아"); // 두 번째 자리를 윤아로 바꿔줌
		System.out.println(s1);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름:");
		String name = sc.next();
		
		if(s1.indexOf(name) != -1) {
			System.out.println("가입한 회원입니다.");
		}
		else {
			System.out.println("가입하지 않은 회원입니다.");			
		}
		System.out.println("----------------------------");
		
		int i;
		boolean flag = false;
		for(i=0;i<s1.size();i++) {
			if(s1.get(i).equals(name)) {
				System.out.println("가입한 회원입니다.");
				flag = true;
				break;
			}
		}
		if(flag == false) {
			System.out.println("가입하지 않은 회원입니다.");
		}
		
		System.out.println("----------------------------");
		
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		s2.add(100);
		s2.add(new Integer(200));
		s2.add(300);
		
		System.out.println("s2 size:" + s2.size());
		System.out.println(s2.toString());
		//[ , , ] (요소)Integer의 toString()이 호출되어 리턴 되어서 사이 사이에 출력됨
		
		Integer g2 = s2.get(0);
		System.out.println("g2:" + g2);
		
		
	}

}

//컬렉션은 동적으로 메모리를 확장할 수 있음 (배열과 큰 차이점)
//컬렉션 안에 List과 Set이 존재 --> 둘 다 인터페이스여서 상속받은 다른 클래스 사용
//List는 순서가 있고, 데이터의 중복을 허용 --> ArrayList가 가장 많이 쓰임 
//Set는 순서가 없고, 중복 허용X

//length : 배열의 길이 (방의 개수)
//length(): 문자열의 길이
// size : X
// size(): 컬렉션안의 요소의 개수


