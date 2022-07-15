<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.pagination {
		list-style: none;
		width: 100%;
		display: inline-block;
	}
	
	.pagination_button {
		float: left;
		margin-left: 5px;
	}

</style>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<h3>게시글 목록</h3>
		
		<form action="/board/getBoardList.do" method="post">
			<table border="1" style="width: 700px; border-collapse: collapse;">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="all"
								<c:if test="${searchCondition eq 'all' }">selected="selected"</c:if>
							>전체</option>
							<option value="title"
								<c:if test="${searchCondition eq 'title' }">selected="selected"</c:if>
							>제목</option>
							<option value="content"
								<c:if test="${searchCondition eq 'content' }">selected="selected"</c:if>
							>내용</option>
							<option value="writer"
								<c:if test="${searchCondition eq 'writer' }">selected="selected"</c:if>
							>작성자</option>
						</select>
						<input type="text" name="searchKeyword">
						<button type="submit">검색</button>
					</td>
				</tr>
			</table>
		
		</form>
		
		<table border="1" style="width: 700px; border-collapse: collapse;">
			<tr>
				<th style="background: orange; width: 100px;">번호</th>
				<th style="background: orange; width: 200px;">제목</th>
				<th style="background: orange; width: 150px;">작성자</th>
				<th style="background: orange; width: 150px;">등록일</th>
				<th style="background: orange; width: 100px;">조회수</th>
			</tr>
			<!-- <tr>
				<td>1</td>
				<td>
					<a href="/board/getBoard.do?boardSeq=1">제목1</a>
				</td>
				<td>작성1</td>
				<td>2022.07.13</td>
				<td>1</td>
			</tr>
			 -->
			 <c:forEach var="board" items="${boardList }">
			 	<tr>
				 	<td>${board.boardSeq }</td>
				 	<td>
				 		<a href="/board/getBoard.do?boardSeq=${board.boardSeq }">${board.boardTitle }</a>
				 	</td>
				 	<td>${board.boardWriter }</td>
				 	<td>${board.boardRegdate }</td>
				 	<td>${board.boardCnt }</td>
				 </tr>
			 </c:forEach>
		</table>
		<br/>
		<div style="text-align: center">
			<ul class="pagination">
				<li class="pagination_button">
					<a href="#">Previous</a>
				</li>
				<li class="pagination_button">
					<a href="#">1</a>
				</li>
				<li class="pagination_button">
					<a href="#">2</a>
				</li>
				<li class="pagination_button">
					<a href="#">3</a>
				</li>
				<li class="pagination_button">
					<a href="#">Next</a>
				</li>				
			</ul>
		</div>
		<br/>
		<a href="/board/insertBoard.do">새 글 등록</a>
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
</body>
</html>