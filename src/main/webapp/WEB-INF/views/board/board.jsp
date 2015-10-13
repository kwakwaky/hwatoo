<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style type="text/css">
	#pageGroup {
		text-align: center;
	}
</style>
</head>
<body>
<h1 align="center">board</h1>
<div>
<table class="table">
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
	<c:forEach var="board" items="${board}">
	<tr>
		<td>${board.num}</td>
		<td><a href="?num=${board.num}">${board.subject}</a></td>
		<td>${board.name}</td>
		<td><fmt:formatDate value="${board.regdate}" pattern="YY/MM/dd"/></td>
	</tr>
	</c:forEach>
</table>
</div>


<div id="pageGroup">
<c:if test="${!pageInfo.isFirstGroup()}">
	<a href="/hwatoo/board?pageNo=${pageInfo.startPage - 1}">이전</a>
</c:if>

<c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}" var="i">
	<a href="/hwatoo/board?pageNo=${i}">${i}</a>
</c:forEach>

<c:if test="${!pageInfo.isLastGroup()}">
	<a href="/hwatoo/board?pageNo=${pageInfo.endPage + 1}">다음</a>
</c:if>

<a href="/hwatoo/board/write" class="btn btn-info" style="float: right;">글쓰기</a>
</div>



</body>
</html>