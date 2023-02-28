import java.io.IOException;
import java.net.ServerSocket;

//네트워크: 다른 장치로 데이터를 이동시킬 수 있는 컴퓨터들과 주변 장치들의 집합
public class Ex14_01_port {
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		
		for(int i=0;i<65535;i++) {
			
			try {
				ss = new ServerSocket(i);
				ss.close();
			} catch (IOException e) {
				System.out.println(i + "번 포트 번호는 이미 사용 중입니다.");
			}
			
		}
		
	}
}
