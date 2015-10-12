<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style type="text/css">
	th {
		border: 1px solid;
	}
	
	#subject {
		width: 40%;
	}
	
	table {
		margin: auto;
	}
	
	#pageGroup {
		border: 1px solid;
		padding: 5px;
	}
	
	div {
		margin: 10px;
		text-align: center;
	}
	

</style>
</head>
<body>
<h1 align="center">board</h1>

<%-- pageNo = ${pageInfo.pageNo} --%>
<%-- totalItem = ${pageInfo.totalItem} --%>
<%-- totalPage = ${pageInfo.totalPage} --%>
<%-- startNum = ${pageInfo.startNum} --%>
<%-- endNum = ${pageInfo.endNum} --%>
<%-- startPage = ${pageInfo.startPage} --%>
<%-- endPage = ${pageInfo.endPage} --%>
<%-- isFirstGroup = ${pageInfo.isFirstGroup()} --%>
<%-- isLastGroup = ${pageInfo.isLastGroup()} --%>

<div>
<table>
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
	
	<c:forEach var="board" items="${board}">
	<tr>
		<td>${board.num}</td>
		<td id="subject"><a href="/hwatoo/board/${pageInfo.pageNo}?num=${board.num}">${board.subject}</a></td>
		<td>${board.name}</td>
		<td>${board.regdate}</td>
	</tr>
	</c:forEach>
	
</table>
</div>


<div>
<c:if test="${!pageInfo.isFirstGroup()}">
	<a href="/hwatoo/board/${pageInfo.startPage - 1}">이전</a>
</c:if>


<c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}" var="i">
	<a href="/hwatoo/board/${i}" id="pageGroup">${i}</a>
</c:forEach>


<c:if test="${!pageInfo.isLastGroup()}">
	<a href="/hwatoo/board/${pageInfo.endPage + 1}">다음</a>
</c:if>
</div>


</body>
</html>