<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="message">
    Wiadomosc<form:input path="text"/>

    <form:hidden path="receiver" />

<button type="submit">Wyślij</button>

</form:form>
</body>
</html>
