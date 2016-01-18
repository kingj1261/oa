<%--绩效管理--绩效基础设置--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        var radioImg = $('.radioImg');
        radioImg.click(function () {
            if ($(this).text() == '公司通用') {
                $(this).addClass('radioImg1').siblings().removeClass('radioImg1');
                $(this).parent().siblings().find('input').attr('disabled', false).removeClass('disabledColor');
            } else if ($(this).text() == '个人设置') {
                $(this).addClass('radioImg1').siblings().removeClass('radioImg1');
                $(this).parent().siblings().find('input').attr('disabled', true).addClass('disabledColor');
            }
        });
    });
</script>

<script id="movieTemplate" type="text/html">
    <dl class="listDataClassBox dataToBox">
        <dd class="unitBox">
            <span class="DataText">
                <em class="DataText FontBold">工龄工资{{test}}</em>
                <em class="DataText">=工资&times;</em>
            </span>
            <input class="DataCont onlyWidth" type="text" required="required" value="${data.workYearSalary}">
            <em class="DataText">&nbsp;&nbsp;元/月</em>
        </dd>
        <dd class="unitBox">
            <em class="DataText FontBold">封顶:</em>
            <input class="DataCont onlyWidth" type="text" required="required" value="${data.maxSalaryPerMonth}">
            <em class="DataText">&nbsp;&nbsp;元/月</em>
        </dd>
    </dl>
</script>

<!-- 绩效基础查询 -->
<script type="text/javascript">
    $(document).ready(function () {
        $.get("basic/list", function (result) {
            $("#infoListDatas").empty();
            $("#infoListDatas").html($("#basicInfoTemplate").render(result.data));

            $("#revenueList").empty();
            $("#revenueList").html($("#revenueItem").render(result.data.revenueVOList));
        });
    });
</script>

<!-- 个税列表 -->
<script type="text/x-jquery-tmpl" id="revenueItem">
    <tr class="infotrColorni">
        <td>{{>order}}</td>
        <td><p class="infoMorny"><em class="DataText"><i class="DataText">{{>fromValue}}</i>&Tilde;</em><input
                type="text" class="onlyWidth" value="{{>toValue}}"/></p></td>
        <td><input type="text" class=" onlyWidth" value="{{>ratio}}"/></td>
        <td><input type="text" class=" onlyWidth" value="{{>deducts}}"/></td>
    </tr>
</script>


<!-- 工龄基础设置模版 -->
<script type="text/x-jquery-tmpl" id="basicInfoTemplate">
    <dl class="listDataClassBox dataToBox">
        <dd class="unitBox">
            <span class="DataText">
                <em class="DataText FontBold">工龄工资</em>
                <em class="DataText">=工资&times;</em>
            </span>
            <input class="DataCont onlyWidth" type="text" required="required" value="{{>workYearSalary}}">
            <em class="DataText">&nbsp;&nbsp;元/月</em>
        </dd>
        <dd class="unitBox">
            <em class="DataText FontBold">封顶:</em>
            <input class="DataCont onlyWidth" type="text" required="required" value="{{>maxSalaryPerMonth}}">
            <em class="DataText">&nbsp;&nbsp;元/月</em>
        </dd>
    </dl>



</script>

<div class="listDataTitle"><i class="listDataTitleImg"></i> <a>您当前位置:</a><a href="">绩效管理</a>&#47;<a
        class="TitleActiveColor">绩效基础设置</a>
