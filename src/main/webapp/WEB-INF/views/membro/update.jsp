<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pc11
  Date: 2024-09-12
  Time: 오전 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 정보</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>회원 정보</h2>
    <form class="needs-validation my-3" novalidate action="/membro/update" method="post">
        <div class="row g-3">
            <div class="col-12">
                <label for="id" class="form-label">ID</label>
                <div class="input-group has-validation">
                    <input type="text" class="form-control" id="id" name="id" placeholder="ID" readonly value="${membro.id}">
                    <div class="valid-feedback">
                        해당 아이디는 사용하실 수 있습니다.
                    </div>
                    <div class="invalid-feedback">
                        해당 아이디는 사용하실 수 없습니다.
                    </div>
                </div>
            </div>
            <div class="col-12">
                <label for="username" class="form-label">이름</label>
                <input type="text" class="form-control" id="username" name="name" placeholder="홍길동" readonly required value="${membro.name}">
                <div class="invalid-feedback">
                    이름은 반드시 입력해야 합니다.
                </div>
            </div>
            <div class="col-12">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" readonly required value="${membro.email}">
                <div class="invalid-feedback">
                    이메일이 유효하지 않습니다.
                </div>
            </div>
            <div class="col-12 my-3">
                <label for="mobileNumber" class="form-label">휴대전화번호</label>
                <input type="tel" class="form-control" id="mobileNumber" name="mobileNumber" placeholder="010-1234-5678" readonly required value="${membro.mobileNumber}">
                <div class="invalid-feedback">
                    휴대전화번호를 입력하세요.
                </div>
            </div>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-center">
            <button class="btn btn-primary btn-lg" id="modifyBtn" type="button">정보 변경</button>
            <button class="btn btn-primary btn-lg" type="button">회원 탈퇴</button>
        </div>
        <security:csrfInput/>
    </form>
</div>
<script src="/js/bootstrap.bundle.min.js"></script>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (() => {
        'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')
        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()
    const modifyBtn = document.querySelector("#modifyBtn")
    modifyBtn.addEventListener("click", (evt) => {
        const btn = evt.target; // => 클릭했을 때 클릭한 대상이 바로 target
        if (btn.textContent !== "수정") {
            btn.textContent = "수정"
            // document.querySelector("#username").readOnly = false;
            document.querySelector("#username").removeAttribute("readonly")
            document.querySelector("#email").readOnly = false
            document.querySelector("#mobileNumber").removeAttribute("readonly")
            btn.type = "submit"
            evt.preventDefault();// 원래 실행해야할 이벤트를 막아주는 함수
            // evt.stopPropagation() => 이벤트의 전파를 막는 것
        }
    })
</script>
</body>
</html>
