<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>相册－${site.title}</title>

    <link rel="shortcut icon" href="${staticUrl}/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">
    <link rel="stylesheet" href="${staticUrl}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${staticUrl}/css/bootstrap.v4.0.0.css">
    <link rel="stylesheet" href="${staticUrl}/css/hero-slider-style.css">
    <link rel="stylesheet" href="${staticUrl}/css/magnific-popup.css">
    <link rel="stylesheet" href="${staticUrl}/css/templatemo-style.css">
    <script src="${staticUrl}/js/jquery-1.11.3.min.js"></script>
</head>

<body>
<!-- Content -->
<div class="cd-hero">
    <!-- Navigation -->
    <div class="cd-slider-nav">
        <nav class="navbar">
            <div class="tm-navbar-bg">

                <a class="navbar-brand text-uppercase" href="#"><i class="fa fa-picture-o tm-brand-icon"></i>${site.title}</a>

                <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                    &#9776;
                </button>
                <div class="collapse navbar-toggleable-md text-xs-center text-uppercase tm-navbar" id="tmNavbar">
                    <ul class="nav navbar-nav">
                        <c:forEach items="${site.navList}" var="navItem" varStatus="status">
                            <li class="nav-item active selected">
                                <a class="nav-link" href="#0" data-no="${status.count}">${navItem.navTitle} <c:if test="${status.count == 1}"><span class="sr-only">(current)</span></c:if> </a>
                            </li>
                        </c:forEach>
                        <li class="nav-item">
                            <a class="nav-link" href="#0" data-no="5">关于班级相册</a>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>
    </div>

    <ul class="cd-hero-slider">
        <c:forEach items="${site.navList}" var="navItem" varStatus="status">
            <li <c:if test="${status.count == 1}" > class="selected" </c:if> >
                <div class="cd-full-width">
                    <div class="container-fluid js-tm-page-content" data-page-no="${status.count}" data-page-type="gallery">
                        <div class="tm-img-gallery-container">
                            <div class="tm-img-gallery gallery-one">
                                <div class="grid-item">
                                    <figure class="effect-sadie">
                                        <img src="${staticUrl}/img/tm-img-01-tn.jpg" alt="Image" class="img-fluid tm-img">
                                        <figcaption>
                                            <h2 class="tm-figure-title">Image <span><strong>One</strong></span></h2>
                                            <p class="tm-figure-description">Set true or false in HTML script tag for this page black and white.</p>
                                            <a href="${staticUrl}/img/tm-img-01.jpg">View more</a>
                                        </figcaption>
                                    </figure>
                                </div>
                                <div class="grid-item">
                                    <figure class="effect-sadie">
                                        <img src="${staticUrl}/img/tm-img-01-tn.jpg" alt="Image" class="img-fluid tm-img">
                                        <figcaption>
                                            <h2 class="tm-figure-title">Image <span><strong>One</strong></span></h2>
                                            <p class="tm-figure-description">Set true or false in HTML script tag for this page black and white.</p>
                                            <a href="${staticUrl}/img/tm-img-01.jpg">View more</a>
                                        </figcaption>
                                    </figure>
                                </div>
                                <div class="grid-item">
                                    <figure class="effect-sadie">
                                        <img src="${staticUrl}/img/tm-img-01-tn.jpg" alt="Image" class="img-fluid tm-img">
                                        <figcaption>
                                            <h2 class="tm-figure-title">Image <span><strong>One</strong></span></h2>
                                            <p class="tm-figure-description">Set true or false in HTML script tag for this page black and white.</p>
                                            <a href="${staticUrl}/img/tm-img-01.jpg">View more</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </c:forEach>

        <!-- Page 5 Contact Us -->
        <li>
            <div class="cd-full-width">
                <div class="container-fluid js-tm-page-content tm-page-pad" data-page-no="5">
                    <div class="tm-contact-page">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="tm-flex tm-contact-container">
                                    <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-2-col-textbox-2 tm-textbox-padding tm-textbox-padding-contact">
                                        <h2 class="tm-contact-info">随意打招呼！</h2>
                                        <p class="tm-text">程序猿拯救世界需要只需要一桶泡面。</p>

                                        <!-- contact form -->
                                        <form action="#" method="post" class="tm-contact-form">

                                            <div class="form-group">
                                                <input type="text" id="contact_name" name="contact_name" class="form-control" placeholder="Name"  required/>
                                            </div>

                                            <div class="form-group">
                                                <input type="email" id="contact_email" name="contact_email" class="form-control" placeholder="Email"  required/>
                                            </div>
                                            <div class="form-group">
                                                <input type="phone" id="contact_phone" name="contact_phone" class="form-control" placeholder="Phone"  required/>
                                            </div>
                                            <div class="form-group">
                                                <textarea id="contact_message" name="contact_message" class="form-control" rows="5" placeholder="Message" required></textarea>
                                            </div>

                                            <button type="button" id="sendBTN" class="pull-xs-right tm-submit-btn">发送</button>

                                        </form>
                                    </div>

                                    <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-2-col-textbox-2 tm-textbox-padding tm-textbox-padding-contact">
                                        <h2 class="tm-contact-info">4466 Old New St 28290, SF, California</h2>
                                        <!-- google map goes here -->
                                        <div id=""></div>
                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                </div>

            </div> <!-- .cd-full-width -->
        </li>
    </ul> <!-- .cd-hero-slider -->
   <%-- <footer class="tm-footer">
        <div class="tm-social-icons-container text-xs-center">
            <a href="mqqwpa://im/chat?chat_type=wpa&uin=648844348" class="tm-social-link"><i class="fa fa-qq"></i></a>
            <a href="mqqwpa://im/chat?chat_type=wpa&uin=648844348" class="tm-social-link"><i class="fa fa-weixin"></i></a>
            <a href="Mailto:18761645505@139.com" class="tm-social-link"><i class="fa fa-envelope-o"></i></a>
            <a href="tel:18761645505" class="tm-social-link"><i class="fa fa-phone"></i></a>
            <a href="https://gitee.com/mayu117" class="tm-social-link"><i class="fa fa-git"></i></a>
        </div>

        <p class="tm-copyright-text">Copyright &copy; <span class="tm-copyright-year">current year</span> Coding monkey</p>

    </footer>--%>

