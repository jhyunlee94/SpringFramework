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
			<a href="getName.do?firstName=${name.firstName }&lastName=${name.lastName}">${name.firstName } ${name.lastName }</a>
			<br/>
		</c:forEach>
	</div>
	
	<form id="insertNameForm" action="insertName.do" method="post">
		<input type="text" name="firstName" placeholder="이름">
		<input type="text" name="lastName" placeholder="성">
		<button type="submit">등록</button>
	</form>
</body>
</html>