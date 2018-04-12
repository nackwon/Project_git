<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/custom.css" />
<meta charset="UTF-8">
<title>join page</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	$(function(){
		$('#nickname').blur(function(){
			
			if(('#nickname').val() == ""){
				$('#n_span').text("아이디를 입력해 주세요");
			} else if(('#nickname').val().length < 3){
				$('#n_span').text("3자 이상 입력하셔야 합니다.");
			}
		});
	})
	
</script>
</head>
<body>
	<!-- top -->
	<form action="./git?cmd=registMember" method="post" name="l_f">
		<div>
			<input type="text" name="nickname" id="nickname" class="control-label" onfocus="nicknameCheck()" placeholder="Enter your Nickname" />
		</div>
		<span id="n_span" class="n_style"></span>
		<div>
			<input type="text" name="email" placeholder="Enter your E-mail" />
		</div>
		<span id="" onkeyup="email_check(); return false"> </span>
		<div>
			<input class="" type="password" name="password" placeholder="Enter your password" />
		</div>
		<span id="p_span" class="p_style"></span>
		<div class="row">
			<input class="btn" type="submit" value="Sign up" />
		</div>
	</form>
	<!-- bottom -->
</body>
</html>
