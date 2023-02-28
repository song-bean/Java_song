import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {

	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	Connection conn = null;
	int cnt = -1;

	public BookDao() {
		System.out.println("BookDao 생성자");

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
	
	public ArrayList<BookBean> getAllBook() {
		
		ArrayList<BookBean> lists = new ArrayList<BookBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from Book order by no";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));
				
				BookBean bb = new BookBean();
				bb.setNo(no);
				bb.setTitle(title);
				bb.setAuthor(author);
				bb.setPublisher(publisher);
				bb.setPrice(price);
				bb.setPub_day(pub_day);
				
				lists.add(bb);
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

	public int InsertBook(BookBean bb) {
		cnt = -1;
		getConnection();
		PreparedStatement ps = null;
		
		String sql = "insert into Book values(bseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setString(3, bb.getPublisher());
			ps.setInt(4, bb.getPrice());
			ps.setString(5, bb.getPub_day());
			
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

	public int UpdateBook(BookBean bb) {
		
		cnt = -1;
		getConnection();
		PreparedStatement ps = null;
		
		String sql = "update Book set title = ?, author = ?, publisher = ?, price = ?, pub_day = ? where no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setString(3, bb.getPublisher());
			ps.setInt(4, bb.getPrice());
			ps.setString(5, bb.getPub_day());
			ps.setInt(6, bb.getNo());
			
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

	public int DeleteBook(int no) {
		cnt = -1;
		getConnection();
		PreparedStatement ps = null;
		
		String sql = "delete from Book where no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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

	public ArrayList<BookBean> getBookBySearch(String column, String searchWord) {
		ArrayList<BookBean> lists = new ArrayList<BookBean>();
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//String sql = "select * from Book where " + column + "like '%" + searchWord + "%'";
		String sql = "select * from Book where " + column + " like ? order by no";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchWord + "%");
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));
				
				BookBean bb = new BookBean();
				bb.setNo(no);
				bb.setTitle(title);
				bb.setAuthor(author);
				bb.setPublisher(publisher);
				bb.setPrice(price);
				bb.setPub_day(pub_day);
				
				lists.add(bb);
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
