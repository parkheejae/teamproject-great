<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>boardList</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="page-wrapper">
		<div class="container-fluid">
			<div class="container">
				<div class="col-lg-12" style="align: center;">
					<!--게시판 넓이 -->
					<div class="col-lg-12">
						<h1 class="page-header"><b>[ 공지사항 ]</b></h1>
					</div>
					<div class="row">
						<div class="col-lg-12"></div>
					</div>
					<div class="panel panel-default" style="background-color: #FFCC66">
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>No.</th>
										<th>제 목</th>
										<th>작성자</th>
										<th>작성일</th>
										<th>조회수</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="blist" items="${lvo.list}">
										<tr>
											<td>${blist.no}</td>
											<td><a class="" style="color:black;" href="noticedetail.do?no=${blist.no}&&nowpage=${lvo.pagingBean.nowPage}">${blist.title} </a></td>
											<td>${blist.writer}</td>
											<td>${blist.register_date}</td>
											<td>${blist.hits}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:set var="blist" value="${lvo.pagingBean}"></c:set>
	<c:if test="${blist.previousPageGroup}">
		<a
			href="noticeList.do?page=${blist.startPageOfPageGroup-1}">
			<img src="img/left_arrow_btn.gif">
		</a>
	</c:if>
	<div style="text-align: center">
		<c:forEach var="i" begin="${blist.startPageOfPageGroup}"
			end="${blist.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${blist.nowPage!=i}">
					<a href="noticeList.do?page=${i}" style="font-size: 15px">${i}</a>
				</c:when>
				<c:otherwise>
	${i}
	</c:otherwise>
			</c:choose>
	&nbsp;
	</c:forEach>
	</div>
	<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
		<a
			href="noticeList.do?page=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">
			<img src="img/right_arrow_btn.gif">
		</a>
	</c:if>
</body>
</html>