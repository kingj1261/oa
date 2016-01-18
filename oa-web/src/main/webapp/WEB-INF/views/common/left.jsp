<%--
  Created by IntelliJ IDEA.
  User: weiquan
  Date: 2016/1/16
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--左边菜单部分-->
<!--左边(首页)-->
<!-- 1 绩效管理-->
<div class="fl w12B none hh1">
    <div class="leftMenui">
        <ul class="itemBorder">
            <li>
                <h2 class="parentitem centerSpace">绩效管理</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('performance/set', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>绩效基础设置</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('performance/setfactor', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>绩效系数设置</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/performance/setbonus', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>岗位奖金设置</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/performance/setpush', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>岗位提成设置</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/performance/seteffect', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>岗位绩效设置</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/performance/oversee/deductions', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>督办扣款设置</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/performance/setsalary/find', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>工资设置查询</em>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <h2 class="parentitem centerSpace">我的绩效</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('/mine/setsalary', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>我的工资构成</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/mine/bonus', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>我的奖金标准</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/mine/push', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>我的提成标准</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/mine/oversee', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>我的督办扣款标准</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/mine/salary', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>我的工资</em>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <h2 class="parentitem centerSpace">统计分析</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('/report/salary', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>工资报表</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/report/salarystat', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>工资统计</em>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<!-- 2 设置中心-->
<div class="fl w12B none hh1">
    <div class="leftMenui">
        <ul class="itemBorder">
            <li>
                <h2 class="parentitem centerSpace">基础设置</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('html/setcentre/setcantre_supplier.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>供应商管理</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('html/setcentre/setcantre_depot.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>库房管理</em>
                        </a>
                    </li>

                </ul>
            </li>
            <li>
                <h2 class="parentitem centerSpace">组织机构管理</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('html/setcentre/setcantre_door.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>分公司及部门管理</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('html/setcentre/setcantre_role.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>角色及权限管理</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('html/setcentre/setcantre_number.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>账号管理</em>
                        </a>
                    </li>

                </ul>
            </li>
            <li>
                <h2 class="parentitem centerSpace">客户设置</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('html/setcentre/setcantre_client.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>客户信息管理</em>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <h2 class="parentitem centerSpace">个人信息管理</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('html/setcentre/setcantre_account.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>修改密码</em>
                        </a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- 3 通用外勤-->
<div class="fl w12B none hh1">
    <div class="leftMenui">
        <ul class="itemBorder">
            <!--通用外勤中心-->
            <li>
                <h2 class="parentitem centerSpace">通用外勤中心</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('html/outworkerCentre/goOut-Entry.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>外出申请</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('html/outworkerCentre/goOut-Approve.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>外出审批</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('html/outworkerCentre/goOut-execute.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>外出执行</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('html/outworkerCentre/goOut-end.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>外出完结审批</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('html/outworkerCentre/goOut-list.html', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>外出列表</em>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>


<!-- 4 督办提醒-->
<div class="fl w12B none hh1">
    <div class="leftMenui">
        <ul class="itemBorder">
            <!--提醒消息-->
            <li>
                <h2 class="parentitem centerSpace">提醒消息</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('/remind/list', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>督办列表</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/remind/superlist', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>提醒列表</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/remind/measslist', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>消息列表</em>
                        </a>
                    </li>

                </ul>
            </li>
            <!--提醒设置-->
            <li>
                <h2 class="parentitem centerSpace">督办提醒设置</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('/remind/setbus', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>督办设置</em>
                        </a>
                    </li>
                    <li>
                        <a onclick="shoutye('/remind/setrem', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>提醒设置</em>
                        </a>
                    </li>

                </ul>
            </li>
            <!--提醒统计-->
            <li>
                <h2 class="parentitem centerSpace">提醒统计</h2>
                <ul class="itemSpace">
                    <li>
                        <a onclick="shoutye('/remind/report', this)">
                            <div class="icon-triangle-right checkg"></div>
                            <em>提醒统计</em>
                        </a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
</div>

<!--**************************华丽丽的分割线*************************************-->
<div class="fl rightCont  ml20">
    <!-- location -->


    <div id="load_content">
        <!--切换内容显示这里-->

        <!--切换内容显示这里结束-->
    </div>
</div>