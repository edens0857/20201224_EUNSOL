<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 목록 조회</title>
</head>
<body>
<form action="./multiDelete.do" method="get">
<div>
	<a href="./writeForm.do"><input type="button" value="글 작성"></a>
	<a href="./multiDel.do"><input type="submit" value="선택 삭제"></a>
</div>

	<table>
	<thead>
	<tr>
		<th><input type="checkbox" id="allCheck"onclick="checkAll(this.checked)"></th>
		<th>연번</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="i" items="${boardList}" varStatus="vs">
	<tr>
			<td><input type="checkbox" name="seqs" value="${i.seq}"> </td>
			<td>${i.seq}</td>
			
			<td>
				<jsp:useBean id="format" class="com.min.edu.useBean.replyPhoto" scope="page"/>
				<jsp:setProperty property="depth" name="format" value="${i.depth}"/>
				<jsp:getProperty property="photo" name="format"/>
			<a href="./boardDetail.do?seq=${i.seq}">${i.title}</a>
							</td>
			<td>${i.id}</td>
			<td style="text-align: center;"><fmt:formatDate value="${i.regdate}" pattern="yyyy-MM-dd"/></td>
	</tr>
		</c:forEach>
	</tbody>
	
	</table>
	</form>
	
</body>

<script type="text/javascript">

// 전체 체크 
function checkAll(bool){
	var seq = document.getElementsByName("seqs");
	for (var i = 0; i < seq.length; i++) {
		seq[i].checked = bool;
	}
}

 
window.onload = function(){
	var seq = document.getElementsByName("seqs");
	var allCheck = document.getElementById("allCheck");
	for (var i = 0; i < seq.length; i++) {
		seq[i].onclick = function(){
			if(seq.length  == seqConfirm()){
				allCheck.checked = true;
			}else{
				allCheck.checked = false;
			}
		}
	}
}


function seqConfirm(){
	var seq = document.getElementsByName("seqs");
	var cnt = 0;
	for (var i = 0; i < seq.length; i++) {
		if(seq[i].checked){
			cnt++;
		}
	}
	return cnt;
}


</script>

</html>