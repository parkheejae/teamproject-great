<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	.block {
	    display: block;
	    width: 45%;
	    border: none;
	    background-color: #ff9c34;
	    padding: 14px 28px;
	    font-size: 16px;
	    cursor: pointer;
	    text-align: center;
	}
</style>
<script type="text/javascript">
	function purchase(){
		location.href = "purchase_History.jsp";
	}
	
	function goHome(){
		location.href = "showmain.do";
	}
</script>
</head>
<body>
	<div align="center">
		<br><br>
		<h1>${purchaseListname} 구매가 완료되었습니다.</h1>
		<br><br>
		<div align="center" style="width: 500px">
			<button type="button" class="block" onclick="purchase()" style="float: left">구매내역 보러가기</button>
			<button type="button" class="block" onclick="goHome()" style="float: right">홈으로</button>
		</div>
<!-- 		<br><br>
		<a href="purchase_History.jsp">구매내역 보러가기</a>&nbsp;&nbsp;&nbsp;
		<a href="showmain.do">홈으로</a> -->
	</div>
</body>
</html>