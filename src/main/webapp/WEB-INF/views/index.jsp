<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forEach" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>

    <s:message code="pages.login.head.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body class="has-navbar-fixed-top is-black">
<header>
    <jsp:include page="/WEB-INF/views/fragments/topbar.jsp"/>
</header>
Wszystkie tweety<br/>
Tweety:
<c:forEach items="${tweets}" var="tweets">
<br/>
    ${tweets.id}
    ${tweets.text}

<sec:csrfInput/>
</c:forEach>
<form:form method="post" modelAttribute="newTweet">
    Podaj Tweeter<form:textarea path="text" rows="2" cols="3"/><form:errors path="text"/>
    <form:hidden path="user"/><br/>
    <form:hidden path="created"/>
    <from:hidden path="user.id"/>
    <button class="button" type="submit">Submit</button>
    <sec:csrfInput/>
</form:form>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>
