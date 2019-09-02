<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>课程管理</title>
<link href="css/list.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div id="main">
 <div id="topMenu">
   <span class="tip">[课程管理]</span>   
   <a href="课程添加.html" target="mainframe"> 
     <img src="images/button/tianjia.gif">
   </a>
 </div>
  
 <div id="dataArea">
 <img src="images/result.gif"/>
   <table class="dataTable" width="100%" border="1" cellspacing="0" cellpadding="0">
     <tr class="hbg">
       <th width="14%">名称</th>
        <th width="33%">简介</th>
        <th width="13%">总学时</th>
        <th width="18%">收费标准</th>
        <th width="11%">编辑</th>
      </tr> 
   <tr class="tabtd1">
	    <td align="center">Java基础 </td>
	    <td align="center"></td>
	    <td align="center">400</td>
	    <td align="center">2000.0</td>
	  	<td width="11%" align="center">
	  		<a href="课程编辑.html"><img src="images/button/modify.gif" class="img"></a>
			<a href=""><img src="images/button/delete.gif" class="img"></a>
	  	</td>
	  </tr>
  
   <tr class="tabtd1">
	    <td align="center">Java就业 </td>
	    <td align="center"></td>
	    <td align="center">600</td>
	    <td align="center">12000.0</td>
	  	<td width="11%" align="center">
	  		<a href="课程编辑.html"><img src="images/button/modify.gif" class="img"></a>
			<a href=""><img src="images/button/delete.gif" class="img"></a>
	  	</td>
	  </tr> 
   <tr class="tabtd1">
	    <td align="center">Java Web基础 </td>
	    <td align="center">JSP,JDBC,JSTL,JNDI</td>
	    <td align="center">80</td>
	    <td align="center">2600.0</td>
	  	<td width="11%" align="center">
	  		<a href="课程编辑.html"><img src="images/button/modify.gif" class="img"></a>
			<a href=""><img src="images/button/delete.gif" class="img"></a>
	  	</td>
	  </tr>
	  <tr class="tabtd1">
	    <td align="center">Java EE课程 </td>
	    <td align="center"></td>
	    <td align="center">800</td>
	    <td align="center">8000.0</td>
	  	<td width="11%" align="center">
	  		<a href="课程编辑.html"><img src="images/button/modify.gif" class="img"></a>
			<a href=""><img src="images/button/delete.gif" class="img"></a>
	  	</td>
	  </tr>
  
   <tr class="tabtd1">
	    <td align="center">Java大数据 </td>
	    <td align="center"></td>
	    <td align="center">900</td>
	    <td align="center">13800.0</td>
	  	<td width="11%" align="center">
	  		<a href="课程编辑.html"><img src="images/button/modify.gif" class="img"></a>
			<a href=""><img src="images/button/delete.gif" class="img"></a>
	  	</td>
	  </tr> 
   <tr class="tabtd1">
	    <td align="center">Java分布式 </td>
	    <td align="center">dubbo,Zookeeper,Nginx,FastDFS</td>
	    <td align="center">800</td>
	    <td align="center">26000.0</td>
	  	<td width="11%" align="center">
	  		<a href="课程编辑.html"><img src="images/button/modify.gif" class="img"></a>
			<a href=""><img src="images/button/delete.gif" class="img"></a>
	  	</td>
	  </tr>
   </table>
 </div>
  <div id="pageDiv">
    <span id="pageSpanId">当前1页/共2页,总条数6条。<br>
        <a href="">&nbsp;1&nbsp;</a> 
        <a href="">&nbsp;2&nbsp;</a> 
        <a href="">下一页</a> 
        <a href="">尾页</a> 
    </span>
    <input type="text" id="pageGoInputId" size="4"><input type="button" onclick="pageGo()" value="go"> 
 </div>
   <script type="text/javascript">
  function pageGo(){ 
   var inputValue = document.getElementById('pageGoInputId').value;location.href = 'All?pageSize=5&pageNum=' + inputValue;
   }
   </script> 
</div>
</body>
</html>
