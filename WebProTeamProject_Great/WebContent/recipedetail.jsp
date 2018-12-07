<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
 #mainimg:hover{
  -webkit-transform:scale(1.2);
    -moz-transform:scale(1.2);
    -ms-transform:scale(1.2);   
    -o-transform:scale(1.2);
    transform:scale(1.2);
 }
</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>

	<div class="container" style="padding: 100px;">
		<!-- 메인 이미지, 레서피 상세정보 row입니다. -->
		<div class="row">
			<div class="col-sm-4">
				<!--${recipe.img_urls}에서 이미지 따와야함.-->
				<img id="mainimg" src="${rvo.imgurls}" class="rounded" alt="recipeimg"
					style="height: 350px; width: 100%; margin: auto; border: 5px solid orange">
			</div>
			<div class="col-sm-8" style="padding: 20px;">
				<H3>
					레서피 이름 : &nbsp;&nbsp;&nbsp; <b>${rvo.name}<%-- ${recipe.name} --%></b>
					<c:if test="${login.id ==rvo.writer }">
						<a class="btn btn-primary" href="deleterecipe.do?no=${rvo.num}" onclick="if(!confirm('정말 삭제하시겠습니까?')){return false}">삭제하기</a>
					</c:if>
				</H3>
				<hr color="orange">
				<table style="width: 100%; height: 250px">
					<tr>
						<td width="100px" height="5px"><b>주 재료 :</b></td>
						<td>${rvo.main_ingredients} <%-- ${recipe.main_ingredients} --%></td>
					</tr>
					<tr>
						<td><b>재료 :</b></td>
						<td>${rvo.sub_ingredients} <%-- ${recipe.sub_ingredients} --%>
						</td>
					</tr>
					<tr>
						<td><b>작성자 :</b></td>
						<td>${rvo.writer} <%-- ${recipe.writer} --%></td>
					</tr>
					<tr>
						<td><b>타입 :</b></td>
						<td>${rvo.type} <%-- ${recipe.type} --%></td>
					</tr>
					<tr>
						<td><b>설명 :</b></td>
						<td>${rvo.descript } <%-- ${recipe.descript} --%></td>
					</tr>
				</table>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br><br>
		<br>
		<div style="text-align: center">
			<h4> <b>- 조리 방법 -</b> </h4>
		</div>
		
		<!-- 조리방법이 나타날 공간입니다.  -->
		<div class="" style="">
			<div>
					<table align="center" >
			<c:forEach var="list" items="${dlist}" varStatus="status">
				
						<tr>
							<td>
							<br>
							<br>
								${status.count} .
							</td>
							<td>
							<br>
							<br>
								${list.discript}
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<br>
							<img src="${list.urls}" width="600" align="center"></td>
							
							<%-- ${list.img_urls} --%>
						</tr>
					
			</c:forEach> 
			<!-- 일단 틀만 잡아놓습니다. -->
			</table>
			</div>

		</div>
		
		<!-- 레시피 재료  -->
		<div style="padding-top: 80px; text-align: center">
		    <div>
			<h5> <b>레시피 재료</b> </h5>
		    </div>
		    ${rvo.main_ingredients}<br>
		    ${rvo.sub_ingredients}
			<!-- <table style="margin: auto;">
			<tr><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td></tr>
			<tr><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td><td><img src="img/pig.jpg" width="100%"></td></tr>
			</table> -->
			</div>
		
		
		
		
		<!-- tip -->
		<div class="row" style="background: lightgray; margin-top: 40px;">
		<div class="col-sm-2" style="margin:auto">
		<h2 style="padding: 15px; text-align: center;"><b>Tip</b></h2>
		</div>
		<div class="col-sm-10" style="margin:auto; padding : 15px">
		<p>${rvo.tip}<br></p><!--${recipe.tip}-->
		</div>
		</div>
		
		<!-- 레시피 관련 상품들 주재료나 재료에서 따오는?? -->
		
		<br><br><br><br><br>
		<div class="row">
		<div class="col-sm-10">
		 <h4>후기 게시판</h4>
		</div>
		<div class="col-sm-2" align="right">
			<button type="button" class="btn btn-primary" style="background-color:orange; border:0px;"
			onclick="window.open('write.jsp?about=${rvo.num}','후기 작성하기','width=1200px, height=600px,location=no,status=no,scrollbars=no')">
			후기 작성</button>
		</div>
		
		</div>
 	<hr color="orange" style="margin:0px;">
             
  <table class="table table-striped">
    <thead>
      <tr>
        <th width="30px">no</th>
        <th width="500px">제목</th>
        <th width="100px">작성자</th>
        <th width="100px">작성시간</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="review" items="${lvo.list}">
      <tr>
        <td>${review.no }</td>
        <td><a class="" style="color:black;" href="reviewdetail.do?no=${review.no}&&nowpage=${lvo.pagingBean.nowPage}&&about=re${rvo.num}">${review.title}</a></td>
        <td>${review.writer }</td>
        <td>${review.register_date }</td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>

<c:set var="blist" value="${lvo.pagingBean}"></c:set>
	<c:if test="${blist.previousPageGroup}">
		<a
			href="showrecipedetail.do?num=${rvo.num }&&page=${blist.startPageOfPageGroup-1}">
			<img src="img/left_arrow_btn.gif">
		</a>
	</c:if>
	<div style="text-align: center">
		<c:forEach var="i" begin="${blist.startPageOfPageGroup}"
			end="${blist.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${blist.nowPage!=i}">
					<a href="showrecipedetail.do?num=${rvo.num }&&page=${i}" style="font-size: 15px">${i}</a>
				</c:when>
				<c:otherwise>
	${i}
	</c:otherwise>
			</c:choose>
	&nbsp;
	</c:forEach>
	
	<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
		<a
			href="showrecipedetail.do?num=${rvo.num }&&page=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">
			<img src="img/right_arrow_btn.gif">
		</a>
	</c:if>
		</div>
		<br><br><br><br><br>
		<h6 style="margin-top: 40px"><b>레시피 상품</b></h6>
		<div class="row">
		<c:forEach var="list" items="${plist }">
		<div class="col-sm-3" style="text-align: center;">
		<a href="showProductDetail.do?name=${list.name}"><img src="${list.img_urls }" width="100%" height="200px"></a>
		<h6>제품명 : ${list.name }</h6>
		<h6>가격 : ${list.price }</h6>
		</div>
				
		</c:forEach>
		</div>
		
		<!-- 관련 레서피 -->
		
		<h6 style="margin-top: 40px"><b>관련 레서피</b></h6>
		<div class="row">
		<c:forEach var="list2" items="${llist }">
		<div class="col-sm-3" style="text-align: center;">
		
		<a href="showrecipedetail.do?num=${list2.num }"><img src="${list2.imgurls }" width="100%" height="200px"></a>
		<h6>${list2.name }</h6>
		</div>
				
		</c:forEach>
		</div>
	

	</div>
	<c:import url="footer.jsp"></c:import>


</body>
</html>