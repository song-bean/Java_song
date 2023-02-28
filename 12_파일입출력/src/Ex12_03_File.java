import java.io.File;
import java.io.IOException;

public class Ex12_03_File {
	public static void main(String[] args) {
		
		File f1 = new File("A"); //	경로를 입력 안하면 12_파일입출력이 기본 경로가 됨
		//File f1 = new File("/Users/songnayoung/Java_song/12_파일입출력/A");
		File f2 = new File("B");
		File f3 = new File("C");
		File f4 = new File(f1,"aa.txt"); //"/Users/songnayoung/Java_song/12_파일입출력/A/aa.txt"
		
		boolean result = f1.exists();
		System.out.println("result:" + result);
		
		if(f1.exists()) {
			f1.renameTo(f2);
		}
		else {
			f1.mkdir(); // 폴더를 만들어라
			System.out.println("폴더 생성함");
			
			try {
				f4.createNewFile();
				System.out.println("파일 생성함");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}//else
		
		if(f3.exists()) {
			f3.delete(); // 폴더안에 뭐가 있으면 안지워짐 --> 못지우면 false 리턴
		}
		
		
	}
}
