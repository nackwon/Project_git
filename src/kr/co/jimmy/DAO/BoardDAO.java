package kr.co.jimmy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import kr.co.jimmy.VO.BoardVO;
import kr.co.jimmy.VO.WriterVO;
import kr.co.jimmy.connection.ConnectionManager;

public class BoardDAO {
	
	//게시판 등록
	public void inserBoard(BoardVO vo, WriterVO w_vo) {
		BoardDAO dao = new BoardDAO();
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO board VALUES (board_cnt.nextval,?,?,?,sysdate,sysdate,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter().getId());
			pstmt.setString(2, vo.getWriter().getName());
			pstmt.setString(3, vo.getTitle());
			pstmt.setInt(4, vo.getReadCount());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				System.out.println("삽입 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.ConnectionClose(con, pstmt, rs);
		}
	}
}
