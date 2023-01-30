package wellsome.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PW_FAIL = 0;
	public static final int ADMIN_LOGIN_NOT = -1;
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void getConnection() {
		String url ="jdbc:mysql://localhost:3306/sample?serverTimeZone=Asia/Seoul";
		String user = "testUser";
		String pw = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결성공!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			if(rs !=null) rs.close();
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 관리자 로그인 체크
	public int adminCheck(String id, String pw) {
		int n = 0;
		String dbPw;
		
		String sql = "SELECT pw "
					+ "FROM w_admin "
					+ "WHERE id=?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dbPw = rs.getString("pw");
				if(dbPw.equals(pw)) { // 비밀번호 일치
					n=AdminDAO.ADMIN_LOGIN_SUCCESS;
				}else { // 비밀번호 불일치
					n=AdminDAO.ADMIN_LOGIN_PW_FAIL;
				}
			}else { // 값이 없는경우
				n=AdminDAO.ADMIN_LOGIN_NOT;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
				
		return n;
	}
	
	// 관리자 정보 가져오기
	public AdminDTO getAdminInfo(String id) {
		AdminDTO dto = null;
		
		String sql = "SELECT * "
				   + "FROM w_admin "
				   + "WHERE id=?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new AdminDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}
}
