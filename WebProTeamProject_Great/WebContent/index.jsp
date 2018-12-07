<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>

   /* 검색창 top에서 부터 얼마나 떨어지는가 */
   #div1 {
      margin:300px auto auto auto;
      
      
      z-index: 1;
      position: relative;
      
      /* form 가운데 정렬 */
      display: inline-block;
        text-align: center;
   }
   /* logo와 검색창 사이 간격 */
   #logo {
      margin-bottom:40px;
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
   
   /* home 이미지 css */
   #home {
      width : 47px;
      height : 47px;
      padding : 0px;
      border: 0px;
   }   
   #homeBtn {
      background-color: #FFF; 
       width:47px;
       height:46px;
       border: none;
       background-image: url('img/homeIcon.PNG');
      background-position: 10px 10px;
       background-size: 25px;
       background-repeat: no-repeat;
   }
   
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
   
   /* 전체 이미지 */
   #index_image {
      position: fixed; 
      top: 0; 
      left: 0; 

      min-width: 100%;
      max-height: 100%;
   }

</style>
<title>그레잍 홈페이지에 오신것을 환영합니다.</title>
</head>
<body>
   <img alt="index_image" src="./img/index_image.JPG" id="index_image">
   <div align="center">
      <div id ="div1">
         <img alt="logo" src="img/logo.png" id="logo">
               
         <form action="search.do">
            <div class="input-group mb-3">
                <span id="home" class="btn btn-outline-secondary">
                   <!-- home 페이지 연결 -->
                    <a href="showmain.do"><input type="button" id="homeBtn"></a>
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
</body>
</html>