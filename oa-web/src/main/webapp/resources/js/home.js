/*
 Author：kitty
 time：15.9.11
 */
//首页菜单点击背景色
$(".menuIco ul li a").click(function () {
    $(".menuIco ul li a").removeClass("menuIcoClick");
    $(this).addClass("menuIcoClick")
});

//首页大菜单切换对应左边菜单
function checkmenu(t) {
    var p = $(t).parent().parent().parent().parent().parent().children();
    alert(p.html());
    p.hide();
    p.eq(0).show();
    p.eq($(t).index() + 1).show();

}

//table隔行变色
$(".cartypeTab tbody>tr:odd").addClass("even");
$(".cartypeTab tbody>tr:even").addClass("odd");


//打开弹出层窗口
//id ：需要弹窗的div 的id名称
//backType：回调类型，默认值：true；true：计算出厂位置之后调用；false：计算出厂位置之前调用
//funcBack：需要执行的回调函数
function OpenModalwindow(id, backType, funcBack) {
    var div_height=($("#" + id).height());
    //alert(div_height+"px")
    //参数处理
    if (typeof (backType) == "function") {
        funcBack = backType;
        backType = true;
    }

    var html = "<div class='Modalwindow'>";
    html += "</div>";
    //统计目前已打开的窗口个数
    var openLength = $(".Modalwindow").length;
    //获取遮罩
    var zz = $(".mask");
    //获取目前最顶上窗口的z-index
    var zindex = $(".Modalwindow").last().css("z-index");
    $(zz).show();
    //创建一个窗口到body
    $("body").append(html);
    var mw = $(".Modalwindow").last();
    //添加传入的元素
    $(mw).html($("#" + id).html());
    if (openLength > 0) {
        $(mw).css("z-index", (parseInt(zindex) + 1));
        $(zz).css("z-index", (parseInt(zindex) + 1));
    }
    //遮罩背景由浅变深  【只打开第一个窗口才开启遮罩背景动画】
    if (openLength == 0) {
//        $(zz).css("opacity", "0").stop(true).animate({ opacity: "0.57" }, 10);
        $(zz).css("opacity", "0.57");


    }
    $(mw).show();
    //弹窗背景由浅变深
    $(mw).css("opacity", "1");
//    $(mw).css("opacity", "0").stop(true).animate({ opacity: "1" }, 10);
    //计算出厂位置前调用回调
    if (backType == false && typeof (funcBack) == "function") {
        funcBack($(mw));
    }
    //计算弹出的位置
    var _height = (document.documentElement.clientHeight);
    var _width = (document.documentElement.clientWidth);
    var boxHeight = $(mw).height();
    //alert(boxHeight)
    //判断计算后的top值如果小于0，就生成滚动条
    //alert(_height+"~~"+boxHeight);
    var top_new = (_height - div_height) / 2 ;
    if (top_new < 0) {
        //生成滚动条后的top值
        top_new = 10;
        $(mw).css("top", top_new + 'px').css("height", (_height - (top_new * 2)) + "px").css("overflow-y", "scroll");
    } else {
        $(mw).css("top", top_new + 'px');
    }
    var boxWdith = $(mw).width();
    $(mw).css("left", ((_width - boxWdith) / 2) + 'px');
    //计算出厂位置后调用回调
    if (backType == true && typeof (funcBack) == "function") {
        funcBack($(mw));
    }
    //隐藏body的滚动条
    if (openLength == 0) {
        $('body').attr("oldoverflow", $('body').css("overflow-y")).css("overflow-y", "hidden");
    }
}
//关闭弹出层窗口
function CloseModalwindow() {
    //统计目前已打开的窗口个数
    var openLength = $(".Modalwindow").length;
    if (openLength == 0) return;
    //获取当前最顶上的窗口
    var ck = $(".Modalwindow").last();
    //下降遮罩层
    if (openLength == 1) {
        $(".mask").hide();
        //显示body的滚动条
        $('body').css("overflow-y", $('body').attr("oldoverflow"));
    }
    else {
        var zindex = $(ck).css("z-index");
        $(".mask").css("z-index", (parseInt(zindex) - 1));
    }
    $(ck).remove();
}

