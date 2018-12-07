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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
<style type="text/css">
.slider {
   width: 50%;
   margin: 100px auto;
}
.slick-slide {
   margin: 0px 20px;
}
.slick-slide img {
   width: 100%;
}
.slick-prev:before, .slick-next:before {
   color: black;
}
.slick-current {
   opacity: 1;
}
table {
   
}
h1 {
   display: block;
   width: 1200px;
   text-align: left;
   clear: both;
   margin: auto;
}
#cartbtn {
   background-color: white;
   color: orange;
   padding: 10px 10px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   border-radius: 10px;
}
#cartbtn:hover {
   background-color: orange;
   color: white;
}
</style>

<script type="text/javascript">

	function checkUpQty(name){
		location.href = "itemCartQtyUp.do?name="+ name;
	}
	function checkDownQty(name, qty){
		if(qty != 1){
			location.href = "itemCartQtyDown.do?name="+ name;
		}
		else
			return;
	}
	
	function purchase(){
		var frm = document.frm;
		frm.method = "post";
		frm.submit();
		
	}
	
	function deleteItem(){
		var frm = document.frm;
		frm.method = "post";
		frm.action = "itemDelete.do";
		frm.submit();
		
	}

	function deleteItem(name){
		location.href = "itemDelete.do?name="+name;
	}
	$(function() {
		$('input[name=allCheck]').change(function() {
			var flag = $(this).prop('checked');
			
			$('input[name=delete]').prop('checked',flag);
		});//change
	});
</script>

</head>
<body>
   <c:import url="header.jsp"></c:import>
   <div align="center" style="margin: 30px auto 30px auto; width: 1020px">
	   <h1 >
	      <font color="black" size="15"><i
	         class="glyphicon glyphicon-shopping-cart"></i> 장바구니</font>
	   </h1>
   </div>
   <br><br>
   <form action="Purchase.do" method="post" name="frm" id="frm">
	   <c:choose>
	      <c:when test="${cartSize == 0}">
	         <!-- 장바구니가 비었다면 -->
	         <h2 align="center">
	            <font color="red">Cart에 담겨진 물건이 없습니다.</font>
	         </h2>
	      </c:when>
	      <c:otherwise>
	      
	         <div class="cart">
	            <input type="hidden" name="command" value="ItemCartD">
	            <div class="table-responsive" style="width:1024px; margin:0 auto 0 auto" >          
               <table class="table" align="center" width="70%">
                  <thead>
                     <tr align="center">
                        <th style="text-align: center">번호</th>
                        <th style="text-align: center">상품 이미지</th>
                        <th style="text-align: center">상품 명</th>
                        <th style="text-align: center">상품 가격</th>
                        <th style="text-align: center">수량</th>
                        <th style="text-align: center">전체체크&nbsp;&nbsp;<input type="checkbox" name="allCheck" width="18" height="18"></th>
                        <th style="text-align: center">삭제</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="cartList" items="${cartList}" varStatus="i">
	                     <tr align="center">
	                        <td style="text-align: center; vertical-align: middle;">${i.count}</td>
	                        <td style="text-align: center; vertical-align: middle;"><img src="${cartList.img_urls}" alt="" width="70"
	                           height="70"></td>
	                        <td style="text-align: center; vertical-align: middle;">${cartList.name}</td>
	                        <td style="text-align: center; vertical-align: middle;">${cartList.price} 원</td>
	                        <td style="text-align: center; vertical-align: middle;">
	                        	<a href="javascript:checkUpQty('${cartList.name}')">
	                        		<img id="plus" alt="1증가" src="img/up_1.PNG" width="15" height="15" border="0">
	                        	</a>
								<br>
								${cartList.quantity}
								<br>
								<a href="javascript:checkDownQty('${cartList.name}',${cartList.quantity})">
									<img id="minus" alt="1감소" src="img/down_1.PNG" width="15" height="15" border="0">
	                            </a> 
	                        </td>
	                        <td style="text-align: center; vertical-align: middle;">
	                        	<input type="checkbox" name="delete" value="${cartList.name}">
	                        </td>
	                        <td style="text-align: center; vertical-align: middle;">
	                        	<%-- <input type="button" value="삭제" onclick="deleteItem('${cartList.name}')"> --%>
	                        	<img alt="delete" src="img/delete.JPG" onclick="deleteItem('${cartList.name}')" width="20" height="20">
	                        	<input type="hidden" id="itemD" name="itemD" value="${cartList.name}">
	                        </td>
	                     </tr>
	                  </c:forEach>
                  </tbody>
               </table>
            </div>

	            
	         </div>
	         <table width="1020" align="center" border="0">
	            <tr align="center" bgcolor="orange">
	               <td align="right"><font size="5" color="#666666">총 결제금액 : ${sumMoney} 원</font></td>
	            </tr>
	         </table>
	      </c:otherwise>
	   </c:choose>

	   <div style="width:1020px; margin:0 auto 0 auto">
		   <table style="width:400px; align:right; margin:0 auto 0 auto; float: right;" >
		      <tr>
		         <td style="text-align: right; vertical-align: middle; width: 200px"><h3>
		               <a href="shopmain.do?type=채소" id="cartbtn">쇼핑 계속하기</a>
		            </h3></td>
		         <td style="text-align: right; vertical-align: middle; width: 150px"><h3>
		               <a href="javascript:purchase()" id="cartbtn">구매하기</a>
		            </h3></td>
	
		      </tr>
		   </table>
	   </div>
   </form>
   
	<div style="margin: 200px auto 50px auto; "align="center">
		<img alt="" src="img/delivery_notice.jpg">
	</div>

	<c:import url="footer.jsp"/>


</body>

</html>


<%-- 	               <table width="1200" align="center" border="1">
	                  <tr align="center" bgcolor="orange">
	                     <td>번호</td>
	                     <td>상품이미지</td>
	                     <td>상품명</td>
	                     <td>상품가격</td>
	                     <td>수량</td>
	                     <td align="center"><input type="button" value="삭제" onclick="deleteItem()">
	                     </td>
	                  </tr>

	                  <c:forEach var="cartList" items="${cartList}" varStatus="i">
	                     <tr align="center">
	                        <td>${i.count}</td>
	                        <td><img src="${cartList.img_urls}" alt="" width="70"
	                           height="70"></td>
	                        <td>${cartList.name}</td>
	                        <td>${cartList.price}</td>
	                        <td>
	                        	<a href="javascript:checkUpQty('${cartList.name}')">
	                        		<img id="plus" alt="1증가" src="img/up.jpg" width="15" height="15" border="0">
	                        	</a>
								<br>
								${cartList.quantity}
								<br>
								<a href="javascript:checkDownQty('${cartList.name}',${cartList.quantity})">
									<img id="minus" alt="1감소" src="img/down.jpg" width="15" height="15" border="0">
	                            </a> 
	                        </td>
	                        <td align="center"><input type="checkbox" name="delete" value="${cartList.name}"></td>
	                     </tr>
	                  </c:forEach>
	               </table> --%>