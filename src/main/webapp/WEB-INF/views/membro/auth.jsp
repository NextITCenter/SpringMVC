<%--
  Created by IntelliJ IDEA.
  User: pc11
  Date: 2024-09-20
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사용자 권한 관리</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>권한</h2>
    <ul class="list-group">
        <c:forEach items="${authorities}" var="auth">
            <li class="list-group-item">${auth.authority}</li>
        </c:forEach>
    </ul>
</div>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
