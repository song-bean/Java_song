import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex14_03_Server {
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.out.println("5555번 포트 번호는 사용할 수 없습니다.");
			System.exit(1);
		}
		
		Socket clientSocket = null;
		
		try {
			System.out.println("Server ready..");
			clientSocket = serverSocket.accept();
			// 접속한 클라이언트 정보를 담음
		} catch (IOException e) {
			System.out.println("accept 실패");
			System.exit(1);
		}
		
		//내보내기위한 다리
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
		
		//읽어들이기위한 다리
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine = in.readLine();
		System.out.println("클라이언트가 보내온 데이터: " + inputLine);
		
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
		
		
	}
}
