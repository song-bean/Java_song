import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JoinDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspid";
	String password = "jsppw";
	Connection conn = null;
	int cnt = -1;

	public JoinDao() {
		System.out.println("JoinDao 생성자");

		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
	}

	public void getConnection() {
		//2.계정에 접속
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		}
	}//getConnection()

	public ArrayList<JoinBean> join() {
		
		ArrayList<JoinBean> jlist = new ArrayList<JoinBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select code, pname, cname, cprice, caddr from producer natural join consumer";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				JoinBean jb = new JoinBean();
				jb.setCode(rs.getString("code"));
				jb.setPname(rs.getString("pname"));
				jb.setCname(rs.getString("cname"));
				jb.setCprice(rs.getInt("cprice"));
				jb.setCaddr(rs.getString("caddr"));
				
				jlist.add(jb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return jlist;
	}
	
	
}
