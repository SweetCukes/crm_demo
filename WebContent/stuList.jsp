<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>在校生管理</title>
<link href="css/list.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
	#importBtn{ 
	width:120px; 
	height:20px; 
	border:0px; 
	margin-bottom:1px;
	float:right;
	background-color:green
	 }
</style>
</head>
<body>
<div id="main">
 <div id="topMenu">
   <span class="tip">[在校生管理]</span>   
   <a href="学生添加.html" target="mainframe"> 
     <img src="images/button/tianjia.gif">
   </a>
    <button class="btn" onClick="query()"/>
 </div>
 <div id="selectFrom">
  <form action="" method="get">
  <table border="0" width="400px" height="40px" style="margin-left:10px">
    <tr>
      <td>班级:</td>
      <td>
       <select name="className" id="classId">
         <option value="-1">--请选择班级--</option>
         <option value="1">Java基础班</option>
         <option value="2">Java中级班</option>
         <option value="3">Java高级班</option>
       </select>
      </td>
       
      <td>学生姓名:</td>
      <td>
        <input name="sename"/>
      </td> 
    </tr>
  </table>
  </form>
 </div>
 <div id="dataArea">
 <img src="images/result.gif"/>
 <input id="importBtn" onClick="showImport()" type="button" value="数据导入">
   <table class="dataTable" width="100%" border="1" cellspacing="0" cellpadding="0">
     <tr class="hbg">
       <th>编号</th>
       <th>学生姓名</th>
       <th>性别</th>
       <th>入学时间</th>
       <th>所在班级</th>
       <th>状态</th>
       <th>编辑</th>
     </tr>
     <tr>
       <td>1</td>
       <td>张三</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
		 <a href=""><img src="images/button/delete.gif" class="img"></a>
       </td>
     </tr>
     <tr>
       <td>2</td>
       <td>李四</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
		 <a href=""><img src="images/button/delete.gif" class="img"></a>
       </td>
     </tr>
     <tr>
       <td>3</td>
       <td>王五</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
		 <a href=""><img src="images/button/delete.gif" class="img"></a>
       </td>
     </tr>
     <tr>
       <td>4</td>
       <td>马六</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
		 <a href=""><img src="images/button/delete.gif" class="img"></a>
       </td>
     </tr>
     <tr>
       <td>5</td>
       <td>赵七</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
		 <a href=""><img src="images/button/delete.gif" class="img"></a>
       </td>
     </tr>
     <tr>
       <td>6</td>
       <td>陆八</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
		 <a href=""><img src="images/button/delete.gif" class="img"></a>
       </td>
     </tr>
     <tr>
       <td>7</td>
       <td>涂九</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
		 <a href=""><img src="images/button/delete.gif" class="img"></a>
       </td>
     </tr>
     <tr>
       <td>8</td>
       <td>张三</td>
       <td>男</td>
       <td>2019-01-11</td>
       <td>JavaEE黑马班</td>
       <td>开课中</td>
       <td>
         <a href="学生编辑.html"><img src="images/button/modify.gif" class="img"></a>
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
</div>
<script type="text/javascript">
	function showImport(){
		window.location.href="stuImport.jsp";
	}
</script>
</body>
</html>
