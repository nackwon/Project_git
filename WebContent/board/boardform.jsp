<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<form action="" method="post">
		<div>
			제목 <input type="text" name="title" id="title" />
		</div><br>
		<div>
			내용<br><textarea rows="10" cols="50" name="content" id="content"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>