//点击时间控件上面的图片
function clickTime(t) {
    $(t).prev().click();
}


function showModelDialog(id, data) {
    var div_height=($("#" + id).height());

    var html = "<div class='Modalwindow'>";
    html += "</div>";
    //统计目前已打开的窗口个数
    var openLength = $(".Modalwindow").length;
    //获取遮罩
    var zz = $(".mask");
    //获取目前最顶上窗口的z-index
    var zindex = $(".Modalwindow").last().css("z-index");
    $(zz).show();
    //创建一个窗口到body
    $("body").append(html);
    var mw = $(".Modalwindow").last();
    //添加传入的元素
    $(mw).html($("#" + id).render(data));
    if (openLength > 0) {
        $(mw).css("z-index", (parseInt(zindex) + 1));
        $(zz).css("z-index", (parseInt(zindex) + 1));
    }
    //遮罩背景由浅变深  【只打开第一个窗口才开启遮罩背景动画】
    if (openLength == 0) {
//        $(zz).css("opacity", "0").stop(true).animate({ opacity: "0.57" }, 10);
        $(zz).css("opacity", "0.57");


    }
    $(mw).show();
    //弹窗背景由浅变深
    $(mw).css("opacity", "1");
    //计算弹出的位置
    var _height = (document.documentElement.clientHeight);
    var _width = (document.documentElement.clientWidth);
    var boxHeight = $(mw).height();
    //alert(boxHeight)
    //判断计算后的top值如果小于0，就生成滚动条
    //alert(_height+"~~"+boxHeight);
    var top_new = (_height - div_height) / 2 ;
    if (top_new < 0) {
        //生成滚动条后的top值
        top_new = 10;
        $(mw).css("top", top_new + 'px').css("height", (_height - (top_new * 2)) + "px").css("overflow-y", "scroll");
    } else {
        $(mw).css("top", top_new + 'px');
    }
    var boxWdith = $(mw).width();
    $(mw).css("left", ((_width - boxWdith) / 2) + 'px');
    //隐藏body的滚动条
    if (openLength == 0) {
        $('body').attr("oldoverflow", $('body').css("overflow-y")).css("overflow-y", "hidden");
    }
}



//推广补贴审批 点击审批 后页面弹窗出现的回调函数
function clickImage() {
    //解绑所有的click事件
    $(".imageClick").find('a img').unbind("click");
    //给弹出窗里面的图片加单击时间
    $(".imageClick").find('a img').click(function () {
        //获取用户点击图片的原路径
        var imageUrl = $(this).attr("src");
        //新打开一个弹出层
        OpenModalwindow('ImageBig', function (t) {
            //设置弹出层大图片的图片路径
            $(t).find('img').eq(0).attr("src", imageUrl);
        });
    });
}


//积分明细

 function agenclick(t){
     var p = $(t).parent().parent().children();
//     alert(p.html());
     p.hide();
     p.eq(0).show();
     p.eq($(t).index() + 1).show();
     $(".jiesuabDefau").removeClass("jiesuabDefau").addClass("jiesuabother");
     $(t).removeClass("jiesuabother").addClass("jiesuabDefau");
 }

//积分明细创建时间选择点击
$(".timeclick li a").click(function(){
    $(".timeclick  li a").removeClass("fbcolor");
    $(this).addClass("fbcolor");
});

$(".T-hovBlue").click(function(){
    $(".T-hovBlue").removeClass("fbcolor");
    $(this).addClass("fbcolor");
});


//车辆图片添加切换

function imgcarchang(t){
    var p = $(t).parent().parent().children();
    p.hide();
    p.eq(0).show();
    p.eq($(t).index() + 1).show();
    $(".outimgdef").removeClass("outimgdef").addClass("outimgother");
    $(t).removeClass("outimgother").addClass("outimgdef");

}


