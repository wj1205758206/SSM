<%--
  Created by IntelliJ IDEA.
  User: Jian
  Date: 2021/5/9
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
success!
${teacherPageInfo.list}
<a href="getTeacherAll?pageNum=1">首页</a><br>
<a href="getTeacherAll?pageNum=${teacherPageInfo.prePage}">前一页</a><br>
<a>当前页码：${teacherPageInfo.pageNum}</a><br>
<a href="getTeacherAll?pageNum=${teacherPageInfo.nextPage}">后一页</a><br>
<a href="getTeacherAll?pageNum=${teacherPageInfo.pages}">末页</a><br>
</body>
</html>
