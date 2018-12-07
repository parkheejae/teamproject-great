<%@page import="java.util.ArrayList"%>
<%@page import="model.vo.MemberVO"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%
  	String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
%>	 --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>
<%-- <script type="text/javascript" src="<%=ctx %>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script> --%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
</head>

<body style="align:center;">	
<script type="text/javascript">
var login = "<c:out value='${login}'/>";
<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" /> 
	if(login==""){
		alert('잘못된 접근입니다. 로그인하고 이용해 주세요');
		window.opener.location.href="loginForm.jsp?callurl=${path}";
		window.close();
	}
/* jQuery('#selectBox').change(function() {
	var state = jQuery('#selectBox option:selected').val();
	if(state == '1') {
		jQuery('#layer').show();
	} else {
		jQuery('#layer').hide();
	}
});	 */
/* $('frm').submit(function(){
	 var msg = document.getElementById('smarteditor').value; 
	alert(msg);
	$('frm').submit();}
);  */
	
var oEditors = [];
$(function(){
	
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "smarteditor", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "smarteditor/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : false,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
              oEditors.getById["smarteditor"].exec("PASTE_HTML", ["여기에 내용을 써주세요."]);
          },
          fCreator: "createSEditor2"
      });
     
     /*  $("#savebutton").click(function(){
          //id가 smarteditor인 textarea에 에디터에서 대입
          editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
           
          // 이부분에 에디터 validation 검증
           
          //폼 submit
          $("#frm").submit();
      }); */
   
      //저장버튼 클릭시 form 전송

      $("#savebutton").click(function(){
          oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
/*           var b = $("#imageupload").find('img').attr('src');*/
			for(i=1; i<=count;i++){
				var b = $('#img'+i+'').attr('src');
				$('form').append("<input type='hidden' name='img"+i+"' value='"+b+"'>")
          	}
		  $('form').append("<input type='hidden' name='count' value='"+count+"'>")

          $('form').submit();
      });      
})
var count = 0;
function pasteHTML(filepath){
	var id = '${sessionScope.login.id}';
	count++;
	var sHTML = '<img src="<%=request.getContextPath()%>/upload/'+id+'/'+filepath+'" width="265px" id="img'+count+'"><br>';
    <%-- var sHTML = '<img src="<%=request.getContextPath()%>/upload/'+filepath+'">'; --%>
   <%--  var sHTML = '<img src="<%= %>C:/jsh/webpro2/eclipse/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TourProject/upload/'+id+'/'+filepath+'">'; --%>
   $('#imageupload').append(sHTML);
 	
   /* oEditors.getById["smarteditors"].exec("PASTE_HTML", [sHTML]); */
}


</script>	
<h1 align="center">후기 작성 </h1>
<form action="writeReview.do?about=re${param.about}" method="post" name="frm" width="1024px"> <!--  enctype="multipart/form-data" -->

<table border="1" align="center" width="1024px"  style="table-layout:fixed;">
	<tr>
		<th align="center">작성자</th>
		<td><input type="text" name="id" value="${sessionScope.login.id}" readonly="readonly" style="width:99%;"></td>	
	</tr>
	<tr>
		<th>제목</th>
		<td width="80px" colspan="4"><input type="text" name="title" required="required" style="width:99%;"></td>
	</tr>

	<tr>
		<td colspan="4"><textarea id="smarteditor" rows="30" cols="40" name="smarteditor" style="width:99%; height:285px"></textarea></td>
		<td><div style="overflow-y:auto; overflow-x:hidden; width:285px; height:285px;" id="imageupload"></div></td>
	</tr>
</table>
	
<table align="center" width="1024px">
	<tr>
		<td align="right">
		<input type="submit" id="savebutton" value="작성">
			<input type="button" value="취소">
			
		</td>
	</tr>	
</table>
</form>

</body>
</html>