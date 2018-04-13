package kr.co.jimmy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.collections.SynchronizedStack;

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
		
		StringBuffer sb = new StringBuffer();
		PrintWriter out = response.getWriter();

		String url = "./main/main.jsp";

		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		LoginDAO dao = new LoginDAO();
		MemberVO vo = new MemberVO();
		int result = dao.login(nickname, password);
		System.out.println(result);
		
		if (result == 1) {
			HttpSession session = request.getSession(); // 세션 생성
			session.setAttribute("nickname", nickname);

		} else if (result == 2) {
			sb.append("<script>");
			sb.append("alert('비밀번호가 틀립니다.');");
			sb.append("history.back();");
			sb.append("</script>");
			out.print(sb.toString());

		} else if (result == -1) {
			sb.append("<script>");
			sb.append("alert('아이디가 다릅니다.');");
			sb.append("history.back();");
			sb.append("</script>");
			out.print(sb.toString());
		} else {
			sb.append("<script>");
			sb.append("alert('DB 오류 입니다.');");
			sb.append("history.back();");
			sb.append("</script>");
			out.print(sb.toString());
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
