<%--
  Created by IntelliJ IDEA.
  User: weiquan
  Date: 2016/1/16
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="topBg">
    <div class="w90B">
        <div class="fl ml25 of">
            <img class="fl mt20" src="resources/images/logoImg.png">
            <div class="fl ml30 tc weclowBan">
                <strong class=" famWY">欢迎使用</strong>
                <em class="tc db mt5">版本：DS-JWT-001</em>
            </div>
        </div>
        <div class="helloTxt ">
            <p class="fl tr">
                <em class="mr5">2015年9月17号</em>
                <em class="mr5">蓝胖子</em>
                <em>,欢迎您登录金万泰商用车管理系统！</em>
            </p>
            <ul class="fl">
                <li class="fl relative">
                    <div class="emailTip">9+</div>
                    <a class="db">
                        <img src="resources/images/email.png">
                        <em>未读消息</em>
                    </a>
                </li>
                <li class="fl" style="display:block;width:80px;height:40px;border: 1px solid transparent">
                    <a class="db">
                        <img src="resources/images/user.png">
                        <em class="tc">帮助中心</em>
                    </a>
                </li>
                <li class="fl">
                    <a class="db">
                        <img src="resources/images/anquantuichu.png">
                        <em>安全退出</em>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="topMenu c0e92d2">
    <div class="topMenuitem">
        <div class="menuIco ">
            <ul class="of w titleMain ">
                <li>
                    <a onclick="noMain();shoutye('html/legwork/legwork_home.html', this)">绩效管理</a>
                </li>
                <li>
                    <a onclick="noMain();shoutye('html/setcentre/setcantre_supplier.html', this)">设置中心</a>
                </li>
                <li>
                    <a onclick="noMain()">通用外勤</a>
                </li>
                <li>
                    <a onclick="noMain()">督办提醒</a>
                </li>
            </ul>
        </div>
    </div>
</div>