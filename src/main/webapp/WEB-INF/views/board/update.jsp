<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>
<body>
<h1 align="center">update</h1>

<form:form commandName="write" method="post">
	<div>
	작성자 : ${board.subject}
	</div>
	<div>
	비밀번호 :<form:password path="password"/>
	</div>
	<div>
	제목 : <form:input path="subject" value="${board.subject}"/>
	</div>
	<div>
	<textarea id="content" name="content">${board.content}</textarea>
	</div>
	<input type="submit" value="완료">
</form:form>


</body>
</html>