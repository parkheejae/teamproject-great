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

		<h2 align="left">검색 결과</h2>
		<ul class="mylist">
			<li>
				<div class="card" style="width: 600px; float:left;" >
					<div>
						<div style="margin:0px; float:left;">
							<img class="recipe_img_top" src="./img/recipe_main/감자탕.jpg"
								alt="recipe_image" style="width: 300px; height: 300px; padding: 1px">
						</div>
						<div style="width:295px; float:left; padding:10px;" align="left">	
							<h5>레시피 이름 : <b class="recipe_title">감자탕</b></h5><br>
							<h5>주 재료 : <b class="recipe_mainIngredient">돼지고기</b></h5><br>
							<h5>설 명 : <br><b class="recipe_content">이리보고 저리봐도 맛있는 감자탕~</b></h5><br>
							<a href="DispatcherServlet?command=showrecipedetail&&name=감자탕" class="btn btn-warning">더보기</a>
						</div>
					</div>
				</div>
			</li>			
			<li>
				<div class="card" style="width: 600px; float:left;" >
					<div>
						<div style="margin:0px; float:left;">
							<img class="recipe_img_top" src="./img/recipe_main/제육덮밥.jpg"
								alt="recipe_image" style="width: 300px; height: 300px; padding: 1px">
						</div>
						<div style="width:295px; float:left; padding:10px;" align="left">	
							<h5>레시피 이름 : <b class="recipe_title">제육덮밥</b></h5><br>
							<h5>주 재료 : <b class="recipe_mainIngredient">밥, 돼지고기</b></h5><br>
							<h5>설 명 : <br><b class="recipe_content">제육소스랑 밥 비벼먹으면 밥도둑</b></h5><br>
							<a href="#" class="btn btn-warning">더보기</a>
						</div>
					</div>
				</div>
			</li>
			<br><br>
			<!-- 2번째 줄 -->
			<li>
				<div class="card" style="width: 600px; float:left;" >
					<div>
						<div style="margin:0px; float:left;">
							<img class="recipe_img_top" src="./img/recipe_main/부대찌개.jpg"
								alt="recipe_image" style="width: 300px; height: 300px; padding: 1px">
						</div>
						<div style="width:295px; float:left; padding:10px;" align="left">	
							<h5>레시피 이름 : <i class="recipe_title">부대찌개</i></h5><br>
							<h5>주 재료 : <i class="recipe_mainIngredient">햄, 라면사리</i></h5><br>
							<h5>설 명 : <br><i class="recipe_content">국물에 밥말아먹으면 호로로록</i></h5><br>
							<a href="#" class="btn btn-warning">더보기</a>
						</div>
					</div>
				</div>
			</li>		
			<li>
				<div class="card" style="width: 600px; float:left;" >
					<div>
						<div style="margin:0px; float:left;">
							<img class="recipe_img_top" src="./img/recipe_main/닭볶음탕.jpg"
								alt="recipe_image" style="width: 300px; height: 300px; padding: 1px">
						</div>
						<div style="width:295px; float:left; padding:10px;" align="left">	
							<h5>레시피 이름 : <i class="recipe_title">닭볶음탕</i></h5><br>
							<h5>주 재료 : <i class="recipe_mainIngredient">닭고기, 양파</i></h5><br>
							<h5>설 명 : <br><i class="recipe_content">닭고기와 야채들의 조화가 Good!</i></h5><br>
							<a href="#" class="btn btn-warning">더보기</a>
						</div>
					</div>
				</div>
			</li>
		</ul>
		
		<ul class="pagination justify-content-center" style="margin: 20px 0">
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item active"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>
	</form>

   <div class="productform">
      <div class="row">
         <div class="col-xs-3">
            <div class="container text-center my-3" style="width: 400px">
               <h2>추천 상품</h2>
               <div class="row mx-auto my-auto">
                  <div id="recipeCarousel1" class="carousel slide w-100"
                     data-ride="carousel">
                     <div class="carousel-inner w-100" role="listbox">
                        <div class="carousel-item active">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/1.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/2.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/3.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/4.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/5.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/3.jpg">
                        </div>
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
         <div class="col-xs-9">
            <div class="container text-center my-3" style="width: 600px">
               <h2>
                  HOT 상품<span class="badge badge-secondary">HOT</span>
               </h2>
               <div class="row mx-auto my-auto">
                  <div id="recipeCarousel2" class="carousel slide w-100"
                     data-ride="carousel">
                     <div class="carousel-inner w-100" role="listbox">
                        <div class="carousel-item active">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/1.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/2.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/3.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/4.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/5.jpg">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/1.jpg">
                        </div>
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