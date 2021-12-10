<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style type="text/css">
	*{margin:auto;}
	table{
		text-align:center;
		width:600px;
		border: 1px solid gray;
	}
	td{
		padding:5px;
		text-align:left;
	}
</style>
<!-- 절대 주소 -->
<script src="/iot/resources/jquery/jquery-3.6.0.js"></script>
<script src="resources/js/board.js"></script>
<!-- 상대 주소 -->
</head>
<body>
<form action="writePro" method="post" name="wForm">
	<table border="1">
		<thead><tr><th colspan="2">글쓰기</th></tr></thead>
		<tbody>
			<c:if test="${dto.num !=0 and dto.ref !=0 and dto!= null}">
			<tr><th style="width:30%">글제목</th><td><input type="text" class="chk" placeholder="입력하세요" size="50" name="subject" value="[답글]">
			<input type ="hidden" name="ref" value="${dto.ref}">
			<input type ="hidden" name="lev" value="${dto.lev}">
			<input type ="hidden" name="step" value="${dto.step}">
			<input type ="hidden" name="num" value="${dto.num}">
			</td></tr>
			</c:if>
			<c:if test="${dto.num ==0 or dto ==null}">
			<tr><th style="width:30%">글제목</th><td><input type="text" class="chk" placeholder="입력하세요" size="50" name="subject"></td></tr>
			</c:if>
			<tr><th style="width:30%">글쓴이</th><td><input type="text" class="chk" placeholder="입력하세요" size="50" name="writer"></td></tr>
			<tr><th style="width:30%">글내용</th><td><textarea rows="15" class="chk" cols="50"  placeholder="입력하세요" name="content"></textarea></td></tr>
			<tr><th style="width:30%">이메일</th><td><input type="email" class="chk" placeholder="입력하세요" size="50" name="email"></td></tr>
			<tr><th style="width:30%">비밀번호</th><td><input type="password" class="chk" placeholder="입력하세요" size="50" name="passwd"></td></tr>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="2" style="text-align:center">
			<input type="button" id="submit1" value="글저장">
			<input type="button" value="글목록" onclick="javascript:location.href='list'">
			</td>
		</tr>
		</tfoot>
	</table>
</form>
</body>
</html>