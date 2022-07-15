<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>콕션-로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/ress.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style_header_footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style_support.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js"></script>

    <style>
        header{
            height: 100px;
        }
    </style>
</head>
<body>
    <!--header-->
    <header>
        <div class="top-bg">
            <div class="top-navbar">
                <div class="nav justify-content-end">
                    <a class="nav-link" href="/user/login2.do">로그인</a>
                    <a class="nav-link" href="register.html">회원가입</a>
                </div>
            </div>
    
        </div>
    </header>
    <!--mian-->
    <main>
         <!--내용 부분-->   
        <section>
            <a href="index.html"><img class="login-logo" src="images/main_logo.png" alt="로고"></a>
            <form action="index_login.html" class="login-form" name="login-form">
                <fieldset>
                    <div class="login-info">
                        <ul>
                            <li>
                                <input type="text" id="input-id" value="아이디">
                            </li>
                            <li>
                                <input type="password" id="input-pw" value="********">
                            </li>
                        </ul>
                    </div>
                    <div class="login-btn"><input type="submit" value="로그인"  id="login-btn"></div>
                    <div class="auto-login">
                        <label class="form-check-label" for="flexSwitchCheckDefault">자동로그인</label>
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault">
                          
                          </div>
                    </div>
                    <a href="register.html" id="link-register">회원가입</a>
                    <a href="#" id="link-findinfo">계정정보를 잊으셨나요?</a>
                    <button type="button" class="btn btn-success" id="login-byNaver">네이버로 시작하기</button>
                    <button type="button" class="btn btn-warning" id="login-byKakao">카카오로 시작하기</button>
                    <button type="button" class="btn btn-outline-secondary" id="login-byGoogle">구글로 시작하기</button>
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
            $("#input-id").focus(function(){   
                $(this).css("color", "rgb(63, 63, 63)");    
                if($(this).val()=="아이디")  {                    
                $(this).val("")
                       
                }
            });

            $("#input-id").blur(function(){              
                if($(this).val()=="")   {    
                $(this).val("아이디")
                       .css("color", "rgb(205, 205, 205)");
                }
            });

            $("#input-pw").focus(function(){
                if($(this).val()=="********")  {
                $(this).val("")
                       .css("color", "rgb(63, 63, 63)");
                }
            });

            $("#input-pw").blur(function(){
                if($(this).val()=="") {        
                $(this).val("********")
                       .css("color", "rgb(205, 205, 205)");
                }       
            });
            
            
        });
    </script>
</body>
</html>
