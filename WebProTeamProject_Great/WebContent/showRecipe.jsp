<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!--scripts loaded here-->

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


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
   
   .carousel-inner .carousel-item.active, .carousel-inner .carousel-item-next,
      .carousel-inner .carousel-item-prev {
      display: flex;
   }
   
   .carousel-inner .carousel-item-right.active, .carousel-inner .carousel-item-next
      {
      transform: translateX(25%);
   }
   
   .carousel-inner .carousel-item-left.active, .carousel-inner .carousel-item-prev
      {
      transform: translateX(-25%);
   }
   
   .carousel-inner .carousel-item-right, .carousel-inner .carousel-item-left
      {
      transform: translateX(0);
   }
   
   #box {
      border-right: 2px solid orange;
   }
   
   .slide-image {
      width: 100%;
   }
   
   .list-group-horizontal .list-group-item {
      display: inline-block;
   }
   
   .list-group-horizontal .list-group-item {
      margin-bottom: 0;
      margin-left: -4px;
      margin-right: 0;
   }
   
   .list-group-horizontal .list-group-item:first-child {
      border-top-right-radius: 0;
      border-bottom-left-radius: 4px;
   }
   
   .list-group-horizontal .list-group-item:last-child {
      border-top-right-radius: 4px;
      border-bottom-left-radius: 0;
   }
   
   .carousel-holder {
      margin-bottom: 30px;
   }
   
   .carousel-control, .item {
      border-radius: 4px;
   }
   
   .caption {
      height: 130px;
      overflow: hidden;
   }
   
   .caption h4 {
      white-space: nowrap;
   }
   
   .thumbnail img {
      width: 100%;
   }
   
   .ratings {
      padding-right: 10px;
      padding-left: 10px;
      color: #d17581;
   }
   
   .thumbnail {
      padding: 0;
   }
   
   .thumbnail .caption-full {
      padding: 9px;
      color: #333;
   }
   
   footer {
      margin: 50px 0;
   }
   
   ul.mylist, ol.mylist {
      list-style: none;
      margin: 0px;
      padding: 0px;
      max-width: 100%;
      width: 100%;
   }
   
   ul.mylist li, ol.mylist li {
      display: inline-block;
      padding: 10px;
      margin-bottom: 5px;
      border: 1px solid #efefef;
      font-size: 12px;
      cursor: pointer;
   }
   
   .pagination {
      display: block;
      width: 100%;
      text-align: center;
      clear: both;
   }
   
   .productform {
      display: block;
      width: 1300px;
      text-align: center;
      align: center;
      clear: both;
      margin: auto;
   }
