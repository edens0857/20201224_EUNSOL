<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 글 조회</title>
</head>
<body>

<table>
<!-- 	<tr> -->
<!-- 		<th>연번</th> -->
<%-- 		<td>${boardList.seq}</td> --%>
<!-- 	</tr> -->
	<tr>	
		<th>제목</th>
		<td>${boardList.title}</td>
	</tr>
	<tr>	
		<th>작성자</th>
		<td>${boardList.id}</td>
	</tr>
<!-- 	<tr> -->
<!-- 		<th>조회수</th> -->
<%-- 		<td>${boardList.readcount}</td> --%>
<!-- 	</tr> -->
	<tr>
		<th>작성일</th>
		<td>${boardList.regdate}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${boardList.content}</td>
	</tr>
	
</table>

<div>
	<a href="./modifyForm.do?seq=${boardList.seq}"><input type="button" value="글수정"></a>
	<a href="./replyForm.do?seq=${boardList.seq}"><input type="button" value="답글 작성"></a>
	<a href="./oneDelete.do?seq=${boardList.seq}"><input type="button" value="글삭제"></a>
	<a href="./boardList.do"><input type="button" value="글목록"></a>
</div>
</body>
</html>