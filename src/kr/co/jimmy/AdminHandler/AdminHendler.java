package kr.co.jimmy.AdminHandler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.co.jimmy.DAO.MemberDAO;
import kr.co.jimmy.VO.MemberVO;
import kr.co.jimmy.command.Command;

public class AdminHendler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		String url = "";
		String cmd = "";
	
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		list = dao.searchAll();
		request.setAttribute("list", list);
		
		url = "./main/admin.jsp";
		return url;
	}
}
