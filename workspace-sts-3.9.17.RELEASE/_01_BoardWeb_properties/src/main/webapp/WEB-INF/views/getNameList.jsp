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
	<div id="divNameList">
		<a>이름1</a>
		<a>이름2</a>
		<a>이름3</a>
		<!-- name으로 꺼내서 쓰겠다 -->
		<c:forEach var="name" items="${nameList }">
			<p>${name.firstName } ${name.lastName }</p>
		</c:forEach>
	</div>
</body>
</html>