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
	<form id="updateNameForm" action="updateName.do" method="post" >
		<!-- 값이 변경되지않기 위해 hidden으로 데이터를 담아줌 -->
		<input type="hidden" name="originalFirstName" value="${name.firstName}">
		<input type="hidden" name="originalLastName" value="${name.lastName }">
		<input type="text" name="firstName" placeholder="이름" value="${name.firstName }">
		<input type="text" name="lastName" placeholder="성" value="${name.lastName }">
		<button type="submit">수정</button>
	</form>
	<a href="deleteName.do?firstName=${name.firstName}&lastName=${name.lastName}">삭제</a>
</body>
</html>