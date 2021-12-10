<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin : auto}
	table{ text-align:center;
		width:600px;
		border : 1px solid gray;
	}
	td{padding:5px;
	   text-align:left;
	}
	h3{
		padding:1em;
	}
</style>
<script src="/iot/resources/jquery/jquery-3.6.0.js"></script>
<script type="text/javascript" src="resources/js/board.js" >
</script>
</head>
<body>
<form action="" method="post" name="content">
	<table border="1">
			<thead><tr><th colspan="2">글내용</th></tr></thead>
			<tbody>
				<tr><th style="width:30%">글제목</th>
					<td><input name="subject"  readonly="readonly" size="50" value="${dto.subject}"></td>
				</tr>
				<tr><th style="width:30%">글쓴이</th>
					<td><input name="writer"  readonly="readonly" size="50" value="${dto.writer}"></td>
				</tr>
				<tr><th style="width:30%">글내용</th>
					<td><textarea rows="15" cols="50" name="content"  readonly="readonly" >${dto.content}</textarea></td>
				</tr>
				<tr><th style="width:30%">이메일</th>
					<td><input type="email" name="email"  readonly="readonly" size="50" value="${dto.email}"></td>
				</tr>
			
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="hidden" name="num" value="${dto.num}">
						<input type="hidden" name="ref" value="${dto.ref}">
						<input type="hidden" name="step" value="${dto.step}">
						<input type="hidden" name="lev" value="${dto.lev}">
						<input type="hidden" name="passwd" value="${dto.passwd}">
						<input type="hidden" name="currentPage" value="${pvo.currentPage}">
						<input type="button" value="글목록" onclick="javascript:location.href='list?currentPage=${pvo.currentPage}'">
						<input type="button" value="답글" onclick="javascript:sendConfirm('reply')">
						<input type="button" value="글수정" onclick="javascript:updateConfirm('update')">
						<input type="button" value="글삭제" onclick="javascript:deleteConfirm('delete')">
					</td>	
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>