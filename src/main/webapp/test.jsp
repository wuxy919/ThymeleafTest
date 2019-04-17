<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fprm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <form:form modelAttribute="user" action="/hello/validate" method="post">
        用户ID：<form:input path="id"></form:input><fprm:errors path="id"></fprm:errors>   <br/>
        用户名：<form:input path="name"></form:input><fprm:errors path="name"></fprm:errors>   <br/>
        <input type="submit"/>
    </form:form>
</body>
</html>