//车辆图片添加切换

function vehicle(t){
    var p = $(t).parent().parent().children();
    p.hide();
    p.eq(0).show();
    p.eq($(t).index() + 1).show();
    $(".cardetaildef").removeClass("cardetaildef").addClass("cardetailother");
    $(t).removeClass("cardetailother").addClass("cardetaildef");
}


//车辆图片添加切换

function morecanshu(t){
    var p = $(t).parent().parent().children();
    p.hide();
    p.eq(0).show();
    p.eq($(t).index() + 1).show();
    $(".caroutdefau").removeClass("caroutdefau").addClass("ouroutother");
    $(t).removeClass("ouroutother").addClass("caroutdefau");
    $(t).find('.DataTextBox').css('top', '-22px');
    $(t).siblings().find('.DataTextBox').css('top', '0');
}
//相册移上去显示
$(".photoshover li").mouseover(
    function () {
        $(".p3_none").hide();
        $(this).children().eq(1).show();
    }
).mouseout(
    function () {
        $(".p3_none").hide();
    }
);


//点击标题隐藏下面的元素
function titlehide(t){
    var p = $(t).next();
    var pd = $(p).is(":hidden");
    if (pd) {
        $(p).show();
        $(t).children().last().attr("src","images/up.png")
    }
    else {
        $(p).hide();
        $(t).children().last().attr("src","images/down.png")
    }

}

//会员积分设置
$("#updateafter").click(function(){
    $("#updateclickq").hide();
    $("#xiugaiclickh").show();
})
$("#zabolish").click(function(){
    $("#updateclickq").show();
    $("#xiugaiclickh").hide();
})

//代理商积分设置


function skuclassfit(t){
    var p = $(t).parent().parent().children();
    p.hide();
    p.eq(0).show();
    p.eq($(t).index() + 1).show();
    $(".skufit").removeClass("skufit").addClass("classificationfit");
    $(t).removeClass("classificationfit").addClass("skufit");
}

//回到顶部
$(function () {
    $(window).scroll(function () {
        var top = $(this).scrollTop();
        if (top >= 400) {
            $("#goTop").show();
        } else {
            $("#goTop").hide();
        }
    });
    $("#goTop img").click(function () {
        //启动滚动条置顶
//        var t = window.setInterval(function () {
//            var top = $(window).scrollTop();
//            if (top <= 0) {
//                window.clearInterval(t);
//                return;
//            }
//            top -= 50;
//            $(window).scrollTop(top);
//        }, 10);

        $('html').animate({ scrollTop: 0 }, 500);
    });
});


