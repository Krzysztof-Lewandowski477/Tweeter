

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="slogan container container--90 -align-center">
    <div class="slogan--item">
        <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">

            <td width="185px"> Nazwa użytkownika  </td>

            <td align="center"> Operacje</td>
            </tr>

            <tr>

                <td>${tweet.text}</td>
                <td>${tweet.id}</td>
                <td>
                    <button  class="default-button" onclick="window.location.href ='${deleteURL}';">Usuń</button>
                </td>
            </tr>
        </table>
            <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
                <td>Komentarz</td>
                <td width="185px"> Nazwa użytkownika  </td>

                <td align="center"> Operacje</td>
                </tr>
                <for:forEach items="${comments}" var="comments" begin="0">
            <tr>
                <td>${comments.text}</td>
                    <td>${comments.user.firstName}</td>
                    <td><b> <a href="${detailsURL}" type="Submit">Napisz do komentującego</a></b></td>
                    <c:url value="/user/message" var="detailsURL">
                        <c:param name="id" value="${comments.user.id}"/>
                    </c:url>

            <tr>
                </for:forEach>


            <tr>
                <form:form  method="post" modelAttribute="comment" >
                Komentarz:<form:input path="text"/>
                    <form:hidden path="user.id"/>
                    <form:hidden path="tweet.id"/>
                    <form:hidden path="twitterId" value="${tweet.id}"/>
                    <button type="submit" title="Submit">Dodaj komentarz</button>
                </form:form>



        </table>
    </div>
</div>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>