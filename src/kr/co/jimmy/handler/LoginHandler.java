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
			HttpSession session = request.getSession(); // ���� ����
			session.setAttribute("nickname", nickname);
		} else if (result == -1) {
			request.setAttribute("result", "���̵� �����ϴ�.");
		} else if (result == 2) {
			request.setAttribute("result", "��й�ȣ�� �ٸ��ϴ�.");
		} else if (result == 0) {
			request.setAttribute("result", "�����ͺ��̽� ���� �Դϴ�.");
		}

		url = "./main/main.jsp";

		return url;
	}
}
