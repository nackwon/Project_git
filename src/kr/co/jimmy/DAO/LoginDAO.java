package kr.co.jimmy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.jimmy.connection.ConnectionManager;

public class LoginDAO {
	
	//로그인 체크 
	public int login(String userid, String password) {
		int index = 0;
		
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT password FROM member WHERE nickname LIKE ?";
			
		if(con == null) {
			System.out.println("연결 노노");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(password.equals(rs.getString("password"))) {
					index = 1;
					return index; // 로그인 성공
				} else {
					index = 2;
					return index; // 비밀번호 틀림
				}
			} else {
				index = -1;
				return index; // 아이디 없음
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return index;
	}
}
