<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	body {font-family: Arial, Helvetica, sans-serif;}
	form {
		float: center;
		width: 500px;
		margin: auto;
	}
	#loginDiv{
		width: 75%;
		margin: 0px;
		float: left;
	}
	#loginBtn{
		width: 21%;
		height: 133px;
		float: right;
		margin: 33px 0 0;
		color: white;
		font-size: 20px;
	}
	input[type=text], input[type=password] {
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    box-sizing: border-box;
	    width: 100%;
	}
	
	button {
	    background-color: #ff9c34;
	    margin: 8px 0;
	    border: none;
	    cursor: pointer;
	}
	
	button:hover {
	    opacity: 0.8;
	}
	
	.registerbtn {
	    width: auto;
	    padding: 10px 18px;
	    background-color: #ff9c34;
	    color: white;
	}
	.cancelbtn {
	    width: auto;
	    padding: 10px 18px;
	    background-color: #f44336;
	    color: white;
	}
	
	.imgcontainer {
	    text-align: center;
	    margin : 80px 0 0;
	}
	
	.registercontainer {
	    padding: 20px;
	}
	
</style>

<script type="text/javascript">
	function registerGo(){
		location.href = "registerForm.jsp";
	}
	
	function mainGo(){
		location.href = "showmain.do";
	}
	
</script>
</head>
<body>
	<c:import url="header.jsp"/>
	
	<form action="login.do">
		<div class="imgcontainer">
			<img src="img/logo.png" alt="logo">
		</div>
		
		<div class="registercontainer">
			<div id="loginDiv">
				<label for="id"><b>ID</b></label>
				<input type="text" placeholder="ID를 입력하세요..." name="id" required>
				<br>
				<label for="password"><b>Password</b></label>
				<input type="password" placeholder="비밀번호를 입력하세요..." name="password" required>
			</div>
			<input type="hidden" name="callurl" value="${param.callurl}">
			<button type="submit" id="loginBtn"><b>Login</b></button>

		</div>
		<br><br><br>
		<br><br><br>
		<br><br><br>
		<div style="float: right; margin-right: 20px;">
			<button type="button" class="registerbtn" onclick="registerGo()"><b>회원가입</b></button>
			&nbsp;&nbsp;
			<button type="button" class="cancelbtn" onclick="mainGo()"><b>홈으로</b></button>
		</div>
	</form>
	<div style="position:absolute; width:100%; bottom:0px;">
		<c:import url="footer.jsp"/>
	</div>
	
</body>
</html>