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
    <title>课程详情</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="stylesheet" href="${staticUrl}/css/public.css">
    <link rel="stylesheet" href="${staticUrl}/css/swiper.min.css">
    <script src="${staticUrl}/js/jquery-3.1.0.min.js"></script>
    <script src="${staticUrl}/js/swiper.min.js"></script>
    <script src="${staticUrl}/js/public.js"></script>
    <script src="${staticUrl}/js/calcsize.js"></script>
</head>
<body>
<!-- 头部-固定 -->
<header class="head">
    <div class="left"><a class="back" href="${webUrl}/index"></a></div>
    <h1 class="page-name">课程详情</h1>
</header>
<!-- //头部-固定 -->
<!--头部占位-->
<div class="head-placehoder"></div>
<!--//头部占位-->

<!-- 商品图轮播 -->
<section class="swiper-container swiper-banner">
    <ul class="swiper-wrapper">
        <li class="swiper-slide"><a href="javascript:;"><img src="${staticUrl}/img/im1.jpg" width="320px"  height="320px" alt="图片名称"></a></li>
        <li class="swiper-slide"><a href="javascript:;"><img src="${staticUrl}/img/img2.jpg" width="320px"  height="320px" alt="图片名称"></a></li>
        <li class="swiper-slide"><a href="javascript:;"><img src="${staticUrl}/img/img4.jpg" width="320px"  height="320px" alt="图片名称"></a></li>
    </ul>
    <div class="swiper-pagination"></div>
</section>
<!-- //商品图轮播 -->

<!-- 商品描述 -->
<section class="box pro-des">
    <header class="hd"><h2>好记性不如烂笔头</h2></header>
    <div class="bd">
        <p>擅于营造轻松活泼的课堂氛围，充分调动学生的积极性，培养学生浓厚的英语学习兴趣。让孩子在快乐中学习，在学习中找到快乐。</p>
    </div>
    <div class="ft">活动价：<strong class="f-orange">2000&yen;</strong></div>

</section>
<!-- //商品描述 -->

<!-- 商品详情 -->
<section class="box pro-det">
    <header class="hd"><h2>课程详情</h2></header>
    <div class="bd">
        <img src="${staticUrl}/img/im1.jpg" width="720px">
        <p>详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情详情</p>
        <img src="${staticUrl}/img/img2.jpg" width="720px">
    </div>
</section>
<!-- //商品详情 -->

<!--底部操作按钮-->
<div class="foot-action js-foot-action">
    <a class="btn btn-blue btn-large" href="${webUrl}/course/page/book/1000">立即预定</a>
</div>
<!--//底部操作按钮-->

<!--底部占位-->
<div class="foot-placehoder"></div>
<!--//底部占位-->
<!-- 底部菜单 --><%--
<ul class="foot-menu js-single-select">
    <li class="cur"><a href="javascript:;"><i class="menu-home"></i>首页</a></li>
    <li><a href="javascript:;"><i class="menu-love"></i>爱心榜</a></li>
    <li><a href="javascript:;"><i class="menu-checkin"></i>签到</a></li>
    <li><a href="javascript:;"><i class="menu-smile"></i>我的</a></li>
</ul>--%>
<!-- //底部菜单 -->

<script>
    $(function(){

        //商品图轮播
        var banLeg = $('.swiper-banner .swiper-slide').length;
        if(banLeg>1){
            var mySwiper = new Swiper('.swiper-banner',{
                autoplay : 5000,
                pagination: '.swiper-pagination',
                loop : true,
            });
        }

        //底部菜单
        singleSelect('.js-single-select');

        //底部操作按钮
        footAction();

        //数量选择
        amountBox();
    })

    function footAction(){
        var act = $('.js-foot-action'),
            hei = act.outerHeight(true),
            meu = act.next('.foot-placehoder');
        if(meu.length){
            meu.css('height',hei*2);
            act.css('bottom',hei-1);
        }else{
            act.prev().css({'padding-bottom':hei,'border-bottom':0});
        }
    }

    function amountBox() {
        $('.amount-box').each(function() {
            var box = $(this),
                minusBtn = $('button:first-child', this),
                addBtn = $('button:last-child', this),
                input = $('input', this),
                min = Number(box.data('min')) || 0,
                max = Number(box.data('max')) || Number.MAX_VALUE,
                step = Number(box.data('step')) || 1;

            minusBtn.on('click', function() {
                input.val(Number(input.val()) - step).trigger('change');
            });

            addBtn.on('click', function() {
                input.val(Number(input.val()) + step).trigger('change');
            });

            input.on('change propertychange', function() {
                var value = Number(input.val());
                minusBtn.prop('disabled', value <= min);
                addBtn.prop('disabled', value >= max);
            }).trigger('change');
        });
    }

</script>
</body>
</html>