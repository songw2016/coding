<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>相册</title>
    <link rel="shortcut icon" href="${staticUrl}/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${staticUrl}/css/album_simple.css" />
    <link rel="stylesheet" href="${staticUrl}/css/font-awesome.min.css" />
</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="#"><strong>首页</strong></a></h1>
        <nav>
            <ul>
                <li><a href="#footer" class="icon fa-info-circle">关于</a></li>
            </ul>
        </nav>
    </header>

    <!-- Main -->
    <div id="main">
        <c:forEach items="${listPic}" var="item">
            <article class="thumb">
                <a href="${item.picUrl}" class="image"><img src="${item.picUrl}" alt="" /></a>
                <h2>${item.picTitle}</h2>
                <p>${item.picDesc}</p>
            </article>
        </c:forEach>
    </div>

    <!-- Footer -->
    <footer id="footer" class="panel">
        <div class="inner split">
            <div>
                <section>
                    <h2>关于程序猿</h2>
                    <p>程序猿，是一种近几十年来出现的新物种，是工业革命的产物。程序猿是一种非常特殊的、可以从事程序开发、维护的动物。<br/>漫道coding无悔不，养家糊口故。年华虚度，青春总被bug误。望断吊丝路，有女神，不得护。 默忆少年游无度，心怀天下牧。流年暗促，胸中豪情不堪负。风华又起时，不忍顾，年娇处。
                    </p>
                </section>
            </div>
            <div>
                <section>
                    <h2>联系我</h2>
                    <form method="post" action="#">
                        <div class="field half first">
                            <input type="text" name="name" id="name" placeholder="姓名" />
                        </div>
                        <div class="field half">
                            <input type="text" name="email" id="email" placeholder="邮箱" />
                        </div>
                        <div class="field half first">
                            <input type="text" name="phone" id="phone" placeholder="电话" />
                        </div>
                        <div class="field half">
                            <input type="text" name="wechart" id="wechart" placeholder="微信" />
                        </div>
                        <div class="field">
                            <textarea name="message" id="message" rows="3" placeholder="消息"></textarea>
                        </div>
                        <ul class="actions">
                            <li><input type="button" value="发送" class="special" /></li>
                        </ul>

                    </form>
                </section>
            </div>
        </div>
    </footer>
    <input type="hidden" value="${total}" id="total"/>
    <input type="hidden" value="${type}" id="type"/>
    <input type="hidden" value="${pageSize}" id="pageSize"/>

</div>

<!-- Scripts -->
<script src="${staticUrl}/js/jquery-1.11.3.min.js"></script>
<script src="${staticUrl}/js/jquery.poptrox.min.js"></script>
<script src="${staticUrl}/js/skel.min.js"></script>
<script src="${staticUrl}/js/util.js"></script>
<script src="${staticUrl}/js/album_simple.js"></script>
<script>
     var CONTEXTPATH = "${webUrl}";
    var albumUrl= "${albumUrl}/${type}";
    var currentPage = 1;
    function showMore(){
        var total = $("#total").val();
        var pageSize = $("#pageSize").val();
        var pageCount =  Math.ceil(total / pageSize);
        if(pageCount > currentPage){
            currentPage ++ ;
            var classPage = 'page'+currentPage;
            for(var i = 0;i< pageSize ;i++){
                var index = (i + pageSize * ( currentPage -1 ));
                if(index<total){
                    var article = $("<article class=\"thumb\"></article>");
                    var picUrl = albumUrl + "/" + index +".jpg";
                    article.append("<a href=\""+picUrl+"\" class=\"image "+classPage+"\"><img src=\""+picUrl+"\" alt=\"\" /></a>");
                    article.append("<h2>"+picUrl+"</h2>");
                    article.append("<p></p>");
                    $("#main").append(article);
                    thumbsImage(article);

                }
            }
            showImg($("#main"),'.thumb > a.'+classPage);
        }
    }
    $(function(){
        $(window).scroll(function () {
            //$(window).scrollTop()这个方法是当前滚动条滚动的距离
            //$(window).height()获取当前窗体的高度
            //$(document).height()获取当前文档的高度
            var bot = 50; //bot是底部距离的高度

            if ((bot + $(window).scrollTop()) >= ($(document).height() - $(window).height())) {
                //当底部基本距离+滚动的高度〉=文档的高度-窗体的高度时；
                //我们需要去异步加载数据了
                showMore();
            }
        });
        $(".special").click(function(){
            var name = $("#name").val();
            var email = $("#email").val();
            var phone = $("#phone").val();
            var msg = $("#message").val();
            if(name == '' || email == '' || msg == '' || phone == ''){
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
                    alert("信息已经收到，我会尽快联系您");
                }
            });
        })
    })
</script>
</body>
</html>