<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>404 - 页面不存在</title>
	 <script type="text/javascript">
             function returnToTheHomePage(){
		             top.location.replace("${webUrl}/main");
	         }
     </script>
</head>

<body>
	<h2>404 - 页面不存在.</h2>
	<p><a href="javascript:returnToTheHomePage()">返回首页</a></p>
</body>
</html>