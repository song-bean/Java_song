import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDao { //데이터 베이스 작업

	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	Connection conn = null;
	int cnt = -1;

	public PersonDao() {
		System.out.println("PersonDao 생성자");

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

	public ArrayList<PersonBean> getAllPerson(){
		// 2.계정에 접속
		getConnection();
		ArrayList<PersonBean> lists = new ArrayList<PersonBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 3.sql문 분석
			String sql = "select * from person order by num";
			ps = conn.prepareStatement(sql);
			System.out.println("ps : " + ps);

			//4.sql문 실행
			rs = ps.executeQuery();
			System.out.println("rs : " + rs);

			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				//String birth = rs.getString("birth"); // 이렇게 쓰면 시간까지 다 나옴 
				String birth =String.valueOf(rs.getDate("birth"));
				//System.out.println(num+"/"+name+"/"+age+"/"+gender+"/"+birth);

				//console창 출력은 main에서 해보겠다
				PersonBean pb = new PersonBean();
				pb.setNum(num);
				pb.setName(name);
				pb.setAge(age);
				pb.setGender(gender);
				pb.setBirth(birth);

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

	}//getAllPerson


	public ArrayList<PersonBean> getPersonByGender(String gender) {
		// 2.계정에 접속
		getConnection();
		ArrayList<PersonBean> lists = new ArrayList<PersonBean>();

		// 3.sql문 분석				
		//String sql = "select * from person where gender = " + gender;
		String sql = "select * from person where gender = ? order by num";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gender);

			//4.sql문 실행
			rs =  ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender2 = rs.getString("gender");
				//String birth = rs.getString("birth");
				String birth =String.valueOf(rs.getDate("birth"));

				PersonBean pb = new PersonBean();
				pb.setAge(age);
				pb.setBirth(birth);
				pb.setGender(gender2);
				pb.setName(name);
				pb.setNum(num);

				lists.add(pb);
			}//while

			//5. 접속 끊기
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lists;			
	}//getPersonByGender


	public int insertPerson(PersonBean pb) {
		System.out.println("PersonDao insertPerson");
		//입력한 것이 잘 들어갔나 확인
		//		System.out.println(pb.getNum());
		//		System.out.println(pb.getName());
		//		System.out.println(pb.getAge());
		//		System.out.println(pb.getGender());
		//		System.out.println(pb.getBirth());

		// 2.계정에 접속
		getConnection();
		PreparedStatement ps = null;

		// 3.sql문 분석	
		try {
			String sql = "insert into person values(perseq.nextval,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getAge());
			ps.setString(3, pb.getGender());
			ps.setString(4, pb.getBirth());

			cnt = ps.executeUpdate();
			//			if(cnt > 0) {
			//				System.out.println("insert 성공");
			//			}
			//			else {
			//				System.out.println("insert 실패");
			//			}


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

	}//insertPerson

	public int updatePerson(PersonBean pb) {

		System.out.println("PersonDao updatePerson");

		// 2.계정에 접속
		getConnection();
		PreparedStatement ps =  null;

		// 3.sql문 분석	
		try {
			String sql = "update person set name = ?, age = ?, gender = ?, birth = ? where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getAge());
			ps.setString(3, pb.getGender());
			ps.setString(4, pb.getBirth());
			ps.setInt(5, pb.getNum());

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

	}//updatePerson

	public int deletePerson(int num) {
		System.out.println("PersonDao deletePerson");

		getConnection();
		PreparedStatement ps = null;

		try {
			String sql = "delete person where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);

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

}
