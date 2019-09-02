<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>员工列表 V1.0</title>
<link href="css/list.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div id="main">
 <div id="topMenu">
   <span class="tip">[员工管理]</span>    
   <a href="员工添加.html" target="mainframe"> 
     <img src="images/button/tianjia.gif">
   </a>
    <button class="btn" onClick="query()"/>
 </div>
 <div id="selectFrom">
  <form action="" method="get">
  <table border="0" width="600px" height="40px" align="center">
    <tr>
      <td>部门:</td>
      <td>
       <select name="dep">
         <option value="-1">--请选择部门--</option>
         <option value="1">行政部</option>
         <option value="2">财务部</option>
         <option value="3">市场部</option>
       </select>
      </td>
      
      <td>职务:</td>
      <td>
       <select name="post">
         <option value="-1">--请选择职务--</option>
         <option value="1">咨询师</option>
         <option value="2">java讲师</option>
         <option value="3">就业专员</option>
       </select>
      </td>
      
      <td>姓名:</td>
      <td>
        <input name="sename"/>
      </td>
      
    </tr>
  </table>
  </form>
 </div>
 <div id="dataArea">
 <img src="images/result.gif"/>
   <table class="dataTable" width="100%" border="1" cellspacing="0" cellpadding="0">
     <tr class="hbg">
       <th>员工姓名</th>
       <th>性别</th>
       <th>入职时间</th>
       <th>所属部门</th>
       <th>职务</th>
       <th>编辑</th>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     <tr>
       <td>张三</td>
       <td>男</td>
       <td>2016-01-11</td>
       <td>市场部</td>
       <td>咨询师</td>
       <td>
         <a href="员工编辑.html"><img src="images/button/modify.gif"/></a>
		 <a href=""><img src="images/button/delete.gif"/></a>
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
   var inputValue = document.getElementById('pageGoInputId').value;
   location.href = 'All?pageSize=5&pageNum=' + inputValue;
   }
   </script> 
</div>
</body>
</html>
