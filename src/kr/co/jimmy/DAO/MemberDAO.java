package kr.co.jimmy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.jimmy.VO.MemberVO;
import kr.co.jimmy.connection.ConnectionManager;

public class MemberDAO {

	// ȸ������
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

			if (count > 0)
				System.out.println("���� �Ϸ�");
			else
				System.out.println("���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, null);
		}
	}

	// ȸ������ �� ���̵� üũ �� �̸��� üũ
	public boolean idCheckMember(String userid) {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "SELECT nickname FROM member WHERE nickname LIKE ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = true; // ���Ե� ��� �ִ�.
				return flag;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, null);
		}
		return flag; // ���Ե� ��� ����.
	}

	// �̸��� üũ
	public boolean emailCheckMember(String email) {
		boolean flag = false;

		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT email FROM member email LIKE ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = true;
				return flag;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, rs);
		}
		return flag;
	}

	// ȸ�� ���� ����
	public void updateMember(MemberVO vo, String userid) {

		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE member SET password=? WHERE nickname LIKE ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, userid);
			int count = pstmt.executeUpdate();

			if (count > 0)
				System.out.println("������Ʈ�� �Ϸ� �Ǿ����ϴ�.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, null);
		}
	}

	// ��ü ȸ�� ��ȸ
	public ArrayList<MemberVO> searchAll() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			MemberVO vo = null;
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setNickname(rs.getString(1));
				vo.setEmail(rs.getString(2));
				vo.setPassword(rs.getString(3));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, rs);
		}
		return list;
	}
	
	//�� ��� ��ȸ
	public MemberVO searchMember(String userid) {
		MemberVO vo = null;
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member LIKE ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNickname(rs.getString(1));
				vo.setEmail(rs.getString(2));
				vo.setPassword(rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, rs);
		}
		return vo;
	}
}
