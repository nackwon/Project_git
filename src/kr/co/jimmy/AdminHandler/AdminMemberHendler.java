package kr.co.jimmy.AdminHandler;

import javax.servlet.http.HttpServletRequest;

import kr.co.jimmy.DAO.MemberDAO;
import kr.co.jimmy.VO.MemberVO;
import kr.co.jimmy.command.Command;

public class AdminMemberHendler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		String url = "";
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		String nickname = request.getParameter("nickname");
		vo = dao.searchMember(nickname);
		request.setAttribute("vo", vo);

		url = "./main/admin.jsp";

		return url;
	}
	

}
