//左边菜单部分
$(function () {
    goMain()
    $('#load_content').load("main.html");
    $(".checkg").hide();
    //主项
    $(".parentitem").next().hide(10);
    $(".parentitem").click(function () {
        $(this).addClass("centerSpace");
        $("h2.parentitem").not(this).removeClass("centerSpace").addClass("itemTitle");
        if ($(this).next().is(":hidden")){
            $(this).next().show(10);
            $("h2.parentitem").not(this).next().hide(10);
    }
        else {
            $(this).next().hide(10);
        }
    });

    //子项
    $(".itemSpace li a").mouseover(function () {
        HideJJ();
        $(this).find(".checkg").show();
        $(this).addClass("itemClick");

        $(this).css("padding", "3% 5% 3% 20%")
    }).click(function () {
        $(this).find(".checkg").show();
        $(".centerSpace").removeClass("centerSpace").addClass("itemTitle");
        $(this).parent().parent().prev().removeClass("itemTitle").addClass("centerSpace");
        $(".itemSpace li a").removeClass("itemClick").attr("isClick", "0").css("padding", "3% 5% 3% 25%");
        $(this).addClass("itemClick").attr("isClick", "1");
        HideJJ();

        $(this).css("padding", "3% 5% 3% 20%")
    }).mouseout(function () {
        HideItemClick();
        HideJJ();
    });
    //给最后一个加内下边距
    $(".itemSpace li a").last().css("padding-bottom", "10px");
    $(".itemTitle").last().css("margin-bottom", "0px");

})

function HideJJ(pd) {
    var checkg = $(".checkg");
    for (var i = 0; i < checkg.length; i++) {
        if (pd != true && $(checkg[i]).parent().attr("isClick") == 1)
            continue;
        $(checkg[i]).hide();
    }
}
function HideItemClick(pd) {
    var itemClick = $(".itemClick");
    for (var i = 0; i < itemClick.length; i++) {
        if (pd != true && $(itemClick[i]).attr("isClick") == 1)
            continue;
        $(itemClick[i]).removeClass("itemClick");
        $(itemClick[i]).css("padding", " 3% 5% 3% 25%");
    }
}
//左边菜单部分 end



function shoutye(index, t) {
    $("#load_content").remove();
    $('#load_content').load('./' + index);
    //变更网站地图名称
    var pname = $(t).parent().parent().prev().text();
    var name = $(t).children().eq(0).text();
    var c = $("#mapAdds").children();
    c.eq(0).text(pname);
    c.eq(3).text(name);
}



//给上面导航菜单加单击，左侧菜单对应变化
$(function () {

    var s = $(".titleMain li a");
    for (var i = 0; i < s.length; i++) {
        $(s[i]).attr("index", i);
    }
    $(".titleMain li a").click(function () {
        helpHide();
        $(".titleMain li a").removeClass("menuIcoClick");
        $(this).addClass("menuIcoClick");
        var s = $(".LeftMenu").children();
        s.hide();
        var c = s.eq($(this).attr("index"));
        c.show();
        c.find("h2").removeClass("centerSpace").addClass("itemTitle");
        c.find("h2").eq(0).removeClass("itemTitle").addClass("centerSpace");
        $(".rightCont").show();
        //清空下方左侧的二级选中菜单
        HideItemClick(true);
        HideJJ(true);
    });
});
//**********************************页面跳转部分*************************************

