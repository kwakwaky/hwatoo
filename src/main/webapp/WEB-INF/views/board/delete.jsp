<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<title>board.jsp</title>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style type="text/css">
	#delete_hidden {
		display: none;
	}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$('#check').click(function() {
		var password = $('#password').val();
		var num = '<c:out value="${num}"/>';
		var check = '';
		$.post(
			"/hwatoo/board/delete",
			{password: password, num: num},
			function(data) {
				console.log(data)
				if (data == 'ok') 
					$('#delete_hidden').show();
				else
					$('#delete_text').html("비밀번호가 일치하지 않습니다.");
		});
	});
});
</script>
</head>
<body>

<h1 align="center">delete</h1>
비밀번호를 입력하세요.
<input id="password" type="password">
<button id="check">확인</button>
<div id="delete_text"></div>


<div id="delete_hidden">
정말 삭제하시겠습니까?

<a href="/hwatoo/board/delete/action?num=${num}"><button>예</button></a>
<a href="/hwatoo/board?num=${num}"><button>아니오</button></a>
</div>


</body>
</html>