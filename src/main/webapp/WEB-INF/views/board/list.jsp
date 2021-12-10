<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style type="text/css">
	* {margin : auto}
	table{ text-align:center;
	width:960px;
	border:1px solid gray;
	}
	td{padding:5px;
		border:1px solid gray;
	}
	th{
		padding :1px;
		border:1px solid gray;
	}
	h3{
		padding:1em;
		text-align:center;
	}
	a:link{color:black; text-decoration:none}
	a:visited{color:black; text-decoration:none}
	a:hover{color:black; text-decoration:none}
</style>
</head>
<body>
	<h3>게시글 목록</h3>
	<p></p>
	<p style="text-align:right; width:960px;">전체 게시글 수: &nbsp; ${pvo.allCount}</p>
	<p style="text-align:left; width:960px;"><input type="button" value="글쓰기" onclick="javascript:location.href='writeForm'"/>
	<table>
		<thead>
			<tr><td>번호</td><td>글제목</td><td>작성자</td><td>작성일자</td><td>아이피</td><td>조회수</td></tr>
		</thead>
		<tbody>
		<c:choose>
			<%--  <c:when test="${list != null}"> --%>
			<c:when test="${fn:length(list)>0}"> 
			<c:forEach var="dto" items="${list}">
			<tr>
			<td style="text-align:right; width:7% ">${dto.no}</td> 
			<td style="text-align:left; width:45% ">
			<c:choose>
				<c:when test="${dto.lev==0}">
				<img src="../images/level.gif" width="5px">
				</c:when>
				<c:when test="${dto.lev >0}">
				<img src="../images/level.gif" width="${dto.lev*10}px">
				<img src="../images/re.gif">
				</c:when>
			</c:choose>	
			<a href="content?num=${dto.num}&amp;currentPage=${pvo.currentPage}">${dto.subject}</a>
				<c:if test="${dto.readcount >= 9}"><img src="../images/hot.gif" width="30px"></c:if>
			</td> 
			<td><a href="mailto:${dto.email}">${dto.writer}</a></td> 
			<td>${dto.reg_date}</td> 
			<td>${dto.ip}</td> 
			<td style="text-align:right; width:9% ">${dto.readcount}</td>
			</tr>
			</c:forEach>
			</c:when>
			<c:otherwise>
			<tr>
				<td colspan="6">게시글이 없습니다.</td>
			</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" style="text-align:center">
				<c:forEach  var="i" begin="${1}" end="${pvo.pagAllCnt}" >
					<a href="list?currentPage=${i}">[${i}]</a>
				</c:forEach>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</body>
</body>
</html>