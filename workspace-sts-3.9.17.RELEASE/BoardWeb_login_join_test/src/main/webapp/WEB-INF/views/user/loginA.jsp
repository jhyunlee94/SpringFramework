<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.form-wrapper {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	#loginForm {
		width: 250px;
		text-align: center;
	}
	
	#loginForm .label-wrapper {
		margin-top: 20px;
		display: flex;
		justify-content: space-between;
		align-item: center;
	}
	
	#loginForm input {
		width: 100%;
	}
	
	#loginForm div {
		display: flex;
		align-items: center;
	}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div class="form-wrapper">
	<!-- action안넣고 비동기 처리 할거임 왜냐?? 로그인에서 화면 이동이 이뤄지면 안되기때문 -->
		<form id="loginForm">
			<h3>로그인</h3>
			<div class="label-wrapper">
				<label for="userId">아이디</label>
			</div>
			<input type="text" id="userId" name="userId" required>
			
			<div class="label-wrapper">
				<label for="userPw">비밀번호</label>
			</div>
			<input type="text" id="userPw" name="userPw" require>
			<div style="display: block; margin: 20px auto;">
				<button type="button" id="btnLogin">로그인</button>			
			</div>
		</form>
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
</body>
</html>