//查看大图
var PopupFn = function (id, option, title, fn) {
    $(".mask").show();
    var popupBox = $(id), iTitle = title | '提示';
    var popupContBox = popupBox.find('.popupContBox'), winH = $(window).innerHeight(), winW = $(window).innerWidth(), sTitle = popupBox.find('.popupTitle span');
    if (option == 'closed') {
        $(".mask").hide();
        popupBox.css({'width': 0, 'height': 0, 'display': 'none'});
        popupContBox.css({'display': 'none', 'z-index': 0});
        $('.errerBox').css('display', 'none');
        $('body').css({'overflow': 'auto'});

    } else {
        if (iTitle)
        {
            sTitle.text(iTitle);
        }
        popupBox.css({'width': winW, 'height': winH, 'display': 'block'});
        $('body').css({'overflow': 'hidden'});
        popupContBox.css({'display': 'block'});
        popupContBox.css({'margin-left': -popupContBox.width() / 2, 'margin-top': -popupContBox.height() / 2});
        fn && fn();

        //    点击关闭
        popupContBox.find('.popupTitle').click(function () {
            $(".mask").hide();
            popupBox.css({'width': 0, 'height': 0, 'display': 'none'});
            popupContBox.css({'display': 'none'});
            $('.errerBox').css('display', 'none');
            $('body').css({'overflow': 'auto'});
        });

//    确认
        popupContBox.find('.count').click(function () {
            // fn && fn(text);
            var Input = popupContBox.find('input[type="text"]');
            if (Input.length == 0) {
                fn && fn();
                $(".mask").hide();
                popupBox.css({'width': 0, 'height': 0, 'display': 'none'});
                popupContBox.css({'display': 'none'});
                $('body').css({'overflow': 'auto'});
                return false;
            } else {
                InputFn(Input, function () {
                    $(".mask").hide();
                    popupBox.css({'width': 0, 'height': 0, 'display': 'none'});
                    popupContBox.css({'display': 'none'});
                    $('body').css({'overflow': 'auto'});
                    return false;
                });
            }
        });
//    取消
        popupContBox.find('.undo').click(function () {
            $(".mask").hide();
            var text = $(this).text();
            popupBox.css({'width': 0, 'height': 0, 'display': 'none'});
            popupContBox.css({'display': 'none'});
            $('body').css({'overflow': 'auto'});
            $('.errerBox').css('display', 'none');

        });
    }

};
//查询列表点击
$(".T-hovBlue").click(function(){
    $(" .colorClick > label ").css("color","#7b7b7b");
    $(this).css("color"," #0a9de6");
});

//获取评论星级
function dianXX(a){
//        $(".T-XX").click(function(){
//            alert("1111")
    $(".T-XX").html("★");
    $(a).nextAll().html("☆");
//        })
}
function XSpLun(){
    $('.XSpLun').show()
    $(".t-PJbtn").css("backgroundColor","#a6a6a6").html("已评价");
    $(".t-PJbtn").attr({"disabled":"disabled"});
}
function HuiFuCss(){
    $(".t-HFBtn").css("backgroundColor","#a6a6a6").html("已回复");
    $(".t-HFBtn").attr({"disabled":"disabled"});
}

function XianOne(){
    $("#leiOne").show();
    $("#leiTwo").hide();
}
function XianTwo(){
    $("#leiOne").hide();
    $("#leiTwo").show();
}
//***********************************************提示弹框*************************************
//驳回成功
function rejectHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("驳 回 成 功 ！")
}
//提交成功
function submitHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("提 交 成 功 ！")
}
//保存成功
function keepHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("保 存 成 功 ！")
}
//修改成功
function XGaiHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("修 改 成 功 ！")
}

//作废成功
function CANHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("作 废 成 功 ！")
}
//审批成功
function approvalHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("审 批 成 功 ！")
}
//删除成功
function delHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("删 除 成 功 ！")
}
//上架
function SJiaHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("上 架 成 功 ！")
}
//下架
function XJiaHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("下 架 成 功 ！")
}
//回复
function HFuHint(){
    $(".T-CZTiShiKuang").show();
    setTimeout(function(){
        $(".T-CZTiShiKuang").hide()
    },1000)
    $(".T-CZTiShiKuang-cont span").html("回 复 成 功 ！")
}

//商家管理点击查看大图

