<%--
  Created by IntelliJ IDEA.
  User: pc11
  Date: 2024-09-20
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>사용자 권한 관리</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <sec:csrfMetaTags/>
</head>
<body>
<div class="container">
    <h2>권한</h2>
    <div class="dropdown py-2">
        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            authority
        </button>
        <ul class="dropdown-menu">
            <c:forEach items="${auths}" var="a">
            <li><button class="dropdown-item" type="button" data-code="${a.name()}">${a.title}</button></li>
            </c:forEach>
        </ul>
    </div>
    <ul class="list-group">
        <c:forEach items="${authorities}" var="auth">
            <li class="list-group-item">${auths.stream().filter(a -> auth.authority == a).findFirst().get().getTitle()}</li>
        </c:forEach>
    </ul>
</div>
<input type="hidden" id="membroId" value="${param.id}">
<script src="/js/bootstrap.bundle.min.js"></script>
<script>
    const searchParams = new URLSearchParams(location.search)
    const dropdownItems = document.querySelectorAll(".dropdown-item")
    dropdownItems.forEach(item => {
        item.addEventListener("click", evt => {
            const csrfHeader = document.querySelector("meta[name=_csrf_header]").getAttribute("content")
            const csrfValue = document.querySelector("meta[name=_csrf]").getAttribute("content")
            let headers = new Headers();
            headers.append(csrfHeader, csrfValue);
            headers.append("Content-Type", "application/json")
            fetch("/membro/auth", {
                method: "POST",
                headers: headers,
                body: JSON.stringify({
                    membroId: searchParams.get("id"),
                    authority: evt.target.dataset.code
                })
            })
            .then(response => response.json())
            .then(data => {
                console.log(data)
                location.reload();
            })
        })
    })
</script>
</body>
</html>














