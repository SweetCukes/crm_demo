<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生Excel数据导入</title>
<link href="/css/add.css" type="text/css" rel="stylesheet"/>
</head> 
<body> 
<div id="topMenu">
   <span class="tip">[学生Excel数据导入]</span>   
   <button class="btn add" onClick="history.go(-1)"/>
<!--    <button class="btn" onClick="formSumit()"/>  -->
 </div>
 <div id="addFrom">
 <form id="formId" enctype="multipart/form-data"
	action="stuUpload.do" method="post" onsubmit="return formSumit()"> 
     <table width="500px" border="0" cellspacing="0" cellpadding="0">
       <tr>
          <td>选择学生Excel表:</td>
          <td>
           <input id="stuex" type="file" name="stufile"/>
           <span id="stuFileTip"></span>
         </td>
       </tr> 
       <tr> 
          <td colspan="2" align="left">
            &nbsp;  &nbsp;  
            <a href="upload/stu.zip">学生Excel表模板</a>
           </td>
       </tr> 
     </table> 
        <input type="submit" value=" 批量导入  "/>
     </form> 
 </div> 
 <script type="text/javascript">
   function formSumit(){ 
	 var formObj=document.getElementById("formId");
	 var lid= document.getElementById("stuex");
	 var ltp= document.getElementById("stuFileTip");
	  if(lid.value ==""){
		  ltp.innerHTML="请选择Excel文件！！"; 
		  return false;
	  }else{
		  ltp.innerHTML="<em style='color:green'>√</em>";
		  return true;
	  }  
   }  
 </script>
</body>
</html>