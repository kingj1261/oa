<%--绩效管理--绩效基础设置--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="S-location">
    <i class="locationImg"></i><a>您当前位置:</a><a href=""> 绩效管理 </a>&#47;<a href=""> 绩效管理 </a>&#47;
    <a class="locC"> 绩效基础设置 </a>
</div>
<div class="mainCont">
    <!-- 绩效工龄工资设置 -->
    <div>
        <div class="perTitle">
            <div class="ml20 mt10 fl titleImg1"></div>
            <a class="textPos mt20 ml20  db fl">工龄工资</a>
        </div>
        <div class="perTitle-after">
            <table class="S-formBox mt10 ml20">
                <tbody>
                <tr>
                    <td  class="w300">
                        <label class="w110 fl"><span class="fb">工龄工资</span> =工龄* </label>
                        <input maxlength="8"  class="S-modified fl" type="text" id="workYearSalary">
                        <span class="unit" style="width: 30px">元/月</span>
                    </td>
                    <td class="w300">
                        <label class="w110 fl"><span class="fb">封顶：</span></label>
                        <input maxlength="8"  class="S-modified fl" type="text" id="maxSalaryPerMonth">
                        <span class="unit" style="width: 30px">元/月</span>
                    </td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 个人所得税率设置 -->
    <div>
        <div class="perTitle">
            <div class="ml20 mt10 fl titleImg2"></div>
            <a class="textPos mt20 ml20  db fl">个人所得税税率设置</a>
        </div>
        <div class="perTitle-after" style="height:auto">
            <table class="S-formBox mt10">
                <tbody>
                <tr>
                    <td class="w300">
                        <label class="w110 fl"><span class="fb">个税起征点：</span></label>
                        <input maxlength="8"  class="S-modified fl" type="text" id="start">
                        <span class="unit" style="width: 30px">元/月</span>
                    </td>
                    <td class="w300"><input type="checkbox" class="fl mt10" checked id="check"/><label class="w30 fl">启用</label></td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                </tr>
                </tbody>
            </table>
            <div class="S-abbBox clear ml20">
                <a class="NewAddBtn" id="addRevenueBtn">添加</a>
                <a id="deleteRevenue" class="NewAddBtn" style="background-color: #a6a6a6;">删除</a>
            </div>
            <table class="GradeTab mt10" style="margin-left:20px;width: 97%" >
                <thead>
                    <tr id="revenueHeader">
                        <th>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="selectAllRevenues"/>&nbsp;全选</th>
                        <th>全月应纳税所得额（含税级距）（元）</th>
                        <th>税率（%）</th>
                        <th>速算扣除数</th>
                    </tr>
                </thead>
                <tbody >
                    <tr id="revenueVOList" class="gratwo">
                        <td><input type="checkbox" id="revenue"/></td>
                        <td>&nbsp; <span id="fromValue"/>
                            <input type="hidden" id="fromValue"/>
                            ~  <input id="toValue" maxlength="8" data-valid="nonull" class="S-modified" type="text"></td>
                        <td><input id="ratio" maxlength="8" data-valid="nonull" class="S-modified" type="text"></td>
                        <td><input id="deducts" maxlength="8" data-valid="nonull" class="S-modified" type="text"></td>
                    </tr>
                    <div id="split"/>
                </tbody>
            </table>
            <div class="ml20 mb10">
                <p class="f14 c7432"><span class="fb">说明</span>：1、最小值  < 全月应纳税所得额 ≤ 最大值 </p>
                <p class="f14 c7432 ml40">   2、全月应纳税所得额 = 应发工资-社保  - 公积金 - 个税起征点</p>
                <p class="f14 c7432 ml40">   3、应纳个人所得税额 = 全月应纳税 所得额 * 税率 - 速算扣除数</p>
            </div>
        </div>
    </div>

    <!-- 社保设置 -->
    <div class="w50B fl " style="margin-top: -17px">
        <div class="perTitle">
            <div class="ml20 mt10 fl titleImg3"></div>
            <a class="textPos mt20 ml20  db fl">社保设置</a>
            <div class="fl w200 h30 lh30 mt20 ml20">
                <input type="checkbox" class="fl mt10" checked id="socialEnable"/>
                <label class="w30 fl f14">启用</label>
            </div>
        </div>
        <div class="perTitle-after shebao" style="height:120px">
            <table class="S-formBox mt10">
                <tbody>
                <tr>
                    <td  class="w300">
                        <label class="w110 fl fb">设置方式：</label>
                        <input name="social" type="radio" class="fl mt10" value="company"/>
                        <label class="w60 fl f14">公司通用</label>
                        <input name="social" type="radio" class="fl mt10 ml10" value="customer"/>
                        <label class="w60 fl f14">个人设置</label>
                    </td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                </tr>
                <tr>
                    <td  class="w300">
                        <label class="w110 fl fb">社保基数：</label>
                        <input id="socailBasic" maxlength="8"  class="S-modified fl" type="text">
                        <span class="unit">元</span>
                    </td>
                    <td class="w300">
                        <label class="w110 fl fb">个人缴纳比例：</label>
                        <input id="socailPercent" maxlength="4"  class="S-modified fl" type="text">
                        <span class="unit">%</span>
                    </td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="w50B fl " style="margin-top: -17px">
        <div class="perTitle">
            <div class="ml20 mt10 fl titleImg4"></div>
            <a class="textPos mt20 ml20  db fl">公积金设置</a>
            <div class="fl w200 h30 lh30 mt20 ml20">
                <input type="checkbox" class="fl mt10" checked id="check2"/>
                <label class="w30 fl f14">启用</label>
            </div>
        </div>
        <div class="perTitle-after gjj" style="height:120px">
            <table class="S-formBox mt10">
                <tbody>
                <tr>
                    <td  class="w300">
                        <label class="w110 fl fb">设置方式：</label>
                        <input name="gjj" type="radio" class="fl mt10" value="company"/>
                        <label class="w60 fl f14">公司通用</label>
                        <input name="gjj" type="radio" class="fl mt10 ml10" value="customer"/>
                        <label class="w60 fl f14">个人设置</label>
                    </td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                </tr>
                <tr>
                    <td  class="w300">
                        <label class="w110 fl fb">公积金基数：</label>
                        <input id="gjjBasic" maxlength="8"  class="S-modified fl" type="text">
                        <span class="unit">元</span>
                    </td>
                    <td class="w300">
                        <label class="w110 fl fb">个人缴纳比例：</label>
                        <input id="gjjPercent" maxlength="4"  class="S-modified fl" type="text">
                        <span class="unit">%</span>
                    </td>
                    <td class="w300"></td>
                    <td class="w300"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="S-footerBtn clear">
        <input class="SaveBtn" type="button" onclick="OpenModalwindow('S-keep')" value="保  存">
    </div>
