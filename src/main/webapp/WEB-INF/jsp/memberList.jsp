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
            <td>Name <form:input path="name"/></td>
            <td>Phone <form:input path="phone"/></td>
            <td>Email <form:input path="email"/></td>
            <td><input type="submit"/></td>
        </tr>
    </table>
</form:form>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>

    <c:forEach items="${guests}" var="mem">
        <tr>
            <td>${mem.name}</td>
            <td>${mem.phone}</td>
            <td>${mem.email}</td>
            <form:form action="remove" method="POST">
                <input type="hidden" id="memberId" name="memberId" value="${mem.id}">
                <td><input type="submit" value="Delete"></td>
            </form:form>
            <form:form action="memberEdit" method="GET">
                <input type="hidden" id="memberId" name="memberId" value="${mem.id}">
                <td><input type="submit" value="Edit"></td>
            </form:form>
        </tr>
    </c:forEach>

</table>
</body>
</html>