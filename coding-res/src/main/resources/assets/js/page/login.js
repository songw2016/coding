// Cloud Float...
var $main = $cloud = mainwidth = null;
var offset1 = 450;
var offset2 = 0;
var offsetbg = 0;
$(document).ready(function () {
        $main = $("#mainBody");
        $body = $("body");
        $cloud1 = $("#cloud1");
        $cloud2 = $("#cloud2");
        mainwidth = $main.outerWidth();

    }
);

/// 飘动
setInterval(function flutter() {
    if (offset1 >= mainwidth) {
        offset1 = -580;
    }
    if (offset2 >= mainwidth) {
        offset2 = -580;
    }
    offset1 += 1.1;
    offset2 += 1;
    $cloud1.css("background-position", offset1 + "px 100px")
    $cloud2.css("background-position", offset2 + "px 460px")
}, 70);
setInterval(function bg() {
    if (offsetbg >= mainwidth) {
        offsetbg = -580;
    }
    offsetbg += 0.9;
    $body.css("background-position", -offsetbg + "px 0")
}, 90);

//登录请求
function submitLogin() {
    var jsonData = {loginName : $('#loginName').val(), loginPwd : $('#loginPwd').val() };
    $.ajax({
        url:   CONTEXTPATH +  '/loginCheck',
        data:jsonData,
        type:'post',
        cache:false,
        dataType:'json',
        success : function(ret) {
            if (0 == ret.retCode) {
                document.location.replace(CONTEXTPATH + "/main");
            } else {
                alert(ret.resMsg,"");
            }
        }
    });
}
//回车事件处理
function treatKeyEvent(event) {
    if (getKeyCode(event) == 13) {
        if (FrmCheck()) {
            submitLogin();
        }
    }
}
//去掉左右空格
function trimBlankFunc(str){
    return str.replace(/^\s*|\s*$/g,"");
}

//验证管理员登陆信息
function FrmCheck() {
    var flag = true;
    var loginName = trimBlankFunc($("#loginName").val());

    var loginPwd = trimBlankFunc($("#loginPwd").val());
    var password = hex_md5(loginPwd).toUpperCase();

    if (loginName.length == 0) {
        $("#loginName").focus();
        flag = false;
        return false
    }
    if (loginPwd.length == 0) {
        $("#loginPwd").focus();
        flag = false;
        return false;
    }
    if (flag) {
        $("#loginPwd").val(password);
    }
    return flag;
}
//键盘事件
function getKeyCode(e){
    var keyNum = 0;
    try{
        if(window.event){ // IE
            keyNum = e.keyCode;
        }else if(e.which){ // Netscape/Firefox/Opera
            keyNum = e.which;
        }

    }catch (ex){}
    return keyNum;
}