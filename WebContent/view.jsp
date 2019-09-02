<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看学生信息</title>
<link href="css/add.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="topMenu">
   <span class="tip">[查看学生信息]</span>   
   <button class="btn add" onClick="history.go(-1)"/> 
 </div>
 <div id="addFrom"> 
     <table width="400px" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="80px">学生姓名:</td>
         <td> 
           <span id="userTip">王鸥铭</span>
         </td>
       </tr>
       <tr>
         <td>学号：</td>
         <td> 
           <span id="codeTip">2019021123</span>
         </td>
       </tr> 
       <tr>
         <td>性别:</td>
         <td>
            男 
         </td>
       </tr>
       <tr>
         <td>所在班级：</td>
         <td>
           Java 1班  
         </td>
       </tr> 
       <tr>
         <td>开学时间:</td>
         <td> 
           <span id="timeTip">2019-02-23</span>
         </td>
       </tr>
       <tr>
         <td>结业时间:</td>
         <td> 
           <span id="endTip">2019-06-23</span>
         </td>
       </tr>
       <tr>
         <td>备注:</td>
         <td>
            无
         </td>
       </tr>
     </table>  
 </div>  
</body>
</html>
    