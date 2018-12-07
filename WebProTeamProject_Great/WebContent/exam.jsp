<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>



	<div class="container" style="padding:100px">
		<div class="container">
			<form>
				<div class="row">
				<div class="col-md-2" style="text-align:right">
				<img src="./img/logo_cap.png" height="50px">
				<img src="./img/logo_fork.png" height="50px"></div>
				
				<div class="col-md-10">
				
				<div class="input-group mb-2" width="50%">
  				<input type="text" class="form-control" placeholder="그레잇!" aria-label="Recipient's username" aria-describedby="button-addon2">
  					<div class="input-group-append">
   					 <button class="btn" style="background-color: orange" type="button" id="button-addon2">Search</button>
 				</div>
 				</div>
 				 </div>
			</div>
			</form>
		</div>
	</div>
	<c:import url="header.jsp"></c:import>
</body>
</html>