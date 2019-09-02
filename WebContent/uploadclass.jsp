<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>班级管理</title>
<link href="css/list.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div id="main">
 <div id="topMenu">
   <span class="tip">[班级管理]</span>   
   <a href="班级添加.html" target="mainframe"> 
     <img src="images/button/tianjia.gif">
   </a>
    <button class="btn" onClick="query()"/>
 </div>
 </div>
 <div id="selectFrom">
  <form action="" method="get">
  <table border="0" width="700px" height="40px" >
    <tr>
      <td>班级状态:</td>
      <td>
       <select name="cstate">
         <option value="-1">--请选择--</option>
         <option value="1">未开班</option>
         <option value="2">已开课</option>
         <option value="3">已结束</option>
       </select>
      </td> 
      <td>开班时间:</td>
      <td>
        <input type="date" name="stratTime"/>
      </td>
      <td>毕业时间:</td>
      <td>
        <input type="date" name="jobTime"/>
      </td>
    </tr>
  </table>
  </form>
 </div>
 <div id="dataArea">
 <img src="images/result.gif"/>
   <table class="dataTable" width="100%" border="1" cellspacing="0" cellpadding="0">
    <thead>
     <tr class="hbg"> 
        <th width="150px" align="center">班级名称</th>
        <th width="200px" align="center">所属课程</th>
        <th width="150px" align="center">开班时间</th>
        <th width="150px" align="center">毕业时间</th> 
        <th width="80px" align="center">状态</th>
        <th width="70px" align="center">学生总数</th>
        <th width="70px" align="center">升学数</th>
        <th width="70px" align="center">转班数</th>
        <th width="50px" align="center">编辑</th>
        <th width="50px" align="center">查看</th>
        <!--<th align="center">课表</th>-->
     </tr>
  </thead>
  <tbody> 
	  <tr class="tabtd1">
	    <td align="center">1期JavaEE </td>
	    <td align="center">Java就业 </td>
	    <td align="center">2019-3-10 </td>
	    <td align="center">2019-4-30 </td>
	    <td align="center">已结束 </td>
	    <td align="center">80 </td>
	    <td align="center">80 </td>
	    <td align="center">0 </td> 
	    <td align="center"> 
	      <a href="班级编辑.html"><img src="images/button/modify.gif" class="img"></a>
		  <a href=""><img src="images/button/delete.gif" class="img"></a>
	    </td>
		<td align="center">
	    	<a href="班级查看.html">
 			<img src="images/button/view.gif" class="img">
            </a>
		</td>
		<!--
		<td align="center"> 
			<a href="班级课表上传.html" target="mainframe">上传</a>  
			<a href="">下载</a> 
		</td>
		-->
	  </tr> 
	  <tr class="tabtd2">
	    <td align="center">2期JavaEE </td>
	    <td align="center">Java基础 </td>
	    <td align="center">2019-4-28 </td>
	    <td align="center">2019-7-1 </td>
	    <td align="center">已开课 </td>
	    <td align="center">67 </td>
	    <td align="center">0 </td>
	    <td align="center">0 </td> 
	    <td align="center"> 
	      <a href="班级编辑.html"><img src="images/button/modify.gif" class="img"></a>
		  <a href=""><img src="images/button/delete.gif" class="img"></a>
	    </td>
		<td align="center">
	    	<a href="班级查看.html">
 			<img src="images/button/view.gif" class="img">
            </a>
		</td>
		<!--
		<td align="center"> 
			<a href="班级课表上传.html" target="mainframe">上传</a>  
			<a href="">下载</a> 
		</td>
		-->
	  </tr> 
	  <tr class="tabtd1">
	    <td align="center">3期JavaEE </td>
	    <td align="center">Java基础 </td>
	    <td align="center">2019-3-29 </td>
	    <td align="center">2019-6-9 </td>
	    <td align="center">已开课 </td>
	    <td align="center">120 </td>
	    <td align="center">0 </td>
	    <td align="center">0 </td>
	    <td align="center"> 
	      <a href="班级编辑.html"><img src="images/button/modify.gif" class="img"></a>
		  <a href=""><img src="images/button/delete.gif" class="img"></a>
	    </td>
		<td align="center">
	    	<a href="班级查看.html">
 			<img src="images/button/view.gif" class="img">
            </a>
		</td>
		<!--
		<td align="center"> 
			<a href="班级课表上传.html" target="mainframe">上传</a>  
			<a href="">下载</a> 
		</td>
		-->
	  </tr>
	  <tr class="tabtd1">
	    <td align="center">1期JavaEE </td>
	    <td align="center">Java就业 </td>
	    <td align="center">2019-3-10 </td>
	    <td align="center">2019-4-30 </td>
	    <td align="center">已结束 </td>
	    <td align="center">80 </td>
	    <td align="center">80 </td>
	    <td align="center">0 </td> 
	    <td align="center"> 
	      <a href="班级编辑.html"><img src="images/button/modify.gif" class="img"></a>
		  <a href=""><img src="images/button/delete.gif" class="img"></a>
	    </td>
		<td align="center">
	    	<a href="班级查看.html">
 			<img src="images/button/view.gif" class="img">
            </a>
		</td>
		<!--
		<td align="center"> 
			<a href="班级课表上传.html" target="mainframe">上传</a>  
			<a href="">下载</a> 
		</td>
		-->
	  </tr> 
	  <tr class="tabtd2">
	    <td align="center">2期JavaEE </td>
	    <td align="center">Java基础 </td>
	    <td align="center">2019-4-28 </td>
	    <td align="center">2019-7-1 </td>
	    <td align="center">已开课 </td>
	    <td align="center">67 </td>
	    <td align="center">0 </td>
	    <td align="center">0 </td> 
	    <td align="center"> 
	      <a href="班级编辑.html"><img src="images/button/modify.gif" class="img"></a>
		  <a href=""><img src="images/button/delete.gif" class="img"></a>
	    </td>
		<td align="center">
	    	<a href="班级查看.html">
 			<img src="images/button/view.gif" class="img">
            </a>
		</td>
		<!--
		<td align="center"> 
			<a href="班级课表上传.html" target="mainframe">上传</a>  
			<a href="">下载</a> 
		</td>
		-->
	  </tr> 
	  <tr class="tabtd1">
	    <td align="center">3期JavaEE </td>
	    <td align="center">Java基础 </td>
	    <td align="center">2019-3-29 </td>
	    <td align="center">2019-6-9 </td>
	    <td align="center">已开课 </td>
	    <td align="center">120 </td>
	    <td align="center">0 </td>
	    <td align="center">0 </td>
	    <td align="center"> 
	      <a href="班级编辑.html"><img src="images/button/modify.gif" class="img"></a>
		  <a href=""><img src="images/button/delete.gif" class="img"></a>
	    </td>
		<td align="center">
	    	<a href="班级查看.html">
 			<img src="images/button/view.gif" class="img">
            </a>
		</td>
		<!--
		<td align="center"> 
			<a href="班级课表上传.html" target="mainframe">上传</a>  
			<a href="">下载</a> 
		</td>
		-->
	  </tr>
   </table>
 </div>
 <div id="pageDiv">
    <span id="pageSpanId">当前1页/共2页，总条数6条。<br>
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
