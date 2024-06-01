<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.javarush.petrenko.quest.enumm.Title" %>

<!DOCTYPE html>
<html>
<head>
    <title>Text Quest</title>

    <%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
<t:set var="SHIP" value="<%=Title.SHIP%>"/>
<t:set var="CAPTAIN_BRIDGE" value="<%=Title.CAPTAIN_BRIDGE%>"/>
<t:set var="ROOM" value="<%=Title.ROOM%>"/>
<t:set var="WAREHOUSE" value="<%=Title.WAREHOUSE%>"/>
<div>
    <p>quest</p>
    <form>
        <button type="button" onclick="selectOption('ship')">нажать</button>
    </form>
</div>
<t:if test="${ship == SHIP}">
    <h1>что-то получилось</h1>
</t:if>
<script>
    function selectOption(action) {
        $.ajax({
            type: 'POST',
            url: 'start',
            data: {action: action},
            success: function (){
                location.reload();
            }
        })
    }
</script>
</body>
</html>
