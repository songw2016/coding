//全局的ajax访问，处理ajax清求时sesion超时
$.ajaxSetup({
    contentType:"application/x-www-form-urlencoded;charset=utf-8",
    complete: function (xhr, status) {
        $("#ajaxMask").remove();
        if(xhr){
            var sessionstatus=xhr.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，
            if(sessionstatus=="timeout"){
                //如果超时就处理 ，指定要跳转的页面
                top.window.location.replace(CONTEXTPATH+"/login");
            }
        }
    },
    beforeSend: function(){
        $("body").append("<div id= 'ajaxMask' class='mask' style='z-index:100000;display:block'></div>");
    },
    error :function(xhr){
        if(xhr){
            var sessionstatus=xhr.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，
            if(sessionstatus=="timeout"){
                //如果超时就处理 ，指定要跳转的页面
                top.window.location.replace(CONTEXTPATH+"/login");
            }
        }
        alert("系统异常，请联系管理员","0");
    }
});
function alertMsg(msg,type){
    var img = "";
    if( type = 0 ){
        img=  "<span><img src='"+STATICURL+"/images/info.png' /></span>\n" ;
    }
    else if( type = 1 ){
        img=  "<span><img src='"+STATICURL+"/images/modify.png' /></span>\n" ;
    }
    else if( type = 2 ){
        img=  "<span><img src='"+STATICURL+"/images/delete.png' /></span>\n" ;
    } else{
        img=  "<span><img src='"+STATICURL+"/images/info.png' /></span>\n" ;
    }
    var html = "<div class='tip'>\n" +
    "<div class='tiptop'><span>提示信息</span><a></a></div>\n" +
    "<div class='tipinfo'>\n" +
    "<div class='tipright'>\n" + img +
    msg +
    "<cite>如果是请点击确定按钮 ，否则请点取消。</cite>\n" +
    "</div>\n" +
    "</div>\n" +
    "<div class='tipbtn'>\n" +
    "<input name='' type='button'  class='sure' value='确定' />&nbsp;\n" +
    "<input name='' type='button'  class='cancel' value='取消' />\n" +
    "</div>\n" +
    "</div>";

    $("body").append(html);
}
function alertOK(){

}