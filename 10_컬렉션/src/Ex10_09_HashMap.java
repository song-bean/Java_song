import java.util.HashMap;
import java.util.Set;

public class Ex10_09_HashMap {
	public static void main(String[] args) {
		
		HashMap map = new HashMap<String,Integer>(); // <key,value>
		
		System.out.println(map.size());
		map.put("아이유", 30); //add 말고 put
		map.put("정국", 40); 
		map.put("아이유", 20); //30 --> 20으로 value만 덮어쓰기가 됨, key 중복 안됨
		map.put("이무진", 20); //value 중복 가능
		System.out.println(map.size());
		System.out.println(map.toString()); //{정국=40, 이무진=20, 아이유=20}
		//map.get(1);
		Integer v = (Integer)map.get("이무진");
		//get("키")를 넣으면 value를 리턴, 없으면 null을 리턴 
		System.out.println("v:" + v);
		
		boolean result1 = map.containsKey("정국"); // 정국이라는 키가 있냐
		System.out.println("result1:" + result1);
		
		boolean result2 = map.containsValue(40); // 40이라는 값이 있냐
		System.out.println("result2:" + result2);
		
		Set<String> s = map.keySet(); // 순서X, 중복X
		System.out.println("s:" + s); //s:[정국, 이무진, 아이유]
		//Object[] s1 = s.toArray();
		int i;
		for(i=0;i<s.size();i++) {
			//System.out.println(s1[i] + ":" + map.get(s1[i]));
			System.out.println(map.get(s));
		}
		System.out.println();
		
		for(String key:s) {
			System.out.println(key + ":" + map.get(key));
		}
		
		//map.clear(); // 모두 다 지움 
		//map.remove("이무진"); // 일부만 지움, 있으면 지우고 없으면 말고, 없어도 에러는 안남
		Integer inte = (Integer) map.remove("이무진"); //성공하면 value, 없어서 삭제 실패하면 null
		System.out.println("inte:" + inte);
		if(inte == null) {
			System.out.println("삭제 실패");
		}
		else {
			System.out.println("삭제 성공");
		}
		System.out.println(map); //{}
		
		
		
		
	}
}

//Map
//key와 값이 쌍으로 이루어진 데이터의 집합
//순서X, 키는 중복X, 값은 중복 가능