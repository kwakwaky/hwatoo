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
<h1 align="center">write</h1>

<form:form commandName="write" method="post">
	<div>
	작성자 :<form:input path="name"/>
	</div>
	<div>
	비밀번호 :<form:password path="password"/>
	</div>
	<div>
	제목 : <form:input path="subject"/>
	</div>
	<div>
	<form:textarea path="content"/>
	</div>
	
	<input type="submit" value="완료">
</form:form>

${content.name}
${content.subject}
${content.content }



</body>
</html>