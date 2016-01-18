<title>绩效管理-岗位提成设置</title>
<script type="text/javascript">
    $(function () {
        var radioImg = $('.radioImg');
        $('#unitBox').css('display', 'none');
        $('.BoxNone').load('/info/dataTable.html #firmBox3');
        radioImg.click(function () {
            if ($(this).text() == '公司通用设置') {
                $(this).addClass('radioImg1').siblings().removeClass('radioImg1');
                $(this).parent().siblings().find(':input').attr('disabled', true);
                $('#unitBox').css('display', 'none');
                $('.BoxNone').load('/info/dataTable.html #firmBox3');

            } else if ($(this).text() == '个人特殊设置') {
                $(this).addClass('radioImg1').siblings().removeClass('radioImg1');
                $(this).parent().siblings().find(':input').attr('disabled', false);
                $('#unitBox').css('display', 'block');
                $('.BoxNone').load('/info/dataTable.html #personBox3');
            }
        });
    });
</script>

<div class="listDataTitle"><i class="listDataTitleImg"></i> <a>您当前位置:</a><a href="">绩效管理</a>&#47;<a
        class="TitleActiveColor">岗位提成设置</a></div>
<div class="listDataClass">
    <p class="bonus">选择岗位奖金设置范围:</p>
    <dl class="listDataClassBox dataToBox bounsList">
        <dt class=" bounsHref "><a onclick="shoutye('/info/info_special_1.jsp', this)">特殊人员查询</a></dt>
        <dd class="unitBox">
            <em class="DataText FontBold">设置方式:</em>
            <em class="DataText radioImg radioImg1">公司通用设置</em>
            <em class="DataText radioImg">个人特殊设置</em>
        </dd>
        <dd class="unitBox" id="unitBox">
            <em class="DataText FontBold">选择人员:</em>
            <div class="DataText selectBoxes onlyWidth">
                <input class="DataText" type="text" required="required">
                <a class="DataCont icon-search" href="applyup_buydata.html"></a>
                <div class="menuBox">

                    <div class="menuCont">
                        <div class="menuChi menuChir">产品研发中心</div>
                        <div class="menuText">
                            <div class="menuCont">
                                <div class="menuChi menuChir">产品研发中心</div>
                                <div class="menuText">
                                    <div class="menuc">陈 斌</div>
                                    <div class="menuc">袁 见</div>
                                    <div class="menuc">李 鹏</div>
                                    <div class="menuc">唐克运</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="menuCont">
                        <div class="menuChi menuChir">产品研发中心</div>
                        <div class="menuText">
                            <div class="menuc">陈 斌</div>
                            <div class="menuc">袁 见</div>
                            <div class="menuc">李 鹏</div>
                            <div class="menuc">唐克运</div>
                        </div>
                    </div>
                </div>
            </div>
        </dd>
    </dl>
</div>
<div class="BoxNone"></div>
<div class="count marginBottom" onclick="PopupFn('#FiedataBox');">保存</div>
<!--/弹出层 消息提示-->
<div class="popupBox" id="FiedataBox">
    <div class="popupContBox delBoxPopup">
        <div class="popupTitle"><i class="iconCls"></i><span id="span">人员特殊设置原因</span></div>
        <div class="popupTextBox">
            <dl class="listDataClassBox">
                <dd class=" unitBox morny" style="text-align: left;" id="morny">
                    提示：由于XX的岗位奖金设置与公司设置不一致
                </dd>
                <dd class="" style="clear: both">
                    <em class="DataText">请输入原因：</em>
                    <textarea class="DataText onlyWidth" style="width: 100%;min-height: 100px"></textarea>
                </dd>
            </dl>

            <ul class="popupBtn marginBottom">
                <li class="DataText count" onclick="PopupFn('#PromoterBox');">提 交</li>
                <li class="DataText undo">取 消</li>
            </ul>
        </div>
    </div>
</div>
<!--/弹出层 消息提示-->
<div class="popupBox" id="PromoterBox">
    <div class="popupContBox delBoxPopup">
        <div class="popupTitle"><i class="iconCls"></i><span>消息提示</span></div>
        <div class="popupTextBox">
            <dl class="listDataClassBox">
                <dd class="morny">
                    XX的独立岗位提成设置保存成功！
                </dd>
            </dl>
            <ul class="popupBtn marginBottom">
                <li class="DataText count">确 定</li>
                <li class="DataText undo">取 消</li>
            </ul>
        </div>
    </div>
</div>
