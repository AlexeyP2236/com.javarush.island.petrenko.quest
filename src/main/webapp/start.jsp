<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Text Quest</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div>
    <p>quest</p>
</div>
<p>${name} ${text.get(0)}</p>
<p>${text.get(1)}</p>
<p>Number: ${number}</p>

<c:if test="${title eq 'BEGINNING'}">
    <c:if test="${fail != true}">
        <form action="start" method="post">
            <input type="radio" name="title" value="CAPTAIN_BRIDGE"/> ${text.get(2)} <br/>
            <input type="radio" name="title" value="BAD_BEGINNING"/> ${text.get(3)} <br/>
            <input type="hidden" name="name" value="${name}">
            <button type="submit">выбрать</button>
        </form>
    </c:if>
    <c:if test="${fail == true}">
        <form action="start" method="post">
            <input type="hidden" name="title" value="BEGINNING"/>
            <input type="hidden" name="number" value="${number}"/>
            <input type="hidden" name="name" value="${name}">
            <button type="submit">Заново</button>
        </form>
    </c:if>
</c:if>

<c:if test="${title eq 'CAPTAIN_BRIDGE'}">
    <c:if test="${fail != true}">
        <form action="start" method="post">
            <input type="radio" name="title" value="FIND_NAME"/> ${text.get(2)} <br/>
            <input type="radio" name="title" value="BAD_CAPTAIN_BRIDGE"/> ${text.get(3)} <br/>
            <input type="hidden" name="name" value="${name}">
            <button type="submit">выбрать</button>
        </form>
    </c:if>
    <c:if test="${fail == true}">
        <form action="start" method="post">
            <input type="hidden" name="title" value="BEGINNING"/>
            <input type="hidden" name="number" value="${number}"/>
            <input type="hidden" name="name" value="${name}">
            <button type="submit">Заново</button>
        </form>
    </c:if>
</c:if>

<c:if test="${title eq 'FIND_NAME'}">
    <c:if test="${fail != true}">
        <form action="start" method="post">
            <input type="radio" name="title" value="GOOD_END"/> ${text.get(2)} <br/>
            <input type="radio" name="title" value="BAD_FIND_NAME"/> ${text.get(3)} <br/>
            <input type="hidden" name="name" value="${name}">
            <button type="submit">выбрать</button>
        </form>
    </c:if>
    <c:if test="${fail == true}">
        <form action="start" method="post">
            <input type="hidden" name="title" value="BEGINNING"/>
            <input type="hidden" name="number" value="${number}"/>
            <input type="hidden" name="name" value="${name}">
            <button type="submit">Заново</button>
        </form>
    </c:if>
</c:if>

<c:if test="${title eq 'GOOD_END'}">
    <form action="start" method="post">
        <input type="hidden" name="title" value="BEGINNING"/>
        <input type="hidden" name="number" value="${number}"/>
        <input type="hidden" name="name" value="${name}">
        <button type="submit">Заново</button>
    </form>
</c:if>

</body>
</html>
