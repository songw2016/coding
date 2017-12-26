<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>个人简历</title>
    <link type="text/css" rel="stylesheet" href="${staticUrl}/css/theme1.css">
    <link rel="shortcut icon" href="${staticUrl}/favicon.ico" type="image/x-icon">
</head>
<body id="top">
<div id="cv" class="instaFade">
    <div class="mainDetails">
        <div id="headshot" class="quickFade">
            <img src="${staticUrl}/images/mayu117.png" alt="马玉亮" />
        </div>

        <div id="name">
            <h1 class="quickFade delayTwo">马玉亮</h1>
            <h2 class="quickFade delayThree">程序猿</h2>
        </div>

        <div id="contactDetails" class="quickFade delayFour">
            <ul>
                <li>E: <a href="mailto:mayu117@sohu.com" target="_blank">mayu117@sohu.com</a></li>
                <li>W: <a href="http://127.0.0.1:8080/coding-web/resume/theme1">www.mayu117.com</a></li>
                <li>M: 18761645505</li>
                <%--<li>导出: <a id="downloadPdf" href="javascipt:void(0);">PDF</a> <a href="javascipt:void(0);" id="downloadWord">WORD</a></li>--%>
            </ul>
        </div>
        <div class="clear"></div>
    </div>

    <div id="mainArea" class="quickFade delayFive">
        <section>
            <article>
                <div class="sectionTitle">
                    <h1>个人技能</h1>
                </div>

                <div class="sectionContent">
                    <p>精通Core Java编程，具有在J2EE标准下从事项目开发的具体经验。具有完备和扎实的基础知识，勤于钻研，自学能力强,备良好的动手操作能力，良好的编程规范。</p>
                </div>
            </article>
            <div class="clear"></div>
        </section>


        <section>
            <div class="sectionTitle">
                <h1>工作经历</h1>
            </div>

            <div class="sectionContent">
                <article>
                    <h2>南京欣网互联</h2>
                    <p class="subDetails">2013年8月 - 至今</p>
                    <p>江苏移动终端统一运营管理系统；</p>
                </article>

                <article>
                    <h2>南京苏宁信息技术有限公司</h2>
                    <p class="subDetails">2011年9月-2013年8月</p>
                    <p>资金管理系统维护性开发；风险控制系统开发；银企接口标准化项目开发；</p>
                </article>

                <article>
                    <h2>上海从事软件开发(东软、东南融通)</h2>
                    <p class="subDetails">2008年6月 - 2011年9月</p>
                    <p>企业金融业务业绩计量系统；宁波银行新一代国际结算系统；证券业务流程平台；</p>
                </article>
            </div>
            <div class="clear"></div>
        </section>


        <section>
            <div class="sectionTitle">
                <h1>技能特长</h1>
            </div>

            <div class="sectionContent">
                <ul class="keySkills">
                    <li>Java</li>
                    <li>Html</li>
                    <li>Css</li>
                    <li>Javascript</li>
                    <li>SQL</li>
                </ul>
            </div>
            <div class="clear"></div>
        </section>
        <section>
            <div class="sectionTitle">
                <h1>教育经历</h1>
            </div>
            <div class="sectionContent">
                <article>
                    <h2>南通大学（本科）</h2>
                    <p class="subDetails">计算机科学与技术</p>
                    <p>南通大学坐落于素有“江海明珠”、“中国近代第一城”美誉的沿海开放城市——江苏省南通市，学校是江苏省人民政府和国家交通运输部共建的综合性大学，江苏省十五所重点建设大学成员，教育部“卓越医生教育培养计划”、“卓越教师培养计划”试点高校。学校的办学历史最早可追溯到近代著名实业家、教育家张謇先生于1912年创办的私立南通医学专门学校和南通纺织专门学校。学校是国家首批具有硕士学位授予权的单位，是精神文明建设典型“莫文隋”精神的发源地。</p>
                </article>
            </div>
            <div class="clear"></div>
        </section>

    </div>
</div>
</body>
</html>