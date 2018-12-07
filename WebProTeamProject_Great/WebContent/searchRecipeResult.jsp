<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!--scripts loaded here-->


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
	#myInput:focus {outline: 2px solid #ddd;}
		
	/* search 이미지 css */
	#search {
		width : 47px;
		height : 45px;
		padding : 0px;
		border: 0px;
	}	
	#searchBtn {
	    background-color: #FFF; 
	    color: white;
	    border: none;
	    /* border-left: 2px solid #ddd; */
	    cursor: pointer;
	    
	    width:47px;
	    height:46px;
	    background-image: url('img/searchIcon.PNG');
		background-position: 8px 7px;
	    background-size: 30px;
	    background-repeat: no-repeat;
	}
	
	
</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>

	<div align="center">
		<div id ="div1">
			<!-- text값 가지고 -->
			<form action="search.do">
				<div class="input-group mb-3">
					<span>
						<img alt="" src="img/cap.PNG" width="45px">
					</span>
      
					<input type="text" placeholder="Search..." id="myInput" name="search" value="${search }">
					<input type="hidden" name="command" value="search">
					<span id="search" class="btn btn-outline-secondary">
						<input type="submit" value="" id="searchBtn">
					</span>		        	
				</div>	
			</form>
		</div>	
	</div>

	
	<div class="container" align="center" width="1024px">
		
		
		
		<c:set var="rlistnum" value="0"/>
		<table>
		<tr>
		<td colspan="2" style=" padding:5px">
			<h2 align="left">검색 결과</h2></td>
		</tr>
		<c:forEach var="recipe" items="${rlist.list}">
		
			<c:if test="${(rlistnum % 2) ==0 }">
			<tr>
			</c:if>
				<td style=" padding:5px">
				<div class="card "   style="width: 500px; border:1px solid #e0e0e0; "  >
					<div class="row">
						<div class="col-sm-6" style="margin:0px; ">
							<img class="recipe_img_top" src="${recipe.imgurls}"
								alt="recipe_image" style="width: 250px; height: 250px; padding: 1px">
						</div>
						<div class="col-sm-6" style="width:200px;  padding:10px;" align="left">	
							<h5>레시피 이름 : <b class="recipe_title">${recipe.name }</b></h5><br>
							<h5>주 재료 : <b class="recipe_mainIngredient">${recipe.main_ingredients}</b></h5><br>
							<h5>설 명 : <br><b class="recipe_content">${recipe.descript}</b></h5><br>
							<a href="showrecipedetail.do?num=${recipe.num}" class="btn btn-warning">더보기</a>
						</div>
					</div>
				</div>
				</td>
			
			<c:if test="${(rlistnum%2) >0 }">
			
			</tr>
			</c:if>
			<c:set var="rlistnum" value="${rlistnum + 1}"/>
			</c:forEach>			
			</table>
		<br><br>
		
		<c:set var="rpb" value="${rlist.pagingBean}"></c:set>
		
		<ul class="pagination" style="margin:auto; padding : auto; align:center; text-align:center;">
			<c:if test="${rpb.previousPageGroup}">
		<li class="page-item"><a class="page-link" href="search.do?page=${rpb.startPageOfPageGroup-1}">
			<img src="img/left_arrow_btn.gif"></li>
		</a>
		</c:if>
		
		<c:forEach var="i" begin="${rpb.startPageOfPageGroup}"
			end="${rpb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${rpb.nowPage!=i}">
				<li class="page-item"><a class="page-link" href="search.do?page=${i}" style="font-size: 15px">${i}</a></li>
				</c:when>
				<c:otherwise>
				<li class="page-item"><a class="page-link" href="#" style="font-size: 15px">${i}</a></li>
				</c:otherwise>
				</c:choose>
				
				</c:forEach>
				<c:if test="${rpb.nextPageGroup}">
				<li class="page-item"><a class="page-link"href="search.do?page=${rpb.endPageOfPageGroup+1}">
			<img src="img/right_arrow_btn.gif">
		</a>
	</c:if>
			
		</ul>
	
	<table><tr>
		<c:forEach var="product" items="${plist.list}">
		<td style="padding:20px">
		<div >
			<div><a href="showProductDetail.do?name=${product.name}"><img class="recipe_img_top" src="${product.img_urls}"
								alt="recipe_image" style="width: 150px; height: 150px; padding: 1px"></a></div>
		<div	>
		<span style="color:#a0a0a0;font-size:1">${product.type }</span><br>
		<span style="font-size:1.2em">${product.name }</span><br>
		<span style="font-size:1em">${product.price}원</span><br>
		</div>
		</div>
		</td>
		</c:forEach>
		</tr>
	</table>
	
			
		</ul>
	
	
	</div>
	<br><br><br><br><br>
	
   <div class="container" align="center" >
      <div class="row" width="1024px"><div class="col-sm-1"></div>
         <div class="col-sm-6"width="600px" style="border-right:1px solid #c0c0c0;">
          
               
              	<table margin="0px">
              	<tr><td colspan=2><h2>추천 상품</h2></td></tr>
              	<tr>
              	<c:forEach var="hotp" items="${HotPlist}">
                     	<td style="width:150px; padding:10px"><a href="showProductDetail.do?name=${hotp.name}">
                           <img src="${hotp.img_urls }" width="150px"></a>
                             <div>
								<span style="color:#a0a0a0;font-size:1">${hotp.type }</span><br>
								<span style="font-size:1.2em">${hotp.name }</span><br>
								<span style="font-size:1em">${hotp.price}원</span><br>
							</div>
							
                        </td>
                     	</c:forEach>
              	
              	
              	</tr>
              	
              	</table>
                 	
                     
                     
             
                  </div>
              
            
         
         
         <div class="col-sm-5" width="400px">
            <div class="container text-center my-3" style="width: 450px">
               
               <table>
              	<tr><td colspan=2><h2 align="left">
                  HOT 상품<span class="badge badge-secondary">HOT</span>   </h2></td></tr>
              	<tr>
              	<c:forEach var="recommendp" items="${RecommendPlist}">
                     	<td style="width:150px; padding:10px"><a href="showProductDetail.do?name=${recommendp.name}">
                           <img src="${recommendp.img_urls }" width="150px"></a>
                             <div>
								<span style="color:#a0a0a0;font-size:1">${recommendp.type }</span><br>
								<span style="font-size:1.2em">${recommendp.name }</span><br>
								<span style="font-size:1em">${recommendp.price}원</span><br>
							</div>
							
                        </td>
                     	</c:forEach>
              	
              	
              	</tr>
              	
              	</table>

            </div>
         </div>
     
		</div>
   
      <br>  <br>  <br>  <br>


   <c:import url="footer.jsp"/>
</div>
</body>

</html>