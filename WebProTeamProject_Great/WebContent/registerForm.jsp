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
	
	#register{
		width: 100%;
		margin: 0px;
		float: left;
	}

	input[type=text], input[type=password], input[type=date], input[type=email] {
	    padding: 10px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    box-sizing: border-box;
	    width: 100%;
	}
	
	#id{
		width :80%;
	}

	.registerbtn {
	    width: 100%;
	    height: 50px;
	    color: white;
	    background-color: #ff9c34;
	    border: none;
	    cursor: pointer;
	    font: medium;
	    font-size: 18px;
	}
	
	button {
	    background-color: #ff9c34;
	    color: white;
	    border: none;
	    cursor: pointer;
	    width: 90px;
	    height: 41px;
	    float: right;
	}
	.imgcontainer {
	    text-align: center;
	    margin: 24px 0 12px 0;
	}
	
	.registercontainer {
	    padding: 20px;
	}
	#div1{
		height: 740px;
	}

</style>
<script type="text/javascript">

	/* 비밀번호 check */
	function passcheck() {
		var frm = document.registerFrm;
		var pass = document.registerFrm.password.value;
		var repass = document.registerFrm.passwordcheck.value;
		if(pass != repass) {
			alert("비밀번호가 일치하지 않습니다...");
			document.registerFrm.passwordcheck.value = "";
			document.registerFrm.passwordcheck.focus();
			return false;
		}else{
			frm.submit();
		}
	}
	
	function idcheck() {
		var id = document.registerFrm.id;
		if(id.value=="")
			alert("ID를 입력해주세요...");
		else
			window.open("idcheck.do?id=" + $('#id').val(), "Window Title", "width=300, height=200, top=100, left=400"); 
	}

</script>
</head>
<body>
	<c:import url="header.jsp"/>
	<br>
	<h2 align="center">회원가입</h2>
	<div id="div1">
	<form action="register.do" method="post" name="registerFrm" onsubmit="return passcheck()">

		<div class="registercontainer">
			<div id="register">
				<label for="id"><b>ID</b></label><br>
				<input type="text" placeholder="ID를 입력하세요..." name="id" id="id" required >
				<button style="margin-top: 8px" onclick="idcheck()">중복확인</button>
				<br>
				<label for="password"><b>비밀번호</b></label>
				<input type="password" placeholder="비밀번호를 입력하세요..." name="password" required>
				<br>
				<label for="passwordcheck"><b>비밀번호 확인</b></label>
				<input type="password" placeholder="비밀번호를 한번 더 입력하세요..." name="passwordcheck" required>
				<br>
				<label for="name"><b>이름</b></label>
				<input type="text" placeholder="이름 입력하세요..." name="name" required>
				<br>
				<label for="email"><b>이메일</b></label>
				<input type="email" placeholder="이메일을 입력하세요..." name="email" required>
				<br>
				<label for="date"><b>생년월일</b></label>
				<input type="date" placeholder="생년월일을 입력하세요..." name="date" required>
				<br>
				<label for="address"><b>주소</b></label>
				<input type="text" placeholder="주소를 입력하세요..." name="address" required>				
				<br><br>
				<!-- <input type="button" value="확인" onclick="check()"> -->
				<input type="hidden" name="flag" value="false">	
				<input type="hidden" name="command" value="register">
				<input type="submit" class="registerbtn" value="회원가입">
			</div>
		</div>
	</form>
	</div>
	
	<c:import url="footer.jsp"/>

</body>
</html>