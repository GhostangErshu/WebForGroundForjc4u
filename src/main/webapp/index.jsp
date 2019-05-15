<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>你好</h1>
	<c:forEach items="${list }" var="a">
		${a}<br>
	</c:forEach>
	<h3>name:${name}</h3>
	<h3>age:${age}</h3>
</body>
</html>