</div>
<div class="listDataContext ">
    <div class="inofBox marginBottom">
        <div class="inofTitle">
            <p><b class="DataText titleImg titleImg1"></b><i class="DataText textPos FontBold">工龄工资</i></p>
        </div>
        <div class="inofList" id="infoListDatas">

        </div>
    </div>
    <div class="inofBox marginBottom">
        <div class="inofTitle">
            <p class="fl"><b class="DataText titleImg titleImg2"></b><i class="DataText textPos FontBold">个人所得税税率设置</i>
            </p>
            <p class="fl textPos"><input type="checkbox"/>启用</p>
        </div>
        <div class="inofList">
            <dl class="listDataClassBox dataToBox">
                <dd class="unitBox">
                    <em class="DataText FontBold">个税起征点:</em>
                    <input class="DataCont onlyWidth" type="text" required="required">
                    <em class="DataText">&nbsp;&nbsp;元</em>
                </dd>
            </dl>

            <dl class="dataToBoxes">
                <dd class="DataText addColor">添加</dd>
                <dd class="DataText delColor" onclick="PopupFn('#delBoxPopup');">删除</dd>
            </dl>
            <div class="listDataTable marginBottom">
                <table class="tableBox">
                    <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>全月应纳税所得额(含税级距)(元)</th>
                        <th>税率(%)</th>
                        <th>速算扣除数</th>
                    </tr>
                    </thead>
                    <tbody class="tableBody" id="revenueList"></tbody>
                </table>
            </div>
            <dl class="listColor">
                <dd>说明:</dd>
                <dd>1、最小值 < 全月应纳税所得额 ≤ 最大值<br>
                    2、全月应纳税所得额 = 应发工资-社保 - 公积金 - 个税起征点<br>
                    3、应纳个人所得税额 = 全月应纳税 所得额 * 税率 - 速算扣除数
                </dd>
            </dl>
        </div>

    </div>
    <div class="marginBottom heightBox" style="height: 220px;">
        <div class="inofBox inofBoxLeft">
            <div class="inofTitle">
                <p class="fl"><b class="DataText titleImg titleImg3"></b><i class="DataText textPos FontBold">社保设置</i>
                </p>
                <p class="fl textPos"><input type="checkbox"/>启用</p>
            </div>
            <div class="inofList">
                <dl class="listDataClassBox dataToBox">
                    <dd class="unitBox">
                        <em class="DataText FontBold">设置方式:</em>
                        <em class="DataText radioImg radioImg1">公司通用</em>
                        <em class="DataText radioImg">个人设置</em>
                    </dd>
                    <dd class="unitBox" style="clear: both">
                        <em class="DataText FontBold">社保基数:</em>
                        <input class="DataCont onlyWidth" type="text" required="required">
                        <em class="DataText">&nbsp;&nbsp;元</em>
                    </dd>
                    <dd class="unitBox">
                        <em class="DataText FontBold">个人缴纳比例:</em>
                        <input class="DataCont onlyWidth" type="text" required="required">
                        <em class="DataText">&nbsp;&nbsp;%</em>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="inofBox inofBoxRight">
            <div class="inofTitle">
                <p class="fl"><b class="DataText titleImg titleImg4"></b><i class="DataText textPos FontBold">公积金设置</i>
                </p>
                <p class="fl textPos"><input type="checkbox"/>启用</p>
            </div>
            <div class="inofList">
                <dl class="listDataClassBox dataToBox">
                    <dd class="unitBox">
                        <em class="DataText FontBold">设置方式:</em>
                        <em class="DataText radioImg radioImg1">公司通用</em>
                        <em class="DataText radioImg">个人设置</em>
                    </dd>
                    <dd class="unitBox" style="clear: both">
                        <em class="DataText FontBold">公积金基数:</em>
                        <input class="DataCont onlyWidth" type="text" required="required">
                        <em class="DataText">&nbsp;&nbsp;元</em>
                    </dd>
                    <dd class="unitBox">
                        <em class="DataText FontBold">个人缴纳比例:</em>
                        <input class="DataCont onlyWidth" type="text" required="required">
                        <em class="DataText">&nbsp;&nbsp;%</em>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
    <div class="count  marginBottom" onclick="PopupFn('#FiedataBox');">保存</div>
</div>


<!--/弹出层 消息提示-->
<div class="popupBox" id="delBoxPopup">
    <div class="popupContBox delBoxPopup">
        <div class="popupTitle"><i class="iconCls"></i><span>消息提示</span></div>
        <div class="popupTextBox">
            <dl class="listDataClassBox">
                <dd class="morny">
                    确定删除吗？
                </dd>
            </dl>
            <ul class="popupBtn marginBottom">
                <li class="DataText count">确 定</li>
                <li class="DataText undo">取 消</li>
            </ul>
        </div>
    </div>
</div>
<!--/弹出层 消息提示-->
<div class="popupBox" id="FiedataBox">
    <div class="popupContBox delBoxPopup">
        <div class="popupTitle"><i class="iconCls"></i><span>消息提示</span></div>
        <div class="popupTextBox">
            <dl class="listDataClassBox">
                <dd class="morny">
                    确定保存吗？
                </dd>
            </dl>
            <ul class="popupBtn marginBottom">
                <li class="DataText count">确 定</li>
                <li class="DataText undo">取 消</li>
            </ul>
        </div>
    </div>
</div>