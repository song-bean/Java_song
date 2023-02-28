import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Ex12_12_wordCount {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("lyrics.txt");
		BufferedReader br = new BufferedReader(fr);


		String str;
		int lineCount = 0;
		String lyrics = "";
		while ((str = br.readLine()) != null) { // 엔터 만나면 그 앞까지만 한줄로 나타냄(엔터 빼고)
			//System.out.println(str);
			lyrics += str + " ";
			lineCount++;
		}
		System.out.println("lineCount:" + lineCount);
		System.out.println(lyrics);


		String[] arr = lyrics.split(" "); // 공백을 기준으로 단어로 나누기
		System.out.println("전체 단어 개수:" + arr.length);
		
		int i;
		
		//대소문자 구분 없이 같은 단어끼리 묶기위해 대문자 --> 소문자로 만드는 과정
//		for(i=0;i<arr.length;i++) {
//			arr[i] = arr[i].toLowerCase();
//		}
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				//map.put(arr[i], map.get(arr[i]+1));
				Integer j = map.get(arr[i]);
				map.put(arr[i], j+1);
			}
			else {
				map.put(arr[i], 1);
			}
// 	강사님이 한 방법			
//			if(map.get(arr[i] == null)) {
//				map.put(arr[i], 1);
//				map.put(arr[i], j+1);
//			}
//			else {
//				Integer j = map.get(arr[i]);
//			}
		}//for
		
		//중복된 것 빼고 나머지 제거
//		for(i=0;i<arr.length;i++) {
//			Integer j = map.get(arr[i]);
//			if(j == 1) {
//				map.remove(arr[i]);
//			}
//		}
//		System.out.println(map);
		
		Set<String> words = map.keySet(); 
		for(String word : words) { // set은 순서가 없음 --> 확장for문
			System.out.println(word + ":" + map.get(word));
		}
		
		System.out.println("중복 제거한 단어 개수:" + words.size());
		System.out.println("중복 제거한 단어 개수:" + map.size());
		

		fr.close();
		br.close();

	}
}
