<link rel="stylesheet" href="${ctx}/resources/css/r_agent.css" type="text/css" />

        <script src="/js/adddate.js"></script>

        <script src="/js/highchart.js"></script>
        <script type="text/javascript" src="./js/dataLinePie2.js"></script>
        <script type="text/javascript">
            $(function () {
                lineChart('#LineData1', 'line');
                pieChart('#pieChart', 'pie');
                pieChart('#pieChart1', 'pie');
            });
        </script>

    <div class="listDataTitle"><i class="listDataTitleImg"></i> <a>您当前位置:</a><a href="">统计分析</a>&#47;<a class="TitleActiveColor">工资统计</a>
    </div>
    <div class="chartsBox inofBox marginBottom">
        <h3 class="marginBottom">一年内工资趋势图</h3>
        <div>
            <dl class="listDataClassBox dataToBox" style="width: 180px;">
                <dd class="unitBox" >
                    <em class="DataText FontBold">部门:</em>
                    <select class="onlyWidth DataText"><option value="">6月</option></select>
                </dd>
            </dl>
        </div>
        <div  id="LineData1"></div>
    </div>
    <div class="chartsBox inofBox marginBottom">
        <h3 class="marginBottom">部门工资分布</h3>
        <dl class="listDataClassBox dataToBox">
            <dd class="unitBox">
                <em class="DataText FontBold">查询时间:</em>
                <select class="onlyWidth DataText"><option value="">6月</option></select>
                <select class="onlyWidth DataText" style="width: 50px;"><option value="">5月</option></select>
            </dd>
            <dd class="unitBox">
                <em class="DataText FontBold">工资种类:</em>
                <select class="onlyWidth DataText"><option value="">技术部</option></select>
            </dd>
        </dl>
        <div  id="pieChart"></div>
    </div>
    <div class="chartsBox inofBox marginBottom">
        <h3 class="marginBottom">应发工资组成</h3>
        <dl class="listDataClassBox dataToBox">
            <dd class="unitBox">
                <em class="DataText FontBold">查询时间:</em>
                <select class="onlyWidth DataText"><option value="">6月</option></select>
                <select class="onlyWidth DataText" style="width: 50px;"><option value="">8月</option></select>
            </dd>
            <dd class="unitBox">
                <em class="DataText FontBold">部门:</em>
                <select class="onlyWidth DataText"><option value="">技术部</option></select>
            </dd>
        </dl>
        <div  id="pieChart1"></div>
    </div>
