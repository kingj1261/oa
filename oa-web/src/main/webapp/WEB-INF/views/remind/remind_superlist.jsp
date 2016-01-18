
<link rel="stylesheet" href="${ctx}/resources/css/S-allModule.css">

<!--您当前位置-->
<div class="S-location">
    <i class="locationImg"></i><a>您当前位置:</a><a href="">外勤中心</a>&#47;<a href="">提醒消息</a>&#47;
    <a class="locC">提醒列表</a>
</div>
<div class="mainCont">
    <!--顶部信息~查询-->
    <div class="S-search">
        <ul>

            <li>
                <label>提醒类型：</label><select >
                    <option value="全部">全部</option>
                    <option value="到期提醒">到期提醒</option>
                    <option value="业务提醒">业务提醒</option>
                </select>
            </li>
            <li>
                <label>业务类型：</label><select >
                    <option value="全部">全部</option>
                    <option value="整车业务">整车业务</option>
                    <option value="维修业务">维修业务</option>
                    <option value="配件业务">配件业务</option>
                    <option value="车贷业务">车贷业务</option>
                    <option value="牌证业务">牌证业务</option>
                    <option value="保险业务">保险业务</option>
                    <option value="挂靠业务">挂靠业务</option>
                </select>
            </li>
            <li style="margin-right:2px;"><label>截止时间：</label>
                <div class="demo fl relative" >
                    <input class="S-modified dateImg" placeholder="全部" type="text"  onclick="laydate()">
                </div>
            </li>
            <li><label style="width:30px;text-align:center;">到</label>
                <div class="demo fl relative" >
                    <input class="S-modified dateImg " placeholder="全部" type="text"  onclick="laydate()">
                </div>
            </li>
            <li>
                <input  type="button" value="查询" class="SearchBtn"/>
            </li>
            <li>
                <input  type="button" value="导出" class="SearchBtn"/>
            </li>
        </ul>
    </div>
    <!--主表单-->
    <table class="S-main-table mt20">
        <tr>
            <th>序号</th>
            <th>提醒类型</th>
            <th>业务类型</th>
            <th>项目</th>
            <th>截止时间</th>
            <th>提醒时间</th>
        </tr>
        <tr class="colorOne">
            <td>1</td>
            <td>业务提醒</td>
            <td>整车</td>
            <td>库存上限预警</td>
            <td></td>
            <td>2015.09.01 10:00:34</td>
        </tr>
        <tr class="colorTwo">
            <td>2</td>
            <td>业务提醒</td>
            <td>维修</td>
            <td>超期维修提醒</td>
            <td></td>
            <td>2015.09.01 10:00:34</td>
        </tr>
        <tr class="colorOne">

            <td>3</td>
            <td>业务提醒</td>
            <td>整车</td>
            <td>超期车提醒</td>
            <td></td>
            <td>2015.09.01 10:00:34</td>
        </tr>
        <tr class="colorTwo">
            <td>4</td>
            <td>业务提醒</td>
            <td>维修</td>
            <td>外出维修审批</td>
            <td>2015.09.01</td>
            <td>2015.09.01 10:00:34</td>
        </tr>
    </table>
    <!--分页-->
    <div class="page">
        <div class="mt20 mb25 fl c7e">每页显示10条 <em>共计1234条</em></div>
        <div class="pageBtn fr">
            <span>第一页</span>
            <span>
                <img src="resources/images/leftBtn.png">
            </span>
            <em>1</em>
            <em>2</em>
            <em>...</em>
            <em>11</em>
            <em>12</em>
            <span>
                <img src="resources/images/rightbtn.png">
            </span>
            <span>末页</span>
        </div>
    </div>
</div>
