<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<title>board.jsp</title>
</head>
<body>
<h1 align="center">read</h1>

제목 : ${item.subject}<br>
작성자 : ${item.name}	/ 작성일 :<fmt:formatDate value="${item.regdate}" pattern="YY/MM/dd kk:mm:ss"/><br>
-------------------------------------------<br>
${item.content}							<br>
-------------------------------------------<br>

<a href="/hwatoo/board/update?num=${item.num}"><button id="update">수정하기</button></a>
<a href="/hwatoo/board/delete?num=${item.num}"><button id="delete">삭제하기</button></a>
</body>
</html>