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
<hr>
사원별 고객리스트
<hr>
<ul>
	<c:forEach var="sawon" items="${ list }">
       <li>${ sawon.sabun }:${ sawon.saname }</li>	
       <ul>
          <c:forEach var="gogek" items="${ sawon.go_list }"> 
          	 <li>${ gogek.gobun }:${ gogek.goname }</li>
          </c:forEach>
       </ul>
	</c:forEach>
</ul>


</body>
</html>