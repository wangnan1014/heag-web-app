<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload a file please</title>
</head>
<body>
<h1>Please upload a file</h1>
<form method="post" action="upload" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file" multiple=true/>
    <input type="submit"/>
</form>
</body>
</html>