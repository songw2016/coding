<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="google" value="notranslate">
    <meta name="robots" content="index,follow">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no,shrink-to-fit=no,minimal-ui">
    <meta name="format-detection" content="telephone=no,email=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="stylesheet" href="${staticUrl}/css/public.css">
    <link rel="stylesheet" href="${staticUrl}/css/swiper.min.css">
    <title>订单查询</title>
    <script src="${staticUrl}/js/calcsize.js"></script>
    <script src="${staticUrl}/js/jquery-3.1.0.min.js"></script>
    <script src="${staticUrl}/js/public.js"></script>
</head>
<body>
<!-- 头部-固定 -->
<header class="head no-right">
    <div class="left"><a class="back" href="${webUrl}/index"></a></div>
    <div class="search-box">
        <input class="search-input" type="search" placeholder="输入手机号或者订单号" autocomplete="off">
        <a class="search-btn" href="javascript:;"><i class="icon icon-search"></i></a>
    </div>
</header>
<!-- //头部-固定 -->
<!--头部占位-->
<div class="head-placehoder"></div>
<!--//头部占位-->

<!-- 搜索结果 -->
<section class="box">
    <ul class="swiper-slide-list-con pro-list points-mall">
        <li>
            <a href="${webUrl}/course/page/view/1000">
                <div class="pic"><img src="${staticUrl}/upload/yingyu.jpg" alt="" height="130px" width="130px"></div>
                <div class="info">
                    <h3 class="name">好记性不如烂笔头</h3>
                    <p class="des line-clamp2">有着丰富的教学经验，专业英语八级。擅于营造轻松活泼的课堂氛围，充分调动学生的积极性，培养学生浓厚的英语学习兴趣。让孩子在快乐中学习，在学习中找到快乐。</p>
                    <p class="points">活动价格：<strong class="f-orange">2000</strong></p>
                </div></a>
        </li>
        <li style="text-align: center">输入关键字查询</li>
    </ul>
</section>
<!-- //搜索结果 -->
<!--底部占位-->
<div class="foot-placehoder"></div>
<!--//底部占位-->
<!-- 底部菜单 -->
<ul class="foot-menu js-single-select">
    <li ><a href="${webUrl}/index"><i class="menu-home"></i>首页</a></li>
    <li class="cur"><a href="${webUrl}/course/page/search"><i class="menu-checkin"></i>订单查询</a></li>
</ul>

</body>
</html>
