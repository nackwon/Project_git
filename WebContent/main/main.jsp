<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.container {
	text-align: center;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<!-- Navbar -->
	<!-- <div class="w3-top">
		<div class="w3-bar w3-theme-d2 w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a> <a href="#"
				class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i
				class="fa fa-home w3-margin-right"></i>Logo</a> <a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="News"><i class="fa fa-globe"></i></a> <a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="Account Settings"><i class="fa fa-user"></i></a> <a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="Messages"><i class="fa fa-envelope"></i></a>
			<div class="w3-dropdown-hover w3-hide-small">
				<button class="w3-button w3-padding-large" title="Notifications">
					<i class="fa fa-bell"></i><span
						class="w3-badge w3-right w3-small w3-green">3</span>
				</button>
				<div class="w3-dropdown-content w3-card-4 w3-bar-block"
					style="width: 300px">
					<a href="#" class="w3-bar-item w3-button">One new friend
						request</a> <a href="#" class="w3-bar-item w3-button">John Doe
						posted on your wall</a> <a href="#" class="w3-bar-item w3-button">Jane
						likes your post</a>
				</div>
			</div>
			<a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white"
				title="My Account"> <img src="/w3images/avatar2.png"
				class="w3-circle" style="height: 23px; width: 23px" alt="Avatar">
			</a>
		</div>
	</div> -->
	<!-- Navbar END -->
	
	<%
		request.setCharacterEncoding("UTF-8");
		String nickname = (String) session.getAttribute("nickname");
		String result = (String) request.getAttribute("result");

		if (nickname == null) {
			result = "";
	%>
	<div class="container">
		<div>
			<form action="./login.do" method="post">
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
			<span><%=result%></span>
		</div>
		<div>
			<br> 아직 회원이 아니신가요? <a href="./join.do">회원가입</a>
		</div>
	</div>
	<%
		} else {
	%>
	<div>
		환영 합니다.
		<%=nickname = nickname ==null?"":nickname%>님
	</div>
	<div>
		<a href="./logout.do">로그아웃</a>
	</div>
	<%
		}
	%>
	<br>
	<br>
	<div>
		<a href="./admin.do">관리자 페이지</a>
	</div>
</body>
</html>