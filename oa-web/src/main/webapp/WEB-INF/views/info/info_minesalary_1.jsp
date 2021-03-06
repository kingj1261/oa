
<title>我的绩效-我的工资</title>

<link rel="stylesheet" href="${ctx}/resources/css/r_agent.css" type="text/css" />
<script src="/js/highchart.js"></script>
<script type="text/javascript" src="/js/dataLinePie2.js"></script>

<script type="text/javascript">
    $(function () {
        lineChart('#LineData', 'line');
        lineChart('#LineData1', 'column');
        lineChart('#LineData2', 'column');
        pieChart('#pieChart', 'pie');
    });
</script>

<div class="listDataTitle"><i class="listDataTitleImg"></i> <a>您当前位置:</a><a href="">我的绩效</a>&#47;<a class="TitleActiveColor">我的工资</a>
</div>
<div class="userBox marginBottom dataToBox" >
    <p class="undo fr">   返回</p>
    <ul class="DataText fl smaNavBoxes" id="smaNavBoxes">
        <li >
            <img src="./images/userImg.png" alt="">
        </li>
        <li id="userImg">
            <i>李娟</i>
            <b>-产品部</b>
        </li>
    </ul>
    <dl class="listDataClassBox dataToBox fl">
        <dd class="unitBox" id="unitBox" >
            <em class="DataText"><i>实发工资:</i><b>7875.00</b><i>元</i></em>
            <em class="DataText"><i class="TitleActiveColor" style="font-size: 12px;">实发工资=</i>{基本工资+星级工资+保底工资差额+工龄工资+岗位奖金+岗位提成+[(考核绩效+星级工资)*(系数叠乘-1)]+
                奖金+补贴-扣款-社保-公积金}-个税-其他代扣</em>
        </dd>
    </dl>
</div>
<div class="salaryBox marginBottom">
    <h3 class="marginBottom"><em class="fr"> 2015年10月1日 至 2015年10月31日</em><span>工资明细</span></h3>

    <div id="pieChart"></div>

