<%@page import="kr.co.jimmy.VO.MemberVO"%>
<%@page import="kr.co.jimmy.DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
	<%
		request.setCharacterEncoding("UTF-8");	
		String nickname = request.getParameter("nickname");
		MemberDAO dao = new MemberDAO();
		boolean flag = dao.idCheckMember(nickname);
		if(flag){
			out.print("false");
		} else{
			out.print("true");
		}
		
	%>
