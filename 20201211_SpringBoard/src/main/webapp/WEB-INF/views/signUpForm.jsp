<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<script type="text/javascript">
function dubplicationId(){
	var url = "./idDuplicateForm.do";
	var title ="아이디 중복 검사";
	var attr = "width=300px, height=500px";
	window.open(url,title,attr);
}


</script>
<body>
<form action="./signUp.do" method="post" id="frm" name="frm">
<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id" name ="id" readonly="readonly"></td>
			<td><input type="button" value="중복확인" onclick="dubplicationId()"></td>
		</tr>
		<tr>
			<td>성명</td>
			<td colspan="2"><input type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td colspan="2"><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td colspan="2"><input type="password"></td>
		</tr>
		<tr>
			<td colspan="3">
			<input type="submit" value="가입">
			<input type="button" value="취소" onclick="javascript:history.back(-1)">
		</tr>
	</table>
</form>
</body>
</html>