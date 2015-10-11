<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<h1>board</h1>

pageNo = ${pageInfo.pageNo}
totalItem = ${pageInfo.totalItem}
totalPage = ${pageInfo.totalPage}
startNum = ${pageInfo.startNum}
endNum = ${pageInfo.endNum}
startPage = ${pageInfo.startPage}
endPage = ${pageInfo.endPage}
isFirstGroup = ${pageInfo.isFirstGroup()}
isLastGroup = ${pageInfo.isLastGroup()}



<ul>
<c:forEach var="board" items="${board}">
	<li>${board.num} / ${board.name} / ${board.subject} / ${board.regdate}</li>
</c:forEach>
</ul>

<c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}" var="i">
	${i}
</c:forEach><br>



</body>
</html>