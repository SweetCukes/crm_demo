<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.pageTag.com" prefix="fy"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>员工列表 V1.0</title>
<link href="css/list.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
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
  <form id="formId" action="queryStaffList.do" method="post">
  <table border="0" width="600px" height="40px" align="center">
    <tr>
      <td>部门:</td>
      <td>
       <select name="dep" onchange="showPost(this.value)">
         <option value="-1">--请选择部门--</option>
         <c:forEach items="${depList }" var="dep">
         <option value="${dep.id }">${dep.depName }</option>
         </c:forEach>
       </select>
      </td>
      
      <td>职务:</td> 
      <td>
       <select id="postId" name="post">
         <option value="-1">--请选择职务--</option>
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
     <c:if test="${StaffList == null }">
     	<c:redirect url="staffList.do"/>
     </c:if>
     <c:forEach items="${StaffList}" var="st">
     <tr>
       <td>${st.staffName }</td>
       <td>${st.gender }</td>
       <td>${st.onDutyDate }</td>
       <td>${st.depName }</td>
       <td>${st.postName }</td>
       <td>
         <a href="editStaff.do?id=${st.staffId }"><img src="images/button/modify.gif"/></a>
		 <a href="delStaff.do?id=${st.staffId }"><img src="images/button/delete.gif"/></a>
       </td>
     </tr>
     </c:forEach>
   </table>
 </div>
 <div id="pageDiv">
    <span id="pageSpanId">当前${currentPage}页 / 共${pageCount}页,总条数${rows}条。<br>
     <a href="staffPage.do?pageIndex=${currentPage - 1}">上一页</a> 
     <c:forEach begin="1" end="${pageCount}" var ="pageIndex">
     	<c:choose>
     		<c:when test="${currentPage == pageIndex }">
     			<font color="red">
     				${pageIndex }
     			</font>
     		</c:when>
     		<c:otherwise>
     		 <a href="staffPage.do?pageIndex=${pageIndex}">&nbsp;${pageIndex }&nbsp;</a> 
     		</c:otherwise>
     	</c:choose>
     </c:forEach>
        <a href="staffPage.do?pageIndex=${currentPage + 1}">下一页</a> 
        <a href="staffPage.do?pageIndex=${pageCount}">尾页</a> 
    </span>
    <input type="text" id="pageGoInputId" size="4">
    <input type="button" onclick="pageGo()" value="go"> 
    <br>
    <fy:pageTag pageSize="5" gotoURI="staffPage.do"/>
 </div>
  <script type="text/javascript">
  function showPost(depid){
	  $("#postId").empty();//清空下拉框
	  $.getJSON("showPost.do?depId="+depid,function(data){
		  $.each(data,function(i,item){
			   $("#postId").append("<option value='"+item.postId+"'>"
					   +item.postName+"</option>");
		  })
	  })
  }
  
  function pageGo(){ 
	  var inputValue = document.getElementById('pageGoInputId').value;
	  if(inputValue>=0 && inputValue<=${pageCount}){
		   location.href = 'staffPage.do?pageIndex=' + inputValue;
	   }else{
	   alert("请输入正确的页码数！");
 }
}
function query(){ 
	 var formObj=document.getElementById("formId");
		 formObj.submit();//手动提交表单
		 return true;	
}
  </script> 
</div>
</body>
</html>
    