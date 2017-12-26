<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>程序猿管理系统</title>
    <link href="${staticUrl}/css/admin.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="${staticUrl}/favicon.ico" type="image/x-icon">
    <script language="JavaScript" src="${staticUrl}/js/lib/jquery-1.11.3.min.js"></script>
</head>
<body style="background-color:#f0f9fd;overflow-x: hidden;overflow-y: hidden;">


<div class="s-contain">
    <div class="s-head">
        <div class="topleft">
           <%-- <img src="${staticUrl}/images/_manager_72px.png" title="系统首页" />--%>
        </div>

        <ul class="nav">
            <li><a href="javascript:openMenu('/demo/workbench');" ><img src="${staticUrl}/images/icon01.png" title="工作台" /><h2>采购管理</h2></a></li>
            <li><a href="javascript:openMenu('/demo/table');" ><img src="${staticUrl}/images/icon02.png" title="模型管理" /><h2>库存管理</h2></a></li>
            <li><a href="javascript:openMenu('/demo/table');"  ><img src="${staticUrl}/images/icon03.png" title="模块设计" /><h2>商品管理</h2></a></li>
            <li><a href="javascript:openMenu('/demo/tools');"  ><img src="${staticUrl}/images/icon04.png" title="常用工具" /><h2>会员管理</h2></a></li>
            <li><a href="javascript:openMenu('/demo/document');" ><img src="${staticUrl}/images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
            <li><a href="javascript:openMenu('/demo/form');"  ><img src="${staticUrl}/images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
        </ul>

        <div class="topright">
            <ul>
                <li><span><img src="${staticUrl}/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
                <li><a href="javascript:void(0);">关于</a></li>
                <li><a href="${webUrl}/admin/logout" target="_parent">退出</a></li>
            </ul>

            <div class="user">
                <span>admin</span>
                <i>消息</i>
                <b><a href="javascript:void(0);">5</a></b>
            </div>

        </div>
    </div>

    <div class="s-content">
        <div class="s-faceplate-l">
            <div class="lefttop"><span></span>导航栏</div>
            <dl class="leftmenu">

                <c:forEach items="${treeList}" var="one">
                    <dd>
                        <div class="title">
                            <span><img src="${staticUrl}/images/leftico01.png" /></span>${one.MENU_NAME}
                        </div>
                        <ul class="menuson">
                            <c:forEach  items="${one.items}" var="subOne">
                                <li ><a href="javascript:openMenu('${subOne.MENU_URL}');" >${subOne.MENU_NAME}</a></li>
                            </c:forEach>
                        </ul>
                    </dd>
                </c:forEach>
            </dl>
        </div>
        <div class="s-faceplate-r">
            <iframe id="content-iframe" src="${webUrl}/welcome"width="100%" height="100%" allowtransparency="true" frameborder="no" border="0"></iframe>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    var ctx = "${webUrl}";
    $(function(){

        var width = $(document).width();
        var height = parseInt($(document).height()) - 88;
        var windowHeight = parseInt($(window).height());
        if(height>windowHeight){
            height = windowHeight;
        }

        $(".s-content").css({
            height:height,
            width:width
        });
        $(".s-faceplate-r").css({
            width:parseInt(width)-158,
            height:height
        });
        //导航切换
        $(".menuson li").click(function(){
            $(".menuson li.active").removeClass("active")
            $(this).addClass("active");
        });
        $('.title').click(function(){
            var $ul = $(this).next('ul');
            $('dd').find('ul').slideUp();
            if($ul.is(':visible')){
                $(this).next('ul').slideUp();
            }else{
                $(this).next('ul').slideDown();
            }
            navigatoPage.show(id,url);
        });

        $('.nav').find("a").click(function(){
            $('.nav').find("a").removeClass("selected");
            $(this).addClass("selected");
        })

    })

    function openMenu(url){
        $("#content-iframe").attr('src',ctx+url);
    }
</script>
</html>
