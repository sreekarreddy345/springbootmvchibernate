<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees Home</title>

    <link href="${pageContext.request.contextPath}/resources/css/uikit.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/uikit.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/core/dropdown.js"></script>


    <style>.AddEmployeeButton {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
    </style>

</head>
<body>

<c:if test="${dataInserted == 1}">
    <div class="uk-alert uk-alert-success" data-uk-alert>
        <a href="" class="uk-alert-close uk-close"></a>
        <p>Data has been successfully inserted into Database</p>
    </div>

</c:if>
<c:if test="${dataInserted ==0}">
    <div class="uk-alert uk-alert-danger" data-uk-alert>
        <a href="" class="uk-alert-close uk-close"></a>
        <p>Data couldn't be inserted. Please try again!</p>
    </div>
</c:if>
<% String contextPath1 = application.getContextPath();%>
<div style="float: right;" class="AddEmployeeButton"><a href=<%=contextPath1%>/create>Add Employee</a></div>

<% session.removeAttribute("dataInserted"); %>
<table class="uk-table uk-table-hover">
    <% %>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>City</th>
    </tr>

    <c:forEach var="boo" items="${employeeList}">

        <tr>
            <td>${boo.id}</td>
            <td>${boo.firstName}</td>
            <td>${boo.lastName}</td>
            <td>${boo.age}</td>
            <td>${boo.city}</td>
            <td><a href=<%=contextPath1%>/delete/${boo.id} class="uk-icon-close" data-uk-tooltip="{pos:'top'}">Delete</a></td>
            <td><a href=<%=contextPath1%>/update/${boo.id} class="uk-icon-close" data-uk-tooltip="{pos:'top'}">Update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
