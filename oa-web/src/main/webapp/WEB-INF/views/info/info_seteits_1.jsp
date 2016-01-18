<link rel="stylesheet" href="${ctx}/resources/css/r_agent.css" type="text/css" />

        <script type="text/javascript">
            $(function () {
                $('.BoxNone').load('/info/dataTable.html #personBox3');
            });
        </script>

    <div class="listDataTitle"><i class="listDataTitleImg"></i> <a>您当前位置:</a><a href="">绩效管理</a>&#47;<a class="TitleActiveColor">岗位提成设置</a></div>
    <div class="listDataClass inofBox inofTitle marginBottom paddingend">
        <dl class="dataToBoxes">
            <dd class="DataText marginRight">
                <em class="DataText FontBold">部门:</em>
                <span class="DataCont">技术部</span>
            </dd>
            <dd class="DataText marginRight">
                <em class="DataText FontBold"> 姓名:</em>
                <span class="DataCont">陈丽</span>
            </dd>
            <dd class="DataText marginRight">
                <em class="DataText FontBold">操作人:</em>
                <span class="DataCont">刘明阳</span>
            </dd>
            <dd class="DataText marginRight">
                <em class="DataText FontBold">操作时间:</em>
                <span class="DataCont">2015-10-06  15：45</span>
            </dd>
            <dd class="DataText" style="clear: both;" >
                <em class="DataText FontBold">原因:</em>
                <span class="DataCont">因为XX原因,与当事员工协调单独调整岗位工作设置。</span>
            </dd>
        </dl>
    </div>
    <div class="BoxNone"></div>
    <div class="marginBottom">
        <p class="DataText count" onclick="PopupFn('#FiedataBox');">保存</p>
        <p class="DataText undo" onclick="shoutye('/info/info_special_1.jsp', this)">返回</p>
    </div>


    <!--/弹出层 消息提示-->
    <div class="popupBox" id="PromoterBox">
        <div class="popupContBox delBoxPopup">  <div class="popupTitle"><i class="iconCls"></i><span>消息提示</span></div>
            <div class="popupTextBox">
                <dl class="listDataClassBox">
                    <dd class="morny">
                        XX的独立岗位提成设置保存成功！
                    </dd>
                </dl>
                <ul class="popupBtn marginBottom">
                    <li class="DataText count">确 定</li>

                </ul>
            </div>
        </div>
    </div>
    <!--/弹出层 消息提示-->
    <div class="popupBox" id="FiedataBox">
        <div class="popupContBox delBoxPopup">
            <div class="popupTitle"><i class="iconCls"></i><span id="span">人员特殊设置原因</span></div>
            <div class="popupTextBox">
                <dl class="listDataClassBox"  id="morny">
                    <dd class=" unitBox morny" style="text-align: left;">
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
