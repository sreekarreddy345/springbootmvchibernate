<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AddEmployee</title>

    <link href="${pageContext.request.contextPath}/resources/css/uikit.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/uikit.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/core/dropdown.js"></script>

</head>
<body>
<form:form class="uk-form uk-form-horizontal" method="post" modelAttribute="employee"
           action="${pageContext.request.contextPath}/saveEmployee">
    <legend>Employee Information</legend>
    <div class="uk-form-row"></div>
    <label class="uk-form-label uk-text-bold">FirstName</label>
    <div class="uk-form-controls">
        <form:input type="text" path="firstName" name="firstName"/>
    </div>
    <form:hidden path="id" name="id"/>

    <div class="uk-form-row"></div>
    <label class="uk-form-label uk-text-bold"> LastName</label>
    <div class="uk-form-controls">
        <form:input type="text" path="lastName" name="lastName"/>
    </div>

    <div class="uk-form-row"></div>
    <label class="uk-form-label uk-text-bold">Age</label>
    <div class="uk-form-controls">
        <form:input type="text" path="age" name="age"/>
    </div>

    <div class="uk-form-row"></div>
    <label class="uk-form-label uk-text-bold">City</label>
    <div class="uk-form-controls">
        <form:input type="text" path="city" name="city"/>
    </div>
    <div class="uk-form-row uk-width-1-4 uk-text-center">

        <input type="submit" class="uk-button-success uk-button-large "/>

    </div>
</form:form>
</body>
</html>
