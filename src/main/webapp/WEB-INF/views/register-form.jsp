<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form method="post" modelAttribute="register">


   Email: <form:input path="email"  requaired="true"/><form:errors path="email" element="p" cssClass="text-input"/><br/>
    Name:<form:input path="firstName" title="username"/><form:errors path="firstName" element="p"/><br/>
    lastName:<form:input path="lastName" title="lastName"/><form:errors path="lastName" element="p"/><br/>
    Password:<form:input path="password" requaired="true" type="password"/><form:errors path="password" element="p" /><br/>
    RePassword:<form:input path="rePassword" type="password"/><form:errors path="rePassword" element="p"/><br/>
    TermsAcceptance:<form:checkbox path="termsAcceptance" /><form:errors path="termsAcceptance"/><br/>
    <form:button name="Accept" class="button is-black" type="Submit">Accept</form:button>




</form:form>
</body>
</html>
