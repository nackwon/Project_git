package kr.co.jimmy.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.jimmy.DAO.LoginDAO;
import kr.co.jimmy.command.Command;

public class LoginHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		
		String url = "";
		LoginDAO dao = new LoginDAO();

		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");

		if (nickname == null || password == null) {
			request.setAttribute("result", "");
		}
		
		int result = dao.login(nickname, password);
		
		if (result == 1) {
			HttpSession session = request.getSession(); // 세션 생성
			session.setAttribute("nickname", nickname);
		} else if (result == -1) {
			request.setAttribute("result", "아이디가 없습니다.");
		} else if (result == 2) {
			request.setAttribute("result", "비밀번호가 다릅니다.");
		} else if (result == 0) {
			request.setAttribute("result", "데이터베이스 오류 입니다.");
		}

		url = "./main/main.jsp";

		return url;
	}
}
