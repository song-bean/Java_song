import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jspid";
		String pw = "jsppw";
		
		try {
			//1.드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			//2.계정에 접속
			//jspid에 접속한 정보가 conn에 들어가 있음
			Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("접속 성공");
			
			//3.SQL문 분석
			String sql = "select * from test";
			//sql 변수에 들어가 있는 문장을 분석 --> 그 정보가 PreparedStatement ps에 들어가 있음
			PreparedStatement ps = conn.prepareStatement(sql); // 분석 
			
			//4.SQL문 실행 
			ResultSet rs = ps.executeQuery(); //sql을 실행한 결과가 들어가 있음
/*
        	      NUM   NAME      ADDR
			---------- --------- ----------
         			1 kim       서울
         			2 hong      부산 
 */			
			while(rs.next()) { // rs가 여러 줄이므로 반복해야함, rs.next()는 rs가 관리하는 데이터가 있냐
				int num = rs.getInt("num"); // 괄호 안은 칼럼명
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num + "/" + name + "/" + addr);
				
			}//while
			
			//5.접속 끊기
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
