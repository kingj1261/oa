
var InputFn = function (Input, fn) {
    var ni = null;
    Input.each(function (index) {
        if (Input.eq(index).val() == '') {
            Input.eq(index).css({'border-color': '#db2b26'});
            $('.errerBox').css('display', 'block');
            return ni = false;
        } else {
            Input.eq(index).css({'border-color': '#c2c2c2'});
            $('.errerBox').css('display', 'none');
            return ni = true;
        }

    });
    if (ni == true) {
        fn && fn();
    } else {
        return false;
    }

};

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
$(function () {
    $('body').delegate('.dataToolBox .DataCont', 'click', function () {
        $(this).addClass('dataToolBoxActive').siblings().removeClass('dataToolBoxActive');
    });
    //代理中心
    var loop = true;

    //采购订单
    $('body').delegate('.shrinkBox .sellerListBoxTitle  ', 'click', function () {
        if ($(this).next().css('display') == 'none') {
            loop = true;
        } else {
            loop = false;
        }
        if (!loop) {
            $(this).find('i').addClass('icon-angle-down');
            $(this).next().css('display', 'none');
        } else {
            $(this).find('i').removeClass('icon-angle-down');
            $(this).next().css('display', 'block');
        }
        loop = !loop;
    });


    $('body').delegate('.menuChi', 'click', function () {
        if ($(this).next('.menuText').css('display') == 'block') {
            $(this).removeClass('menuChin');
            $(this).next('.menuText').css('display', 'none');
        } else {
            $(this).addClass('menuChin');
            $(this).next('.menuText').css('display', 'block');
        }

    });


    var PromoterBox = $('#PromoterBox'), EditData = $('#EditData'), FiedataBox = $('#FiedataBox'), delBoxPopup = $('#delBoxPopup');

    //table
    function TableFn(iTitle, iTextCont) {
        $().find('.popupTextCont .listTextS').eq(0).css('display', 'block');
        $('body').delegate(iTitle, 'click', function () {

            $(this).addClass('unitTitleActive').siblings().removeClass('unitTitleActive');
            $(this).find('.DataTextBox').css('top', '-22px');
            $(this).siblings().find('.DataTextBox').css('top', '0');
            var len = $(this).find('.DataTextImg').attr('class');

            $(iTextCont).eq($(this).index()).css('display', 'block').siblings().css('display', 'none');
        });
    }

    TableFn('.popupTextTitle .DataText', ' .popupTextCont .listTextS');

    //弹出�?
    $('body').delegate('.tableBody .DataText', 'click', function () {
        'use strict';
        if ($(this).text() == '查看') {
            PopupFn(EditData);
        } else if ($(this).text() == '编辑' | $(this).text() == '审批' | $(this).text() == '修改') {
            PopupFn(PromoterBox);
        } else if ($(this).text() == '驳回原因') {
            PopupFn(FiedataBox);

        } else if ($(this).text() == '删除' | $(this).text() == '作废') {
            PopupFn(delBoxPopup);
        }

    });
    $(window).scroll(function () {
        var top = $(window).scrollTop() + $(window).height();
        if (top >= 1200) {
            $('.TopBox').css({'display': 'block', 'z-index': 2});
        } else {
            $('.TopBox').css({'display': 'none', 'z-index': 2});
        }
    });

    $('.TopBox').click(function () {
        window.scrollTo(0, 0);
    });
//    单�?�框
    var radioImg = $('.radioImg');
    $('body').delegate('.radioImg', 'click', function () {

        if ($(this).attr('class') == 'radioImg1') {
            $(this).addClass('radioImg1').siblings().removeClass('radioImg1');
        } else {
            $(this).addClass('radioImg1').siblings().removeClass('radioImg1');
        }
    });

});