function shoutye(index, t) {
    $('#load_content').load('./' + index);
    //变更网站地图名称
    var pname = $(t).parent().parent().prev().text();
    //alert(pname)
    var name = $(t).children().eq(1).text();
    var c = $("#mapAdds").children();
    c.eq(1).text(pname);
    c.eq(3).text(name);
    try {
        lineChart('#LineData1', 'spline');
        lineChart1('#LineData2', 'line');
        lineChart('#LineData3', 'spline');
        lineChart('#LineData4', 'spline');
        lineChart('#LineData5', 'spline');
        lineChart('#LineData6', 'spline');
        lineChart('#LineData7', 'spline');
        lineChart('#LineData8', 'spline');
        pieChart('#PieData', 'pie');
    } catch (e) {

    }
}
function goMain() {
//    inform();
    //$(".infolb").hide()
    $(".all").css('background', '#f5f5f5');
}
function  noMain() {
    $("#inform").removeClass("hide");
    $("#inform").addClass("show");
    //$(".infolb").show();
    $(".all").css('background', '#fff');
    $('#load_content').load("html/alltool/kong.html");
    lunbo();
}
function inform() {
    $("#inform").addClass("hide");
    $("#inform").removeClass("show");
}
//提示消息滚动
//var time_time = 1500;
//var time_lb;
//var h = 0;
//var time_pd = false;
//$(function () {
//    //给通知滚动栏设置容器
//    var c = $("#messge").children();
//    if (c.length > 1) {
//        //初始化
//        h = c.eq(0).show().height();
//        var w = c.eq(0).show().width();
//        $("#messge").parent().css("height", h + "px").css("width", w + "px").css("overflow-y", "hidden").css("position", "relative");
//        $("#messge").parent().mouseout(Star_lunbo);
//        $("#messge").css("position", "absolute");
//        //开始动画
//        Star_lunbo();
//        $("#messge,#messge li,#messge li div").mouseover(function () {
//            time_pd = true;
//        });
//    }
//});
//function Star_lunbo() {
//    time_pd = false;
//    clearInterval(time_lb);
//    time_lb = window.setInterval(lunbo, 2000);
//}
//function lunbo() {
//    if (!time_pd)
//        $("#messge").stop(true).animate({ top: "-=" + h + "px" }, time_time, function () {
//            var l = $("#messge").children().first();
//            $("#messge").append(l);
//            $("#messge").css("top", "0px");
//            if (!time_pd)
//                time_lb = window.setInterval(lunbo, 2000);
//        });
//    clearInterval(time_lb);
//
//}

var time_time = 1500;
var time_lb;
var h = 0;
var time_pd = false;
var time_pd2 = false;
$(function () {
    //给通知滚动栏设置容器
    var c = $("#messge").children();
    if (c.length > 1) {
        //初始化
        h = c.eq(0).show().height();
        var w = c.eq(0).show().width();
        $("#messge").parent().css("height", h + "px").css("width", w + "px").css({'overflow':'hidden','position': 'relative'});
        $("#messge").mouseout(function () {
            time_pd = false;
            window.setTimeout(function () {
                if (!time_pd && !time_pd2)
                    lunbo();
            }, 2000);
        });
        $("#messge").css("position", "absolute");
        //开始动画
        window.setInterval(function(){lunbo()},1000);
        $("#messge,#messge li,#messge li div").mouseover(function () {
            time_pd = true;
        });
    }
});
//横向
function lunbo() {
    $(".lunboInfo").animate({left: "-510px"}, 10000, function () {
        $(".lunboInfo").css({left: "0"}).children('li').last().after(
            $('.lunboInfo').children('li').first());
    });
}
//纵向
//function lunbo() {
//    if (time_pd)
//        return;
//    time_pd2 = true;
//    $("#messge").stop(true).animate({top: "-=" + h + "px"}, time_time, function () {
//        var l = $("#messge").children().first();
//        $("#messge").append(l);
//        $("#messge").css("top", "0px");
//        //停顿
//        if (time_pd) {
//            time_pd2 = false;
//            return;
//        }
//        time_lb = window.setTimeout(lunbo(), 1000);
//    });
//}


//子菜单数据模型 构建
var titleMainModel = function () {
    this.parentId = 0;//当前元素的父级id
    this.id = 0;//当前元素id
    this.text = "";//当前元素显示值
}
//子菜单数据源
var titleMainModels = new Array();//存储所以子菜单
//构建虚拟子菜单数据源
var m = new titleMainModel();
m.id = 3;
m.parentId = 1;
m.text = "车辆初始设置";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 4;
m.parentId = 1;
m.text = "车辆基本信息维护";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 5;
m.parentId = 1;
m.text = "商家商品管理";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 6;
m.parentId = 1;
m.text = "商品报表";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 7;
m.parentId = 3;
m.text = "厂家设置";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 8;
m.parentId = 3;
m.text = "车辆品牌";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 9;
m.parentId = 3;
m.text = "车辆车系";
titleMainModels.push(m);
m = new titleMainModel();


m.id = 10;
m.parentId = 4;
m.text = "车辆基本信息添加";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 11;
m.parentId = 4;
m.text = "车辆基本信息审批";
titleMainModels.push(m);
m = new titleMainModel();

m.id = 12;
m.parentId = 5;
m.text = "现货车辆管理";
titleMainModels.push(m);
m = new titleMainModel();

