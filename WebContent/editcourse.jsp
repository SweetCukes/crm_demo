<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>课程编辑</title>
<link href="css/add.css" type="text/css" rel="stylesheet"/>
</head> 
<body> 
<div id="topMenu">
   <span class="tip">[课程编辑]</span>   
   <button class="btn add" onClick="history.go(-1)"/>
   <button class="btn" onClick="formSumit()"/> 
 </div>
 <div id="addFrom">
 <form id="formId" action="" method="post" > 
     <table width="500px" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="80px">课程名称:</td>
         <td>
           <input id="couseId" name="couseName" value="Java Web基础" onBlur="couseNameBlur()"/>
           <span id="couseTip"></span>
         </td>
       </tr> 
       <tr>
         <td>课程费用:</td>
         <td>
           <input id="couseMoney" type="number" value="2600.00" name="couseMoney" onBlur="moneyBlur()"/>
           <span id="momeyTip"></span>
         </td>
         </tr>
          <tr>
          <td>总学时:</td> 
         <td>
           <input id="classHour" type="number" value="80" name="classHour" onBlur="chourBlur()"/>
           <span id="hourTip"></span>
         </td>
         </tr>
          <tr>
          <td>课程简介:</td>
         <td>
           <textarea rows="10" cols="40" name="mark">JSP,JDBC,JSTL,JNDI</textarea> 
         </td>
       </tr>
     </table> 
     </form> 
 </div> 
 <script type="text/javascript">
   function formSumit(){ 
	 var formObj=document.getElementById("formId");
	 if(couseNameBlur() &&moneyBlur() && chourBlur()){
		 formObj.submit();//手动提交表单
		 return true;
	 }
	 return false;
   }
   function couseNameBlur(){
	  var lid= document.getElementById("couseId");
	  var ltp= document.getElementById("couseTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入课程名称！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
    
   function moneyBlur(){
	  var lid= document.getElementById("couseMoney");
	  var ltp= document.getElementById("momeyTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入课程费用！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function chourBlur(){
	  var lid= document.getElementById("classHour");
	  var ltp= document.getElementById("hourTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入总课时！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   } 
 </script>
</body>
</html>
