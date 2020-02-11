<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://wuse.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top is-black">
<header>
    <jsp:include page="/WEB-INF/views/fragments/topbar.jsp"/>
</header>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="left-container">

                <div class="left-arrow">

                    <c:url var="accountURL" value="/user/account"/>
                    <a class="navbar-item button is-black" href="${accountURL}">
                        <spring:message code="pages.menu.links.account"/>
                    </a>

                </div>
            Wszystkie twoje tweety
<c:forEach items="${allTwitt}" var="allTwitt">
    ${allTwitt.user.id}
    ${allTwitt.text}

<sec:csrfInput/>
</c:forEach>
        <div class="hero-body">
            <h1 class="title">
                Twitter
            </h1>
            <h2 class="subtitle">
                Witaj w projekcie <strong>Twitter</strong>.
                <br/>
            </h2>

        </div>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>
