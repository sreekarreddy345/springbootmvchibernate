<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Home</title>

    <link href="${pageContext.request.contextPath}/resources/css/uikit.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/uikit.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/core/dropdown.js"></script>


    <style>.AddStudentButton {
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
<div style="float: right;" class="AddStudentButton"><a href=<%=contextPath1%>/createStudent>Add Student</a></div>

<% session.removeAttribute("dataInserted"); %>
<div id="studentContent"> </div>
<script>
    jQuery(document).ready(function ($) {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/students",
            dataType: 'json',
            timeout: 100000,
            success: function (students) {
                console.log("SUCCESS: ", students);
                // display(data)

                var htmlText = '<table class="uk-table uk-table-hover">';
                htmlText += "<tr> <th>ID</th> <th>Address</th> <th>First Name</th> <th>Last Name</th> </tr>";

                students.forEach(function (student) {
                    htmlText += "<tr><td>" + student.id + "</td><td>" + student.address + "</td><td>" + student.firstName + "</td><td>" + student.lastName + "</td> </tr>";
                });
                htmlText += "</table>";
                $("#studentContent").html(htmlText);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                // display(e);
                alert(JSON.stringify(e));
            },
            done: function (e) {
                console.log("DONE");
            }
        });
    });
</script>
</body>

</html>
