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
</head>
<body>
	<!-- ${pageContext.request.contextPath} 는 루트 경로의 걸 가져온다. -->
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div class="form-wrapper">
		<form id="loginForm">
			<h3>로그인</h3>
			<div class="label-wrapper">
				<label for="userId">아이디</label>
			</div>
			<input type="text" id="userId" name="userId" required>
			
			<div class="label-wrapper">
				<label for="userPw">비밀번호</label>
			</div>
			<input type="password" id="userPw" name="userPw" required>
			<div style="display: block; margin: 20px auto;">
				<button type="button" id="btnLogin">로그인</button>
				<button type="button" id="back">취소</button>
			</div>
			
			
		</form>
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#back").on("click", function(){
				location.href="/index.jsp";
			});
		});
	</script>
</body>
</html>