<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function review() {
	location.href="reviewlist.do?page=${page}";
	
}

function recipe() {
	if(window.opener!=null){
	window.opener.location.href="showrecipedetail.do?num=${about}&page=1";
	window.close();
	}else{
		location.href="showrecipedetail.do?num=${about}&page=1";
	}
}

function product() {
	if(window.opener!=null){
	window.opener.location.href="showProductDetail.do?name=${about}&page=1";
	window.close();
	}
	location.href="showProductDetail.do?name=${about}&page=1";
}

</script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container" align="center">
<table cellpadding="5">
<tr>
	<td>
		<table width="550" text-align="center">
			<tr>
				<td>No. : ${rvo.no}
				<hr style="color: #6691BC; border-style: dotted; margin: 0">
				 	   작 성 자 : ${requestScope.rvo.writer}
				<hr style="color: #6691BC; border-style: dotted; margin: 0">		
				    제    목 : ${requestScope.rvo.title}
				<hr style="color: #6691BC; border-style: dotted; margin: 0">	
				    작성일시 : ${requestScope.rvo.register_date}	 
				   &nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<hr style="color: #6691BC; margin: 0">
					<c:forEach var="url" items="${urls }">
					<img src ="${url}" width="300px" height="300px">
					</c:forEach>
					<pre>${requestScope.rvo.content}</pre>
				</td>
			</tr>
			<tr>
				<td valign="middle">
				<c:choose>
					<c:when test="${cat =='review' }">
					<button type="button" class="btn btn-primary" style="background-color:orange; border:0px"
					onclick = "review()">목록으로 돌아가기</button>
					
					</c:when>
					<c:when test="${cat =='re' }">
					<button type="button" class="btn btn-primary" style="background-color:orange; border:0px"
					onclick = "recipe()">목록으로 돌아가기</button>
					
					</c:when>
					<c:when test="${cat =='pro' }">
					<button type="button" class="btn btn-primary" style="background-color:orange; border:0px"
					onclick = "product()">목록으로 돌아가기</button>
					
					</c:when>
				
				</c:choose>
				
				</td>			
			</tr>
		</table>
	</td>
</tr>
</table>
</div>
</body>
</html>
















