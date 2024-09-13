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
    <title>회원 등록</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>회원 가입</h2>
    <form class="needs-validation my-3" novalidate action="/membro/register" method="post">
        <div class="row g-3">
            <div class="col-12">
                <label for="id" class="form-label">ID</label>
                <div class="input-group has-validation">
                    <input type="text" class="form-control" id="id" name="id" placeholder="ID" required>
                    <button class="btn btn-outline-secondary" type="button" id="idCheck">ID 중복 검사</button>
                    <div class="valid-feedback">
                        해당 아이디는 사용하실 수 있습니다.
                    </div>
                    <div class="invalid-feedback">
                        해당 아이디는 사용하실 수 없습니다.
                    </div>
                </div>
            </div>
            <div class="col-12">
                <label for="password" class="form-label">패스워드</label>
                <input type="password" class="form-control" id="password" required>
                <div class="invalid-feedback">
                    패스워드를 입력해야 합니다.
                </div>
            </div>
            <div class="col-12">
                <label for="passwordConfirm" class="form-label">패스워드 확인</label>
                <input type="password" class="form-control" id="passwordConfirm" name="password">
                <div class="invalid-feedback">
                    패스워드가 일치하지 않습니다.
                </div>
                <div class="valid-feedback">
                    패스워드가 일치합니다.
                </div>
            </div>
            <div class="col-12">
                <label for="username" class="form-label">이름</label>
                <input type="text" class="form-control" id="username" name="name" placeholder="홍길동" required>
                <div class="invalid-feedback">
                    이름은 반드시 입력해야 합니다.
                </div>
            </div>
            <div class="col-12">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
                <div class="invalid-feedback">
                    이메일이 유효하지 않습니다.
                </div>
            </div>
            <div class="col-12 my-3">
                <label for="mobileNumber" class="form-label">휴대전화번호</label>
                <input type="tel" class="form-control" id="mobileNumber" name="mobileNumber" placeholder="010-1234-5678" required>
                <div class="invalid-feedback">
                    휴대전화번호를 입력하세요.
                </div>
            </div>
        </div>
        <button class="w-100 btn btn-primary btn-lg" type="submit">회원 가입</button>
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
        const passwordEl = document.querySelector("#password")
        const passwordConfirmEl = document.querySelector("#passwordConfirm")
        passwordConfirmEl.addEventListener("keyup", (evt) => {
            let pcEl = evt.target
            pcEl.classList.remove("is-invalid", "is-valid")
            if (pcEl.value === passwordEl.value) {
                pcEl.classList.add("is-valid")
            } else {
                pcEl.classList.add("is-invalid")
            }
        })
    })()
    const idCheck = document.querySelector("#idCheck");
    const idEl = document.querySelector("#id");
    idCheck.addEventListener("click", () => {
        idEl.classList.remove("is-invalid", "is-valid")
        let idValue = idEl.value;
        if (idValue.length == 0) {
            idEl.setCustomValidity("ID를 입력하세요.")
            // checkValidity()는 폼 태그 전체에서 사용하는 것
            // reportValidity()는 입력태그(input, textarea, select)에서 개별적으로 사용
            idEl.reportValidity()
            idEl.focus()
            return;
        }
        fetch(`/check/\${idValue}`)
            .then(response => response.json())
            .then(data => {
                if (data.result == "ok") {
                    // .invalid-feedback에 "해당 아이디는 사용하실 수 있습니다." 정보 표시
                    idEl.classList.add("is-valid")
                } else {
                    // .invalid-feedback에 "해당 아이디는 사용하실 수 없습니다." 정보 표시
                    idEl.classList.add("is-invalid")
                }
            })
    })
</script>
</body>
</html>
