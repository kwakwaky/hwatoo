<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>

<script type="text/javascript">
$(document).ready(function() {
	$('#update').click(function() {
		console.log('zzz')
	});
	
});

</script>

</head>
<body>
<h1 align="center">read</h1>

제목 : ${content.subject}<br>
작성자 : ${content.name}	/ 작성일 :<fmt:formatDate value="${content.regdate}" pattern="YY/MM/dd kk:mm:ss"/><br>
-------------------------------------------<br>
${content.content}							<br>
-------------------------------------------<br>

<button id="update">수정하기</button>

</body>
</html>