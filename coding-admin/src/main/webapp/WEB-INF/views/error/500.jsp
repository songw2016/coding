<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%response.setStatus(200);%>
<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
 
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
	<title>500 - 系统内部错误</title>
	
</head>

<body>
	<h2>500 - 系统发生内部错误.</h2>
	<p>
		<%=ex %>
	</p>
</body>
</html>