</div>
<!--删除弹窗-->
<div id="bank-sub" class="none">
    <div class="w400 h200 S-popWindow">
        <div class="popWTop" style="border: none">
            <h2 class="popWTitle">提  示</h2>
            <a class="popWClose" style="position:absolute; left: 360px;top: -1px;" onclick="CloseModalwindow()">
                <img class="middle mt15" src="resources/images/close.png">
            </a>
        </div>
        <div class="popWContent">
            <span class="hintSpan">是否确认删除？</span>
            <div class="popWFoot">
                <input class="ConBtn" type="button" id="confirmBtn" value="确 定"/>
                <input class="CelBtn" type="button" onclick="CloseModalwindow()" value="取 消"/>
            </div>
        </div>
    </div>
</div>
<!--保存弹窗-->
<div id="S-keep" class="none">
    <div class="w400 h200 S-popWindow">
        <div class="popWTop" style="border: none">
            <h2 class="popWTitle">提  示</h2>
            <a class="popWClose" style="position:absolute; left: 360px;top: -1px;" onclick="CloseModalwindow()">
                <img class="middle mt15" src="resources/images/close.png">
            </a>
        </div>
        <div class="popWContent">
            <span class="hintSpan">是否确认保存？</span>
            <div class="popWFoot">
                <input id="saveBaseConfigBtn" class="ConBtn" type="button" value="确 定"/>
                <input class="CelBtn" type="button" onclick="CloseModalwindow()" value="取 消"/>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    $('#check').click(function () {
        if ($(".GradeTab").find('.S-modified').attr('disabled') == 'disabled') {
            $(".GradeTab").find('.S-modified').removeAttr('disabled');
        } else {
            $(".GradeTab").find('.S-modified').attr('disabled', "disabled");
        }

    });
    $('#socialEnable').click(function () {
        if ($(".shebao").find('input').attr('disabled') == 'disabled') {
            $(".shebao").find('input').removeAttr('disabled');
        } else {
            $(".shebao").find('input').attr('disabled', "disabled");
        }

    });
    $('#check2').click(function () {
        if ($(".gjj").find('input').attr('disabled') == 'disabled') {
            $(".gjj").find('input').removeAttr('disabled');
        } else {
            $(".gjj").find('input').attr('disabled', "disabled");
        }
    });
