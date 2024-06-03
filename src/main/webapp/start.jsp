<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Text Quest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body class="text-center">
<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5">
    <div class="modal-dialog">
        <div class="modal-content rounded-3 shadow">
            <div class="modal-body p-4 text-center">
                <p class="mb-0">Прохождение: ${number}</p>
                <p class="mb-0">${name} ${text.get(0)}</p>
                <h5 class="mb-0">${text.get(1)}</h5>
            </div>
            <div>
                <c:if test="${title eq 'BEGINNING' || title eq 'BAD_BEGINNING'}">
                    <c:if test="${fail != true}">
                        <form action="start" method="post">
                            <input type="radio" name="title" value="CAPTAIN_BRIDGE"/> ${text.get(2)} <br/>
                            <input type="radio" name="title" value="BAD_BEGINNING"/> ${text.get(3)} <br/>
                            <input type="hidden" name="name" value="${name}">
                            <button type="submit" class="w-100 btn btn-lg btn-primary">Выбрать</button>
                        </form>
                    </c:if>
                    <c:if test="${fail == true}">
                        <form action="start" method="post">
                            <input type="hidden" name="title" value="BEGINNING"/>
                            <input type="hidden" name="number" value="${number}"/>
                            <input type="hidden" name="name" value="${name}">
                            <button type="submit" class="w-100 btn btn-lg btn-primary">Заново</button>
                        </form>
                    </c:if>
                </c:if>

                <c:if test="${title eq 'CAPTAIN_BRIDGE' || title eq 'BAD_CAPTAIN_BRIDGE'}">
                    <c:if test="${fail != true}">
                        <form action="start" method="post">
                            <input type="radio" name="title" value="FIND_NAME"/> ${text.get(2)} <br/>
                            <input type="radio" name="title" value="BAD_CAPTAIN_BRIDGE"/> ${text.get(3)} <br/>
                            <input type="hidden" name="name" value="${name}">
                            <button type="submit" class="w-100 btn btn-lg btn-primary">Выбрать</button>
                        </form>
                    </c:if>
                    <c:if test="${fail == true}">
                        <form action="start" method="post">
                            <input type="hidden" name="title" value="BEGINNING"/>
                            <input type="hidden" name="number" value="${number}"/>
                            <input type="hidden" name="name" value="${name}">
                            <button type="submit" class="w-100 btn btn-lg btn-primary">Заново</button>
                        </form>
                    </c:if>
                </c:if>

                <c:if test="${title eq 'FIND_NAME' || title eq 'BAD_FIND_NAME'}">
                    <c:if test="${fail != true}">
                        <form action="start" method="post">
                            <input type="radio" name="title" value="GOOD_END"/> ${text.get(2)} <br/>
                            <input type="radio" name="title" value="BAD_FIND_NAME"/> ${text.get(3)} <br/>
                            <input type="hidden" name="name" value="${name}">
                            <button type="submit" class="w-100 btn btn-lg btn-primary">Выбрать</button>
                        </form>
                    </c:if>
                    <c:if test="${fail == true}">
                        <form action="start" method="post">
                            <input type="hidden" name="title" value="BEGINNING"/>
                            <input type="hidden" name="number" value="${number}"/>
                            <input type="hidden" name="name" value="${name}">
                            <button type="submit" class="w-100 btn btn-lg btn-primary">Заново</button>
                        </form>
                    </c:if>
                </c:if>

                <c:if test="${title eq 'GOOD_END'}">
                    <form action="start" method="post">
                        <input type="hidden" name="title" value="BEGINNING"/>
                        <input type="hidden" name="number" value="${number}"/>
                        <input type="hidden" name="name" value="${name}">
                        <button type="submit" class="w-100 btn btn-lg btn-primary">Заново</button>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
