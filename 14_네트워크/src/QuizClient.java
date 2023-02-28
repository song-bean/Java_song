import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader user = null;
		
		try {
			socket = new Socket("localhost",8888);

		} catch (UnknownHostException e) {
			System.err.println("localhost에 접근할 수 없습니다.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("입출력 오류");
			System.exit(1);
		}
		
		out = new PrintWriter(socket.getOutputStream(),true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		user = new BufferedReader(new InputStreamReader(System.in));
		
		String fromServer, fromUser = null;
		while((fromServer = in.readLine()) != null) {
			System.out.println("서버:" + fromServer);
			if(fromServer.equals("QUIT")) {
				break;
			}
			
			fromUser = user.readLine(); // y or n, java.net, y or n
			if(fromUser != null) {
				System.out.println("클라이언트:" + fromUser);
				out.println(fromUser); // y, java.net, y
			}
			
		}//while
		
		out.close();
		in.close();
		user.close();
		socket.close();

	}
}
