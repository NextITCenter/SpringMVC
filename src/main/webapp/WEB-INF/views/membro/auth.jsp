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
        <c:forEach items="${authorities}" var="auth" varStatus="status">
            <li class="list-group-item">
                <input class="form-check-input me-1" type="checkbox" value="${auth.authority}" data-membro-id="${param.id}" id="auth${status.count}">
                <label class="form-check-label" for="auth${status.count}">${auths.stream().filter(a -> auth.authority == a).findFirst().get().getTitle()}</label>
            </li>
        </c:forEach>
    </ul>
    <div>
        <button class="btn btn-danger" type="button" id="deleteBtn">권한 삭제</button>
        <!-- 권한 삭제 버튼 클릭시 권한 삭제하는 과제(2024.09.20) -->
    </div>
</div>
<input type="hidden" id="membroId" value="${param.id}">
<script src="/js/bootstrap.bundle.min.js"></script>
<script>
    const searchParams = new URLSearchParams(location.search)
    const dropdownItems = document.querySelectorAll(".dropdown-item")
    const listGroup = document.querySelector(".list-group")
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
                if (data.result === "success") {
                    // 동적으로 태그 만들기
                    // 1. document의 createElement() 함수 사용
                    const inputEl = document.createElement("input")
                    inputEl.classList.add("form-check-input", "me-1")
                    inputEl.setAttribute("type", "checkbox")
                    inputEl.setAttribute("value", "?")
                    inputEl.setAttribute("data-membro-id", "?")
                    inputEl.setAttribute("id", "auth0")

                    const labelEl = document.createElement("label")
                    labelEl.classList.add("form-check-label")
                    labelEl.setAttribute("for", "auth0")
                    labelEl.textContent = "?"

                    const liEl = document.createElement("li")
                    liEl.classList.add("list-group-item")
                    liEl.appendChild(inputEl)
                    liEl.appendChild(labelEl)

                    listGroup.appendChild(liEl)
                    // 2. innerHTML을 사용
                    // listGroup.innerHTML += `<li class="list-group-item">\${evt.target.textContent}</li>`
                } else {
                    alert("권한이 정상적으로 등록되지 않았습니다.");
                }
            })
        })
    })
</script>
</body>
</html>














