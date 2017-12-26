<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>相册</title>
    <link rel="shortcut icon" href="${staticUrl}/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${staticUrl}/css/album_main.css" />
</head>
<body>

<!-- Wrapper -->
<div id="wrapper" class="divided">

    <!-- One -->
    <section class="banner style1 orient-left content-align-left image-position-right fullscreen onload-image-fade-in onload-content-fade-right">
        <div class="content">
            <h1>毕业八年聚会<c:if test="${a}"/></h1>
            <p class="major"><!--[-->八年了，时光虽然在我们的脸上刻下痕迹，我们也不再是八年前的我们；但是，岁月的流逝并没有磨灭我们同学之间那纯真的友情，在大家的脸上仍然能找到当年的笑貌音容。<!--]--></p>
            <ul class="actions vertical">
                <li><a href="#one" class="button big wide smooth-scroll-middle">Next</a></li>
            </ul>
        </div>
        <div class="image">
            <img src="${staticUrl}/images/album/8.jpg" alt="" />
        </div>
    </section>
    <!-- Two -->
    <section class="spotlight style1 orient-right content-align-left image-position-center onscroll-image-fade-in" id="one">
        <div class="content">
            <h2>毕业季</h2>
            <p>我们每人心里的某一部分，都属于当年的自己，永远是孩子般的模样，代表了年少时的所有美好和期许。如今回头遥望，有怀念有伤感，但任你如何去追忆，那样的时光永不再回来，就像那轮咖啡色的夕阳，每天都落下，只是，在你的眼中，已无法如当年那般纯粹美好。</p>
            <ul class="actions vertical">
                <li><a href="#two" class="button">Next</a></li>
            </ul>
        </div>
        <div class="image">
            <img src="${staticUrl}/images/album/2.jpg" alt="" />
        </div>
    </section>

    <!-- Three -->
    <section class="spotlight style1 orient-left content-align-left image-position-center onscroll-image-fade-in" id="two">
        <div class="content">
            <h2>2004年</h2>
            <p>校园里有迷人的四季：桃红柳绿的春天，花繁叶茂的夏天，枫红菊香的秋天，松青雪白的冬天。</p>
            <ul class="actions vertical">
                <li><a href="#three" class="button">Next</a></li>
            </ul>
        </div>
        <div class="image">
            <img src="${staticUrl}/images/album/4.jpg" alt="" />
        </div>
    </section>

    <!-- Four -->
    <section class="spotlight style1 orient-right content-align-left image-position-center onscroll-image-fade-in" id="three">
        <div class="content">
            <h2>计师042的男人</h2>
            <p>岁月的年轮，像那黑色的旋转着的唱片，在我们每个人的内心深处播放着那美丽的旧日情曲。</p>
            <ul class="actions vertical">
                <li><a href="#four" class="button">Next</a></li>
            </ul>
        </div>
        <div class="image">
            <img src="${staticUrl}/images/album/5.jpg" alt="" />
        </div>
    </section>
    <!-- Five -->
    <section class="wrapper style1 align-center" id="four">
        <div class="inner">
            <h2>计师042精彩瞬间</h2>
            <p>友情同窗数度，不忍分别，唯把重逢盼。高考亦没，各奔东西难通联。思念依依，常凝视集体照片。抚今思未来，感慨无限。</p>
        </div>

        <!-- Gallery -->
        <div class="gallery style2 medium lightbox onscroll-fade-in">
            <% for(int i=1;i<8;i++){ %>
            <article>
                <a href="${staticUrl}/images/album/<%=i%>.jpg" class="image">
                    <img src="${staticUrl}/images/album/<%=i%>.jpg" alt="" />
                </a>
                <div class="caption">
                    <h3>计师042精彩瞬间</h3>
                    <p>友情同窗数度，不忍分别，唯把重逢盼。高考亦没，各奔东西难通联。思念依依，常凝视集体照片。抚今思未来，感慨无限。</p>
                    <ul class="actions">
                        <li><span class="button small">Details</span></li>
                    </ul>
                </div>
            </article>
            <%}%>
        </div>

    </section>

    <!-- Seven -->
    <section class="wrapper style1 align-center" style="">
        <div class="inner medium">
            <h2>创建我的相册</h2>
            <form method="post" action="#">
                <div class="field  first">
                    <input type="text" id="name"  value="Name *" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name *';}">
                </div>
                <div class="field ">
                    <input type="text" id="email" value="Email *" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email *';}">
                </div>
                <div class="field ">
                    <input type="text" id="phone" value="phone *" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Phone *';}">
                </div>
                <div class="field">
                    <textarea  id="msg" value="Message" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Message';}">Message *</textarea>
                </div>
                <ul class="actions">
                    <li><input type="button" name="submit" id="submit" value="点击发送" /></li>
                </ul>
            </form>
        </div>
    </section>
    <!-- Footer -->
    <footer class="wrapper style1 align-center">
        <div class="inner">
            <p>Copyright &copy; 2017.Coding All rights reserved.</p>
        </div>
    </footer>

</div>

<!-- Scripts -->
<script src="${staticUrl}/js/jquery-1.11.3.min.js"></script>
<script src="${staticUrl}/js/jquery.scrollex.min.js"></script>
<script src="${staticUrl}/js/jquery.scrolly.min.js"></script>
<script src="${staticUrl}/js/skel.min.js"></script>
<script src="${staticUrl}/js/util.js"></script>
<script src="${staticUrl}/js/album_main.js"></script>
<script>

    var CONTEXTPATH = "${webUrl}";
    $(function(){
        $("#sendBTN").click(function(){
            var name = $("#name").val();
            var email = $("#email").val();
            var phone = $("#phone").val();
            var msg = $("#msg").val();
            if(name == 'Name *' || email == 'Email *' || msg == 'Message' || phone == 'phone *'){
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
    })

</script>
</body>
</html>