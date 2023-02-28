import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12_05_FileInputStream {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("from.txt"); // 읽어드릴 파일은 미리 만들어 놓아야 함 --> 아니면 에러
			fos = new FileOutputStream("to.txt",true); // 저절로 만들어짐
			//false: 파일이 없으면 파일 자동 생성, 있으면 새로 생성
			//true: 파일이 없으면 파일 자동 생성, 있으면 있는 파일에 추가가 됨
			
			while(true) {
				int i = fis.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
				fos.write(i);
				//fos.write(42); // *
				
			}//while
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}



}
