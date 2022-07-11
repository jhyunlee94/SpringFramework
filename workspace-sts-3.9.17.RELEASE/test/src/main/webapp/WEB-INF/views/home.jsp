<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<a href="test.do?firstName=gi&lastName=go&age=36&job=teacher">click</a>

<form action="test1.do" method="post">
	<input type=text placeholder="firstName" name="firstName">
	<input type=text placeholder="lastName" name="lastName">
	<input type=text placeholder="age" name="age">
	<input type=text placeholder="job" name="job">
	<button type="submit">Submit</button>
</form>
</body>
</html>
