<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- ${modifyForm} --%>
<form action="./modifyBoard.do" method="post">
<input type="hidden" name="seq" value="${modifyForm.seq}">
	<table>
	<tr>	
		<th>제목</th>
		<td><input type="text" name="title" value="${modifyForm.title}"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${modifyForm.id}</td>
	<tr>
		<th>내용</th>
		<td><textarea cols="30" rows="10" name="content">${modifyForm.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="저장">
			<input type="reset" value="초기화">
			<input type="button" value="뒤로가기" onclick="history.back(-1)">
		</td>
	</tr>
	
	</table>
	</form>
</body>
</html>