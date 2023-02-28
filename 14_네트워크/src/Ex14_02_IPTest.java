import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ex14_02_IPTest {
	public static void main(String[] args) {
		
		String url;
		System.out.print("웹사이트 주소 입력:");
		InetAddress[] address;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			url = br.readLine();
			
			//netAddress class:  IP Address를 표현한 class
			address = InetAddress.getAllByName(url); //UnknownHostException이라는 예외가 발생 --> IOException
			for(int i=0;i<address.length;i++) {
				System.out.println(address[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
