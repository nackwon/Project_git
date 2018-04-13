<%@page import="kr.co.jimmy.DAO.MemberDAO"%>
<%@page import="kr.co.jimmy.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

	<%
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		String a_nickname = request.getParameter("a_nickname");
		vo = dao.searchMember(a_nickname);
		if (vo == null) {
			out.print("false");
		} else {
			out.print(vo);
		}
	%>
