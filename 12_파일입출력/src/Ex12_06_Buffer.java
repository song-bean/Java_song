import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12_06_Buffer {
	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("data.txt"); 
			bos = new BufferedOutputStream(fos,5); 
			
			
			bos.flush(); 
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}

//Buffer : 스트림으로부터의 입/출력 속도를 향상 시키기 위한 메모리의 임시 저장소
//입출력 효율을 높이기 위해 버퍼를 사용하는 보조스트림(2차스트림)
//FileOutputStream는 1차스트림
//0의 아스키코드: 48