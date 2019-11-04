<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Student</title>

    <link href="${pageContext.request.contextPath}/resources/css/uikit.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/uikit.js"></script>

</head>
<body>
<form class="uk-form uk-form-horizontal" method="post" id="student-form">
    <legend>Student Information</legend>
    <div class="uk-form-row"></div>
    <label class="uk-form-label uk-text-bold">FirstName</label>
    <div class="uk-form-controls">
        <input type="text" id="firstName"/>
    </div>
    <input type="hidden" id="id"/>

    <div class="uk-form-row"></div>
    <label class="uk-form-label uk-text-bold"> LastName</label>
    <div class="uk-form-controls">
        <input type="text" id="lastName"/>
    </div>

    <div class="uk-form-row"></div>
    <label class="uk-form-label uk-text-bold">Address</label>
    <div class="uk-form-controls">
        <input type="text" id="address"/>
    </div>
    <div class="uk-form-row uk-width-1-4 uk-text-center">

        <button type="submit" id="bth-search"
                class="uk-button-success uk-button-large ">Submit</button>

    </div>
</form>

<script>
    jQuery(document).ready(function ($) {
        // alert("Add Student page");
        $("#student-form").submit(function (event) {
            //Prevent default submission of form
            event.preventDefault();
            var id = $("#id").val();
            var address = $("#address").val();
            var firstName = $("#firstName").val();
            var lastName = $("#lastName").val();
            var data = {}
            data["id"] = id;
            data["address"] = address;
            data["firstName"] = firstName;
            data["lastName"] = lastName;

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/saveStudent",
                data: JSON.stringify(data),
                dataType: 'json',
                timeout: 100000,
                success: function (data) {
                    console.log("SUCCESS: ", data);
                    alert("SUCCESS - "+ data);
                    window.location.href = "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/getStudents";
<%--                    <%  response.sendRedirect("http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/getStudents");%>--%>

                },
                error: function (e) {
                    console.log("ERROR: ", e);
                    window.location.href = "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/getStudents";
                },
                done: function (e) {
                    console.log("DONE");
                }

            });

        });
    });
</script>
</body>
</html>
