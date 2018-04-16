package kr.co.jimmy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.jimmy.VO.MemberVO;
import kr.co.jimmy.connection.ConnectionManager;

public class MemberDAO {

	// 회원가입
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
				System.out.println("삽입 완료");
			else
				System.out.println("삽입 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, null);
		}
	}

	// 회원가입 시 아이디 체크 및 이메일 체크
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
				flag = true; // 가입된 사람 있다.
				return flag;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, null);
		}
		return flag; // 가입된 사람 없다.
	}

	// 이메일 체크
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

	// 회원 정보 수정
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
				System.out.println("업데이트가 완료 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, null);
		}
	}

	// 전체 회원 조회
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
	
	//한 사람 조회
	public MemberVO searchMember(String userid) {
		MemberVO vo = null;
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member WHERE nickname LIKE ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			vo = new MemberVO();
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
