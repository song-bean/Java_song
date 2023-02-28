import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ProducerDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspid";
	String password = "jsppw";
	Connection conn = null;
	int cnt = -1;

	public ProducerDao() {
		System.out.println("ProducerDao 생성자");

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


	public ArrayList<ProducerBean> getAllProducer() {
		ArrayList<ProducerBean> plist = new ArrayList<ProducerBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select*from producer order by code";
		try {
			ps = conn.prepareCall(sql);

			rs = ps.executeQuery();

			while(rs.next()) {
				ProducerBean pb = new ProducerBean();
				pb.setCode(rs.getString("code"));
				pb.setPname(rs.getString("pname"));
				pb.setPprice(rs.getInt("pprice"));

				plist.add(pb);
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

		return plist;
	}

	public int insertProducer(ProducerBean pb) {
		cnt =  -1;
		getConnection();
		PreparedStatement ps = null;

		String sql = "insert into producer values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getCode());
			ps.setString(2, pb.getPname());
			ps.setInt(3, pb.getPprice());
			
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

	public int deleteProducer(String code) {
		cnt = -1;
		getConnection();
		PreparedStatement ps = null;
		
		String sql = "delete producer where code = ?";
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

	public int updateProducer(String scode, String wcode) {
		cnt = -1;
		getConnection();
		PreparedStatement ps = null;
		
		String sql = "update producer set code = ? where code = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, scode);
			ps.setString(2, wcode);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("자식 레코드가 있습니다.");
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
