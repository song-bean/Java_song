import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumsDao {

	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	Connection conn = null;
	int cnt = -1;

	public AlbumsDao() {
		System.out.println("AlbumsDao 생성자");

		//1.드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
	}//생성자
	
	public void getConnection() {
		//2.계정에 접속
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("접속 실패");
		}
	}//getConnection()
	
	public ArrayList<AlbumsBean> getAllAlbums() {
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from albums order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String song = rs.getString("song");
				String singer = rs.getString("singer");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));
				
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(num);
				ab.setSong(song);
				ab.setSinger(singer);
				ab.setCompany(company);
				ab.setPrice(price);
				ab.setPub_day(pub_day);
				
				lists.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 접속 끊기
			try {
				if(conn != null) 
					conn.close();
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

	public ArrayList<AlbumsBean> getAlbumsBySearch(String column, String searchWord) {
		
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from albums where " + column + " like '%" + searchWord + "%' order by num" ;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(rs.getInt("num"));
				ab.setSong(rs.getString("song"));
				ab.setSinger(rs.getString("singer"));
				ab.setCompany(rs.getString("company"));
				ab.setPrice(rs.getInt("price"));
				ab.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				lists.add(ab);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) 
					conn.close();
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
	
	public int insertAlbums(AlbumsBean ab) {
		
		getConnection();
		PreparedStatement ps = null;
		cnt = -1;
		
		String sql = "insert into albums values(albumseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ab.getSong());
			ps.setString(2, ab.getSinger());
			ps.setString(3, ab.getCompany());
			ps.setInt(4, ab.getPrice());
			ps.setString(5, ab.getPub_day());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 접속 끊기
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

	public int updateAlbums(AlbumsBean ab) {
		
		//트랜잭션(transaction)
		getConnection();
		PreparedStatement ps = null;
		cnt = -1;
		
		String sql = "update albums set song = ?, singer = ?, company = ?, price = ?, pub_day = ? where num = ?";
		try {
			
			conn.setAutoCommit(false); // 자동 저장 되지 마라
			
			ps = conn.prepareCall(sql);
			ps.setString(1, ab.getSong());
			ps.setString(2, ab.getSinger());
			ps.setString(3, ab.getCompany());
			ps.setInt(4, ab.getPrice());
			ps.setString(5, ab.getPub_day());
			ps.setInt(6, ab.getNum());
			
			cnt = ps.executeUpdate(); // JDBC에서는 실행만 해도 자동 저장이 이루어짐
			conn.commit(); // 다 끝나면 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) 
					conn.close(); // 접속을 끊으면 commit이 됨
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public int deleteAlbums(int num) {
		
		getConnection();
		PreparedStatement ps = null;
		cnt = -1;
		
		String sql = "delete albums where num = ?";
		try {
			
			conn.setAutoCommit(false); // 자동 저장 되지 마라
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			conn.commit(); 
			
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

	public ArrayList<AlbumsBean> orderByAlbums(String column, String order) {
		
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from albums order by " + column + " " + order;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String song = rs.getString("song");
				String singer = rs.getString("singer");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));
				
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(num);
				ab.setSong(song);
				ab.setSinger(singer);
				ab.setCompany(company);
				ab.setPrice(price);
				ab.setPub_day(pub_day);
				
				lists.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 접속 끊기
			try {
				if(conn != null) 
					conn.close();
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

	public AlbumsBean groupByAlbums(String company) {
		
		AlbumsBean ab = null;
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//String sql = "select company, avg(price) from albums where company = ? group by company";
		String sql = "select company, avg(price) as 평균 from albums where company like ? group by company";
		try {
			ps = conn.prepareStatement(sql);
			//ps.setString(1, company);
			ps.setString(1, "%" + company + "%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ab = new AlbumsBean();
				ab.setCompany(rs.getString("company"));
				//ab.setPrice(rs.getInt("avg(price)"));
				ab.setPrice(rs.getInt("평균 "));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 접속 끊기
			try {
				if(conn != null) 
					conn.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return ab;
	}

	public ArrayList<AlbumsBean> priceAlbums(int start, int end) {
		
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//String sql = "select rank, num, song, singer, company, price, pub_day from(select rownum rank, num, song, singer, company, price, pub_day from albums order by price desc, singer) where rank between " + start + " and " + end;
		String sql = "select num, song, singer, company, price, pub_day, rank from(select num, song, singer, company, price, pub_day, rank() over(order by price desc, singer) as rank from albums) where rank between ? and ?";		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String song = rs.getString("song");
				String singer = rs.getString("singer");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));
				
				AlbumsBean ab = new AlbumsBean();
				ab.setNum(num);
				ab.setSong(song);
				ab.setSinger(singer);
				ab.setCompany(company);
				ab.setPrice(price);
				ab.setPub_day(pub_day);
				
				lists.add(ab);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 접속 끊기
			try {
				if(conn != null) 
					conn.close();
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

	
	
	

}
