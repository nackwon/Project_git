<%@page import="kr.co.jimmy.VO.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function searchMember(){
		var nickname = document.getElementById("nickname").value;
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(this.status == 200 && this.readyState == 4){
				var result = this.responseText;
				
				if(result == "false"){
					alert("해당하는 회원이 없습니다.");
				} else if(result == "true"){
					
				}
			}
		}
		data = "a_nickname="+nickname;
		xhr.open("POST", "./main/searchCheck.jsp",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(data);
		return false;
	}
</script>
</head>
<body>
	<form action="./git?cmd=searchMember" method="post">
		<input type="text" id="nickname" name="nickname" placeholder="아이디 입력 ">
		<input type="submit" value="찾기" onclick="return searchMember()"> 
	</form>
	
	<%
		ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
		
		StringBuffer sb = new StringBuffer("<table><tr><td>아이디</td><td>이메일</td><td>비밀번호</td></tr>");
		
		if(list != null){
			for(MemberVO vo : list){
			sb.append("<tr><td>"+vo.getNickname()+"</td>");
			sb.append("<td>"+vo.getEmail()+"</td>");
			sb.append("<td>"+vo.getPassword()+"</td></tr>");
			}
			sb.append("</table>");
			out.print(sb.toString());
		}else{
			out.print("등록된 회원이 없습니다.");
		}
	%>
</body>
</html>