</div> <!-- .cd-hero -->


<!-- Preloader, https://ihatetomatoes.net/create-custom-preloading-screen/ -->
<div id="loader-wrapper">

    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>

</div>

<!-- load JS files -->

<script src="${staticUrl}/js/tether.min.js"></script> <!-- Tether (http://tether.io/)  -->
<script src="${staticUrl}/js/bootstrap.min.js"></script>             <!-- Bootstrap js (v4-alpha.getbootstrap.com/) -->
<script src="${staticUrl}/js/hero-slider-main.js"></script>          <!-- Hero slider (https://codyhouse.co/gem/hero-slider/) -->
<script src="${staticUrl}/js/jquery.magnific-popup.min.js"></script> <!-- Magnific popup (http://dimsemenov.com/plugins/magnific-popup/) -->

<script>

    function adjustHeightOfPage(pageNo) {

        var pageContentHeight = 0;

        var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

        if( pageType != undefined && pageType == "gallery") {
            pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
        }
        else {
            pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height() + 20;
        }

        // Get the page height
        var totalPageHeight = $('.cd-slider-nav').height()
            + pageContentHeight
            + $('.tm-footer').outerHeight();

        // Adjust layout based on page height and window height
        if(totalPageHeight > $(window).height())
        {
            $('.cd-hero-slider').addClass('small-screen');
            $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
        }
        else
        {
            $('.cd-hero-slider').removeClass('small-screen');
            $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
        }
    }

    /*
        Everything is loaded including images.
    */
    $(window).load(function(){
        var CONTEXTPATH = '${webUrl}';
        $("#sendBTN").click(function(){
            var name = $("#contact_name").val();
            var email = $("#contact_email").val();
            var phone = $("#contact_phone").val();
            var msg = $("#contact_message").val();
            if(name == '' || email == '' || msg == '' || phone == ''){
                return false;
            }

            if (!email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1){
                alert("请输入合法的邮箱地址!");
                return false;
            }
            $.ajax({
                url: CONTEXTPATH + "/sendEmail",
                type: 'post',
                cache: false,
                data :{
                    name: name,
                    email:email,
                    phone:phone,
                    msg:  msg
                },
                dataType: 'json',
                success: function (ret) {
                    alert("信息已经收到，我们会尽快联系您");
                }
            });
        })

        adjustHeightOfPage(1); // Adjust page height

        /* Gallery One pop up
        -----------------------------------------*/
        $('.gallery-one').magnificPopup({
            delegate: 'a', // child items selector, by clicking on it popup will open
            type: 'image',
            gallery:{enabled:true}
        });

        /* Gallery Two pop up
        -----------------------------------------*/
        $('.gallery-two').magnificPopup({
            delegate: 'a',
            type: 'image',
            gallery:{enabled:true}
        });

        /* Gallery Three pop up
        -----------------------------------------*/
        $('.gallery-three').magnificPopup({
            delegate: 'a',
            type: 'image',
            gallery:{enabled:true}
        });

        /* Collapse menu after click
        -----------------------------------------*/
        $('#tmNavbar a').click(function(){
            $('#tmNavbar').collapse('hide');

            adjustHeightOfPage($(this).data("no")); // Adjust page height
        });

        /* Browser resized
        -----------------------------------------*/
        $( window ).resize(function() {
            var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");

            // wait 3 seconds
            setTimeout(function() {
                adjustHeightOfPage( currentPageNo );
            }, 1000);

        });

        // Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
        $('body').addClass('loaded');

        // Write current year in copyright text.
        $(".tm-copyright-year").text(new Date().getFullYear());

    });



</script>

</body>
</html>