</style>
</head>
<body>
   <c:import url="header.jsp"></c:import>

   <div align="center">
      <div id ="div1">
         <!-- text값 가지고 -->
         <form action="DispatcherServlet">
            <div class="input-group mb-3">
               <span>
                  <img alt="" src="img/cap.PNG" width="45px">
               </span>
      
               <input type="text" placeholder="Search..." id="myInput" name="search">
               <input type="hidden" name="command" value="search">
               <span id="search" class="btn btn-outline-secondary">
                  <input type="submit" value="" id="searchBtn">
               </span>                 
            </div>   
         </form>
      </div>   
   </div>

   <form method="post">
   <div class="productform">

      <ul class="mylist">
      <c:forEach items="${requestScope.rlvo.list}" var="rvo">
         <li>
            <div class="card" style="width: 600px; float:left;" >
               <div>
                  <div style="margin:0px; float:left;">
                     <img class="recipe_img_top" src="${rvo.imgurls}"
                        alt="recipe_image" style="width: 300px; height: 300px; padding: 1px">
                  </div>
                  <div style="width:295px; float:left; padding:10px;" align="left">   
                     <h5>레시피 이름 : <b class="recipe_title">${rvo.name}</b></h5><br>
                     <h5>주 재료 : <b class="recipe_mainIngredient">${rvo.main_ingredientents}</b></h5><br>
                     <h5>설 명 : <br><b class="recipe_content">${rvo.descript}</b></h5><br>
                     <a href="DispatcherServlet?command=showrecipedetail&&num=${rvo.num}" class="btn btn-warning">더보기</a>
                  </div>
               </div>
            </div>
         </li>  
         </c:forEach>       
         <br><br>
      </ul>
      
      <c:set var="pb" value="${requestScope.rlvo.pagingBean}"></c:set>

	<c:if test="${pb.previousPageGroup}">
	<a href="DispatcherServlet?command=recipes&pageNo=${pb.startPageOfPageGroup-1}">
	<img src="img/left_arrow_btn.png"></a>	
	</c:if>
	
	<ul class="pagination justify-content-center" style="margin: 20px 0">	
	<c:forEach var="i" begin="${pb.startPageOfPageGroup}" 
	end="${pb.endPageOfPageGroup}">
	
	
	<c:choose>
	
	<c:when test="${pb.nowPage!=i}">
	
         <li class="page-item"><a class="page-link" href="DispatcherServlet?command=recipes&pageNo=${i}">${i}</a></li>
    
	</c:when>
	
	<c:otherwise>
	${i}
	</c:otherwise>
	</c:choose>
	
	&nbsp;
	</c:forEach>
	</ul>	 


	<c:if test="${requestScope.plvo.pagingBean.nextPageGroup}">
	<a href="DispatcherServlet?command=recipes&pageNo=${requestScope.plvo.pagingBean.endPageOfPageGroup+1}">
	<img src="img/right_arrow_btn.png"></a>
	</c:if>
      
   </div>
   </form>
   
   <div id="recipe_ad" align="center">
      <img alt="" src="img/main_2.PNG" width="1280px" height="280px">
   </div>

   <div class="productform">
      <div class="row">
         <div class="col-xs-6">
            <div class="container text-center my-3" style="width: 600px">
               <h2>추천 상품</h2>
               <p><p>
               <div class="row mx-auto my-auto">
                  <div id="recipeCarousel1" class="carousel slide w-100"
                     data-ride="carousel">
                     
                     <div class="carousel-inner w-100" role="listbox">
                        <div class="carousel-item active">
                           <img class=""
                              src="">
                     </div>
                        <c:forEach var="rpvo" items="${rplist}">
                        <div class="carousel-item">
                           <a href="DispatcherServlet?command=showproductdetail&&name=${rpvo.name}"><img class="" 
                              src="${rpvo.img_urls}" style="width:300px">
                           </a>
                        </div>
                        </c:forEach>
                        
                     </div>
                     <a class="carousel-control-prev" href="#recipeCarousel1"
                        role="button" data-slide="prev"> <span
                        class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                        class="sr-only">Previous</span>
                     </a> <a class="carousel-control-next" href="#recipeCarousel1"
                        role="button" data-slide="next"> <span
                        class="carousel-control-next-icon" aria-hidden="true"></span> <span
                        class="sr-only">Next</span>
                     </a>
                  </div>
               </div>
            </div>
         </div>
         <hr style="width: 1px;"></hr>
         <div id="box"></div>
         <hr style="width: 1px;"></hr>
         <table>

         </table>
         <div class="col-xs-6">
            <div class="container text-center my-3" style="width: 600px">
               <h2>
                  HOT 상품 &nbsp;&nbsp;<span class="badge badge-secondary" style="background: red;"> HOT </span>
               </h2>
               <p><p>
               <div class="row mx-auto my-auto">
                  <div id="recipeCarousel2" class="carousel slide w-100"
                     data-ride="carousel">
                     <div class="carousel-inner w-100" role="listbox">
                     <div class="carousel-item active">
                           <img class=""
                              src="">
                     </div>
                        <c:forEach var="hpvo" items="${hplist}">
                        <div class="carousel-item">
                           <a href="DispatcherServlet?command=showproductdetail&&name=${hpvo.name}"><img class="" alt="" src="${hpvo.img_urls}" style="width: 300px"></a>
                        </div>
                        </c:forEach>
                        
                     </div>
                     <a class="carousel-control-prev" href="#recipeCarousel2"
                        role="button" data-slide="prev"> <span
                        class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                        class="sr-only">Previous</span>
                     </a> <a class="carousel-control-next" href="#recipeCarousel2"
                        role="button" data-slide="next"> <span
                        class="carousel-control-next-icon" aria-hidden="true"></span> <span
                        class="sr-only">Next</span>
                     </a>
                  </div>
               </div>

            </div>
         </div>
      </div>
   </div>
   <p>
      <br>
   </p>

   <c:import url="footer.jsp"/>

</body>

<script>
   // sandbox disable popups
   if (window.self !== window.top && window.name != "view1") {
      ;
      window.alert = function() {/*disable alert*/
      };
      window.confirm = function() {/*disable confirm*/
      };
      window.prompt = function() {/*disable prompt*/
      };
      window.open = function() {/*disable open*/
      };
   }

   // prevent href=# click jump
   document.addEventListener("DOMContentLoaded", function() {
      var links = document.getElementsByTagName("A");
      for (var i = 0; i < links.length; i++) {
         if (links[i].href.indexOf('#') != -1) {
            links[i].addEventListener("click", function(e) {
               console.debug("prevent href=# click");
               if (this.hash) {
                  if (this.hash == "#") {
                     e.preventDefault();
                     return false;
                  } else {
                     /*
                     var el = document.getElementById(this.hash.replace(/#/, ""));
                     if (el) {
                       el.scrollIntoView(true);
                     }
                      */
                  }
               }
               return false;
            })
         }
      }
   }, false);

   $('.carousel .carousel-item').each(function() {
      var next = $(this).next();
      if (!next.length) {
         next = $(this).siblings(':first');
      }
      next.children(':first-child').clone().appendTo($(this));

      for (var i = 0; i < 3; i++) {
         next = next.next();
         if (!next.length) {
            next = $(this).siblings(':first');
         }

         next.children(':first-child').clone().appendTo($(this));
      }
   });
</script>
</html>