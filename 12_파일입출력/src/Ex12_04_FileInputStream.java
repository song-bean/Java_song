import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex12_04_FileInputStream {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		File f = new File("/Users/songnayoung/sun/abc.txt"); // 작업대상을 객체로 만듦
		
		//FileInputStream fis = new FileInputStream(f);
		FileInputStream fis = new FileInputStream("/Users/songnayoung/sun/abc2.txt");
		//new FileNotFoundException() --> 없는 파일을 불러오면 생기는 에러
		
		while(true) { 
			int i = fis.read(); //IOException
			if(i == -1) {
				break;
			}
			
			System.out.println(i + ":" + ((char)i));
		}//while
		
		
		fis.close(); // 다리 끊어내기
		
		
	}
}

//stream은 자료의 입출력을 도와주는 연결다리
//13: CR: 개행(Carriage Return), 줄바꿈
//10: LF: 복귀(Line Feed)
//EOF:End Of File(-1)
//문자 스트림(한글) --> 입력용 스트림 : Reader 출력용 스트림 : Writer
//바이트 스트림 --> 입력용 스트림 : InputStream 출력용 스트림 : OutputStream