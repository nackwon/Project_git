package kr.co.jimmy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jimmy.DAO.MemberDAO;
import kr.co.jimmy.VO.MemberVO;

public class MemberController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		String url = "./main/main.jsp";
		cmd = cmd == null?"":cmd;
		
		if("join".equals(cmd)) {
			url = "./main/join.jsp";
		} else if("registMember".equals(cmd)) {
			MemberDAO dao = new MemberDAO();
			
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			MemberVO vo = new MemberVO();
			System.out.println(nickname+password+email);
			vo.setNickname(nickname);
			vo.setPassword(password);
			vo.setEmail(email);
			dao.registMember(vo);
			
			url = "./main/main.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
