import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	Connection conn = null;
	int cnt = -1;

	public ProductDao() {
		System.out.println("ProductDao 생성자");

		//1.드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");

			//2단계 여기서 해도 됨	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
	}// 생성자 

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
	
	public ArrayList<ProductBean> getAllProducts() {
		getConnection();
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3.sql문 분석
			String sql = "select * from products order by id";
			ps = conn.prepareStatement(sql);
			
			//4.sql문 실행
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//int id = rs.getInt("id");
				//String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				ProductBean pb = new ProductBean();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setStock(stock);
				pb.setPrice(price);
				pb.setCategory(category);
				pb.setInputdate(inputdate);

				lists.add(pb);
			}//while

		}catch(SQLException e) {
			System.out.println("SQLException 발생");
		}finally {
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
	}//getAllProduct
	
	public ArrayList<ProductBean> getProductById(int id) {
		
		getConnection();
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3.sql문 분석
			String sql = "select * from products where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			//4.sql문 실행
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id2 = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				ProductBean pb = new ProductBean();
				pb.setId(id2);
				pb.setName(name);
				pb.setStock(stock);
				pb.setPrice(price);
				pb.setCategory(category);
				pb.setInputdate(inputdate);

				lists.add(pb);
			}//while

		}catch(SQLException e) {
			System.out.println("SQLException 발생");
		}finally {
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
		
	}//getProductById
	
	public ArrayList<ProductBean> getProductByCategory(String category) {
		
		getConnection();
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductBean pb = null;
		
		try {
			// 3.sql문 분석
			String sql = "select * from products where category = ?";
			//String sql = "select * from products where category = upper(?)";
			//String sql = "select * from products where lower(category) = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			//4.sql문 실행
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category2 = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				pb = new ProductBean();
				pb.setId(id);
				pb.setName(name);
				pb.setStock(stock);
				pb.setPrice(price);
				pb.setCategory(category2);
				pb.setInputdate(inputdate);

				lists.add(pb);
			}//while

		}catch(SQLException e) {
			System.out.println("SQLException 발생");
		}finally {
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
	
	}//getProductByCategory
	
	public int InsertProduct(ProductBean pb) {
		
		getConnection();
		PreparedStatement ps = null;
		cnt = -1;
		
		try {
			String sql = "insert into products values(prdseq.nextval,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			
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
	}//InsertProduct
	
	public int UpdateProduct(ProductBean pb) {
		getConnection();
		PreparedStatement ps = null;
		cnt = -1;
		
		try {
			String sql = "update products set name = ?, stock = ?, price = ?, category = ?, inputdate = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			ps.setInt(6, pb.getId());
			
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
	}//UpdateProduct
	
	public int DeleteProduct(int id) { 
		
		getConnection();
		PreparedStatement ps = null;
		cnt = -1;
		
		try {
			String sql = "delete from products where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
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
	}//DeleteProduct
}	
