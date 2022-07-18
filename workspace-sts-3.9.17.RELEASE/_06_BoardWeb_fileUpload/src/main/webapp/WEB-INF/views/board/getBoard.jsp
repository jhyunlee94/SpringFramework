<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form action="/board/updateBoard.do" method="post" enctype="multipart/form-data">
			<!-- form을 이용하여 데이터 전송할때는 입력창 (<input>, <textarea> 등)의 내용만 전달 그래서 글 수정 삭제할 때 hidden에 담아서 전송 -->
			<input type="hidden" name="boardSeq" value="${board.boardSeq}" >
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
						내용
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
				<tr>
					<td style="background: orange; width: 70px;">
						첨부파일
					</td>
					<td>
						<c:forEach items="${fileList }" var="file">
							<a class="downlink" id="${file.fileSeq }" href="${file.fileName }">
								${file.originalFileName }
							</a>
							<button type="button" onclick="deleteBoardFile('${file.fileSeq}')">삭제</button>
							<img src="/upload/${file.fileName }">
							<br/>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td style="background: orange; width: 70px;">
						업로드
					</td>
					<td align="left">
						<input type="file" name="uploadFiles" multiple="multiple">
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
		<a id="btnDelete" href="/board/deleteBoard.do?boardSeq=${board.boardSeq }">글 삭제</a>
		<a href="/board/getBoardList.do">글 목록</a>
		
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	
	
	<script>
	function deleteBoardFile(fileSeq) {
		$.ajax({
			url: '/board/deleteBoardFile.do',
			type: 'post',
			data: {
				"boardSeq" : $("input[name='boardSeq']").val(),
				"fileSeq" : fileSeq
				  },
			success: function() {
				location.reload();
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
	
		$(function(){
			const loginUserId = '${loginUser.userId}';
			const boardWriter = '${board.boardWriter}';
			
			if(loginUserId !== boardWriter) {
				$("#btnWrap").hide();
				$("#btnDelete").hide();
				$("#boardTitlle").attr("readonly", true);
				$("#boardContent").attr("readonly", true);
			}
			
			$(".downlink").on("click", function(e){
				e.preventDefault();
				
				const fileName = $(this).attr("href");
				window.location = "/board/fileDown.do?fileName=" + fileName;
			});
			

		});
	</script>
</body>
</html>