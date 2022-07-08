<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
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
</body>
</html>
