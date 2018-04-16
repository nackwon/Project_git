package kr.co.jimmy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jimmy.DAO.LoginDAO;
import kr.co.jimmy.VO.MemberVO;

public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=euc-kr");

		String cmd = request.getParameter("cmd");
		cmd = cmd == null ? "" : cmd;
		
		String url = "./git";

		if ("logout".equals(cmd)) {
			url = "./main/logout.jsp";
		}

		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");

		if (nickname == null || password == null || nickname.equals("") || password.equals("")) {
			request.setAttribute("result", "");
		} else {
			LoginDAO dao = new LoginDAO();
			int result = dao.login(nickname, password);
			System.out.println(result);

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
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
