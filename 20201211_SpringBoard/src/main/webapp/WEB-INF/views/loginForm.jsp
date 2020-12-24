<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div id="container">
<form method="post" action="./enLogin.do">
		<div id="id">아이디</div>
		<input type="text" name="id"><br>
		<div id="pw">비밀번호</div>
		
		<input type="password" name="pw"><br>
		
		<input type="submit" id="login" name="login" value="로그인"><br>
		
		<div id="bottom">
			<input type="button" id="SignUp" name="signup" value="회원가입">			
		</div>	
		
	</form>
</div>
</body>
</html>