</script>


<!-- 加载初始化数据 -->
<script type="text/javascript">
    $(document).ready(function(){

        //页面请求加载初始化数据
        $.get("basic/list",function(result){
            if(result.success==false){
                alert('请求失败:'+result.errorMessage);
                return;
            }
            $(".mainCont").loadJSON(result.data);
        });

        //个人列表全选checkbox
        $("#selectAllRevenues").click(function(){
            var allChecked=$(this).attr("checked");
            $("input[id^=revenue]").each(function(){
                if(allChecked){
                    $(this).attr("checked",true);
                }else{
                    $(this).attr("checked",false);
                }
            });
        });

        //个税删除按钮
        $("#deleteRevenue").click(function(){
            var hasCheckRevenue= ($("input:checked[id^=revenue]").length>0);
            if(hasCheckRevenue){
                OpenModalwindow('bank-sub');
            }else{
                alert("请选择需要删除的数据项!");
            }
        });

        //个税配置新增按钮
        $("#addRevenueBtn").click(function(){
            var template= $("#addRevenueTemplate").html();

            //如果选择了全部删除
            if($("#revenueVOList").length==0){
                $("#revenueHeader").parent().append(template);
            }else{
                $("#revenueVOList").parent().append(template);
            }
        });

        //删除个税配置项目
        $("#confirmBtn").die().live("click",function(){
            $("input:checked[id^=revenue]").each(function(){
                $(this).parent().parent().remove();
            });
            CloseModalwindow();
        });

        //基础设置保存
        $("#saveBaseConfigBtn").die().live("click",function(){
            var workYearSalary=$("#workYearSalary").val();
            var maxSalaryPerMonth=$("#maxSalaryPerMonth").val();
            var socailBasic=$("#socailBasic").val();
            var socailPercent=$("#socailPercent").val();
            var gjjBasic=$("#gjjBasic").val();
            var gjjPercent=$("#gjjPercent").val();

            //创建配置对象
            var model=new BasicModel(workYearSalary,maxSalaryPerMonth,socailBasic,socailPercent,gjjBasic,gjjPercent);

            //循环解析个税对象
            $("tr[id^=revenueVOList]").each(function(){
                var fromValue=$(this).find("input[id^=fromValue][type=hidden]").val();

                if(fromValue==undefined || fromValue==""){
                    fromValue="0";
                }
                var toValue=$(this).find("#toValue").val();
                var ratio=$(this).find("#ratio").val();
                var deducts=$(this).find("#deducts").val();

                model.addRevenue(fromValue,toValue,ratio,deducts);
            });

            //提交
            $.ajax({
                url:'basic/add',
                type:"post",
                dataType:"json",
                data:{
                    data:JSON.stringify(model)
                },
                success:function(result){
                    //关闭窗口
                    CloseModalwindow();
                    if(result.success){
                        alert("修改成功");
                    }else{
                        alert("修改失败:"+result.errorMessage);
                    }
                }
            });
        });
    });
</script>

<!-- 新增税收设置模板 -->
<script type="text/html" id="addRevenueTemplate">
    <tr id="revenueVOList" class="gratwo">
        <td><input type="checkbox" id="revenue"/></td>
        <td>&nbsp;
            <input type="hidden" id="fromValue"/>
            <input id="fromValue" maxlength="8" data-valid="nonull" class="S-modified" type="text">~
            <input id="toValue" maxlength="8" data-valid="nonull" class="S-modified" type="text"></td>
        <td><input id="ratio" maxlength="8" data-valid="nonull" class="S-modified" type="text"></td>
        <td><input id="deducts" maxlength="8" data-valid="nonull" class="S-modified" type="text"></td>
    </tr>
</script>