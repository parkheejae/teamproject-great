<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>


<style type="text/css">

</style>

<script type="text/javascript">
		
	function cart(){
		var login = "<c:out value='${login}'/>";
		if(login==""){
				alert('잘못된 접근입니다. 로그인하고 이용해 주세요');
	  			location.href = "loginForm.jsp";
	  	}else if(login!=""){
			var frm = document.cartFrm;
			var conf = confirm('장바구니로 이동하시겠습니까?');
			if(conf){
			location.href = "itemAdd.do?name=${product.name}&confirm=true";}
			else{
			location.href = "itemAdd.do?name=${product.name}&confirm=false";}
			}
		}
	
	function buy(){
			var login = "<c:out value='${login}'/>";
	  		if(login==""){
	  			alert('잘못된 접근입니다. 로그인하고 이용해 주세요');
	  			location.href = "loginForm.jsp";
	  		}
		
			
		var conf = confirm('바로 구매하시겠습니까?');
		if(conf)
		location.href = "FastPurchase.do?name=${product.name}";
	
	}

    	
</script>
</head>
<body>

   <c:import url="header.jsp"></c:import>
   <div class="container">
      <div class="row">
      <form action="itemAdd.do?name=${product.name}" name="cartFrm">
         <div class="col-sm-4">
            <img src="${product.img_urls}" 
               class="rounded" alt="상품사진"
               style="height: 350px; width: 100%; margin: auto; border: 5px solid orange">
         </div>
         <div class="col-sm-8" style="padding: 20px;">
            <H3>
               <b>상품명</b> &nbsp;&nbsp;&nbsp;
                ${product.name}
            </H3>
            <hr color="orange">
            <table style="width: 100%; height: 200px">
               <tr>
                  <td width="100px" height="5px"><b>분 류 </b></td>
                  <td>${product.type}</td>
               </tr>
               <tr>
                  <td><b>원산지 </b></td>
                  <td>${product.origin}
                  </td>
               </tr>
               <tr>
                  <td><b>가 격 </b></td>
                  <td>${product.price}</td>
               </tr>
               <tr>
                  <td><b>용 량 </b></td>
                  <td>${product.amount}</td>
               </tr>
               <tr>
                  <td><b>제조사 </b></td>
                  <td>${product.brand}</td>
               </tr>
            </table>
            <div style="text-align: right;">
            
           	
        		
            	
            	
            	
               <button type="button" class="btn btn-warning" onclick="cart()">장바구니 담기</button>
               &nbsp;&nbsp;&nbsp;
               <button type="button" class="btn btn-warning" onclick="buy()">구매하기</button>
            </div>
         </div>
         </form>
      </div>



      <div class="menu" data-spy="scroll" data-target=".navbar"
         data-offset="50" align="center">
         <nav class="navbar navbar-inverse">
              <div class="container-fluid">
            <ul class="nav navbar-nav">
               <li class="nav-item"><a class="nav-link" href="#section1">상세정보</a></li>
               <li class="nav-item"><a class="nav-link" href="#section2">배송정보</a></li>
               <li class="nav-item"><a class="nav-link" href="#section3">관련상품</a></li>
               <li class="nav-item"><a class="nav-link" href="#section4">상품문의</a></li>
               <li class="nav-item"><a class="nav-link" href="#section5">상품후기</a></li>
            </ul>
            </div>
         </nav>

         <div id="section1" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>상세정보</h1>
            <p>
               <br>
               <img src="${product.img_urls}" 
               class="rounded" alt="상품사진"
               style="height: 50%; width: 50%; margin: auto; border: 2px solid black"><br><br>
               
               ${product.content}
               
               
               <!-- 상세정보<br> 상세정보<br> 상세정보<br> 상세정보<br> 상세정보<br>
               상세정보<br> 상세정보<br> 상세정보<br> 상세정보<br> 상세정보<br>
               상세정보<br> 상세정보<br> 상세정보<br> 상세정보<br> 상세정보<br>
               상세정보<br> 상세정보<br> 상세정보<br> -->
            </p>
         </div>
         <div id="section2" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>배송정보</h1><br><br>
            <p>
               <img src="./img/delivery_notice.jpg" 
               class="rounded" alt="상품사진"
               style="height: 100%; width: 100%; margin: auto; border: 2px solid white"><br><br>
            </p>
         </div>
         <div id="section3" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>관련상품</h1>
        
        <table><tr>
		<c:forEach var="product" items="${plist.list}">
		<td style="padding:20px">
		<div >
			<div><a href="showProductDetail.do?name=${product.name}"><img class="recipe_img_top" src="${product.img_urls}"
								alt="recipe_image" style="width: 150px; height: 150px; padding: 1px"></a></div>
		<div	>
		<span style="color:#a0a0a0;font-size:1">${pvo.type }</span><br>
		<span style="font-size:1.2em">${pvo.name }</span><br>
		<span style="font-size:1em">${pvo.price}원</span><br>
		</div>
		</div>
		</td>
		</c:forEach>
		</tr>
	</table>
        
        
        
         </div>
         <div id="section4" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
            <h1>상품문의</h1>
               <div class="form-group">
                 <label for="comment">Comment:</label>
                 <textarea class="form-control" rows="5" id="comment"></textarea>
                 <button type="submit" class="btn_reply add" data-tlarea="PCI2" data-tlord="2">등록하기</button>
               </div>
         </div>
         <div id="section5" class="container-fluid"
            style="padding-top: 70px; padding-bottom: 70px">
          <br><br><br><br><br>
		<div class="row">
		<div class="col-sm-10">
		 <h4>후기 게시판</h4>
		</div>
		<div class="col-sm-2" align="right">
			<button type="button" class="btn btn-primary" style="background-color:orange; border:0px;"
			onclick="window.open('write.jsp?about= ${product.name}','후기 작성하기','width=1200px, height=600px,location=no,status=no,scrollbars=no')">
			후기 작성</button>
		</div>
		
		</div>
 	<hr color="orange" style="margin:0px;">
             
  <table class="table table-striped">
    <thead>
      <tr>
        <th width="30px">no</th>
        <th width="500px">제목</th>
        <th width="100px">작성자</th>
        <th width="100px">작성시간</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="review" items="${lvo.list}">
      <tr>
        <td>${review.no }</td>
        <td><a class="" style="color:black;" href="reviewdetail.do?no=${review.no}&&nowpage=${lvo.pagingBean.nowPage}&&about=pro${product.name}">${review.title}</a></td>
        <td>${review.writer }</td>
        <td>${review.register_date }</td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>

<c:set var="blist" value="${lvo.pagingBean}"></c:set>
	<c:if test="${blist.previousPageGroup}">
		<a
			href="showProductDetail.do?name=${product.name}&&page=${blist.startPageOfPageGroup-1}">
			<img src="img/left_arrow_btn.gif">
		</a>
	</c:if>
	<div style="text-align: center">
		<c:forEach var="i" begin="${blist.startPageOfPageGroup}"
			end="${blist.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${blist.nowPage!=i}">
					<a href="showProductDetail.do?name=${product.name}&&page=${i}" style="font-size: 15px">${i}</a>
				</c:when>
				<c:otherwise>
	${i}
	</c:otherwise>
			</c:choose>
	&nbsp;
	</c:forEach>
	
	<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
		<a
			href="showrecipedetail.do?name=${product.name}&&page=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">
			<img src="img/right_arrow_btn.gif">
		</a>
	</c:if>
		</div>
		<br><br><br><br><br>
         </div>
      </div>
   </div>
</body>
</html>