<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>课表上传</title>
</head>
<body>
<h2>课表上传</h2>
<form action="classUpload.do" method="post" 
enctype="multipart/form-data">
选择课标文件： <input type="file" name="kbfile"/> 
<input type="submit" value="上传"/>
</form>
</body>
</html>