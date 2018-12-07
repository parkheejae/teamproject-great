<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
	button{
		border: none;
	}
	
</style>
  <script type="text/javascript">
  
  	$(function() {
  		var login = "<c:out value='${login}'/>";
  		if(login==""){
  			alert('잘못된 접근입니다. 로그인하고 이용해 주세요');
  			location.href = "loginForm.jsp";
  		}
  		
	}) 
     
  	var count = 2; 
    function add_item(){
        // pre_set 에 있는 내용을 읽어와서 처리..
        
        var addedFormDiv = document.getElementById('field');//폼 생성
      
        var str = "";
     
        str+="<br><div class='input-group'><input type='text' class='form-control' name=way_"+count+" placeholder='요리방법 설명' style='width=50%'>";
        str+="<div class='input-group-btn'><input type='button' value='삭제' class='btn btn-default' target=added_"+count+" onclick='remove_item(this)'></div></div>";
        str+="<div class='input-group'><input type='text' id= 'way_"+count+"_filename' class='form-control' readonly='readonly'>";
        str+="<div class='input-group-btn'><label class='btn btn-default'>찾아보기";
        str+="<input type='file' onchange=\"javascript:document.getElementById(\'way_"+count+"_filename\').value=this.value\" id='uploadBtn' class='uploadBtn'  name='way_"+count+"_url' ></label></label></div></div><br>";
       
        
        var addedDiv = document.createElement("div"); // 폼 생성

        addedDiv.id = "added_"+count; // 폼 Div에 ID 부여 (삭제를 위해)

        addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입

        addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
        document.getElementById('count').value=count;
        count++;   
        
    }
 
    function remove_item(obj){
        // obj.parentNode 를 이용하여 삭제
      /*   document.getElementById('field').removeChild(obj.parentNode); */
    	var target = obj.getAttribute('target');
    	   // 삭제할 element 찾기
    	   var field = document.getElementById(target);
    	   // #field 에서 삭제할 element 제거하기
    	    document.getElementById('field').removeChild(field);
    }

</script>
 
<style type="text/css">

input[type="file"] {position:absolute;padding:0;margin:-1px;overflow:hidden;border:0; width:0; height:0}
</style>


</head>
<body>
   <c:import url="header.jsp"></c:import>
   <form action="insertrecipe.do" name="recipe" method="post" enctype="multipart/form-data">
      <div class="container">
         <div>
            <br><br>
            <h1 align="center">Recipe 등록하기</h1><br><br>
            <h5>음식이름</h5>
            <input type="text" class="form-control" name="name" placeholder="ex)김치볶음밥"   ><br><br>
            <h5>음식설명</h5>
            <input type="text" class="form-control" name="discript" placeholder="음식에 대한 설명을 간단하게 적어주세요"   ><br><br>
         </div>   
         <div>
            <h5>음식사진</h5>
            <div class="input-group" id="mainimg">
	<input type="text" class="form-control" readonly="readonly" id="mainimgname">
	<div class="input-group-btn">
	<label class="btn btn-default">찾아보기
	<input type="file" onchange="javascript:document.getElementById('mainimgname').value=this.value" id="uploadBtn" class="uploadBtn"  name="imgurls" ></label>

			    	
	</div></div>
	</div>
           	 
      
    </div>
   

      <div class="container">
      <h5>음식 분류</h5>
      <!-- 카테고리. 밸류값 해서 불러오자 -->
         <select id="type" name="type">
              <option value="beef" selected="selected">beef</option>
              <option value="noodle">noodle</option>
              <option value="rice">rice</option>
              <option value="salad">salad</option>
              <option value="soup">soup</option>
         </select>
      </div>
      <br><br>
      <div class="container">
      <div class="row">
         <div class="col-sm-4" style="margin-right:20px;">
            <h5>주재료</h5>
            <input type="text" name="ingredient1" placeholder="주재료 1" required="required"><br><br>
            <input type="text" name="ingredient2" placeholder="주재료 2"><br><br>
            <input type="text" name="ingredient3" placeholder="주재료 3"><br><br>
         </div>
         <div  class="col-sm-4" >
            <h5>부재료</h5>
            <input type="text" name="sub_ingredient1" placeholder="부재료 1" required="required"><br><br>
            <input type="text" name="sub_ingredient2" placeholder="부재료 2"><br><br>
            <input type="text" name="sub_ingredient3" placeholder="부재료 3"><br><br>
         </div>
         </div>
      </div>
      <br>
      <br>
      <div class="container">
         <div>
         <h5>요리방법</h5>
            <div class="form-group" >
            	<br>
               <input type="text" class="form-control" name="way_1" placeholder="요리방법 설명" style="width=40%" required="required">
                   <div class="input-group">
			    	<input type="text" class="form-control" readonly="readonly" id="way_1_filename">
			    	<div class="input-group-btn">
			    	<label class="btn btn-default">찾아보기
					<input type="file" onchange="javascript:document.getElementById('way_1_filename').value=this.value" id="uploadBtn" class="uploadBtn"  name="way_1_url" ></label>
			    	</div></div> 
	           
            </div>
             
            <div id="field"></div>
            <input type="hidden" name="count" id="count" value="1">
            
            <div align="center">
                <input type="button" value="추가" class="btn btn-orange" style="background: #ff9c34; color:white" onclick="add_item()">
            </div> 
         </div>
         <div>
            <h5><span class="badge badge-warning">Tip</span></h5>
            <div class="container" style="padding : 0 30px 0 0">
                <div class="form-group">
                  <label for="tip">Comment</label>
                  <textarea class="form-control" rows="5" id="tip" name="tip"></textarea>
                </div>
             <div align="right">     
             <button type="button" class="btn btn-danger" onclick="location.href='showmain.do'">취소하기</button>
             <input type="hidden" name="command" value="InsertRecipe">&nbsp;&nbsp;
             <button type="submit" class="btn btn-orange" style="background: #ff9c34; color:white">제출하기</button>
             </div>
            </div>
         </div>
      </div><br><br><br>
   </form>
   <c:import url="footer.jsp"></c:import>
</body>
</html>