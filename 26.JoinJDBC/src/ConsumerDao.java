import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ConsumerDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspid";
	String password = "jsppw";
	Connection conn = null;
	int cnt = -1;

	public ConsumerDao() {
		System.out.println("ConsumerDao 생성자");

		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		}
	}

	public ArrayList<ConsumerBean> getAllConsumer() {
		ArrayList<ConsumerBean> clist = new ArrayList<ConsumerBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from consumer order by code";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				ConsumerBean cb = new ConsumerBean();

				cb.setCode(rs.getString("code"));
				cb.setCname(rs.getString("cname"));
				cb.setCprice(rs.getInt("cprice"));
				cb.setCaddr(rs.getString("caddr"));

				clist.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		return clist;
	}
	
	public int insertConsumer(ConsumerBean cb) {
		cnt =  -1;
		getConnection();
		PreparedStatement ps = null;

		String sql = "insert into consumer values(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cb.getCode());
			ps.setString(2, cb.getCname());
			ps.setInt(3, cb.getCprice());
			ps.setString(4, cb.getCaddr());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("부모키가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	public int deleteConsumer(String code) {
		cnt = -1;
		getConnection();
		PreparedStatement ps = null;

		String sql = "delete consumer where code = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
		
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	public int updateConsumer(String scode, String wcode) {
		cnt = -1;
		getConnection();
		PreparedStatement ps = null;
		
		String sql = "update consumer set code = ? where code = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, scode);
			ps.setString(2, wcode);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("부모키가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

}
