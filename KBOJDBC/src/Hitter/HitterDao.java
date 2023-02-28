package Hitter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HitterDao {
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	Connection conn = null;
	int cnt = -1;

	public HitterDao() {
		System.out.println("HitterDao 생성자");

		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		}
	}// 생성자 

	public ArrayList<HitterBean> getAllHitter(String club) {
		ArrayList<HitterBean> lists = new ArrayList<HitterBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from hitter where club = ? order by hno";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, club);
			rs = ps.executeQuery();

			while(rs.next()) {
				HitterBean hb = new HitterBean();
				hb.setHno(rs.getInt("hno"));
				hb.setClub(rs.getString("club"));
				hb.setHplayer(rs.getString("hplayer"));
				hb.setHnum(rs.getInt("hnum"));
				hb.setHname(rs.getString("hname"));
				hb.setPosition(rs.getString("position"));
				hb.setBa(rs.getDouble("ba"));
				hb.setHit(rs.getInt("hit"));

				lists.add(hb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lists;	
	}

	public int insertHitter(HitterBean hb) {
		cnt = -1;
		PreparedStatement ps = null;

		String sql = "insert into hitter values ((select max(hno) from hitter where club = ?)+1,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hb.getClub());
			ps.setString(2, hb.getClub());
			ps.setString(3, hb.getHplayer());
			ps.setInt(4, hb.getHnum());
			ps.setString(5, hb.getHname());
			ps.setString(6, hb.getPosition());
			ps.setDouble(7, hb.getBa());
			ps.setInt(8, hb.getHit());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public int updateHitter(HitterBean hb) {
		cnt = -1;
		PreparedStatement ps = null;

		String sql = "update hitter set hnum = ?, hname = ?, position = ?, ba = ?, hit = ? where hno = ? and club = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,hb.getHnum());
			ps.setString(2, hb.getHname());
			ps.setString(3, hb.getPosition());
			ps.setDouble(4, hb.getBa());
			ps.setInt(5, hb.getHit());
			ps.setInt(6, hb.getHno());
			ps.setString(7, hb.getClub());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public int deleteHitter(int hno, String club) {
		cnt = -1;
		PreparedStatement ps = null;

		String sql = "delete hitter where hno = ? and club = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hno);
			ps.setString(2, club);

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public void exit() {
		if(conn != null)
			try {
				conn.close();
				System.out.println("접속 끊기");
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}



}
