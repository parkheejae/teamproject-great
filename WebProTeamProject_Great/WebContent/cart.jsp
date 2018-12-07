<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./slick/slick.css">
<link rel="stylesheet" type="text/css" href="./slick/slick-theme.css">



<style type="text/css">
.slider {
   width: 50%;
   margin: 100px auto;
}

.slick-slide {
   margin: 0px 20px;
}

.slick-slide img {
   width:195px;
   height: 195px;
   padding:40px;
}

.slick-prev:before, .slick-next:before {
   color: black;
}







table {
   color: white;
}
#table2 {
   color: black;
}


#carttitle {
   display: block;
   width: 1200px;
   text-align: left;
   clear: both;
   margin: auto;
}

#cartbtn {
   background-color: white;
   color: black;
   padding: 30px 30px;
   text-align: center;
   text-decoration: none;
   border: 2px double orange;
   border-radius: 10px;   
}
#cartbtn2 {
   background-color: white;
   color: black;
   padding: 30px 60px;
   text-align: center;
   text-decoration: none;
   border: 2px double orange;
   border-radius: 10px;   
}

#cartbtn:hover {
   background-color: orange;
   color: white;
}
#cartbtn2:hover {
   background-color: orange;
   color: white;
}

</style>
</head>
<body>

   <c:import url="header.jsp"></c:import>

   <h1 id="carttitle">
      <font color="black" size="15"><i
         class="glyphicon glyphicon-shopping-cart"></i> 장바구니</font>
   </h1>



   <c:choose>
      <c:when test="${cartSize==0}">
         <!-- 장바구니가 비었다면 -->
         <h1 align="center" id="carttitle">
            <font color="red">Cart에 담겨진 물건이 없습니다.</font>
         </h1>
      </c:when>
      <c:otherwise>
         <div class="cart">
            <form action="itemCartRemove.do" method="post" name="frm" id="frm">
               
               <table width="1200" align="center" border="1">
                  <tr align="center" bgcolor="orange" color="black">
                     <td>번호</td>
                     <td>상품이미지</td>
                     <td>상품명</td>
                     <td>상품가격</td>
                     <td>수량</td>
                     <td>배송비</td>

                     <td align="center"><input type="submit" value="삭제">
                     </td>
                  </tr>
                  
               </table>
               <table width="1200" align="center" border="1" id="table2">
                  <tr align="center" bgcolor="white">
                     <td style="width: 108px;"><h2>1</h2></td>
                     <td style="width: 262px;"><img alt="" src="img/product_main/ingrediant/bab.jpg" width="100px" height="110px"></td>
                     <td style="width: 159px;"><h2>밥</h2></td>
                     <td style="width: 211px;"><h2>2500</h2></td>
                     <td style="width: 108px;"><h2>1</h2></td>
                     <td style="width: 160px;"><h2>3000원</h2></td>

                     <td align="center"><input type="submit" value="삭제">
                     </td>
                  </tr>
                  
               </table>
               <table width="1200" align="center" border="1" id="table2">
                  <tr align="center" bgcolor="white">
                     <td style="width: 108px;"><h2>2</h2></td>
                     <td style="width: 262px;"><img alt="" src="img/product_main/ingrediant/kim.jpg" width="100px" height="110px"></td>
                     <td style="width: 159px;"><h2>김</h2></td>
                     <td style="width: 211px;"><h2>10000</h2></td>
                     <td style="width: 108px;"><h2>1</h2></td>
                     <td style="width: 160px;"><h2>3000원</h2></td>

                     <td align="center"><input type="submit" value="삭제">
                     </td>
                  </tr>
                  
               </table>
            </form>
         </div>

         <table width="1200" align="center" border="0">
            <tr align="center" bgcolor="orange">
               <td align="right"><font size="5" color="black">상품가격 12500원 + 배송비 3000원 = 총 결제금액 15,500원</font> <font
                  color="black" size=6>${sumMoney}</font></td>
            </tr>
         </table>
         
      </c:otherwise>
   </c:choose>
   <p>
      <br> <br> <br>
   </p>
   <table width="500" align="center">
      <tr>
         <td><h1>
               <a href="itemList.do" id="cartbtn"><strong>쇼핑 계속하기</strong></a>
            </h1></td>
         <td><h1>
               <a href="#" id="cartbtn2"><strong>구매하기</strong></a>
            </h1></td>
      </tr>
      </table>

   <p>
      <br> <br> <br> <br> <br> <br>
   </p>
   <p>
      <br> <br> <br> <br> <br> <br>
   </p>
   

   <p>
      <br> <br> <br> <br> <br> <br>
   </p>

  <h1 class="title" id="carttitle">HOT 추천</h1>
        <div class="slider lazy" role="toolbar" id="imageDiv">
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="img/product_main/ingrediant/bab.jpg"/>밥밥밥</a></div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="img/product_main/ingrediant/kim.jpg" />김김김</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="img/product_main/ingrediant/kimchi.jpg" />김치치치</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="img/product_main/ingrediant/memilmyun.jpg" />메밀면</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="img/product_main/ingrediant/somyun.jpg" />소면면</div>
            <div style="cursor:pointer" onclick = "window.location.href='#'"><img data-lazy="img/product_main/ingrediant/udongmyun.jpg" />우동면면</div>
            
        </div>






   <p>
      <br> <br> <br> <br> <br> <br>
   </p>

   <c:import url="footer.jsp"></c:import>
</body>

<script src="https://code.jquery.com/jquery-2.2.0.min.js"
   type="text/javascript"></script>
<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(document).on('ready', function() {
     
    
      $('.lazy').slick({
         lazyLoad: 'ondemand',
         slidesToShow: 5,
         slidesToScroll: 1
      });
    });
   
    
</script>
</html>