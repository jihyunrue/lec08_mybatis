<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty resultList }">
					<tr>
						<td colspan="5">게시글이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${resultList }" var="b" varStatus="status">
						<%-- <tr onclick="location.assign('<c:url value="/boardDetail?boardNo=${b.board_no }"/>')"> --%>
						<tr data-no="${b.board_no }">
							<td><c:out value ="${paging.numPerPage*(paging.nowPage-1)+status.count}"/></td>
							<td><c:out value ="${b.board_title }"/></td>
							<td><c:out value="${b.board_content }"/></td>
							<td><fmt:formatDate pattern="yy-MM-dd" value="${b.reg_date }"/></td>
							<td>
								<button onclick="deleteBoard('${b.board_no}')">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<c:if test="${not empty paging }">
		<div>
			<div>
				<c:if test="${paging.prev }">
					<a href="<c:url value='/boardList?nowPage=${paging.pageBarStart-1 }'/>">&laquo;</a>
				</c:if>
				<c:forEach begin="${paging.pageBarStart }" end="${paging.pageBarEnd }" var="idx">
					<a href="<c:url value='/boardList?nowPage=${idx }'/>">${idx }</a>
				</c:forEach>
				<c:if test="${paging.next }">
					<a href="<c:url value='/boardList?nowPage=${paging.pageBarEnd+1 }'/>">&raquo;</a>
				</c:if>
			</div>
		</div>
	</c:if>
<script>
	const tds = document.querySelectorAll("table tr td:not(:last-child)");
	for(let i = 0; i < tds.length ; i++){
		tds[i].onclick = function(){
			const parent = this.parentNode;
			const boardNo = parent.dataset.no;
			location.href = "<%=request.getContextPath()%>/boardDetail?boardNo="+boardNo;
		}
	}
	
	
	const deleteBoard = function(boardNo){
		const xhr = new XMLHttpRequest();
		xhr.open('get','<%=request.getContextPath()%>/boardDelete?boardNo='+boardNo);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				const resp =xhr.reponseText;
				if(resp == '200'){
					alert("게시글이 정상적으로 삭제 되었습니다.");
					location.href="<%=request.getContextPath()%>/boardList";
				}else{
					alert("게시글 삭제중 오류가 발생하였습니다.");
				}
			}
		}
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");  
		xhr.send();
	}
</script>
</body>
</html>
						