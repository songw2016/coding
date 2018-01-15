//下拉选择
function selectList(ele,hasArrow){
  var elm = $(ele);
  elm.each(function(){
    var self = $(this),
        dt = $('dt',self),
        dd = dt.nextAll(),
        sort = self.parent().hasClass('sort-select');
    if(!hasArrow) self.addClass('select-no-arrow');
    self.on('click','dt',function(e){
      e.stopPropagation();
      var _this = $(this),
          ind = self.css('z-index');
      if(ind=='2'){
        self.removeAttr('style');
        if(hasArrow) self.removeClass('select-arrow-up');
      }else{
        self.css('z-index','2');
        if(hasArrow) self.addClass('select-arrow-up');
      }
      var up = $('.select-arrow-up');
      if(up.length>1){
        up.removeAttr('style').removeClass('select-arrow-up').find('dd').slideUp('fast');
        self.css('z-index','2').addClass('select-arrow-up');
        dd.slideDown('fast');
      }else{
        dd.slideToggle('fast');
      }
    }).on('click','dd',function(e){
      e.stopPropagation();
      var txt = $(this).text();
      dt.text(txt);
      dd.slideToggle('fast');
      self.removeAttr('style');
      if(hasArrow) self.removeClass('select-arrow-up');
    });
    $(document).on('click',function(){
      if(dd.css('display')=='block'){
        dd.slideToggle('fast');
        self.removeAttr('style');
        if(hasArrow) self.removeClass('select-arrow-up');
      }
    })

    if(sort){
      var hei = $('dt',self).height();
      $.each(dd,function(i){
        var _this = $(this);
        _this.css('top',hei*(i+1));
      })
    }
  })
}
//tab页
function tabSwitch(){
  $('.tab-bar').on('click','.tab-bar-item',function(){
    var bar = $(this).parent(),
        itm = $('.tab-bar-item',bar),
        con = bar.next().children('.tab-con-item'),
        ind = $(this).index();
    itm.removeClass('cur').eq(ind).addClass('cur');
    con.removeClass('cur').eq(ind).addClass('cur');
  });
}

//单选器
function singleSelect(el){
   var ele = $(el).children();
   ele.on('click',function(){
    var _this = $(this);
    _this.addClass('cur').siblings().removeClass('cur');
  });
}

function freeSelect(el) { 
  $.each($(el), function(index, ele) {
    var that = $(ele);
    var children = that.children();
    children.on('click',function() {
        if(that.hasClass('single')) {
          $(this).addClass('cur').siblings().removeClass('cur')
        }
        else {
          $(this).toggleClass('cur')
        }
    });
  });
}

//固定在中间的弹窗
function showPop(btnName, popName) {
  var btn = $(btnName);
  btn.on('click',function() {
    showPopClickEvent(popName);
  });
}
function showPopClickEvent(popName) {
  var box = $(popName),
      hei = box.height(),
      close = $('.js-close-pop',box),
      rot = $('html');
  if(!$('.mask').length){
    $('body').append('<div class="mask"></div>');
  }
  var mask = $('.mask');
  rot.addClass('lock-screen');
  box.fadeIn('fast');
  mask.fadeIn('fast');
  close.on('click',function() {
    box.fadeOut('fast');
    mask.fadeOut('fast');
    rot.removeClass('lock-screen');
  });
}

//切换排序
function sortControl(el, sortType) {
    var els = $(el).children().not('.sort-select');
    els.on('click', function(){
      var that = $(this);
      if(that.hasClass('cur')) {
        $('a',that).toggleClass(sortType);
      }
      that.addClass('cur').siblings().removeClass('cur');
   })
}

//提示弹窗
function tipPop(str){
  if(!Object.prototype.toString.call(str) === "[object String]" || str=='' || str==null) return false;
  var tip = $('<span class="pop-box tip-pop"></span>');
  if(!$('.tip-pop').length) $('body').append(tip);
  var pop = $('.tip-pop');
  pop.text(str).fadeIn().delay(1500).fadeOut();
}
