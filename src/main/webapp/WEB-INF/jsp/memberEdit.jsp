<%--
    Document   : memberList
    Created on : 19.09.2018., 13.14.52
    Author     : Vlada
--%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Member List</title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>

<body>
<form action="<c:url value="/logout"/>" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="ui small red basic compact button">Logout</button>
</form>

<form:form method="post" modelAttribute="member">
    <form:errors path="*" cssClass="error"/>
    <table>
        <tr>

            <td>Name <form:input path="name" value="${member.name}"/></td>
            <td>Phone <form:input path="phone" value="${member.phone}"/></td>
            <td>Email <form:input path="email" value="${member.email}"/></td>
            <td>ID <form:hidden path="id" value="${member.id}"/></td>
            <td><input type="submit"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>