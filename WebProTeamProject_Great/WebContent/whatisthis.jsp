<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>



<style type="text/css">
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

.productform {
   display: block;
   width: 1200px;
   text-align: center;
   align: center;
   clear: both;
   margin: auto;
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
ul.mylist2 li, ol.mylist li {
   display: inline-block;
   padding: 10px;
   margin-bottom: 5px;
   
   font-size: 12px;
   cursor: pointer;
}
</style>
</head>
<body>
   <c:import url="header.jsp"></c:import>


   <div class="container" style="padding: 100px">
      <div class="container">
         <form>
            <div class="row">
               <div class="col-md-2" style="text-align: right">
                  <img src="./img/logo_cap.png" height="50px"> <img
                     src="./img/logo_fork.png" height="50px">
               </div>

               <div class="col-md-10">

                  <div class="input-group mb-2" width="50%">
                     <input type="text" class="form-control" placeholder="그레잇!"
                        aria-label="Recipient's username"
                        aria-describedby="button-addon2">
                     <div class="input-group-append">
                        <button class="btn" style="background-color: orange"
                           type="button" id="button-addon2">Search</button>
                     </div>
                  </div>
               </div>
            </div>
         </form>
      </div>



   </div>

   <div class="productform">
      <div class="row">
         <div class="col-xs-3">
            <div class="container text-center my-3" style="width: 400px">
               <h2>계절 상품</h2>
               <div class="row mx-auto my-auto">
                  <div id="recipeCarousel1" class="carousel slide w-100" data-ride="carousel">
                     <div class="carousel-inner w-100" role="listbox">
                        <div class="row item active">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/vegetable/buchu.jpg" width ="100px">
                       
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/vegetable/dubu.jpg" width ="100px">
                        </div>
                        <div class="row item">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/vegetable/gochu.jpg" width ="100px">
                        
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/vegetable/gamja.jpg" width ="100px">
                        </div>
                        <div class="row item">
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/vegetable/songi.jpg" width ="100px">
                       
                           <img class="d-block col-6 img-fluid"
                              src="img/product_main/vegetable/gochu.jpg" width ="100px">
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
               <h2>HOT 상품</h2>
               <div class="row mx-auto my-auto">
                  <div id="recipeCarousel2" class="carousel slide w-100"
                     data-ride="carousel">
                     <div class="carousel-inner w-100" role="listbox">
                        <div class="carousel-item active">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/vegetable/buchu.jpg" width ="100px">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/vegetable/dubu.jpg" width ="100px">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/vegetable/gochu.jpg" width ="100px">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/vegetable/gamja.jpg" width ="100px">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/vegetable/songi.jpg" width ="100px">
                        </div>
                        <div class="carousel-item">
                           <img class="d-block col-4 img-fluid"
                              src="img/product_main/vegetable/buchu.jpg" width ="100px">
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
   
   <p>
      <br> <br> <br> <br> <br> <br> <br>
   </p>
   <p>
      <br> <br> <br> <br> <br> <br> <br>
   </p>

   <c:import url="footer.jsp"></c:import>



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
</script>

<!--scripts loaded here-->

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
   src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>



<script>
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