var isClick = false;
$(function () {
    //点击门店
    $(".click_mendian").click(function () {

        if ($(this).next().is(":hidden")) {
            $(this).next().show();
            $(this).next().next().show();
        } else {

            $(this).next().hide();
            $(this).next().next().hide();
        }
    });
    //点击门店下的a标签
    var index_m = 0;
    $(".clicka_img").each(function () {
        var as = $(this).find("li a");
        //给a标签加序号
        var i = 0;
        $(as).each(function () {
            $(this).attr("a_index", i).attr("mendian_index", index_m);
            i++;
        });
        index_m++;
        $(as).click(function () {
            //获取当前的序号
            var index = $(this).attr("a_index");
            //当前总数
            var count = $(as).length - 1;
            //当前容器
            var index_rq = $(this).attr("mendian_index");
            //获取用户点击的图片路径
            var imgurl = $(this).children().eq(0).attr("src");
            OpenModalwindow('imgbtnlongclick', function (t) {
                isClick = false;
                //设置弹出层大图片的图片路径 并记录序号和总数，容器
                $(t).find('.onlyimg').attr("src", imgurl).attr("a_index", index).attr("a_count", count).attr("mendian_index", index_rq);
                //给上下按钮加事件
                //上一张
                $(t).find('.left_jt').click(function () {
                    if (isClick) return;
                    isClick = true;

                    var onlyimg = $(t).find('.onlyimg');
                    var i = parseInt($(onlyimg).attr("a_index"));
                    var c = parseInt($(onlyimg).attr("a_count"));
                    if (i == 0)
                        i = c;
                    else
                        i--;
                    //获取容器
                    var m_index = parseInt($(onlyimg).attr("mendian_index"));
                    //获取图片地址 并更新序号
                    var imgurl_new = $(".clicka_img").eq(m_index).find("li a").eq(i).children().eq(0).attr("src");
                    $(onlyimg).attr("a_index", i);

                    //动画准备
                    $(onlyimg).parent().prev().find("img").attr("src", imgurl_new);
                    $(onlyimg).parent().parent().animate({ left: "+=400px" }, 600, function () {
                        $(this).css("left", "-400px");
                        $(onlyimg).attr("src", imgurl_new);
                        $(this).prepend($(onlyimg).parent().prev());
                        isClick = false;
                    });
                });
                //下一张
                $(t).find('.right_jt').click(function () {
                    if (isClick) return;
                    isClick = true;

                    var onlyimg = $(t).find('.onlyimg');
                    var i = parseInt($(onlyimg).attr("a_index"));
                    var c = parseInt($(onlyimg).attr("a_count"));
                    if (i == c)
                        i = 0
                    else
                        i++;
                    //获取容器
                    var m_index = parseInt($(onlyimg).attr("mendian_index"));
                    //获取图片地址 并更新序号
                    var imgurl_new = $(".clicka_img").eq(m_index).find("li a").eq(i).children().eq(0).attr("src");
                    $(onlyimg).attr("a_index", i);

                    //动画准备
                    $(onlyimg).parent().next().find("img").attr("src", imgurl_new);
                    $(onlyimg).parent().parent().animate({ left: "-=400px" }, 600, function () {
                        $(this).css("left", "-400px");
                        $(onlyimg).attr("src", imgurl_new);
                        $(this).append($(onlyimg).parent().next());
                        isClick = false;
                    });
                });
            })
        });
    });
});


function OpenModalwindowBySP() {
    OpenModalwindow('realnamenametan', function (t) {
        $(t).find(".clickBigImg").click(
            function () {
                //获取用户点击的图片路径
                var imgurl = $(this).parent().prev().attr("src");
                //新打开一个弹出层
                OpenModalwindow('ImageBig2', function (t) {
                    //设置弹出层大图片的图片路径
                    $(t).find('img').eq(0).attr("src", imgurl);
                });
            }
        );

        //车主认证审核
        $(t).find(".owntanphone li").mouseover(
            function () {
                $(".tan_none").hide();
                //                alert($(this).children().eq(1).html());
                $(this).children().eq(1).show();
            }
        ).mouseout(
            function () {
                $(".tan_none").hide();
            }
        );
    });
}
//只查看大图
//function OpenModalwindowByck() {
//    OpenModalwindow('realnamenametanselct', function (t) {
//        $(t).find(".clickBigImg").click(
//            function () {
//                //获取用户点击的图片路径
//                var imgurl = $(this).parent().prev().attr("src");
//                //新打开一个弹出层
//                OpenModalwindow('ImageBig2', function (t) {
//                    //设置弹出层大图片的图片路径
//                    $(t).find('img').eq(0).attr("src", imgurl);
//                });
//            }
//        );
//
//        //车主认证审核
//        $(t).find(".owntanphone li").mouseover(
//            function () {
//                $(".tan_none").hide();
//                //                alert($(this).children().eq(1).html());
//                $(this).children().eq(1).show();
//            }
//        ).mouseout(
//            function () {
//                $(".tan_none").hide();
//            }
//        );
//    });
//}
$(function(){
    $(".clickBigImg").click(
        function(){
            //获取用户点击的图片路径
            var imgurl=$(this).parent().parent().prev().attr("src");
            //新打开一个弹出层
            OpenModalwindow('ImageBig2', function (t) {
                //设置弹出层大图片的图片路径
                $(t).find('img').eq(0).attr("src", imgurl);
            });

        }
    );
})




