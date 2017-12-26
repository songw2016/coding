<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录程序猿管理系统</title>
    <link href="${staticUrl}/css/admin.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="${staticUrl}/favicon.ico" type="image/x-icon">


    <script language="JavaScript" src="${staticUrl}/js/lib/jquery-1.11.3.min.js"></script>
    <script language="JavaScript" src="${staticUrl}/js/lib/md5.js"></script>

    <script language="javascript">
        var CONTEXTPATH = "${webUrl}";
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
            $("#loginName").focus();
        });
    </script>
    <script src="${staticUrl}/js/page/login.js" type="text/javascript"></script>

</head>

<body style="background-color:#1c77ac; background-image:url(${staticUrl}/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录程序猿管理系统</span>
    <ul>
        <%--    <li><a href="#">回首页</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>--%>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox">

        <ul>
            <li><input id="loginName" type="text" class="loginuser" value=""  onkeydown="treatKeyEvent(event);"/></li>
            <li><input id="loginPwd" type="text" class="loginpwd" value="" onkeydown="treatKeyEvent(event);"/></li>
            <li><input type="button" class="loginbtn" value="登录" onclick="javascript:if(FrmCheck()) submitLogin();" />
                <%--<label> <input name="" type="checkbox" value=""  checked="checked"/>记住密码</label>
                <label> <a  href="#">忘记密码？</a></label>--%></li>
        </ul>


    </div>

</div>

<div class="loginbm">版权所有 2017 程序猿代码随笔</div>
</body>
</html>
