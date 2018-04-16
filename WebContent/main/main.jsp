<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
	text-align: center;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String nickname = (String) session.getAttribute("nickname");
		String result = (String) request.getAttribute("result");
		if(result == null){
			result ="";
		}
		if (nickname == null) {
	%>
	<div class="container">
		<div>
			<form action="./login" method="post">
				<div>
					<input type="text" name="nickname" id="nickname" placeholder="Enter the Email">
				</div>
				<br>
				<div>
					<input type="password" name="password" id="password" placeholder="Enter the Password">
				</div>
				<br>
				<div>
					<input type="submit" value="Login" onclick="loginCheck(<%=result%>)">
				</div>
			</form>
			 <span><%=result %></span>
		</div>
		<div>
			<br> 아직 회원이 아니신가요? <a href="./git?cmd=join">회원가입</a>
		</div>
	</div>
	<%
		} else {
	%>
	<div>
		환영 합니다.
		<%=nickname%>님
	</div>
	<div>
		<a href="./login?cmd=logout">로그아웃</a>
	</div>
	<%
		}
	%>
	<br>
	<br>
	<div>
		<a href="./git?cmd=admin">관리자 페이지</a>
	</div>
</body>
</html>