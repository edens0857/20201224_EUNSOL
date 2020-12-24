<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 검사</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	document.getElementById("btnuseid").style.display="none";
});
function checkId(){
	var doc = document.getElementById("id").value;
	$.ajax({
		url:"./idDuplicateCheck.do", 
		type:"POST",
		data: "id="+doc,
		async: true,
		success: function(msg){
			if(msg.isc=='false'){
				document.getElementById("msgidcondition").innerHTML = "사용가능합니다.";
				document.getElementById("btnuseid").style.display = "block";
			}else{
				document.getElementById("msgidcondition").innerHTML = "사용 불가능합니다.";
				document.getElementById("btnuseid").style.display = "none";
			}
		},
		error:function(err) {
			console.log(err)
		}
	});
}

function useid(){
	var doc = document.getElementById("id").value;
	window.opener.document.getElementById("id").value = doc;
	window.opener.document.getElementById("name").focus();
	window.close();
}
</script>
</head>
<body>
	<div>
		<input type="text" id="id">
		<input type="button" value="확인" onclick="checkId()"> 
	</div>
	<div>
		<input type="button" value="사용하기" id="btnuseid" onclick="useid()">
	</div>
	<div id="msgidcondition"></div>
</body>
</html>