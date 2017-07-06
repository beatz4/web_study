<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center" border="1">
	<caption>::::고객목록::::</caption>
	<tr>
		<th>고객번호</th>
		<th>고객명</th>
		<th>주소</th>
		<th>주민번호</th>
		<th>고객담당사원번호</th>
	</tr>
	
	<c:forEach var="vo"  items="${ list }">
		<tr>
			<td>${ vo.gobun }</td>
			<td>${ vo.name }</td>
			<td>${ vo.goaddr }</td>
			<td>${ vo.gojumin }</td>
			<td>${ vo.godam }</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>