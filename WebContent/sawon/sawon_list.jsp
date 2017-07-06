<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function find()
{
	var deptno = document.getElementById("deptno").value;
	
	location.href="list.do?deptno=" + deptno;
}

function find_job()
{
	var sajob = document.getElementById("sajob").value; 
	location.href="list_job.do?sajob=" + encodeURIComponent(sajob);
}


//현재 문서가 배치가 완료되면
window.onload = function(){
	
	var deptno = '${ param.deptno }';
	var select_deptno = document.getElementById("deptno");
	
	//방법1)
	/* if(deptno==0)
	   select_deptno[0].selected = true;
	else if(deptno==10)
 	   select_deptno[1].selected = true;
	else if(deptno==20)
	   select_deptno[2].selected = true;
	else if(deptno==30)
	   select_deptno[3].selected = true;
	else if(deptno==40)
	   select_deptno[4].selected = true; */
	   
	//방법2)            0  1  2  3  4
	var deptno_array = [0,10,20,30,40];
	for(var i=0;i<deptno_array.length;i++)
	{
		if(deptno ==  deptno_array[i]){
			select_deptno[i].selected = true;
			break;
		}
	}
	
	
	//직급선택설정
	var select_sajob = document.getElementById("sajob");
	var job_array = ["","부장","과장","대리","사원","알바"];
	var sajob = '${ param.sajob }';
	for(var i=0;i<job_array.length;i++){
		if(sajob==job_array[i]){
			select_sajob[i].selected = true;
			break;
		}
	}
	
	//검색된 급여정보 설정
	document.getElementById("start").value = 
		 "${ empty param.start ? 2000 :  param.start }";
	document.getElementById("end").value = 
		 "${ empty param.end ? 3000 : param.end }";
	
	
};

function find_sapay()
{
   var start = document.getElementById("start").value;
   var end   = document.getElementById("end").value;
   
   location.href=
	   "list_sapay.do?start="+start + "&end=" + end;
	
}

</script>

</head>
<body>

<div style="margin-left: 200px; ">
	부서번호:<select id="deptno">
				<option value="0">::::전체보기::::</option>
				<option value="10">10번부서</option>
				<option value="20">20번부서</option>
				<option value="30">30번부서</option>
				<option value="40">40번부서</option>
	         </select>
	         <input type="button" value="검색" 
	                onclick="find();">
	         <br>       
<!-- ########################## -->
     직급:<select id="sajob">
     			<option value="">::::전체보기::::</option>
     			<option value="부장">부장</option>
     			<option value="과장">과장</option>
     			<option value="대리">대리</option>
     			<option value="사원">사원</option>
     			<option value="알바">알바</option>
          </select> 
          <input type="button" value="검색" 
	                onclick="find_job();">
	                
<!-- ###################################### -->
      <br>
      <style>
         #start,#end{
            width: 60px;
         }
      </style>
      
      년봉:<input id="start" value="3000"> - 
           <input id="end" value="3500"> 
           <input type="button" value="검색" 
	                onclick="find_sapay();"> 	                
	                
</div>

<hr>
<table align="center"  border="1">
	<!-- 타이틀 -->
	<tr>
		<th>사번</th>
		<th>직위</th>
		<th>부서번호</th>
		<th>성별</th>
		<th>사원명</th>
		<th>입사일자</th>
		<th>상사번호</th>
		<th>년봉</th>
	</tr>
	
	<!-- Data출력 -->
	<!-- for(SawonVo vo : list) -->
	<c:forEach var="vo" items="${ list }">
		<tr>
            <td>${ vo.sabun }</td>
            <td>${ vo.sajob }</td>
            <td>${ vo.deptno }</td>
            <td>${ vo.sasex }</td>
            <td>${ vo.saname }</td>
            <td>${ vo.sahire }</td>
            <td>${ vo.samgr }</td>
            <td>${ vo.sapay }</td>		
		</tr>
	</c:forEach>
	
	
</table>



</body>
</html>




