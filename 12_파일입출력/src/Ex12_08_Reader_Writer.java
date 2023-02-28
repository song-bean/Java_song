import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex12_08_Reader_Writer {
	public static void main(String[] args) {

		//FileOutputStream --> FileNotFoundException: 경로를 지정했을 때 폴더가 없는 경우 이 예외가 발생함
		FileWriter fw = null;
		FileReader fr = null ;

		try {
			//Writer.txt와 스트림 형성(쓰기위한 용도)
			fw = new FileWriter("write.txt"); // IOException --> 경로가 없을 때 발생
			fw.write("재미있는 자바수업!");
			//fw.close(); // 닫고나면 아무것도 못씀, 닫아야 파일에 기록이 됨
			fw.flush();// 닫기 싫으면 flush라도 써야 내보내짐
			//fw.write("하하하");

			fr = new FileReader("write.txt"); // FileNotFoundException < IOException이어서 굳이 안써도 됨, 쓸거면 IOException보다 위에 써야 함 
			int i;
			while (	(i = fr.read()) != -1	) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}



	}
}

//Reader class, Writer class는 추상 클래스이다.  
//First in, First out(FIFO구조) 