m.id = 12;
m.parentId = 6;
m.text = "车辆基本信息报表";
titleMainModels.push(m);
//m.id = 9;
//m.parentId = 8;
//m.text = "订单管理1-2-2-1";
//titleMainModels.push(m);
//m = new titleMainModel();
m = new titleMainModel();
m.id = 13;
m.parentId = 2;
m.text = "积分设置";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 14;
m.parentId = 2;
m.text = "商品积分规则";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 15;
m.parentId = 2;
m.text = "积分统计";
titleMainModels.push(m);
m = new titleMainModel();
m.id = 16;
m.parentId = 2;
m.text = "商家积分统计";
titleMainModels.push(m);


m = new titleMainModel();
m.id = 17;
m.parentId = 13;
m.text = "会员积分设置";
titleMainModels.push(m);

$(function () {
    //给菜单加悬浮事件，生成第一级菜单
    $(".titleMain li").mouseover(function () {
        //背景设置
        $(".titleMain li a").removeClass("menuIcoClick");
        $(this).find("a").addClass("menuIcoClick");
        //获取当前位于浏览器的偏移值
        var _left = $(this).offset().left;
        var _top = $(this).offset().top;
        var _height = $(this).height();
        //获取当前id
        var id = $(this).attr("data-id");
        var html = "<ul level='1' parentId='" + id + "' class='titleMain_item_ul' style='top:" + (_top + _height) + "px;left:" + _left + "px;'>";
        for (var i = 0; i < titleMainModels.length; i++) {
            var item = titleMainModels[i];
            if (item.parentId == id) {
                html += "<li data-id='" + item.id + "' class='titleMain_item_ul_li_one' onmouseover='ClickItem_li(this)' onmouseout='Itemli_out()'>" + item.text + "</li>";
            }
        }
        html += "</ul>";
        //清空当前的下级级下下级，默认查找5级，若更多需要修改固定值
        for (var i = 1; i < 5; i++) {
            $("ul[level=" + i + "]").remove();
        }
        $("body").append(html);
    }).mouseout(function () {
        Itemli_out();
    });
    $(".titleMain li a").mouseover(function () {
        pd_Main = true
    });
});
//单击子菜单，下侧左边菜单对应选中
function ClickItem_li2(t) {
    //跳转上方主菜单
    var pid = $(".titleMain_item_ul").attr("parentId");
    $(".titleMain li").each(function () {
        if ($(this).attr("data-id") == pid) {
            $(this).find("a").click();
        }
    });
    //匹配下方左侧菜单
    var c = $(".LeftMenu :visible div");
    $(c).find(".itemSpace em").each(function () {
        if ($(t).text() == $(this).text()) {
            $(this).parent().click();
        }
    });
}
//悬浮生成后的第一级菜单，开始生成下一级菜单
function ClickItem_li(t) {
    pd_Main = true;
    //获取当前位于浏览器的偏移值
    var _left = $(t).offset().left;
    var _top = $(t).offset().top;
    var _width = $(t).parent().width();
    //获取当前id
    var id = $(t).attr("data-id");
    //获取当前等级
    var level = parseInt($(t).parent().attr("level"));
    //修改当前选中样式
    $("ul[level=" + level + "]").children().removeClass("menuIcoClick_li");
    $(t).addClass("menuIcoClick_li");
    //生成下一级菜单
    var html = "<ul  level='" + (level + 1) + "' class='titleMain_item_ul' style='top:" + _top + "px;left:" + (_left + _width) + "px;'>";
    var pd = false;
    for (var i = 0; i < titleMainModels.length; i++) {
        var item = titleMainModels[i];
        if (item.parentId == id) {
            html += "<li data-id='" + item.id + "' class='titleMain_item_ul_li' onmouseover='ClickItem_li(this)' onclick='ClickItem_li2(this)'  onmouseout='Itemli_out()'>" + item.text + "</li>";
            pd = true;
        }
    }
    html += "</ul>";
    //清空当前的下级级下下级，默认查找5级，若更多需要修改固定值
    level++;
    for (var i = level; i < level + 5; i++) {
        $("ul[level=" + i + "]").remove();
    }
    if (pd)
        $("body").append(html);
}
var pd_Main = false;
//隐藏子集菜单
function Itemli_out() {
    pd_Main = false;
    //1秒钟延迟
    window.setTimeout(function () {
        if (!pd_Main) {
            $(".titleMain_item_ul").remove();
        }
    }, 1000);
}


function helpShow() {
    $(".hh1").hide()
    $(".helpBox").show()
}
function helpHide() {
    $(".helpBox").hide();
    $(".hh1").show()
}