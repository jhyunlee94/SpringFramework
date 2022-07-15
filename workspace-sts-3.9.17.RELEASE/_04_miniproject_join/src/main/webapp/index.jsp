
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>콕션-회원가입</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/ress.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style_header_footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style_support.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js"></script>

</head>
<body>
   <!--header-->
    <header>
        <div class="top-bg">
            <div class="top-navbar">
                <div class="nav justify-content-end">
                    <a class="nav-link" href="/user/login2.do">로그인</a>
                    <a class="nav-link" href="/user/join.do">회원가입</a>
                </div>
            </div>
        </div>
    </header>
    <!--mian-->
    <main>
         <!--내용 부분-->   
        <section>
            <a href="index.jsp"><img class="login-logo" src="images/main_logo.png" alt="로고"></a>
            <form action="/index.do" class="register-form" name="register-form" id="joinForm" onsubmit="return joinSubmit()" method="post">
                <fieldset>
                    <legend>회원가입</legend>
                    <ul class="register-info">
                        <li>
                            <label for="userId">아이디</label>
                            <input type="text" id="userId" name="userId" required >
                            <input type="button" value="중복확인"  id="btnIdCheck">
                        </li>
                        <li>
                            <label for="userPw">비밀번호</label>
                            <input type="password" id="userPw" name="userPw" required >
                            <p id="pwValidation" style="color: red; font-size: 0.8rem">비밀번호는 영문자, 숫자, 특수문자 조합의 9자리 이상으로 설정해주세요.</p>
                        </li>
                        
                        <li>
                            <label for="userPwCheck">비밀번호 확인</label>
                            <input type="password" id="userPwCheck" name="userPwCheck" required >
                            <p id="pwCheckResult" style="font-size: 0.8rem"></p>
                        </li>

                        
                        <li>
                            <label for="userNm">이름</label>
                            <input type="text" id="userNm" name="userNm" required >
                        </li>
                        <li>
                            <label for="userTel">전화번호</label>
                            <input type="tel" id="userTel" name="userTel" >
                        </li>
                        <li>
                            <label for="userMail">이메일</label>
                            <input type="email" id="userMail" name="userMail">
                        </li>
                        <li style="justify-content: center;">
                            <input type="button" value="뒤로가기"  id="go-back-btn">
                            <input type="submit" value="회원가입"  id="regist-sybmit-btn">
                        </li>
                    </ul>
                </fieldset>
            </form>
        </section>  
    </main>
    <!--footer-->
    <footer>
        <div class="footer-div">
            <div class="footer1">
                <p><strong>Koction</strong>
                    <br>서울특별시 강남구 강남대로 94길 20<br>
                    상호명 : (주) 콕션<br>
                    대표자 : 고기천<br>
                </p>
            </div>
            <div class="footer2">
                <div>
                    <p><strong>고객센터</strong>
                        <br>Tel: 1688-5757 ( 평일 09:00 ~ 18:00 )<br>
                        이메일: koction@koction.kr<br>
                    FAX: 1688-5758</p>
                </div>
            </div>
        </div>
        <div class="footer3">
            <p>
                (주)콕션은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 (주)콕션은 상품거래정보 및 가격에 대하여 책임을 지지 않습니다.
                <br>
                본사이트의 모든 정보, 콘텐츠, UI 등에 대한 무단 복제, 전송, 배포, 스크래핑 등의 행위는 관련 법령에 의하여 엄격히 금지됩니다.
            </p>
            <span><small>&copy; 2022 Koction</small></span>
        </div>
    </footer>
    <!--스크립트-->
    <script>
		$(function(){
			
         	let checkId = false;
         	let pwValidation = false;
         	let pwCheck = false;
         	
         	$("#pwValidation").hide();
         	$("#pwCheckResult").hide();
         	
         	$("#btnIdCheck").on("click", function(){
         		if($("#userId").val() == null || $("#userId").val() == '') {
         			alert("아이디 입력하세요");
         			return;
         		}
         		
         		$.ajax({
         			url: '/idCheck.do',
         			type: 'post',
         			data: $("#joinForm").serialize(),
         			success: function(obj) {
         				console.log(obj);
         				
         				const data = JSON.parse(obj);
         				
         				if(data.resultIdCheck < 1) {
         					if(confirm("사용가능한 아이디입니다. " + $("#userId").val() + "를(을) 사용하시겠습니까?")) {
         						checkId = true;
         						$("#btnIdCheck").attr("disabled", true);
         					}
         				} else {
         					checkId = false;
         					alert("이미 존재")
         					$("#userId").focus();
         					return;
         				}
         			},
         			error: function(e) {
         				console.log(e);
         			}
         		});
         	});
			$("#userId").on("change", function() {
				checkId = false;
				$("#btnIdCheck").attr("disabled", false);
			});
			// 비밀번호 유효성 검사
			//8,25 가 최소길이 최대길이.{8,25}
			//.{9,} 최소 9 최대 ~~
			function validationPassword(character) {
				return /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{9,}$/.test(character);
			}
			
			$("#userPw").on("change", function() {
				if(!validationPassword($("userPw").val())) {
					pwValidation = false;
					$("#pwValidation").show();
					$("#userPw").focus();
				} else {
					pwValidation = true;
					$("#pwValidation").hide();
				}
				if($("#userPw").val() == $("#userPwCheck").val()) {
					pwCheck = true;
					$("#pwCheckResult").css("color", "green");
					$("#pwCheckResult").text("비밀번호가 일치합니다.");
				} else {
					pwCheck = false;
					$("#pwCheckResult").css("color", "red");
					$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");
				}
			});

			//비밀번호 확인
			$("#userPwCheck").on("change", function() {
				$("#pwCheckResult").show();
				
				if($("#userPw").val() == $("#userPwCheck").val()) {
					pwCheck = true;
					$("#pwCheckResult").css("color", "green");
					$("#pwCheckResult").text("비밀번호가 일치합니다.");
				} else {
					pwCheck = false;
					$("#pwCheckResult").css("color", "red");
					$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");
				}
			});
			
			//회원가입할 (회원가입 폼 서브밋될) 때 마지막 유효성 검사
			$("#joinForm").on("submit", function(e){
				if(!checkId) {
					alert("아이디 중복체크를 진행해주세요.")
					$("#userId").focus();
					e.preventDefault();
					return;
				}
				
				if(!pwValidation) {
					alert("비밀번호는 영문자, 숫자, 특수문자 조합의 9자리 이상으로 설정해주세요.");
					$("#userPw").focus();
					e.preventDefault();
					return;
				}
				
				if(!pwCheck) {
					alert("비밀번호가 일치하지 않습니다.");
					$("#userPwCheck").focus();
					e.preventDefault();
					return;
				}
			});
		});
    </script>
</body>
</html>