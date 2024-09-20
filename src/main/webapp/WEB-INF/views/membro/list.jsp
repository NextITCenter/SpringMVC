<%--
  Created by IntelliJ IDEA.
  User: pc11
  Date: 2024-09-13
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 목록</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>회원 목록</h2>
    <table class="table">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>휴대전화번호</th>
            <th>이메일</th>
            <th></th>
        </tr>
        <c:forEach items="${membros}" var="m">
            <tr>
                <td>${m.id}</td>
                <td><a href="/membro/${m.id}">${m.name}</a></td>
                <td>${m.mobileNumber}</td>
                <td>${m.email}</td>
                <td><a href="/membro/auth?id=${m.id}" class="btn btn-outline-primary">권한</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
