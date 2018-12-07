<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">

</style>
</head>
<body>
   <c:import url="header.jsp"></c:import>
   <div class="container">
      <h2>
           주문 내역
      </h2>
      <br>
      <div class="panel-group">
      <c:forEach  var="purchaseInfo" items="${purchaseInfo}">
         <div class="panel panel-warning">
            <div class="panel-heading">
               ${purchaseInfo.date}
            </div>
            <div class="panel-body">
               <div class="col-sm-3">
                  <!-- <img src="./img/vegetable/dubu.jpg" class="rounded"
                     style="height: 150px; width: 150px; margin: auto; border: 5px solid orange"> -->
                  <img src="${purchaseInfo.img_urls}" class="rounded" alt="상품사진"
                     style="height: 150px; width: 100%; margin: auto; border: 5px solid orange">
               </div>

               <div class="col-sm-5" style="padding: 20px;">
                  <br>
                  <table style="width: 100%; height: 100px">
                     <tr>
                        <td><b>배송 완료 <!-- 배송 상태 --> </b></td>
                        <%-- <td>${purchaseInfo.status}</td> --%>
                     </tr>
                     <tr>
                        <td>${purchaseInfo.proname}</td>
                     </tr>
                     <tr>
                        <td>${purchaseInfo.proprice} 원 / ${purchaseInfo.proamount} 개 </td>
                     </tr>
                     <tr>
                        <td>${purchaseInfo.delivery_date}</td>
                     </tr>
                  </table>
               </div>
               <div id="btn" class="col-sm-3"   style="text-align: right;">
                  <button type="button" class="btn btn-warning btn-sm" style="margin-top: 10px;">배송 조회</button>
                  <br>
                  <button type="button" class="btn btn-warning btn-sm" style="margin-top: 10px;">교환 신청</button>
                  <br>
                  <button type="button" class="btn btn-warning btn-sm" style="margin-top: 10px;">반품 신청</button>
                  <br>
                  <button type="button" class="btn btn-warning btn-sm" style="margin-top: 10px;">후기 쓰기</button>
                  <br>
               </div>
            </div>
         </div>
         </c:forEach>
         
         </div>
         </div>
         <div align="center">
            <ul class="pagination">
               <li><a href="#">Pre</a></li>
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li><a href="#">Next</a></li>
            </ul>
         </div>
</body>
</html>
