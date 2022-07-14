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
	<!-- ${pageContext.request.contextPath} 는 루트 경로의 걸 가져온다. -->
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div class="form-wrapper" >
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
			</div>
		</form>
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	<script>
	
	//로그인 시 아이디나 비밀번호가 틀렸을 경우를
	//대비하여 폼을 서브 하지 않고
	//후 처리를 위해 ajax로 처리
	
	$(function () {
		$("#btnLogin").on("click", function() {
			$.ajax({
				url: '/user/login.do',
				type: 'post',
				data: $("#loginForm").serialize(),
				success: function(obj) {
					const data = JSON.parse(obj);
					//1. 아이디 체크
					if(data.message == 'idFail') {
						alert("존재하지 않는 아이디입니다.");
						return;
					}
					//2. 비밀번호 체크
					else if (data.message == "pwFail"){
						alert("비밀번호가 틀렸습니다.");
						return;
					}
					//3. 로그인 처리
					location.href = "/index.jsp";
				},
				error: function(e) {
					console.log(e);
				}
			});
		});
	});

	</script>
</body>
</html>