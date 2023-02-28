import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
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
			
			int upNum = 10;
			String upName = "태연";
			String upAddr = "광주";
			int conNum = 8; //조건에 사용할 숫자
			//3.sql문 분석
			//String sql = "update test set num=7, name='윤아', addr = '목포' where num=3";
			//String sql = "update test set num =" + upNum + "," + "name = '" + upName + "' ,addr = '" + upAddr + "' where num = " + conNum;
			String sql = "update test set num=?, name=?, addr=? where num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, upNum);
			ps.setString(2, upName);
			ps.setString(3, upAddr);
			ps.setInt(4, conNum);
			
			
			//4.sql문 실행
			int cnt = ps.executeUpdate();
			//성공적으로 update된 개수를 리턴
			//0개면 insert 실패 
			
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
