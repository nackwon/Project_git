package kr.co.jimmy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.jimmy.VO.MemberVO;
import kr.co.jimmy.connection.ConnectionManager;

public class MemberDAO {
	
	//ȸ������
	public void registMember(MemberVO vo) {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO member VALUES(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getNickname());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			int count = pstmt.executeUpdate();
			
			if(count > 0)
				System.out.println("���� �Ϸ�");
			else
				System.out.println("���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
