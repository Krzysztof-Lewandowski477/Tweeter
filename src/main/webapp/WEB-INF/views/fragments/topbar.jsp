<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<header>--%>


<nav class="navbar is-fixed-top is-black" role="navigation" aria-label="main navigation">
    <div class="navbar-brand is-black">
        <div class="navbar-item ">
            <c:url var="homeURL" value="/"/>
            <a class="button is-black " href="${homeURL}">
                <spring:message code="pages.menu.links.main"/>
            </a>
        </div>
    </div>
    <div class="navbar-menu is-black">
        <div class="navbar-start">
            <sec:authorize access="hasRole('USER')">
                <div class="navbar-item">

                    <c:url var="accountURL" value="/user/account"/>
                    <a class="navbar-item button is-black" href="${accountURL}">
                        <spring:message code="pages.menu.links.account"/>
                    </a>

                </div>
            </sec:authorize>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <sec:authorize access="!isAuthenticated()">

                        <c:url var="registerURL" value="/register"/>
                        <a class="button  is-black" href="${registerURL}">
                            <strong><spring:message code="pages.menu.links.register"/></strong>
                        </a>
                        <c:url var="loginURL" value="/login"/>
                        <a class="button is-black" href="${loginURL}">
                            <strong><spring:message code="pages.menu.links.login"/></strong>
                        </a>

                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">

                        <c:url var="logoutURL" value="/logout"/>
                        <form method="post" action="${logoutURL}">
                            <button class="button  is-black" ><spring:message code="pages.menu.links.logout"/></button>
                            <sec:csrfInput/>
                        </form>

                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</nav>

<%--</header>--%>
