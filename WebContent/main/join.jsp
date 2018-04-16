<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/custom.css" />
<meta charset="UTF-8">
<title>join page</title>
<style type="text/css">
span {
	color: red;
	font-size: 12px;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	//중복 체크
	function nicknameDupleCheck() {
		var nickname = document.getElementById("nickname").value;

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
				var result = this.responseText;
				if (result == "false") {
					document.getElementById("n_span").innerHTML = "사용할 수 없는 아이디 입니다.";
				} else if (result == "true") {
					nicknameCheck(nickname);
				}
			}
		}
		var data = "nickname=" + nickname;
		xhr.open("POST", "./main/id_check.jsp", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(data);
	}

	//아이디 빈칸 등 체크
	function nicknameCheck(val) {
		if ((val < "0" || val > "9") && (val < "A" || val > "Z") && (val < "a" || val > "z")) {
			document.getElementById("n_span").innerHTML = "한글 및 특수기호는 사용할 수 없습니다.";
		} else {
			document.getElementById("n_span").innerHTML = "";

			if (val.length < 3) {
				document.getElementById("n_span").innerHTML = "3자 이상 작성을하세요";
			} else {
				document.getElementById("n_span").innerHTML = "";
			}

			if (val == "") {
				document.getElementById("n_span").innerHTML = "아이디를 입력하세요";
			} else {
				docuemnt.getElementById("n_span").innerHTML = "";
			}
		}
	}
	//이메일 중복 체크
	/* function emailDupleCheck() {
		var email = document.getElementById("email").value;

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var result = this.responseText;

				if (result == "true") {
				
				} else if (result == "flase") {
					document.getElementById("e_span").innerHTML = "사용할 수 없는 이메일 입니다.";

				}
			}
		}
		data = "email=" + email;
		xhr.open("POST", "./main/id_check.jsp", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(data);
	}

	//이메일 빈칸 체크 등
	function emailCheck() {
		
		//이메일 유효성 테스트
		//var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		if (val == "") {
			document.getElementById("n_span").innerHTML = "이메일을 입력하세요";
		} else {
			docuemnt.getElementById("n_span").innerHTML = "";
		}
	} */

	//모든 체크가 끝난 후 최종 가입
	function finalCheck() {
		var flag = false;
		var idflag = document.getElementById("isIdcheck").value;
		alert(idflag);
		var emailflag = document.getElementById("isEmailcheck").value;
		alert(emailflag);
		if (idflag == "true" && emailflag == "true") {
			flag = true;
		} else {
			document.getElementById("final_check").innerHTML = "빈칸을 모두 채워주세요";
		}
		return flag;
	}
</script>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<!-- top -->
	<div class="container">
		<form action="./git?cmd=registMember" method="post" name="l_f">
			<div>
				<input type="text" name="nickname" id="nickname" class="control-label" onblur="nicknameDupleCheck()" placeholder="Enter your Nickname" />
				<!-- <input type="hidden" id="isIdcheck" value="false" name="isIdCheck" /> -->
			</div>
			<span id="n_span" class="n_style"></span>
			<div>
				<input type="text" id="email" name="email" onblur="emailDupleCheck()" placeholder="Enter your E-mail" />
				<!-- <input type="hidden" id="isEmailcheck" value="false" name="isEmailCheck" /> -->
			</div>
			<span id="e_span"></span>
			<div>
				<input class="" type="password" name="password" placeholder="Enter your password" />
			</div>
			<span id="p_span" class="p_style"></span>
			<div class="row">
				<input class="btn" type="submit" value="Sign up" /> <span id="final_check"></span>
			</div>
		</form>
	</div>

	<!-- bottom -->
</body>
</html>
<!-- 해야 할 일 : 유효성 체크 및 final_check -->
