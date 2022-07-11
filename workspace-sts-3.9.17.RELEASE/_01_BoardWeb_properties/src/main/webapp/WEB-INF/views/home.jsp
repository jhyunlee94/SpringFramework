<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
${hi }
</h1>

	<a href="test.do?firstName=gicheon&lastName=go&age=36&job=teacher">click</a>
	
	<form action="test.do" method="post">
		<input type="text" placeholder="firstName" name="firstName"> <!-- 각 태그의 name이 자동으로 적용됨 -->
		<input type="text" placeholder="lastName" name="lastName">
		<input type="text" placeholder="age" name="age">
		<input type="text" placeholder="job" name="job">
		<button type="submit">Submit</button>
	</form>
	<a href="/hello.do">hello 페이지로</a>
	<a href="getNameList.do">이름 목록 페이지로</a>
</body>
</html>
