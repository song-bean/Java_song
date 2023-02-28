import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex12_09_InputStreamReader {
	public static void main(String[] args) {
		
		System.out.print("입력하세요 : ");
		
//		InputStream is = System.in;// 키보드, InputStream in이어서 바이트입력만 가능(한글X)
//		
//		InputStreamReader isr = new InputStreamReader(is); // 바이트 입력 --> 문자 입력으로 바꿔주는 클래스
//		
//		BufferedReader br = new BufferedReader(isr); // 버퍼 사이즈를 안 정하면 8192사이즈로 고정, 버퍼의 도움을 받아 빨리 읽어 들임

		// 위 세 줄은 하나의 실행을 함 --> 한 줄로 정리 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			String str = br.readLine(); // 한 줄 읽어들이는 메서드
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

//InputStreamReader : Byte Input Stream --> Character Input Stream으로 바꾸고 싶을 때 사용
//OutputStreamWriter : Byte Output Stream --> Character Output Stream
//바이트 --> 문자