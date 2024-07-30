<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
</head>
<body>
	<form>
		<input type="hidden" id="board_no" value="<c:out value='${detail.board_no }'/>">
		<label for="board_title">제목</label>
		<input type="text" id="board_title" value="<c:out value='${detail.board_title }'/>"><br>
		<label for="board_content">내용</label>
		<textarea id="board_content"><c:out value='${detail.board_content }'/></textarea><br>
		<input type="button" value="수정" onclick="boardUpdate();">
		<input type="reset" value="초기화">
	</form>
	<script>
		const boardUpdate = function(){
			const no = document.getElementById("board_no").value;
			const title = document.getElementById("board_title").value;
			const content = document.getElementById("board_content").value;
			
			const xhr = new XMLHttpRequest();
			xhr.open("post","<%=request.getContextPath()%>/boardUpdate",true);
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					const resp = xhr.responseText;
					if(resp == '200'){
						location.href="<%=request.getContextPath()%>/boardList";
					}else{
						alert("게시글 수정중 오류가 발생하였습니다.");
					}
				}
			}
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
			xhr.send("board_no="+no+"&board_title="+title+"&board_content="+content);
		}
	</script>
	
	
	
	
	
	
</body>
</html>