//大图加照片切换

//用户点击的索引，序号
var imgIndex = 0;
function OpenModalwindowForLook() {
    //初始化为第一个
    imgIndex = 0;
    OpenModalwindow('chakanImgphone', function (t) {
        //默认滚动条至左
        $(t).find(".chakansmall").scrollLeft(0);
        //默认小图选中第一个
        var s_li = $(t).find(".chakansmall ul li");
        $(s_li).eq(0).find("img").css("border-color", "red");
        //点击小图片
        $(s_li).each(function () {
            var i = $(this).index();
            $(this).find("img").attr("index", i).click(function () {
                //更新序号
                imgIndex = parseInt($(this).attr("index"));
                var _left = $(t).find(".reanlleft");
                var _right = $(t).find(".reanright");
                $(_left).show();
                $(_right).show();
                if (imgIndex == 0) $(_left).hide();
                else if (imgIndex == $(t).find(".chakansmall ul li").length - 1) $(_right).hide();
                //更新图片
                $(t).find("#bigImg").attr("src", $(this).attr("src"));
                //同步选中小图
                $(t).find(".chakansmall ul li").find("img").css("border-color", "#c2c2c2");
                $(this).css("border-color", "red");
            });
        });
        //左 默认隐藏左按钮
        $(t).find(".reanlleft").hide().click(function () {
            imgIndex--;
            //显示对于图片
            var s = $(t).find(".chakansmall ul li");
            var img = $(s).eq(imgIndex).find("img");
            $(t).find("#bigImg").attr("src", $(img).attr("src"));
            //按钮操作
            if (imgIndex < s.length - 1) $(t).find(".reanright").show();
            if (imgIndex <= 0) {
                $(this).hide();
            } else {
                $(this).show();
            }
            //同步滚动条
            var _width = $(s).eq(0).width() + 20;
            $(t).find(".chakansmall").stop(true).animate({ "scrollLeft": (imgIndex * _width) + "px" }, 1000);
            //同步小图选中效果
            $(s).find("img").css("border-color", "#c2c2c2");
            $(img).css("border-color", "red");
        });
        //右
        $(t).find(".reanright").click(function () {
            imgIndex++;
            //显示对于图片
            var s = $(t).find(".chakansmall ul li");
            var img = $(s).eq(imgIndex).find("img");
            $(t).find("#bigImg").attr("src", $(img).attr("src"));
            //按钮操作
            if (imgIndex > 0) $(t).find(".reanlleft").show();
            if (imgIndex >= s.length - 1) {
                $(this).hide();
            } else {
                $(this).show();
            }
            //同步滚动条
            var _width = $(s).eq(0).width() + 20;
            $(t).find(".chakansmall").stop(true).animate({ "scrollLeft": (imgIndex * _width) + "px" }, 1000);
            //同步小图选中效果
            $(s).find("img").css("border-color", "#c2c2c2");
            $(img).css("border-color", "red");
        });
    });
}

//图片放大镜
$(".zphotoshover").mouseover(
    function () {

        $(".hover_none").hide();

        $(this).children().eq(1).show();
    }
).mouseout(
    function () {
        $(".hover_none").hide();
    }
);

