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
<h1 align="center">read</h1>

${content.subject}<br>
${content.name}	/ ${content.regdate}<br>
-------------------------------------------<br>
${content.content}							<br>
-------------------------------------------<br>



</body>
</html>