package kr.co.jimmy.handler;

import javax.servlet.http.HttpServletRequest;

import kr.co.jimmy.DAO.MemberDAO;
import kr.co.jimmy.VO.MemberVO;
import kr.co.jimmy.command.Command;

public class JoinHandler implements Command {

	// 회원 가입시 DAO연결 해주는 역할을 하게 된다.
	@Override
	public String process(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();

		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String url = "";

		if (nickname == null || email == null || password == null) {
			nickname = "";
			email = "";
			password = "";
		}
		
		MemberVO vo = new MemberVO();
		vo.setNickname(nickname);
		vo.setPassword(password);
		vo.setEmail(email);
		dao.registMember(vo);

		url = "./main/main.jsp";

		return url;
	}
}
