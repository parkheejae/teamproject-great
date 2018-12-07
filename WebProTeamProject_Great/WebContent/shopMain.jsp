<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<style type="text/css">
/* 검색창 top에서 부터 얼마나 떨어지는가 */
#div1 {
	z-index: 1;
	position: relative;
	margin: 50px auto 50px auto;
	/* form 가운데 정렬 */
	display: inline-block;
	text-align: center;
}
/* logo와 검색창 사이 간격 */
#logo {
	width: 80px;
	height: 40px;
}

/* 검색창 css */
#myInput {
	width: 500px;
	height: 46px;
	font-size: 16px;
	padding: 10px 20px 10px 10px;
	border: 1px solid #ddd;
}
/* 검색창 클릭시 css */
#myInput:focus {
	outline: 2px solid #ddd;
}

/* search 이미지 css */
#search {
	width: 47px;
	height: 45px;
	padding: 0px;
	border: 0px;
}

#searchBtn {
	background-color: #FFF;
	color: white;
	border: none;
	/* border-left: 2px solid #ddd; */
	cursor: pointer;
	width: 47px;
	height: 46px;
	background-image: url('img/searchIcon.PNG');
	background-position: 8px 7px;
	background-size: 30px;
	background-repeat: no-repeat;
}

.nav-tabs {
	margin-bottom: 0;
	background-color: orange;
	z-index: 9999;
	border: 0;
	font-size: 12px !important;
	line-height: 1.42857143 !important;
	letter-spacing: 4px;
	border-radius: 0;
	font-family: Montserrat, sans-serif;
}

.nav-tabs li a, .nav-tabs .navbar-brand {
	color: #fff !important;
}

.nav-tabs li a:hover, .nav-tabs li.active a {
	color: orange !important;
	background-color: #fff !important;
}

.nav-tabs .navbar-toggle {
	border-color: transparent;
	color: #fff !important;
}


</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div align="center">
      <div id ="div1">
         <!-- text값 가지고 -->
         <form action="#">
            <div class="input-group mb-3">
                <span>
                   <img alt="" src="img/cap.PNG" width="45px">
                 </span>
                 
                <input type="text" placeholder="Search.." id="myInput">
   
                 <span id="search" class="btn btn-outline-secondary">
                    <input type="submit" value="" id="searchBtn">
                 </span>                 
            </div>   
         </form>
      </div>   
   </div>
	<div class="container" align="center" width="1024px">
		<ul class="nav nav-tabs" text-align="center">
			<li class=""><a href="shopmain.do?type=채소">채소</a></li>
			<li><a href="shopmain.do?type=고기">고기</a></li>
			<li><a href="shopmain.do?type=소스류">소스류</a></li>
			<li><a href="shopmain.do?type=식재료">식재료</a></li>
		</ul>
		
	  <div id="recipe_ad" align="center">
      <img alt="" src="img/main_2.PNG" width="1024px" height="280px" style="padding :15px;">
      </div>

		<c:set var="tlistnum" value="0" />
		<table>
			<c:forEach var="tvo" items="${plist.list}">
				<c:if test="${(tlistnum % 2) == 0 }">
					<tr>
				</c:if>
				<td style="padding: 5px">
					<div class="card " style="width: 500px; border: 1px solid #e0e0e0;">
						<div class="row">
							<div class="col-sm-6" style="margin: 0px;">
								<img class="recipe_img_top" src="${tvo.img_urls}"
									alt="recipe_image"
									style="width: 250px; height: 250px; padding: 1px">
							</div>
							<div class="col-sm-6" style="width: 200px; padding: 10px;"
								align="left">
								<h5>
									상품 이름 : <b class="recipe_title">${tvo.name }</b>
								</h5>
								<br>
								<h5>
									가격 : <b class="recipe_mainIngredient">${tvo.price} 원</b>
								</h5>
								<br>
								<h5>
									설 명 : <br> <b class="recipe_content">${tvo.content} </b>
								</h5>
								<br> <a
									href="showProductDetail.do?name=${tvo.name}"
									class="btn btn-warning">더보기</a>
							</div>
						</div>
					</div>
				</td>

				<c:set var="tlistnum" value="${tlistnum + 1}" />
			</c:forEach>
		</table>
		<br>
		<c:set var="rpb" value="${plist.pagingBean}" />
		<ul class="pagination"
			style="margin: auto; padding: auto; align: center; text-align: center;">
			<c:if test="${rpb.previousPageGroup}">
				<li class="page-item">
					<a class="page-link" href="shopmain.do?type=채소&page=${rpb.startPageOfPageGroup-1}">
					<img src="img/left_arrow_btn.gif">
					</a>
				</li>
				
			</c:if>

			<c:forEach var="i" begin="${rpb.startPageOfPageGroup}"
				end="${rpb.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${rpb.nowPage!=i}">
						<li class="page-item"><a class="page-link"
							href="shopmain.do?type=채소&pageNo=${i}" style="font-size: 15px; color: #ff9c34">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href=""
							style="font-size: 15px; color: #ff9c34">${i}</a></li>
					</c:otherwise>
				</c:choose>

			</c:forEach>
			<c:if test="${rpb.nextPageGroup}">
				<li class="page-item">
					<a class="page-link" href="shopmain.do?type=채소&page=${rpb.endPageOfPageGroup+1}">
						<img src="img/right_arrow_btn.gif">
					</a>
				</li>
			</c:if>

		</ul>
	</div>
	
	
	<div class="container" align="center">
		<c:import url="ad.jsp"></c:import>
	</div>
  
 <div class="container" align="center" style="margin-bottom: 50px;">
		<div class="row">
			<div class="col-xs-6" style="border-right: 1px solid #c0c0c0;">
				<table>
					<tr>
						<td colspan=2><h3>추천 레시피</h3></td>
					</tr>
					<tr>
						<c:forEach var="rr" items="${RecommendRlist}" begin="1" end="3">
							<td style="width: 150px; padding: 10px"><a
								href="showrecipedetail.do?num=${rr.num}"> <img
									src="${rr.imgurls}" width="150px" height="150px"></a>
								<div>
									<span style="color: #a0a0a0; font-size: 1">${rr.type }</span><br>
									<span style="font-size: 1.2em">${rr.name }</span><br> 
								</div></td>
						</c:forEach>
					</tr>
				</table>
			</div>
			
			<div class="col-xs-6">
				<div class="container text-center my-3" style="width: 450px; margin-left: 30px;">
					<table>
						<tr>
							<td colspan=2>
								<h3 align="left">
									<span class="badge badge-secondary" style="background: red; font-size: 23px">HOT</span> 레시피
								</h3>
							</td>
						</tr>
						<tr>
							<c:forEach var="hotr" items="${HotRlist}" begin="1" end="3">
								<td style="width: 150px; padding: 10px"><a
									href="showrecipedetail.do?num=${hotr.num}"> <img
										src="${hotr.imgurls }" width="150px" height="150px"></a>
									<div>
										<span style="color: #a0a0a0; font-size: 1">${hotr.type }</span><br>
										<span style="font-size: 1.2em">${hotr.name }</span><br>
									</div></td>
							</c:forEach>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<c:import url="footer.jsp"/>
</body>
</html>