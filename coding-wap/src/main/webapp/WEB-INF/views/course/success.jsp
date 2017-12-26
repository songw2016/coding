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
    <title>课程预定成功</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="${staticUrl}/css/public.css">
    <script src="${staticUrl}/js/jquery-3.1.0.min.js"></script>
    <script src="${staticUrl}/js/public.js"></script>
    <script src="${staticUrl}/js/calcsize.js"></script>
</head>
<body>
<!-- 头部-固定 -->
<header class="head">
    <div class="left"><a class="back" href="javascript:history.back(-1);"></a></div>
    <h1 class="page-name">课程预定成功</h1>
</header>
<!-- //头部-固定 -->
<!--头部占位-->
<div class="head-placehoder"></div>
<!--//头部占位-->

<!-- 兑换明细 -->
<section class="box">
    <header class="hd"><h2>课程</h2></header>
    <div class="bd">
        <table class="table table-noborder f-999">
            <colgroup>
                <col width="50%">
                <col width="30%">
                <col width="20%">
            </colgroup>
            <tr>
                <td>好记性不如烂笔头</td>
                <td></td>
                <td class="ta-r"><strong class="f-orange">2000&yen;</strong></td>
            </tr>
        </table>
    </div>
</section>
<!-- //兑换明细 -->

<!-- 兑换人信息 -->
<section class="box">
    <header class="hd"><h2>预定信息</h2></header>
    <div class="bd">
        <table class="table table-noborder f-999">
            <colgroup>
                <col width="22%">
            </colgroup>
            <tr>
                <td>家长姓名：</td>
                <td>马玉亮</td>
            </tr>
            <tr>
                <td>小孩姓名：</td>
                <td>马良辰</td>
            </tr>
            <tr>
                <td>联系电话：</td>
                <td>
                    18761645505
                </td>
            </tr>
            <tr>
                <td>付款状态：</td>
                <td>
                    已付款
                </td>
            </tr>
        </table>
    </div>
</section>
<!-- //兑换人信息 -->

<!-- //积分变动信息 -->
<section class="box border0">
    <div class="bd">
        <a class="btn btn-blue btn-large" href="${webUrl}/index">返回首页</a>
    </div>
</section>


</body>
</html>