</div>
<div class=" inofListBorder marginBottom">
    <div class="popupTextTitle marginBottom">
        <div class="DataText unitTitleActive">岗位奖金</div>
        <div class="DataText">岗位提成</div>
        <div class="DataText">绩效系数</div>
        <div class="DataText">奖金</div>
        <div class="DataText">补贴</div>
        <div class="DataText">扣款</div>
        <div class="DataText">其他代扣款</div>
    </div>
    <div class="popupTextCont">
        <div class="listDataTable marginBottom listTextS" style="display: block">
            <table class="tableBox marginBottom">
                <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>项目</th>
                        <th>单价</th>
                        <th>单位</th>
                        <th>数量</th>
                        <th>合计(元)</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr class="infotrColorn">
                        <td>1</td>
                        <td>公共类</td>
                        <td>季度经营计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>2</td>
                        <td>公共类</td>
                        <td>月度工作计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>

                    </tr>
                    <tr class="infotrColorn">
                        <td>3</td>
                        <td>公共类</td>
                        <td>工作总结报告</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>4</td>
                        <td>公共类</td>
                        <td>定展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorn">
                        <td>5</td>
                        <td>公共类</td>
                        <td>巡展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>6</td>
                        <td>公共类</td>
                        <td>库存车保养清洗</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                </tbody>
                <tfoot class="ftHeight">
                    <tr class="ftHeightColor">
                        <td>总计</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1000.00</td>
                    </tr>
                </tfoot>
            </table>
            <h3 class="marginBottom" style="text-align: center;color: #707070;">岗位奖金环比</h3>
            <div class="marginBottom" id="LineData1"></div>
        </div>
        <div class="listDataTable marginBottom listTextS">
            <table class="tableBox marginBottom">
                <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>项目</th>
                        <th>单价</th>
                        <th>单位</th>
                        <th>数量</th>
                        <th>合计(元)</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr class="infotrColorn">
                        <td>1</td>
                        <td>公共类</td>
                        <td>季度经营计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>2</td>
                        <td>公共类</td>
                        <td>月度工作计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>

                    </tr>
                    <tr class="infotrColorn">
                        <td>3</td>
                        <td>公共类</td>
                        <td>工作总结报告</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>4</td>
                        <td>公共类</td>
                        <td>定展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorn">
                        <td>5</td>
                        <td>公共类</td>
                        <td>巡展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>6</td>
                        <td>公共类</td>
                        <td>库存车保养清洗</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                </tbody>
                <tfoot class="ftHeight">
                    <tr class="ftHeightColor">
                        <td>总计</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1000.00</td>
                    </tr>
                </tfoot>
            </table>
            <h3 class="marginBottom" style="text-align: center;color: #707070;">岗位奖金环比</h3>
            <div class="marginBottom" id="LineData2">

            </div>
        </div>
        <div class="listDataTable marginBottom listTextS">
            <table class="tableBox">
                <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>项目</th>
                        <th>单价</th>
                        <th>单位</th>
                        <th>数量</th>
                        <th>合计(元)</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr class="infotrColorn">
                        <td>1</td>
                        <td>公共类</td>
                        <td>季度经营计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>2</td>
                        <td>公共类</td>
                        <td>月度工作计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>

                    </tr>
                    <tr class="infotrColorn">
                        <td>3</td>
                        <td>公共类</td>
                        <td>工作总结报告</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>4</td>
                        <td>公共类</td>
                        <td>定展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorn">
                        <td>5</td>
                        <td>公共类</td>
                        <td>巡展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>6</td>
                        <td>公共类</td>
                        <td>库存车保养清洗</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                </tbody>
                <tfoot class="ftHeight">
                    <tr class="ftHeightColor">
                        <td>总计</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1000.00</td>
                    </tr>
                </tfoot>
            </table>
            <div class="marginBottom" id="LineData3">

            </div>
        </div>
        <div class="listDataTable marginBottom listTextS">
            <table class="tableBox">
                <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>项目</th>
                        <th>单价</th>
                        <th>单位</th>
                        <th>数量</th>
                        <th>合计(元)</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr class="infotrColorn">
                        <td>1</td>
                        <td>公共类</td>
                        <td>季度经营计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>2</td>
                        <td>公共类</td>
                        <td>月度工作计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>

                    </tr>
                    <tr class="infotrColorn">
                        <td>3</td>
                        <td>公共类</td>
                        <td>工作总结报告</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>4</td>
                        <td>公共类</td>
                        <td>定展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorn">
                        <td>5</td>
                        <td>公共类</td>
                        <td>巡展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>6</td>
                        <td>公共类</td>
                        <td>库存车保养清洗</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                </tbody>
                <tfoot class="ftHeight">
                    <tr class="ftHeightColor">
                        <td>总计</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1000.00</td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <div class="listDataTable marginBottom listTextS">
            <table class="tableBox">
                <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>项目</th>
                        <th>单价</th>
                        <th>单位</th>
                        <th>数量</th>
                        <th>合计(元)</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr class="infotrColorn">
                        <td>1</td>
                        <td>公共类</td>
                        <td>季度经营计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>2</td>
                        <td>公共类</td>
                        <td>月度工作计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>

                    </tr>
                    <tr class="infotrColorn">
                        <td>3</td>
                        <td>公共类</td>
                        <td>工作总结报告</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>4</td>
                        <td>公共类</td>
                        <td>定展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorn">
                        <td>5</td>
                        <td>公共类</td>
                        <td>巡展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>6</td>
                        <td>公共类</td>
                        <td>库存车保养清洗</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                </tbody>
                <tfoot class="ftHeight">
                    <tr class="ftHeightColor">
                        <td>总计</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1000.00</td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <div class="listDataTable marginBottom listTextS">
            <table class="tableBox">
                <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>项目</th>
                        <th>单价</th>
                        <th>单位</th>
                        <th>数量</th>
                        <th>合计(元)</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr class="infotrColorn">
                        <td>1</td>
                        <td>公共类</td>
                        <td>季度经营计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>2</td>
                        <td>公共类</td>
                        <td>月度工作计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>

                    </tr>
                    <tr class="infotrColorn">
                        <td>3</td>
                        <td>公共类</td>
                        <td>工作总结报告</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>4</td>
                        <td>公共类</td>
                        <td>定展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorn">
                        <td>5</td>
                        <td>公共类</td>
                        <td>巡展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>6</td>
                        <td>公共类</td>
                        <td>库存车保养清洗</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                </tbody>
                <tfoot class="ftHeight">
                    <tr class="ftHeightColor">
                        <td>总计</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1000.00</td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <div class="listDataTable marginBottom listTextS">
            <table class="tableBox">
                <thead class="tableHead infothColor">
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>项目</th>
                        <th>单价</th>
                        <th>单位</th>
                        <th>数量</th>
                        <th>合计(元)</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr class="infotrColorn">
                        <td>1</td>
                        <td>公共类</td>
                        <td>季度经营计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>2</td>
                        <td>公共类</td>
                        <td>月度工作计划</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>

                    </tr>
                    <tr class="infotrColorn">
                        <td>3</td>
                        <td>公共类</td>
                        <td>工作总结报告</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>4</td>
                        <td>公共类</td>
                        <td>定展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorn">
                        <td>5</td>
                        <td>公共类</td>
                        <td>巡展活动</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                    <tr class="infotrColorni">
                        <td>6</td>
                        <td>公共类</td>
                        <td>库存车保养清洗</td>
                        <td>20.00</td>
                        <td>元/次</td>
                        <td>1</td>
                        <td>20.00</td>
                    </tr>
                </tbody>
                <tfoot class="ftHeight">
                    <tr class="ftHeightColor">
                        <td>总计</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1000.00</td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
