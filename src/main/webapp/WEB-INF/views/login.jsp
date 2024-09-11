<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pc11
  Date: 2024-09-11
  Time: 오전 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<form action="/login" method="post">
    <label>
        <input type="text" name="username" placeholder="ID">
    </label>
    <label>
        <input type="password" name="password" placeholder="password">
    </label>
    <button>로그인</button>
    <sec:csrfInput/>
</form>
</body>
</html>
