<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>

<c:import url="header.jsp"></c:import>

<div class="container">
  <h2>후기에 대한 이야기!!</h2>
             
  <table class="table table-striped">
    <thead>
      <tr>
        <th>no</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성시간</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="review" items="${lvo.list}">
      <tr>
        <td>${review.no }</td>
        <td><a class="" style="color:black;" href="reviewdetail.do?no=${review.no}&&nowpage=${lvo.pagingBean.nowPage}">${review.title}</a></td>
        <td>${review.writer }</td>
        <td>${review.register_date }</td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
</div>
<c:set var="blist" value="${lvo.pagingBean}"></c:set>
	<c:if test="${blist.previousPageGroup}">
		<a
			href="reviewlist.do?page=${blist.startPageOfPageGroup-1}">
			<img src="img/left_arrow_btn.gif">
		</a>
	</c:if>
	<div style="text-align: center">
		<c:forEach var="i" begin="${blist.startPageOfPageGroup}"
			end="${blist.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${blist.nowPage!=i}">
					<a href="reviewlist.do?page=${i}" style="font-size: 15px">${i}</a>
				</c:when>
				<c:otherwise>
	${i}
	</c:otherwise>
			</c:choose>
	&nbsp;
	</c:forEach>
	</div>
	<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
		<a
			href="reviewlist.do?page=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">
			<img src="img/right_arrow_btn.gif">
		</a>
	</c:if>
</body>
</html>
