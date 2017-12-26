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
    <title>课程列表</title>
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
    <div class="left"><%--<a class="back" href="javascript:;"></a>--%></div>
    <h1 class="page-name">课程列表</h1>
</header>
<!-- //头部-固定 -->
<!--头部占位-->
<div class="head-placehoder"></div>
<!--//头部占位-->

<!-- 列表 -->
<section class="box">
    <!-- 滑动项 -->
    <div class="swiper-slide-list">
        <div class="swiper-container js-swiper-slide-list">
            <ul class="swiper-wrapper js-single-select">
                <li class="swiper-slide cur"><a href="javascript:;">英语</a></li>
                <li class="swiper-slide"><a href="javascript:;">数学</a></li>
                <li class="swiper-slide"><a href="javascript:;">语文</a></li>
                <li class="swiper-slide"><a href="javascript:;">画画</a></li>
                <li class="swiper-slide"><a href="javascript:;">书法</a></li>
                <li class="swiper-slide"><a href="javascript:;">足球</a></li>
            </ul>
        </div>
    </div>
    <!-- //滑动项 -->
    <!-- 内容 -->
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
        <li>
            <div class="pic"><img src="${staticUrl}/upload/yuwen.jpg" alt=""></div>
            <div class="info">
                <h3 class="name">没有你做不到的，只有你想不到的。</h3>
                <p class="des line-clamp2">从教以来，全身心投入工作，让爱、激情与活力充满课堂，用爱唤起孩子的求知欲。</p>
                <p class="points">活动价格：<strong class="f-orange">2000</strong></p>
            </div>
        </li>
        <li>
            <div class="pic"><img src="${staticUrl}/upload/shuxue.jpg" alt=""></div>
            <div class="info">
                <h3 class="name">只要努力，一切皆有可能。</h3>
                <p class="des line-clamp2">授课风格活泼，善于把重要的英语知识点与有趣的故事融汇在一起进行讲解，让孩子慢慢培养学习英语的兴趣，从而达到更好的学习效果。</p>
                <p class="points">活动价格：<strong class="f-orange">2000</strong></p>
            </div>
        </li>
        <li>
            <div class="pic"><img src="${staticUrl}/upload/shuxue.jpg" alt=""></div>
            <div class="info">
                <h3 class="name">时间创造奇迹。</h3>
                <p class="des line-clamp2">课堂驾驭能力强，能准确把握学生心理。拥有丰富的知识和信息量。授课风格诙谐幽默，在培养兴趣的同时，更注重对孩子知识点掌握程度的了解，对症下药，查缺补漏，扫除知识盲点，让孩子在考试时能发挥出最好的水平！</p>
                <p class="points">活动价格：<strong class="f-orange">2000</strong></p>
            </div>
        </li>
        <li>
            <div class="pic"><img src="${staticUrl}/upload/shuxue.jpg" alt=""></div>
            <div class="info">
                <h3 class="name">没有付出就没有收获。</h3>
                <p class="des line-clamp2">教法灵活多变，善于抓住学生的注意力，激发学生的学习兴趣和表达欲，让孩子在轻松活泼、富有趣味性的氛围中学到知识。</p>
                <p class="points">活动价格：<strong class="f-orange">2000</strong></p>
            </div>
        </li>
        <li>
            <div class="pic"><img src="${staticUrl}/upload/shuxue.jpg" alt=""></div>
            <div class="info">
                <h3 class="name">当机会来临时，我已准备好了。</h3>
                <p class="des line-clamp2">为人有耐心，做事认真细致，课堂氛围生动活跃。从事过外事工作，有很好的口语交际能力，已通过教师资格证考核，热爱教育事业，有上进心，希望不断自我提升。</p>
                <p class="points">活动价格：<strong class="f-orange">2000</strong></p>
            </div>
        </li>
        <li style="text-align: center">敬请期待更多课程</li>
    </ul>
    <!-- //内容 -->
</section>
<!-- //列表 -->

<!--底部占位-->
<div class="foot-placehoder"></div>
<!--//底部占位-->
<!-- 底部菜单 -->
<ul class="foot-menu js-single-select">
    <li class="cur"><a href="${webUrl}/index"><i class="menu-home"></i>首页</a></li>
    <li><a href="${webUrl}/course/page/search"><i class="menu-checkin"></i>订单查询</a></li>
</ul>
<!-- //底部菜单 -->
<script>
    $(function(){
        //滑动项
        swiperSlideList('.js-swiper-slide-list');
        //单选
        singleSelect('.js-single-select');
    })

    function swiperSlideList(ele){
        var swp = $(ele),
            leg = $('.swiper-slide',swp).length,
            size = leg>4 ? 4.5 : leg,
            mySwiper = new Swiper(swp[0],{
                slidesPerView: size
            });
    }
</script>
</body>
</html>