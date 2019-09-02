<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工添加</title>
<link href="css/add.css" type="text/css" rel="stylesheet"/>
</head>

<body>

<div id="topMenu">
   <span class="tip">[员工添加]</span>   
   <button class="btn add" onClick="history.go(-1)"/>
   <button class="btn" onClick="formSumit()"/> 
 </div>
 <div id="addFrom">
 <form id="formId" action="http://www.163.com" method="post" > 
     <table width="400px" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="80px">登录名:</td>
         <td>
           <input id="loginId" name="loginName" onBlur="loginBlur()"/>
           <span id="loginTip"></span>
         </td>
       </tr>
       <tr>
         <td>密码：</td>
         <td>
           <input id="pwdId" name="pwd" onBlur="pwdBlur()"/>
           <span id="pwdTip"></span>
         </td>
       </tr>
       <tr>
         <td>姓名：</td>
         <td>
         <input id="userId" name="userName" onBlur="userNameBlur()"/>
         <span id="userTip"></span>
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
         <td>所属部门：</td>
         <td>
          <select id="depId" name="dep" onBlur="depBlur()">
             <option value="-1">--请选择部门--</option>
             <option value="1">行政部</option>
             <option value="2">财务部</option>
             <option value="3">市场部</option>
           </select>
           <span id="depTip"></span>
         </td>
       </tr>
       <tr>
         <td>职务：</td>
         <td>
          <select id="postId" name="post" onBlur="postBlur()">
             <option value="-1">--请选择职务--</option>
             <option value="1">咨询师</option>
             <option value="2">java讲师</option>
             <option value="3">就业专员</option>
           </select>
           <span id="postTip"></span>
         </td>
       </tr>
       <tr>
         <td>入职时间:</td>
         <td>
           <input id="postTime" type="datetime-local" name="PostTime" onBlur="timeBlur()"/>
           <span id="timeTip"></span>
         </td>
       </tr>
     </table> 
     </form> 
 </div> 
 <script type="text/javascript">
   function formSumit(){
     //alert("111111111111");
	 var formObj=document.getElementById("formId");
	 if(loginBlur() &&pwdBlur() &&userNameBlur() && depBlur() &&postBlur() && timeBlur() ){
		 formObj.submit();//手动提交表单
		 return true;
	 }
	 return false;
   }
   function loginBlur(){
	  var lid= document.getElementById("loginId");
	  var ltp= document.getElementById("loginTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入登录名！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function pwdBlur(){
	  var lid= document.getElementById("pwdId");
	  var ltp= document.getElementById("pwdTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入密码！！";
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
   
   function depBlur(){
	  var lid= document.getElementById("depId");
	  var ltp= document.getElementById("depTip");
	  if(lid.value =="-1"){
		  ltp.innerHTML="请选择部门！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   function postBlur(){
	  var lid= document.getElementById("postId");
	  var ltp= document.getElementById("postTip");
	  if(lid.value =="-1"){
		  ltp.innerHTML="请选择职务！！";
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
		  ltp.innerHTML="请选择入职时间！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
 </script>
</body>
</html>
