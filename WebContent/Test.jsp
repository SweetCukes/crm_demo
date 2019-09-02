<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<a href=" <c:url value='/cn.incast.servlet.OneServlet'/>">go</a><br/>
	<a href="${pageContext.request.contextPath}/cn.incast.servlet.OneServlet">go</a>
</body>
</html>