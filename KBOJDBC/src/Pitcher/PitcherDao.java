package Pitcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PitcherDao {
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	Connection conn = null;
	int cnt = -1;


	public PitcherDao() {
		System.out.println("PitcherDao 생성자");

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

	public ArrayList<PitcherBean> getAllPitcher(String club) {
		ArrayList<PitcherBean> lists = new ArrayList<PitcherBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from pitcher where club = ? order by pno";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, club);
			rs = ps.executeQuery();

			while(rs.next()) {
				PitcherBean pb = new PitcherBean();
				pb.setPno(rs.getInt("pno"));
				pb.setClub(rs.getString("club"));
				pb.setPplayer(rs.getString("pplayer"));
				pb.setPnum(rs.getInt("pnum"));
				pb.setPname(rs.getString("pname"));
				pb.setEra(rs.getDouble("era"));
				pb.setStrike(rs.getInt("strikeout"));

				lists.add(pb);
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

	public int insertPitcher(PitcherBean pb) {
		cnt = -1;
		PreparedStatement ps = null;

		String sql = "insert into pitcher values((select max(pno) from pitcher where club = ?)+1,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getClub());
			ps.setString(2, pb.getClub());
			ps.setString(3, pb.getPplayer());
			ps.setInt(4, pb.getPnum());
			ps.setString(5, pb.getPname());
			ps.setDouble(6, pb.getEra());
			ps.setInt(7, pb.getStrike());

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

	public int updatePitcher(PitcherBean pb) {
		cnt = -1;
		PreparedStatement ps = null;

		String sql = "update pitcher set pnum = ?, pname = ?, era = ?, strikeout = ? where pno = ? and club = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pb.getPnum());
			ps.setString(2, pb.getPname());
			ps.setDouble(3, pb.getEra());
			ps.setInt(4, pb.getStrike());
			ps.setInt(5, pb.getPno());
			ps.setString(6, pb.getClub());

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

	public int deletePitcher(int pno, String club) {
		cnt = -1;
		PreparedStatement ps = null;

		String sql = "delete pitcher where pno = ? and club = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
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
