<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <s:message code="pages.register.head.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body class="has-navbar-fixed-top">
<header>
    <jsp:include page="/WEB-INF/views/fragments/topbar.jsp"/>
</header>
<section class="hero is-fullheight">
    <div class="container">
        <h1 class="title">
            <s:message code="pages.register.form.title.main"/>
        </h1>
        <h2 class="subtitle">
            <s:message code="pages.register.form.title.sub"/>
        </h2>
    </div>


    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form method="post" modelAttribute="register">
                    <div class="field">
                        <form:label path="firstName" cssClass="label"><s:message code="global.username"/></form:label>
                        <div class="control has-icons-left">
                            <s:message code="pages.register.form.helps.username" var="firstNamePlaceholder"/>
                            <form:input path="firstName" cssClass="input" required="true" placeholder="${firstNamePlaceholder}"/>
                            <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                            <form:errors path="firstName" element="p" cssClass="help is-danger"/>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="lastName" cssClass="label"><s:message code="global.lastname"/></form:label>
                        <div class="control has-icons-left">
                            <s:message code="pages.register.form.helps.username" var="lastNamePlaceholder"/>
                            <form:input path="lastName" cssClass="input" required="true" placeholder="${lastNamePlaceholder}"/>
                            <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                            <form:errors path="lastName" element="p" cssClass="help is-danger"/>
                        </div>
                    <div class="field">
                        <form:label path="email" cssClass="label"><s:message code="global.email"/></form:label>
                        <div class="control has-icons-left">
                            <s:message code="pages.register.form.helps.email" var="emailPlaceholder"/>
                            <form:input path="email" cssClass="input" required="true" placeholder="${emailPlaceholder}"/>
                            <span class="icon is-small is-left"><i
                                    class="fas fa-envelope"></i></span>
                            <form:errors path="email" element="p" cssClass="help is-danger"/>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="password" cssClass="label"><s:message code="global.password"/></form:label>
                        <div class="control has-icons-left">
                            <s:message code="pages.register.form.helps.password" var="passwordPlaceholder"/>
                            <form:password path="password" cssClass="input" required="true" placeholder="${passwordPlaceholder}"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <form:errors path="password" element="p" cssClass="help is-danger"/>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="rePassword" cssClass="label"><s:message code="global.re-password"/></form:label>
                        <div class="control has-icons-left">
                            <s:message code="pages.register.form.helps.re-password" var="rePasswordPlaceholder"/>
                            <form:password path="rePassword" cssClass="input" required="true" placeholder="${rePasswordPlaceholder}"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help is-dange"></p>
                            <form:errors path="rePassword" element="p" cssClass="help is-danger"/>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="termsAcceptance"
                                    cssClass="checkbox">
                            <form:checkbox path="termsAcceptance"
                                           required="true"/> <s:message code="pages.register.form.helps.terms"/></form:label>
                        <form:errors path="termsAcceptance" element="p" cssClass="help is-danger"/>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button  is-black" type="submit"><s:message code="pages.register.form.submit"/>
                            </button>
                        </div>
                        <div class="control">
                            <button class="button  is-black" type="reset"><s:message code="pages.register.form.reset"/></button>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form:form>
            </div>
            <div class="column">
            </div>
        </div>
    </div>
</section>
</body>
</html>
