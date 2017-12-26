<%@ page import="org.apache.commons.lang3.exception.ExceptionUtils" %>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%response.setStatus(200);%>
<%
    Throwable ex = null;
    if (exception != null)
        ex = exception;
    if (request.getAttribute("javax.servlet.error.exception") != null)
        ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
        System.out.println(ExceptionUtils.getStackTrace(ex));
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>500 - 系统内部错误</title>
</head>

<body>
<h2>500 - 系统发生内部错误.</h2>
<p><%out.print(ExceptionUtils.getStackTrace(ex));%></p>
</body>
</html>
