<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>部门管理</title>
<link href="css/list.css" type="text/css" rel="stylesheet"/>
<style type="text/css"> 
#pageSpanId a{
	text-decoration: none;
	}
</style>
</head>

<body>
<div id="main">
 <div id="topMenu">
   <span class="tip">[部门管理]</span>    
   <!-- 添加部门 -->
    <a href="depAdd.jsp" target="mainframe">
    <img src="images/button/tianjia.gif">
    </a> 
 </div>
<div id="dataArea">  
<img src="images/result.gif"/>
   <table class="dataTable" width="100%" border="1" cellspacing="0" cellpadding="0">
     <tr class="hbg">
       <th>部门ID</th>
       <th>部门名称</th> 
       <th>编辑</th>
     </tr>
     <c:if test="${depList == null }">
     	<c:redirect url="deplist.do"/>
     </c:if>
     <c:forEach items="${depList}" var="dep">
     <tr>
       <td>${dep.id }</td>
       <td>${dep.depName }</td> 
       <td>
<%--          url字符串有长度限制，超过长度会被截断。
<a href="depUpdate.jsp?id=${dep.id}&depName=${dep.depName}"> --%>
		<a href="depEdit.do?id=${dep.id}&depName=${dep.depName }">
         <img src="images/button/modify.gif"/></a> 
		 <a href="depDelete.do?id=${dep.id}">
         <img src="images/button/delete.gif"/>
         </a> 
       </td>
       </tr>
       </c:forEach>
   </table>
<div id="pageDiv">
    <span id="pageSpanId">当前${currentPage}页共${pageCount}页，总条数${rows }条。<br>
       	        <a href="depPage.do?pageIndex=${currentPage - 1}">上一页</a> 
       	<c:forEach begin="1" end="${pageCount}" var="pageIndex">
       		<c:choose>
       			<c:when test="${currentPage == pageIndex}">
       				<font color="red">
       				${pageIndex}
       				</font>
       			</c:when>
       			<c:otherwise>
       				<a href="depPage.do?pageIndex=${pageIndex}">&nbsp;${pageIndex}&nbsp;</a> 
       			</c:otherwise>
       		</c:choose>
       	</c:forEach>
        <a href="depPage.do?pageIndex=${currentPage + 1}">下一页</a> 
        <a href="depPage.do?pageIndex=${pageCount}">尾页</a> 
    </span>
    <input type="text" id="pageGoInputId" size="4">
    <input type="button"onclick="pageGo()" value="go"> 
 </div>
 <script type="text/javascript">
  function pageGo(){ 
   var inputValue = document.getElementById('pageGoInputId').value;
   if(inputValue>=0 && inputValue<${pageCount}){
	   location.href = 'depPage.do?pageIndex=' + inputValue;
   }else{
	   alert("请输入正确页码数");
   }
   
   }
   </script>
   
    </td>
  </tr>
</tbody>
</table>
 </div>
</div>
</body>
</html>
