import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jspid";
		String pw = "jsppw";
		
		try {
			//1.드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			//2.계정 접속 
			Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("접속 성공");
			
			//3.SQL문 분석
			int inputNum = 3;
			String inputName = "choi";
			String inputAddr = "제주";
			
			//String sql = "insert into test values(4,'park','경기')"; // 값을 직접 넣기  
			//String sql = "insert into test values(inputNum,'inputName','inputAddr')"; --> 틀린 방법
			//String sql = "insert into test values(" + inputNum + ", '" + inputName + "' , '" + inputAddr + "' )";
			String sql = "insert into test values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql); // 분석 --> 물음표가 있으면 값을 채우기
			
			//3.1 ?(위치홀더)에 값 채우기
			ps.setInt(1, inputNum); // 1:첫 번째 ? 자리 
			ps.setString(2, inputName); // 2:두 번째 ? 자리 
			ps.setString(3, inputAddr); // 3:세 번째 ? 자리 
			
			
			//4.SQL문 실행 
			int cnt = ps.executeUpdate();
			// 성공적으로 insert한 개수를 리턴 
			System.out.println("cnt:" + cnt);
			if(cnt > 0) {
				System.out.println("insert 성공");
			}
			else {
				System.out.println("insert 실패");
			}
			
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
