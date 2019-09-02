<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>咨询添加</title>
<link href="css/add.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="topMenu">
   <span class="tip">[咨询添加]</span>   
   <button class="btn add" onClick="history.go(-1)"/>
   <button class="btn" onClick="formSumit()"/> 
 </div>
 <div id="addFrom">
 <form id="formId" action="http://www.163.com" method="post" > 
     <table width="600px" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="90px">学生姓名:</td>
         <td>
           <input id="userId" name="userName" onBlur="userNameBlur()"/>
           <span id="userTip"></span>
         </td>
       </tr>
       <tr>
         <td>手机号码：</td>
         <td>
           <input id="phoneId" name="phone" onBlur="phoneBlur()"/>
           <span id="phoneTip"></span>
         </td>
       </tr> 
       <tr>
         <td>性别:</td>
         <td>
           <input type="radio" name="sex" value="男" checked>男
           <input type="radio" name="sex" value="女">女
         </td>
       </tr>
       <tr>
         <td>来源：</td>
         <td>
          <select id="sourceId" name="source" onBlur="sourceBlur()">
             <option value="-1">--请选择--</option>
             <option value="1">网站</option>
             <option value="2">线下</option>
             <option value="3">电话</option>
           </select>
           <span id="sourceTip"></span>
         </td>
       </tr> 
       <tr>
         <td>咨询的课程：</td>
         <td>
          <select id="couseId" name="couse" onBlur="couseBlur()">
             <option value="-1">--请选择--</option>
             <option value="1">Java课程</option>
             <option value="2">大数据课程</option>
             <option value="3">Web前端课程</option>
           </select>
           <span id="couseTip"></span>
         </td>
       </tr>
       <tr>
         <td>是否毕业：</td>
         <td>
          <select id="isJobId" name="isJob"> 
             <option value="1" selected>已毕业</option>
             <option value="0">应届生下</option>
             <option value="2">其他</option>
           </select> 
         </td>
       </tr>
       <tr>
         <td>毕业院校：</td>
         <td>
           <input id="byAcademyId" name="byAcademy"/> 
         </td>
       </tr>   
       <tr>
         <td>通讯地址:</td>
         <td>
           <input type="text" name="address"/> 
         </td>
       </tr>
       <tr>
         <td>邮箱:</td>
         <td>
           <input id="email" type="email" name="email" /> 
         </td>
       </tr>
       <tr>
         <td>微信:</td>
         <td>
           <input id="weixin" type="text" name="weixin" /> 
         </td>
       </tr>
       <tr>
         <td>QQ号:</td>
         <td>
           <input id="qq" type="number" name="qq" /> 
         </td>
       </tr>
       <tr>
         <td>备注:</td>
         <td>
           <textarea rows="6" cols="36" name="mark"></textarea> 
         </td>
       </tr>
     </table> 
     </form> 
 </div> 
 <script type="text/javascript">
   function formSumit(){
     //alert("111111111111");
	 var formObj=document.getElementById("formId");
	 if(phoneBlur() &&userNameBlur() && couseBlur() &&postBlur() && timeBlur()&&endBlur() ){
		 formObj.submit();//手动提交表单
		 return true;
	 }
	 return false;
   } 
   
   function phoneBlur(){
	  var lid= document.getElementById("stuCodeId");
	  var ltp= document.getElementById("phoneTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入学号！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function userNameBlur(){
	  var lid= document.getElementById("userId");
	  var ltp= document.getElementById("userTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入姓名！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function couseBlur(){
	  var lid= document.getElementById("couseId");
	  var ltp= document.getElementById("couseTip");
	  if(lid.value =="-1"){
		  ltp.innerHTML="请选择班级！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   } 
   
   function timeBlur(){
	  var lid= document.getElementById("postTime");
	  var ltp= document.getElementById("timeTip"); 
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
    