<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级编辑</title>
<link href="css/add.css" type="text/css" rel="stylesheet"/>
</head> 
<body> 
<div id="topMenu">
   <span class="tip">[班级编辑]</span>   
   <button class="btn add" onClick="history.go(-1)"/>
   <button class="btn" onClick="formSumit()"/> 
 </div>
 <div id="addFrom">
 <form id="formId" action="http://www.163.com" method="post" > 
     <table width="500px" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="80px">班级名称:</td>
         <td>
           <input id="classId" name="className" value="1期JavaEE" onBlur="classBlur()"/>
           <span id="classTip"></span>
         </td>
       </tr>
       <tr>
         <td>所上课程：</td>
         <td> 
           <select name="course"  id="courseId" onBlur="courseBlur()">
             <option value="-1">--请选择--</option>
             <option value="1">Java基础</option>
             <option value="2" selected>JavaEE就业班</option>
             <option value="3">Web前端班</option>
           </select>
           <span id="courseTip"></span>
         </td>
       </tr> 
       <tr>
         <td>开课时间:</td>
         <td>
           <input id="startTime" type="date" value="2019-02-03" name="startTime" onBlur="startBlur()"/>
           <span id="startTip"></span>
         </td>
         </tr>
          <tr>
          <td>结业时间:</td> 
         <td>
           <input id="endTime" type="date" value="2019-06-03" name="endTime" onBlur="endBlur()"/>
           <span id="endTip"></span>
         </td>
         </tr>
          <tr>
          <td>其他说明:</td>
         <td>
           <textarea rows="10" cols="40" name="mark"></textarea> 
         </td>
       </tr>
     </table> 
     </form> 
 </div> 
 <script type="text/javascript">
   function formSumit(){ 
	 var formObj=document.getElementById("formId");
	 if(classBlur() &&courseBlur() &&startBlur() && endBlur()){
		 formObj.submit();//手动提交表单
		 return true;
	 }
	 return false;
   }
   function classBlur(){
	  var lid= document.getElementById("classId");
	  var ltp= document.getElementById("classTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入班级名称！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function courseBlur(){
	  var lid= document.getElementById("courseId");
	  var ltp= document.getElementById("courseTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请选择课程！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function startBlur(){
	  var lid= document.getElementById("startTime");
	  var ltp= document.getElementById("startTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入开课时间！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function endBlur(){
	  var lid= document.getElementById("endTime");
	  var ltp= document.getElementById("endTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入结课时间！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   } 
 </script>
</body>
</html>
    