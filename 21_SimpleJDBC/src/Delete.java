import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jspid";
		String pw = "jsppw";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("접속 성공");
			
			int delNum = 10;
			String sql = "delete from test where num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, delNum);
			
			int cnt = ps.executeUpdate();
			System.out.println("cnt:" + cnt);
			
			conn.close();
			System.out.println("접속 끊기 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("계정에 접속/끊기 실패");
			}

		
	}
}
