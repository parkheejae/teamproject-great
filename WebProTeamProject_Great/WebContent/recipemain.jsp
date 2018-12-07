<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>main페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">



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
   
   #recipe_ad {
      margin: 0px auto 50px auto;
   }
   #main_div1 {
      margin: 0px auto 30px auto;
      height: 250px;
   }
   #main_div2 {
      margin: 0px auto 50px auto;
      height: 250px;
   }
   #main_div3 {
      margin: 0px auto 50px auto;
      height: 300px;
   }
   #main_div1_div1{
      width:1024px;
   }
   
   #main_div2_div1{
      width:1024px;
   }
   #main_div3_div1{
      width:1024px;
   }
   #board {
      float:left;
      width:30%;
   }
   #board2 {
      float:left;
      width:30%;
   }
   #inMenu추천 {
      float:left;
      width:40%;
   }
   #hotMenu {
      float:right;
      width: 65%;
   }
   #hotMenu1 {
      float:right;
      width: 65%;
   }
   #hotMenu2 {
      float:right;
      width: 55%;
      height: 300px;
      border-left : 1px solid;
      padding-left: 30px;
   }
   .hotMenu1{
      width:100%;
      float:right;
      padding-left:15px;
   }
   
   #inMenu1{
      width:100%;
      float:right;
      padding-left : 30px;
   }
   
   #inMenu2{
      width:100%;
      float:right;
      padding-left : 30px;
   }
   .hotMenu2 {
      width: 150px;
      height: 130px;
      float:left;
      margin-right: 10px;
   }
   .hotMenu2 img{
      width: 150px;
      height: 130px;
      
   }

   #ingredient_ad{
      margin: 0px auto 50px auto;
   }
  
   ul.ultable{ 
      display: table; 
      clear: both;
      width: 300px;

      margin-bottom: 20px;
      border-spacing: 0;
      border-collapse: collapse;
      box-sizing: border-box;
      background-color: transparent;
      list-style: none;
      padding:0;
   }

   ul.ultable li ul {
      display: table; 
      clear: both;
      width: 300px;

      list-style: none;
      padding:0;
   }

   ul.ultable li ul li {   
      display:inline-block;      
      text-align: left;   
      display: table-cell;
      padding: 8px;
      line-height: 1.42857143;
   }

   ul.ultable li:first-child ul li { 
       font-weight: bold;
       border-bottom-width: 1px;
       border-top: 0;
       vertical-align: bottom;
      
   }
   ul.ultable-striped li ul:nth-child(2n) { background-color: #f9f9f9; }
   ul.ultable-bordered { border: 1px solid #ddd; }
   ul.ultable-bordered li ul li { border: 1px solid #ddd; }
   ul.ultable-hover li:last-child ul:hover { background-color: #f5f5f5}
   
   
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
   
   <div width="1024px" align="center">
     <c:import url="mainad.jsp"></c:import>
   </div>
   <br><br><br>
   <div id="main_div1" align="center">
      <div id="main_div1_div1" align="center">
         <div id="board">
            <div class="table-responsive">          
               <table class="table">
                  <thead>
                     <tr>
                        <th>공지사항</th>
                     </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="blist" items="${bvo }">
                     <tr>
                        <td>${blist.title }</td>
                        <td>${blist.register_date }</td>
                     </tr>
                     </c:forEach>
                    
                  </tbody>
               </table>
            </div>
         </div>
         
         <div id="hotMenu">
            <h3 align="left">오늘의 추천메뉴</h3><br>
            <div class="hotMenu1">
            <c:forEach var="rrvo" items="${RecommendRlist}">
               <div class="hotMenu2">
                  <a href="showrecipedetail.do?num=${rrvo.num}"><img alt="" src="${rrvo.imgurls}"><br><br>
                  <p>${rrvo.name}</p></a>
               </div>
               </c:forEach>
            </div>
         </div>
      </div>
   
   </div>
   <div id="main_div2" align="center">
      <div id="main_div2_div1" align="center">
         <div id="board2">
            <img src="./img/ad/adbox.jpg"art="광고판" width="300px">
         </div>
         
         <div id="hotMenu1">
            <h3 align="left">HOT 메뉴</h3><br>
            <div class="hotMenu1">
            <c:forEach var="hrvo" items="${HotRlist}">
               <div class="hotMenu2">
                  <a href="showrecipedetail.do?num=${hrvo.num}"><img alt="" src="${hrvo.imgurls}"><br><br>
                  <p>${hrvo.name}</p></a>
               </div>
               </c:forEach>
            </div>
         </div>

      </div>
   </div>
   <br><br>
     <div width="1024px" align="center">
     <c:import url="ad.jsp"></c:import>
   </div>
   
   <div id="main_div3" align="center">
      <div id="main_div3_div1" align="center">
         <div id="inMenu추천">
            <h3 align="left">추천 상품</h3><br>
            <div id="inMenu2">    
            <c:forEach var="rpvo" items="${RecommendPlist}">
               <div class="hotMenu2">
                  <a href="showproductdetail.do?name=${rpvo.name}"><img alt="" src="${rpvo.img_urls}"></a><br><br>
                  <p>이름 : ${rpvo.name}</p>
                  <p>가격 : ${rpvo.price}</p>
               </div>
               </c:forEach>
            </div>
         </div>
         
         <div id="hotMenu2">
            <h3 align="left">HOT 상품</h3><br>
            <div id="inMenu1">
            <c:forEach var="hpvo" items="${HotPlist}">
               <div class="hotMenu2">
                  <a href="showproductdetail.do?name=${hpvo.name}"><img alt="" src="${hpvo.img_urls}"></a><br><br>
                  <p>이름 : ${hpvo.name}</p>
                  <p>가격 : ${hpvo.price}</p>
               </div>
               </c:forEach>
            </div>
         </div>

      </div>
   </div>
   
 <c:import url="footer.jsp"></c:import>
   </div>
   
</body>
</html>