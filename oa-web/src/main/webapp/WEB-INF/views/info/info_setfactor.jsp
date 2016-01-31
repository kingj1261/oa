<%--绩效管理-绩效系数设置--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>绩效管理-绩效系数设置</title>
<!-- 岗位系数业务事项模板 -->
<script id="gwxsBizItemsTemplate" type="text/x-jsrender">
    {{for bizItems}}
        <li id="bizItem-{{> bizItem}}" configType="{{> configType}}" bizItem="{{> bizItem}}" class=" caroutdefau w100">
            <div class="DataTextImgBox">
                <p class="DataTextBox" style="top:-22px;">
                    <i class="DataTextImg {{> context.icon0 }}"></i>
                    <i class="DataTextImg {{> context.icon1 }}"></i>
                </p>
            </div>
            <a>{{> bizItemName}}</a>
        </li>
    {{/for}}
</script>


<!-- 业务事项下业务事件模板 -->
<script id="bizEventTemplate" type="text/x-jquery-tmpl">
    {{each(i,bizEventInfo) data}}
        <div id="bizEvent-{{= configId}}"  configId="{{= configId}}" style="display: block;" class="mt30">
            <div>
                <!-- 事件名称 -->
                <div class="perTitle" style="height:50px">
                    <a class="textPos mt10  ml20  db fl">{{= bizEventInfo.bizEventName }}</a>
                    <a class="TabBlue mt10 lh30  ml10  db fl">（{{= bizEventInfo.memo}}）</a>
                </div>

                <!-- 事件子列表 -->
                <div class="perTitle-after" style="height:auto">
                    <div class="S-abbBox clear ml20 mt20">
                        <a class="NewAddBtn" id="addSubEventBtn"    configId="{{= configId}}">添加</a>
                        <a class="NewAddBtn" id="deleteSubEventBtn" configId="{{= configId}}" style="background-color: #a6a6a6;">删除</a>
                    </div>

                    <table class="GradeTab mt10" style="margin-left:20px;width: 97%">
                        <thead>
                            <tr>
                                <th>&nbsp;&nbsp;&nbsp;<input id="checkAll" configId="{{= configId}}" type="checkbox"/>全选</th>
                                <th>考试得分区间（分）</th>
                                <th>绩效系数</th>
                            </tr>
                        </thead>
                        <tbody id="bizEventContainer-{{= configId}}">
                            {{each(i,subEvent) subEventList}}
                                <tr class="bizEventList-{{= configId}}">
                                    <td><input id="checkBizEvent-{{= configId}}" configId="{{= configId}}" type="checkbox" class=" mt10" /></td>
                                    <td><input maxlength="30" data-valid="nonull" value="{{= subEvent.fromValue}}" class="S-modified" type="text">~
                                    <input maxlength="30" data-valid="nonull" value="{{= subEvent.toValue}}" class="S-modified" type="text"></td>
                                    <td><input maxlength="30" data-valid="nonull" value="{{= subEvent.value}}" class="S-modified" type="text"></td>
                                </tr>
                            {{/each}}
                        </tbody>
                    </table>
                    <div class="S-abbBox clear ml10 mt20">
                        <input id="saveConfigBtn-{{= configId}}" configId="{{= configId}}" onclick="openSaveDialog(this.configId);" class="SaveBtn" type="button"  value="保 存">
                    </div>
                </div>
            </div>
        </div>
    {{/each}}
</script>


<!-- 新增子事项配置模板  -->
<script id="addSubEventTemplate" type="text/x-jsrender">
    <tr class="bizEventList-{{> configId}}">
        <td><input id="checkBizEvent-{{> configId}}" configId="{{> configId}}" type="checkbox" class="mt10"/></td>
        <td><input maxlength="8" data-valid="nonull" value="0" class="S-modified" type="text">~
            <input maxlength="8" data-valid="nonull" value="0" class="S-modified" type="text"></td>
        <td><input maxlength="8" data-valid="nonull" value="0" class="S-modified" type="text"></td>
    </tr>
</script>


<script type="text/javascript">
    $(document).ready(function(){
        /** 加载业务事项大类数据 */
        $.get("config/list?configType=GWXS",function(result){
            if(result.success){
                var bizItems=result.data.bizItems;
                $(bizItems).each(function(){
                    $(this).attr("configType",result.data.configType);
                });
                var html=$("#gwxsBizItemsTemplate").render(result.data);
                $("#gwxsBizItems").append(html);
            }
        });

        /** 绑定业务事项的点击事件 */
        $("li[id^=bizItem-]").die().live("click",function(){
            var configType  =$(this).attr("configType");
            var bizItem     =$(this).attr("bizItem");
            var parameter={configType:configType,bizItem:bizItem};
            $.get("subconfig/list",parameter,function(result){
                if(result.success){
                    $("#bizEvents").empty();
                    $("#bizEventTemplate").tmpl(result).appendTo("#bizEvents");
                }
            });
        });

        //触发第一个tab页加载数据
        //$("li[id^=bizItem-]")[0].click();

        //新增子事件按钮
        $("#addSubEventBtn").die().live("click",function(){

            //获取当前配置id
            var configId=$(this).attr("configId");
            var html= $("#addSubEventTemplate").render({configId:configId});

            //是否全部删除了
            var allDeleted=$(".bizEventList-"+configId).length;
            if(allDeleted==0){
                $("#bizEventContainer-"+configId).append(html);
            }else{
                $(".bizEventList-"+configId).parent().append(html);
            }
        });

        //删除子事项按钮
        $("#deleteSubEventBtn").die().live("click",function(){
            var checkedCounts=$("input:checked[id^=checkBizEvent]").length;
            if(checkedCounts>0){
                OpenModalwindow('bank-sub');
            }
        });

        //删除子事项确认按钮
        $("#confirmBtn").die().live("click",function(){
            var checkedCounts=$("input:checked[id^=checkBizEvent]").length;
            if(checkedCounts>0){
                $("input:checked[id^=checkBizEvent]").parent().parent().remove();
            }
            CloseModalwindow();
        });

        //全选按钮
        $("#checkAll").die().live("click",function(){
            var configId=$(this).attr("configId");
            var checked=$(this).attr("checked");
            if(checked){
                $("input[id=checkBizEvent-"+configId+"][configId="+configId+"]").attr("checked",true);
            }else{
                $("input[id^=checkBizEvent-"+configId+"][configId="+configId+"]").attr("checked",false);
            }
        });

        //保存按钮
        $("#confirmSaveConfigBtn").die().live("click",function(){
        });
    });

    function openSaveDialog(configId){
        showModelDialog('S-keep',{configId:configId});
    }
</script>



<div class="S-location">
    <i class="locationImg"></i><a>您当前位置:</a><a href=""> 绩效管理 </a>&#47;<a href=""> 绩效管理 </a>&#47;
    <a class="locC"> 绩效系数设置 </a>
</div>
<div class="mainCont">
    <div class="clear w90B fl of mt20">
        <!-- 上方业务事项导航菜单 -->
        <ul id="gwxsBizItems" style="display: block;" class="c67 imgcaroutdeta">

        </ul>

        <!-- 下方业务事件列表 -->
        <div id="bizEvents"></div>
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
                <input id="confirmSaveConfigBtn" class="ConBtn" type="button" onclick="CloseModalwindow();keepHint()" value="确 定"/>
                <input class="CelBtn" type="button" onclick="CloseModalwindow()" value="取 消"/>
            </div>
        </div>
    </div>
</div>
