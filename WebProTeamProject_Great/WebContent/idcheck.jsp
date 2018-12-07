<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[type=button]').click(function() {
			var of = window.opener.document.registerFrm;
			
			if(${flag} == true){ 
				of.id.value = "";
				of.id.focus();
			} else{
				of.password.focus();
				of.flag.value = of.id.value; 
				of.id.readOnly = true;
			}
				
			self.close(); 
			
		});
	});
</script>
</head>
	<c:set var="message" value="해당 ID 사용 불가"/>
	<c:if test="${flag == false}">
		<c:set var="message" value="해당 ID 사용 가능"/>
	</c:if>
<body bgcolor="orange">

	<br><b>${param.id}</b>, ${message}<br><br>
	<input type="button" value="확인"> <!-- String 으로 값을 넘겨야한다. 인자값으로 넘어가기 때문에 타입을 지정할 수 없다. -->
</body>
</html>

