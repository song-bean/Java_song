import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) { // 이미 사용중인 포트를 사용하려고하면 생기는 에러
			System.out.println("8888번 포트 번호는 사용할 수 없습니다.");
			System.exit(1);
		}

		Socket clientSocket = null;

		try {
			System.out.println("Server ready..");
			clientSocket = serverSocket.accept(); // 접속한 클라이언트 정보를 담음
			System.out.println("접속 성공");
		} catch (IOException e) {
			System.out.println("accept 실패");
			System.exit(1);
		}

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		QuizBank bank = new QuizBank();
		
		// 퀴즈를 시작합니다.(y/n)가 들어감
		String outputLine = bank.process(null); //bank의 process메서드를 호출함
		
		out.println(outputLine);
		
		String inputLine;
		while((inputLine = in.readLine()) != null) {
			//inputLine = y, java.net, y
			outputLine = bank.process(inputLine); // 네트워크 처리 패키지는? , 정답입니다. 계속하시겠습니까?(y/n)
			out.println(outputLine);
			
			if(outputLine.equals("QUIT")) {
				break;
			}
			
		}
		
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
		
		
		
		
	}
}
