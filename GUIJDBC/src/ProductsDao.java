import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDao {
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	Connection conn = null;
	int cnt = -1;

	public ProductsDao() {
		System.out.println("ProductDao 생성자");

		//1.드라이버 로드
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

//	public void getConnection() {
//		try {
//			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("접속 성공");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("접속 실패");
//		}
//	}//getConnection()
	
	public ArrayList<ProductsBean> getAllProducts() {
		ArrayList<ProductsBean> lists =  new ArrayList<ProductsBean>();
		//getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from products order by id";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs.next());
			
			while(rs.next()) {
				ProductsBean pb = new ProductsBean();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setStock(rs.getInt("stock"));
				pb.setPrice(rs.getInt("price"));
				pb.setCategory(rs.getString("category"));
				pb.setInputdate(String.valueOf(rs.getDate("inputdate")));
				
				lists.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn != null) 
//					conn.close();
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
	
	public int insertProducts(ProductsBean pb) {
		cnt = -1;
		//getConnection();
		PreparedStatement ps = null;
		
		String sql = "insert into products values(prdseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2,pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn != null) 
//					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	public int updateProducts(ProductsBean pb) {
		cnt = -1;
		//getConnection();
		PreparedStatement ps = null;
		
		String sql = "update products set name = ?, stock = ?, price = ?, category = ?, inputdate = ? where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2,pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			ps.setInt(6, pb.getId());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn != null) 
//					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	public int deleteProducts(int id) {
		cnt = -1;
		//getConnection();
		PreparedStatement ps = null;
		
		String sql = "delete products where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn != null) 
//					conn.close();
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
