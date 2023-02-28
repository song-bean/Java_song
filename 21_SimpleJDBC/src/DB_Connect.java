import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
	public static void main(String[] args) {
//0단계 - 프로젝트마다 해줘야 함
//ojdbc11.jar의 위치 
////Users/songnayoung/Oracle/jdbc/ojdbc11-full/ojdbc11.jar
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "jspid";
			String pw = "jsppw";
			
			// 2.계정에 접속 
			Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB와의 연결 성공");
			
			// 여러가지 DB 작업 
			
			// 5.접속 끊기 
			conn.close();
			System.out.println("DB와의 연결 끊기 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB와의 연결/끊기 실패");
		}
		
	}
}
