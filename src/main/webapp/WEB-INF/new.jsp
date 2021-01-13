<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: scc
  Date: 1/13/2021
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">

    <div class="row">

        <div class="col-3"></div>
        <div class="col-6">
            <h1>What is Your Question</h1>

        <form:form action="/questions/new" method="post" modelAttribute="getForm">
            <div>
                <form:label path="question">Question</form:label>
                <form:textarea class="form-control mt-3"  path="question" rows="3"></form:textarea>

            </div>
            <form:errors path="tags"/>
            <div class="mt-2">
                <form:label path="tags">Tags</form:label>
                <form:input path="tags"/>

            </div>
            <div>
                <button type="submit" class="btn btn-primary mt-3">Submit</button>

            </div>

        </form:form>



        </div>
        <div class="col-3"></div>

    </div>



</div>

</body>
</html>
