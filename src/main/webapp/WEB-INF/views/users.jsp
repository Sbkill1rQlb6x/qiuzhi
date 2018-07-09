<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guoshuai
  Date: 2018/7/3
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${users}" var="u">
    <tr>
        <td>${u.userName}</td>
        <td>${u.email}</td>
    </tr>
</c:forEach>
</body>
</html>
