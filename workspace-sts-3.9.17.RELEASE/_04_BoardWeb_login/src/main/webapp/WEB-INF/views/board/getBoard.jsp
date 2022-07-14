<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<h3>게시글 상세</h3>
		<form>
			<table border="1" style="border-collapse: collapse; ">
				<tr>
					<td style="background: orange; width: 70px">
						제목
					</td>
					<td style="text-align: left;"> 									<!-- model에서 키값  -->
						<input type="text" name="boardTitle" id="boardTitle" value="${board.boardTitle }">
					</td>
				</tr>
				<tr>
					<td style="background: orange;">
						작성
					</td>
					<td style="text-align: left;">
						<input type="text" name="boardWriter" id="boardWriter" value="${board.boardWriter }" readonly >
					</td>
				</tr>
				<tr>
					<td style="background: orange;">
						내
					</td>
					<td style="text-align: left;">
						<textarea name="boardContent" id="boardContent" cols="40" rows="10">${board.boardContent }</textarea> 
					</td>
				</tr>
				<tr>
					<td style="background: orange;">
						작성
					</td>
					<td style="text-align: left;">
						${board.boardRegdate }
					</td>
				</tr>
				<tr>
				<td style="background: orange;">
						조회
					</td>
					<td style="text-align: left;">
						${board.boardCnt }
					</td>
				</tr>
				<tr id="btnWrap">
					<td colspan="2" align="center">
						<button type="submit" id="btnUpdate">수정</button>
					</td>
				</tr>
			</table>
		</form>
		<hr/>
		<a href="/board/insertBoard.do">글 등록</a>
		<a id="btnDelete" href="#">글 삭제</a>
		<a href="/board/getBoardList.do">글 목록</a>
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	
	
	<script>
		$(function(){
			const loginUserId = '${loginUser.userId}';
			const boardWriter = '${board.boardWriter}';
			
			if(loginUserId !== boardWriter) {
				$("#btnWrap").hide();
				$("#btnDelete").hide();
			}
		});
	</script>
</body>
</html>