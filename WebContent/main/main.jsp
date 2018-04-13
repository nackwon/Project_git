<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.container{
		text-align: center;
	}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String nickname = (String)session.getAttribute("nickname");
	if(nickname == null){
%>
	<div class="container">
		<div>
			<form action="./login" method="post">
				<div>
					<input type="text" name="nickname" id="nickname" placeholder="Enter the Email" >
				</div><br>
				<div>
					<input type="password" name="password" id="password" placeholder="Enter the Password">
				</div><br>
				<span id="loginCheck"></span>
				<div>
					<input type="submit" value="Login" onclick="id()">
				</div>
			</form>
		</div>
		<div><br>
			아직 회원이 아니신가요? <a href="./git?cmd=join">회원가입</a>
		</div>
	</div>
	<%
	} else{%>
	<div>환영 합니다. <%=nickname %>님</div>
	<div><a href="./main/logout.jsp ">로그아웃</a></div>
	<%
	
	}	%>
	<br><br>
	<div>
		<a href="./git?cmd=admin">관리자 페이지</a>
	</div>
</body>
</html>