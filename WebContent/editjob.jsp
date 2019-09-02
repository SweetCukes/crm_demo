<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职务编辑</title>
<link href="css/add.css" type="text/css" rel="stylesheet"/>
</head>

<body>

<div id="topMenu">
   <span class="tip">[职务编辑]</span>  
   <button class="btn add" onClick="history.go(-1)"/>
   <button class="btn" onClick="formSumit()"/> 
 </div>
 <div id="addFrom">
 <form id="formId" action="" method="post" > 
     <table width="400px" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="80px">部门名:</td>
         <td> 
           <select name="depName" id="depId" onBlur="depBlur()">
             <option value="-1">--请选择部门--</option>
             <option value="1" selected>行政部</option>
             <option value="2">财务部</option>
             <option value="3">市场部</option>
           </select>
           <span id="depTip"></span>
         </td>
       </tr>
        <tr>
         <td width="80px">职务名:</td>
         <td>
           <input id="postId" name="postName" onBlur="postBlur()" value="咨询师"/>
           <span id="postTip"></span>
         </td>
       </tr>
     </table> 
     </form> 
 </div> 
 <script type="text/javascript">
   function formSumit(){ 
	 var formObj=document.getElementById("formId");
	 if(depBlur()){
		 formObj.submit();//手动提交表单
		 return true;
	 }
	 return false;
   }
   
   function depBlur(){
	  var lid= document.getElementById("depId");
	  var ltp= document.getElementById("depTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请选择部门名！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   }
   
   function postBlur(){
	  var lid= document.getElementById("postId");
	  var ltp= document.getElementById("postTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请输入职务名！！";
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
	  }
	 return true;
   } 
 </script>
</body>
</html>
