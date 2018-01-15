<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="良辰美景 欢乐谷 同学聚餐 朋友聚会 儿童乐园">
    <title>良辰美景</title>
    <!-- Bootstrap Core CSS -->
    <link href="${staticUrl}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="${staticUrl}/css/website.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${staticUrl}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="${staticUrl}/images/favicon.ico" type="image/x-icon"/>
</head>
<body class="index-page">
<div class="wrap-body">
    <!-- Intro -->

    <header id="page-header">
        <!--Navigation-->
        <nav id="menu" class="navbar">
            <div class="container">
                <div class="row">
                    <div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>
                        <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
                    </div>
                    <div class="collapse navbar-collapse navbar-ex1-collapse">
                        <ul class="nav navbar-nav">
                            <li ><a href="${webUrl}/index">首页</a></li>
                            <li class="active"><a href="${webUrl}/happyvalley">快乐小镇</a></li>
                            <li><a href="${webUrl}/agritainment">宴会聚餐</a></li>
                            <li><a href="${webUrl}/contact">联系我们</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <!-- /////////////////////////////////////////Content -->
    <div id="page-content" class="container">
        <div class="row">
            <!-- ////////////Content Box 01 -->
            <section class="box-content box-1 box-style-0">
                <div class="flex-box no-gutter">
                    <div class="col-sm-5">
                        <div class="box-image">
                            <img src="${staticUrl}/images/1.jpg" alt="" />
                        </div>
                    </div>
                    <div class="col-sm-7">
                        <div class="box-text">
                            <div class="box-text-inner pd-large-lg pd-small-xs">
                                <div class="heading">
                                    <h2>欢乐时光</h2>
                                </div>
                                <p>这里是属于孩子们的！——快乐小镇快乐小镇，是专为3—13岁少年儿童打造，由少年儿童自主管理并快乐成长的儿童小镇。犹如剪刀、石头、布，充满童真，却不失规则与文化。
                                    在这里，孩子们敢想、敢表达；在这里，孩子们敢说、乐于说！在欢乐与赞扬的环境中成长，孩子们将会变得更加活泼与自信！在轻松快乐中积累未来竞争力！</p>

                                <a class="btn btn-skin m-top30">更多</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- ////////////Content Box 02 -->
            <section class="box-content box-2 box-style-0">
                <div class="flex-box no-gutter">
                    <div class="col-sm-5 f-right">
                        <div class="box-image">
                            <img src="${staticUrl}/images/3.jpg" alt="" />
                        </div>
                    </div>
                    <div class="col-sm-7">
                        <div class="box-text">
                            <div class="box-text-inner pd-large-lg pd-small-xs t-right">
                                <div class="heading">
                                    <h2>宴会聚餐</h2>
                                </div>
                                <p>在星愿湖畔远离尘世喧嚣，湖面波光粼粼，四周宁静和谐，享受与全家人在此休养生息、放松身心、愉快玩耍。                             </p>
                                <a class="btn btn-skin m-top30">更多</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- ////////////Content Box 03 -->
            <section class="box-content box-3 box-style-0">
                <div class="flex-box no-gutter">
                    <div class="col-sm-5">
                        <div class="box-image">
                            <img src="${staticUrl}/images/2.jpg" alt="" />
                        </div>
                    </div>
                    <div class="col-sm-7">
                        <div class="box-text">
                            <div class="box-text-inner pd-large-lg pd-small-xs">
                                <div class="heading">
                                    <h2>教育</h2>
                                </div>
                                <p>爱心打造青少年专属课外活动营，以丰富多彩的活动营地课程，专注于对青少年体验式教育的开发和实施，以国际营地教育的标准、专业的户外运动指导教学理念，令广大青少年在轻松、愉快的氛围里，感受探索自然、挑战运动的乐趣。</p>

                                <a class="btn btn-skin m-top30">更多</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div><!-- End Content -->

    <footer id="page-footer" class="footer-contact">
        <div class="wrap-footer container">
            <div class="row">
                <div class="flex-box no-gutter">
                    <!-- Map and address -->
                    <div class="col-lg-12">
                        <div class="contact-info">
                            <!-- Show Info Button -->
                            <div id="map" style="height: 350px;"></div>
                            <address class="contact-info-wrapper">
                                <ul class="list-unstyled">
                                    <!-- Address -->
                                    <li class="contact-group">
                                        <span class="adr-heading">地址</span>
                                        <span class="adr-info">盱眙县马坝镇良辰大道1号</span>
                                    </li>
                                    <!-- Email -->
                                    <li class="contact-group">
                                        <span class="adr-heading">邮箱</span>
                                        <span class="adr-info">187616465505@139.com</span>
                                    </li>
                                </ul>
                                <ul class="list-unstyled">
                                    <!-- Phone -->
                                    <li class="contact-group">
                                        <span class="adr-heading">电话</span>
                                        <span class="adr-info">+ 025 8868 0517</span>
                                    </li>
                                    <!-- Mobile -->
                                    <li class="contact-group">
                                        <span class="adr-heading">手机</span>
                                        <span class="adr-info">+ 187 6164 5505</span>
                                    </li>
                                </ul>
                            </address>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="bottom-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <ul class="list-inline quicklinks">
                            <li><a href="#">Copyright 2017 - 2018 良辰有限公司</a></li>
                        </ul>
                    </div>
                    <div class="col-md-6">

                    </div>
                    <div class="col-md-3">
                        <ul class="list-inline quicklinks">
                            <li><a href="#">加入我们</a></li>
                            <li><a href="#">管理后台</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer><!-- Footer -->

</div><!-- .wrap-body -->

<!-- jQuery and Plugin-->
<script src="${staticUrl}/js/jquery1.11.3.min.js"></script>
<!-- Bootstrap JS -->
<script src="${staticUrl}/js/bootstrap.min.js"></script>
<!-- Google Map -->
<!-- Logo -->
<script src="${staticUrl}/js/arctext.min.js"></script>
<script>
    $(document).ready(function() {
        $(".line-2").arctext({radius: 400});
    });
</script>

</body>
</html>