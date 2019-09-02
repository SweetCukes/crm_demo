<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门添加</title>
<link href="css/add.css" type="text/css" rel="stylesheet"/>
</head>

<body>

<div id="topMenu">
   <span class="tip">[部门添加]</span>  
   <button class="btn add" onClick="history.go(-1)"/>
   <button class="btn" onClick="formSumit()"/> 
 </div>
 <div id="addFrom">
 <form id="formId" action="depAdd.do" method="post" > 
     <table width="400px" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="80px">部门名:</td>
         <td>
           <input id="depId" name="depName" onBlur="depBlur()"/>
           <span id="depTip"></span>
         </td>
       </tr>
            </table> 
     </form> 
 </div> 
 <script type="text/javascript" src="js/dep.js">
 //如果有src的属性
 </script>
</body>
</html>