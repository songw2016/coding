<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>个人简历</title>
    <link href="${staticUrl}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link href="${staticUrl}/css/theme2.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="shortcut icon" href="${staticUrl}/favicon.ico" type="image/x-icon">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<!--start-header-section-->
<div class="header-section">
    <div class="continer">
        <img src="${staticUrl}/images/mayu117.png">
        <h1>hello..<span>!</span></h1>
        <p>我是马玉亮 & 我是一名程序猿</p>
        <a href="#studySection" class="scroll top"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span></a>
    </div>
</div>
<!--end header-section-->
<!--start-study-section-->
<div class="study-section" id="studySection">
    <div class="container">
        <div class="study-grids">
            <div class="col-md-6 study-grid">
                <h3>教育经历<span>!</span></h3>
                <div class="study1">
                    <p>南通大学计算机科学与技术学院<label>( 2004 -2008 )</label></p>
                </div>
            </div>
            <div class="col-md-6 study-grid">
                <h3>技能特长<span>!</span></h3>
                <div class="study2">
                        <h4>Java</h4>
                        <div class="progress">
                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="94" aria-valuemin="0" aria-valuemax="100" style="width: 94%">
                                <span class="sr-only">94% Complete (success)</span>
                            </div>
                        </div>
                        <h4>Sql</h4>
                            <div class="progress">
                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="88" aria-valuemin="0" aria-valuemax="100" style="width: 88%">
                                    <span class="sr-only">88% Complete (danger)</span>
                                </div>
                            </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

    </div>
</div>
<!--end study-section-->
<!--start-services-section-->
<div class="service-section" id="service">
    <h2>工作经验</h2>
    <div class="container">
        <div class="service-grids">
            <div class="col-md-4 service-grid">
                <h4>南京欣网互联</h4>
                <span> </span>
                <p>江苏移动终端统一运营管理系统；                </p>
            </div>
            <div class="col-md-4 service-grid">
                <h4>南京苏宁信息技术有限公司                </h4>
                <span> </span>
                <p>资金管理系统维护性开发；风险控制系统开发；银企接口标准化项目开发；</p>
            </div>
            <div class="col-md-4 service-grid">
                <h4>上海从事软件开发(东软、东南融通)</h4>
                <span> </span>
                <p>企业金融业务业绩计量系统；宁波银行新一代国际结算系统；证券业务流程平台；</p>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div><a href="#contact" class="scroll top"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span></a>
</div>
<!--end services-section-->
<!--start-contact-section-->
<div class="contact-section" id="contact">
    <div class="container">
        <h3>联系我</h3>
        <div class="contact-details">
            <form>
                <div class="col-md-6 contact-left">
                    <input type="text" id="name" class="text" value="Name *" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name *';}">
                    <input type="text" id="email" class="text" value="Email *" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email *';}">
                    <input type="text" id="phone" class="text" value="phone *" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Phone *';}">
                </div>
                <div class="col-md-6 contact-right">
                    <textarea  id="msg" value="Message" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Message';}">Message *</textarea>
                    <input type="button" id="sendBTN" value="点击发送"/>
                </div>
                <div class="clearfix"> </div>
            </form>
        </div>
    </div>
</div>
<div class="footer-section">
    <div class="container">
        <div class="footer-top">
            <p>Copyright &copy; 2017.Coding All rights reserved.</p>
        </div>
        <a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 2;"> </span></a>
    </div>
</div>
<!--end-footer-section-->
<script src="${staticUrl}/js/jquery-1.11.3.min.js"></script>
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