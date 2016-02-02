
//只能填写数字验证
function number(){
    var inter = $(".number");
    var num = /^[0-9]*$/;
    if(inter.val() == ""){
        inter.css("border-color","#d00505");
        return;
    }
    else if(!num.test(inter.val())){
        inter.css("border-color","#d00505");
        return;
    }
    else{
        inter.css("border-color","#c2c2c2");
        return;
    }
}
//电话号码验证
function phone(){
    var inter = $(".phone");
    var num =/^(+d{2,3}-)?d{11}$/;
    if(inter.val() == ""){
        inter.css("border-color","#d00505");
        return;
    }
    else if(!num.test(inter.val())){
        console.log("kdjfvklncvjfcbj")
        inter.css("border-color","#d00505");
        return;
    }
    else{
        inter.css("border-color","#c2c2c2");
        return;
    }
}
//非空验证
function nonull(){
    var inter = $(".nonull");
    if(inter.val() == " "){
        inter.css("border-color","#d00505");

    }else{
        console.log("jhnfkjbhvkj")
        inter.css("border-color","#c2c2c2");

    }
}























//代理商补贴设置 弹出层积分验证
function taninter(){
    var tuigungmubiao = $(".Modalwindow").last().find("#tuigungmubiao");
    var btinter = $(".Modalwindow").last().find("#btinter");
    var number = /^[0-9]*$/;

    if(tuigungmubiao.val() == ""){
        tuigungmubiao.css("border","1px solid #d00505");
        $(".tiptext").show();
        return ;
    }
    else if(!number.test(tuigungmubiao.val()) &&  tuigungmubiao.val()!=""){
        tuigungmubiao.css("border","1px solid #d00505");
        return;
        $(".tiptext").show();
    }
    else{
        $(".tiptext").hide();
        tuigungmubiao.css("border","1px solid #c2c2c2");
    }

    if(btinter.val() == ""){
        btinter.css("border","1px solid #d00505");
        $(".tiptext").show();
        return;
    }
    else if(!number.test(btinter.val()) && btinter.val()!="" ){
        btinter.css("border","1px solid #d00505");
        $(".tiptext").show();
        return;
    }
    else{
        $(".tiptext").hide();
        btinter.css("border","1px solid #c2c2c2");
    }
}

//添加车辆品牌

function addcarcheck(){
    //$(".tiptext").show();
    //数字验证
    var num = /^[0-9]*$/;
//    网站验证
    var eamil= /^(http:\/\/)?(www.)?(\w+\.)+\w{2,4}(\/)?$/;

    var s = [];
    <!--厂家名称-->
    var venderName = $(".Modalwindow").last().find("#venderName");
    <!--车辆品牌-->
    var cardbrand = $(".Modalwindow").last().find("#cardbrand");
    <!--品牌网站-->
    var brandEmail = $(".Modalwindow").last().find("#brandEmail");
    <!--排序-->
    var carNumber = $(".Modalwindow").last().find("#carNumber");

    <!--厂家名称-->
    if(venderName.val() == ""){
        s.push(venderName);
    }

    <!--车辆品牌-->
    if(cardbrand.val() == ""){
        s.push(cardbrand);
    }

    <!--品牌网站-->
    if(brandEmail.val() == "" || !eamil.test(brandEmail.val())){
        s.push(brandEmail);
    }

    <!--排序-->
    if(carNumber.val() == "" || !num.test(carNumber.val()) ){
        s.push(carNumber);
    }

    //处理提示语
    if(s.length>0) $(".Modalwindow").last().find(".tiptext").show();
    else $(".Modalwindow").last().find(".tiptext").hide();
    //处理不规则的边框样式
    $(".Modalwindow").last()
        .find("#venderName,#cardbrand,#brandEmail,#carNumber").css("border","1px solid #c2c2c2");
    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}

function paixu(){
    $(".tiptext").show();
    //数字验证
    var num = /^[0-9]*$/;
    var sortpaixu = $(".Modalwindow").last().find("#sortpaixu");

    if(sortpaixu.val() == ""){
        $(".tiptext").show();
        sortpaixu.css("border","1px solid #d00505");

    }
    else if(!num.test(sortpaixu.val()) && sortpaixu.val() !="" ){
        $(".tiptext").show();
        sortpaixu.css("border","1px solid #d00505");

    }
    else{
        $(".tiptext").hide();
        sortpaixu.css("border","1px solid #c2c2c2");
    }
}

//     车辆类别
  function addcartype(){

          //数字验证
          var num = /^[0-9]*$/;
          var s = [];
          <!--车辆类型-->
        var shopcartypexing = $(".Modalwindow").last().find("#shopcartypexing");
          <!--车辆类别-->

        var shopcarType = $(".Modalwindow").last().find("#shopcarType");

        <!--排序-->
          var shopcarnumber = $(".Modalwindow").last().find("#shopcarnumber");
      <!--车辆类型-->
      if(shopcartypexing.val() == ""){
          s.push(shopcartypexing);
      }
          <!--车辆类别-->
          if(shopcarType.val() == ""){
              s.push(shopcarType);
          }

          <!--排序-->
          if(shopcarnumber.val() == "" || !num.test(shopcarnumber.val()) ){
              s.push(shopcarnumber);
          }

          //处理提示语
          if(s.length>0) $(".Modalwindow").last().find(".tiptext").show();
          else $(".Modalwindow").last().find(".tiptext").hide();
          //处理不规则的边框样式
          $(".Modalwindow").last()
              .find("#shopcartypexing,#shopcarType,#shopcarnumber").css("border","1px solid #c2c2c2");
          for(var i=0;i< s.length;i++){
              $(s[i]).css("border","1px solid #d00505");
          }

  }

//车辆车系
function addseries(){

    //数字验证
    var num = /^[0-9]*$/;
    var s = [];
    <!--厂家名称-->
    var mailname = $(".Modalwindow").last().find("#mailname");
    <!--车辆品牌-->
    var carPinpai = $(".Modalwindow").last().find("#carPinpai");
    <!--车辆车系-->
    var carsery = $(".Modalwindow").last().find("#carsery");
    <!--排序-->
    var seriynumber = $(".Modalwindow").last().find("#seriynumber");

    <!--厂家名称-->
    if(mailname.val() == ""){
        s.push(mailname);
    }
    <!--车辆品牌-->
    if(carPinpai.val() == ""){
        s.push(carPinpai);
    }
    <!--车辆车系-->
    if(carsery.val() == ""){
        s.push(carsery);
    }
    <!--排序-->
    if(seriynumber.val() == "" || !num.test(seriynumber.val()) ){
        s.push(seriynumber);
    }

    //处理提示语
    if(s.length>0) $(".Modalwindow").last().find(".tiptext").show();
    else $(".Modalwindow").last().find(".tiptext").hide();
    //处理不规则的边框样式
    $(".Modalwindow").last()
        .find("#mailname,#carPinpai,#carsery,#seriynumber").css("border","1px solid #c2c2c2");
    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }

}


//厂家设置
function addfactoryset(){
    var s = [];
    var regrul =/^(http:\/\/)?(www.)?(\w+\.)+\w{2,4}(\/)?$/
    <!--厂家名称-->
    var factName = $(".Modalwindow").last().find("#factName");

    <!--厂家网站-->
    var facturl = $(".Modalwindow").last().find("#facturl");

    <!--厂家名称-->
    if(factName.val() == ""){
        s.push(factName);
    }
    <!--厂家网站-->
    if(facturl.val() == "" || !regrul.test(facturl.val())){
        s.push(facturl);
    }
    //处理提示语
    if(s.length>0) $(".Modalwindow").last().find(".tiptext").show();
    else $(".Modalwindow").last().find(".tiptext").hide();
    //处理不规则的边框样式
    $(".Modalwindow").last()
        .find("#factName,#facturl").css("border","1px solid #c2c2c2");
    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }

}


//车辆颜色设置
function setcolor(){
    var s = [];
    <!--车辆品牌-->
    var carbrandspb = $(".Modalwindow").last().find("#carbrandspb");

    <!--车辆颜色-->
    var carColor = $(".Modalwindow").last().find("#carColor");

    <!--厂家名称-->
    if(carbrandspb.val() == ""){
        s.push(carbrandspb);
    }
    <!--厂家网站-->
    if(carColor.val() == "" ){
        s.push(carColor);
    }
    //处理提示语
    if(s.length>0) $(".Modalwindow").last().find(".tiptext").show();
    else $(".Modalwindow").last().find(".tiptext").hide();
    //处理不规则的边框样式
    $(".Modalwindow").last()
        .find("#carbrandspb,#carColor").css("border","1px solid #c2c2c2");
    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}


//底盘选配参数
function addmatchpara(){
    var s = [];
    <!--参数名称-->
    var paramname = $(".Modalwindow").last().find("#paramname");
    <!--参数值-->
    var parametervalues = $(".Modalwindow").last().find("#parametervalues");

    <!--参数名称-->
    if(paramname.val() == "" ){
        s.push(paramname);
    }

    <!--参数值-->
    if(parametervalues.val() == "" ){
        s.push(parametervalues);
    }

    //处理提示语
    if(s.length>0) $(".Modalwindow").last().find(".tiptext").show();
    else $(".Modalwindow").last().find(".tiptext").hide();
    //处理不规则的边框样式
    $(".Modalwindow").last()
        .find("#paramname,#parametervalues").css("border","1px solid #c2c2c2");
    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}

//上装参数设置
   function addparameterset(){
       var s = [];
       <!--参数名称-->
       var namepara = $(".Modalwindow").last().find("#namepara");
       <!--参数单位-->
       var paradanwei = $(".Modalwindow").last().find("#paradanwei");
       <!--参数值-->
       var parazhi = $(".Modalwindow").last().find("#parazhi");

       <!--参数名称-->
       if(namepara.val() == "" ){
           s.push(namepara);
       }
       <!--参数单位-->
       if(paradanwei.val() == "" ){
           s.push(paradanwei);
       }

       <!--参数值-->
       if(parazhi.val() == "" ){
           s.push(parazhi);
       }

       //处理提示语
       if(s.length>0) $(".Modalwindow").last().find(".tiptext").show();
       else $(".Modalwindow").last().find(".tiptext").hide();
       //处理不规则的边框样式
       $(".Modalwindow").last()
           .find("#namepara,#paradanwei,#parazhi").css("border","1px solid #c2c2c2");
       for(var i=0;i< s.length;i++){
           $(s[i]).css("border","1px solid #d00505");
       }
   }



//车辆基本信息添加
function megcaraddy(){
    //数字验证
//    var num = /^[0-9]*$/;
    var s = [];
    <!--厂家名称-->
    var namepara = $("#jname");
    <!--车辆品牌-->
    var paradanwei = $("#jpinpai");
    <!--车辆车系-->
    var jchexi = $("#jchexi");
    <!--公告型号-->
    var jgonggao = $("#jgonggao");
    <!--驱动形式-->
    var jqudongxingshi = $("#jqudongxingshi");
    <!--整备质量-->
    var jzhengbeizhilaing = $("#jzhengbeizhilaing");
    <!--车身高度-->
    var jcarshenghight = $("#jcarshenghight");
    <!--车身长度-->
    var jcarshegnlong = $("#jcarshegnlong");
    <!--车身宽度-->
    var jcarshegnwidth = $("#jcarshegnwidth");
    <!--准牵引质量-->
    var jzhunqianymolive = $("#jzhunqianymolive");
    <!--额定载质量-->
    var jedingzaimolive = $("#jedingzaimolive");



//发动机参数
    <!--发动机品牌-->
    var fmotorbrand = $("#fmotorbrand");
    <!--发动机型号-->
    var fmotorxinghao=$("#fmotorxinghao");
    <!--排量-->
    var fdisplacement = $("#fdisplacement");
    <!--额定功率转速-->
    var fratedspeed = $("#fratedspeed");

    <!--排放标准-->
    var feffluentstandard = $("#feffluentstandard");
    <!--每缸气门数-->
    var fmgqgatecount = $("#fmgqgatecount");
    <!--气缸数-->
    var fcylindersnumber = $("#fcylindersnumber");
    <!--气缸排列形式-->
    var fcylindershape = $("#fcylindershape");
    <!--最大马力-->
    var fmaxhp = $("#fmaxhp");
    <!--燃油种类-->
    var ffueltypes = $("#ffueltypes");
    <!--系列-->
    var fseries = $("#fseries");
    <!--最大输出功率-->
    var fmaximumoutput = $("#fmaximumoutput");
    <!--进气形式-->
    var fintakeform = $("#fintakeform");
    <!--最大扭矩-->
    var ftorque = $("#ftorque");
    <!--最大扭矩转速-->
    var fmostrpm = $("#fmostrpm");

//驾驶室参数
    <!--驾驶室类型-->
    var scabtype = $("#scabtype");
    <!--准剩人数-->
    var squasiresidual = $("#squasiresidual");
    <!--座位排数-->
    var sseatingarrangement = $("#sseatingarrangement");
    <!--卧铺宽度-->
    var ssleeperwidth = $("#ssleeperwidth");
    <!--驾驶室型号-->
    var ssscabtype = $("#ssscabtype");



    //底盘参数
    <!--驾驶室型号-->
    var xsuspensionform = $("#xsuspensionform");
    <!--钢板片数-->
    var xsplatenumber = $("#xsplatenumber");
    <!--油箱/气罐材质-->
    var xyouxiangtankmaterial = $("#xyouxiangtankmaterial");
    <!--最高设计车速-->
    var xmaxdesignspeed = $("#xmaxdesignspeed");
    <!--鞍座-->
    var xsaddle = $("#xsaddle");
    <!--轴距-->
    var xwheelbase = $("#xwheelbase");
    <!--油箱/气罐容积-->
    var xtankcapacity = $("#xtankcapacity");
    <!--最小转弯直径-->
    var xminturningdiameter = $("#xminturningdiameter");
    <!--前悬-->
    var xoverhang = $("#xoverhang");
    <!--后悬-->
    var xrearoverhang = $("#xrearoverhang");
    <!--车架层数/厚度-->
    var xframenumber = $("#xframenumber");


//变数箱参数
    <!--变速箱品牌-->
    var xvariablebrand = $("#xvariablebrand");
    <!--换挡方式-->
    var hsteptronic = $("#hsteptronic");
    <!--系列-->
    var hseries = $("#hseries");
    <!--变速箱型号-->
    var hvariablemodel = $("#hvariablemodel");
    <!--倒挡档为数-->
    var hinvertedfilenumber = $("#hinvertedfilenumber");
    <!--前进档位数-->
    var hforwardfilenumber = $("#hforwardfilenumber");
    <!--变速箱油容量-->
    var htransmission = $("#htransmission");
    <!--最大扭矩-->
    var hmaximumtorque = $("#hmaximumtorque");
    <!--换挡行驶-->
    var hshiftdrive = $("#hshiftdrive");
    <!--最大输出扭矩-->
    var maxtorqueoutput = $("#maxtorqueoutput");

//车桥参数
    <!--前桥型号-->
    var cfrontaxletype = $("#cfrontaxletype");
    <!--后桥型号-->
    var cRearaxlemodel = $("#cRearaxlemodel");
    <!--轮距(前/后)-->
    var ctreadqh = $("#ctreadqh");
    <!--前桥允许载荷-->
    var cpossibleload = $("#cpossibleload");
    <!--后桥速比-->
    var cRearaxleratio = $("#cRearaxleratio");
    <!--轮辋-->
    var crim = $("#crim");
    <!--最大输出扭矩-->
    var cmaxtorqueoutput = $("#cmaxtorqueoutput");
    <!--后桥允许载荷-->
    var callowableload = $("#callowableload");


//轮胎参数
    <!--轮胎品牌-->
    var ltirebrand = $("#ltirebrand");
    <!--轮胎系列-->
    var ltireseries = $("#ltireseries");
    <!--轮胎规格-->
    var ltirenorms = $("#ltirenorms");
    <!--轮胎数量-->
    var ltirenumber = $("#ltirenumber");
    <!--层级-->
    var ltopclass = $("#ltopclass");
    <!--轮辋-->
    var lfelly = $("#lfelly");



    <!--厂家名称-->
    if(namepara.val() == "" ){
        s.push(namepara);
    }
    <!--车辆品牌-->
    if(paradanwei.val() == "" ){
        s.push(paradanwei);
    }
    <!--车辆车系-->
    if(jchexi.val() == "" ){
        s.push(jchexi);
    }
    <!--公告型号-->
    if(jgonggao.val() == "" ){
        s.push(jgonggao);
    }
    <!--驱动形式-->
    if(jqudongxingshi.val() == "" ){
        s.push(jqudongxingshi);
    }
    <!--整备质量-->
    if(jzhengbeizhilaing.val() == "" || isNaN(jzhengbeizhilaing.val()) || jzhengbeizhilaing.val()<0){
        s.push(jzhengbeizhilaing);
    }
    <!--车身高度-->
    if(jcarshenghight.val() == "" || isNaN(jcarshenghight.val()) || jcarshenghight.val()<0){
        s.push(jcarshenghight);
    }
    <!--车身长度-->
    if(jcarshegnlong.val() == "" || isNaN(jcarshegnlong.val()) || jcarshegnlong.val()<0){
        s.push(jcarshegnlong);
    }
        <!--车身宽度-->
    if(jcarshegnwidth.val() == "" || isNaN(jcarshegnwidth.val()) || jcarshegnwidth.val()<0){
        s.push(jcarshegnwidth);
    }
    <!--准牵引质量-->
    if(jzhunqianymolive.val() == "" || isNaN(jzhunqianymolive.val()) || jzhunqianymolive.val()<0){
        s.push(jzhunqianymolive);
    }
        <!--额定载质量-->
    if(jedingzaimolive.val() == "" || isNaN(jedingzaimolive.val()) || jedingzaimolive.val()<0){
        s.push(jedingzaimolive);
    }

//发动机参数
    <!--发动机品牌-->
    if(fmotorbrand.val() == "" ){
        s.push(fmotorbrand);
    }
    <!--发动机型号-->
    if(fmotorxinghao.val() == "" ){
        s.push(fmotorxinghao);
    }
    <!--排量-->
    if(fdisplacement.val() == "" ){
        s.push(fdisplacement);
    }
    <!--额定功率转速-->
    if(fratedspeed.val() == "" ){
        s.push(fratedspeed);
    }
    <!--排放标准-->
    if(feffluentstandard.val() == "" ){
        s.push(feffluentstandard);
    }
    <!--每缸气门数-->
    if(fmgqgatecount.val() == "" ){
        s.push(fmgqgatecount);
    }
    <!--气缸数-->
    if(fcylindersnumber.val() == "" ){
        s.push(fcylindersnumber);
    }
    <!--气缸排列形式-->
    if(fcylindershape.val() == "" ){
        s.push(fcylindershape);
    }
    <!--最大马力-->
    if(fmaxhp.val() == ""  || isNaN(fmaxhp.val()) || fmaxhp.val()<0){
        s.push(fmaxhp);
    }
    <!--燃油种类-->
    if(ffueltypes.val() == "" ){
        s.push(ffueltypes);
    }
    <!--系列-->
    if(fseries.val() == "" ){
        s.push(fseries);
    }
    <!--最大输出功率-->
    if(fmaximumoutput.val() == "" ){
        s.push(fmaximumoutput);
    }
    <!--进气形式-->
    if(fintakeform.val() == "" ){
        s.push(fintakeform);
    }
    <!--最大扭矩-->
    if(ftorque.val() == "" ){
        s.push(ftorque);
    }
    <!--最大扭矩转速-->
    if(fmostrpm.val() == "" ){
        s.push(fmostrpm);
    }


    //驾驶室参数
    <!--驾驶室类型-->
    if(scabtype.val() == "" ){
        s.push(scabtype);
    }
    <!--准剩人数-->
    if(squasiresidual.val() == ""  || isNaN(fmaxhp.val()) || squasiresidual.val()<0){
        s.push(squasiresidual);
    }
    <!--座位排数-->
    if(sseatingarrangement.val() == "" || isNaN(sseatingarrangement.val()) || sseatingarrangement.val()<0){
        s.push(sseatingarrangement);
    }
    <!--卧铺宽度-->
    if(ssleeperwidth.val() == "" || isNaN(ssleeperwidth.val()) || ssleeperwidth.val()<0){
        s.push(ssleeperwidth);
    }

    <!--驾驶室型号-->
    if(ssscabtype.val() == "" ){
        s.push(ssscabtype);
    }

    //底盘参数
    <!--悬挂形式-->
    if(xsuspensionform.val() == "" ){
        s.push(xsuspensionform);
    }
    <!--钢板片数-->
    if(xsplatenumber.val() == "" || isNaN(xsplatenumber.val()) || xsplatenumber.val()<0){
        s.push(xsplatenumber);
    }
    <!--油箱/气罐材质-->
    if(xyouxiangtankmaterial.val() == "" ){
        s.push(xyouxiangtankmaterial);
    }
    <!--最高设计车速-->
    if(xmaxdesignspeed.val() == "" ){
        s.push(xmaxdesignspeed);
    }
    <!--鞍座-->
    if(xsaddle.val() == "" || isNaN(xsaddle.val()) || xsaddle.val()<0){
        s.push(xsaddle);
    }
    <!--轴距-->
    if(xwheelbase.val() == "" ){
        s.push(xwheelbase);
    }
    <!--油箱/气罐容积-->
    if(xtankcapacity.val() == "" ){
        s.push(xtankcapacity);
    }
    <!--最小转弯直径-->
    if(xminturningdiameter.val() == "" ){
        s.push(xminturningdiameter);
    }
    <!--前悬-->
    if(xoverhang.val() == "" ){
        s.push(xoverhang);
    }
    <!--后悬-->
    if(xrearoverhang.val() == "" ){
        s.push(xrearoverhang);
    }
    <!--车架层数/厚度-->
    if(xframenumber.val() == "" || isNaN(xframenumber.val()) || xframenumber.val()<0){
        s.push(xframenumber);
    }


    //变色箱参数
    <!--变速箱品牌-->
    if(xvariablebrand.val() == "" ){
        s.push(xvariablebrand);
    }
    <!--换挡方式-->
    if(hsteptronic.val() == "" ){
        s.push(hsteptronic);
    }
    <!--系列-->
    if(hseries.val() == "" ){
        s.push(hseries);
    }
    <!--变速箱型号-->
    if(hvariablemodel.val() == "" ){
        s.push(hvariablemodel);
    }
    <!--倒挡档为数-->
    if(hinvertedfilenumber.val() == "" || isNaN(hinvertedfilenumber.val()) || hinvertedfilenumber.val()<0){
        s.push(hinvertedfilenumber);
    }
    <!--前进档位数-->
    if(hforwardfilenumber.val() == "" || isNaN(hforwardfilenumber.val())  || hforwardfilenumber.val()<0){
        s.push(hforwardfilenumber);
    }
    <!--变速箱油容量-->
    if(htransmission.val() == "" ){
        s.push(htransmission);
    }
    <!--最大扭矩-->
    if(hmaximumtorque.val() == "" ){
        s.push(hmaximumtorque);
    }
    <!--换挡行驶-->
    if(hshiftdrive.val() == "" ){
        s.push(hshiftdrive);
    }

    //车桥参数
    <!--前桥型号-->
    if(cfrontaxletype.val() == "" ){
        s.push(cfrontaxletype);
    }
    <!--后桥型号-->
    if(cRearaxlemodel.val() == "" ){
        s.push(cRearaxlemodel);
    }
    <!--轮距(前/后)-->
    if(ctreadqh.val() == "" ){
        s.push(ctreadqh);
    }
    <!--前桥允许载荷-->
    if(cpossibleload.val() == "" ){
        s.push(cpossibleload);
    }
    <!--后桥速比-->
    if(cRearaxleratio.val() == "" ){
        s.push(cRearaxleratio);
    }
    <!--轮辋-->
    if(crim.val() == "" ){
        s.push(crim);
    }
    <!--最大输出扭矩-->
    if(cmaxtorqueoutput.val() == "" ){
        s.push(cmaxtorqueoutput);
    }
    <!--后桥允许载荷-->
    if(callowableload.val() == "" ){
        s.push(callowableload);
    }

//轮胎参数
    <!--轮胎品牌-->
    if(ltirebrand.val() == "" ){
        s.push(ltirebrand);
    }
    <!--轮胎系列-->
    if(ltireseries.val() == "" ){
        s.push(ltireseries);
    }
    <!--轮胎规格-->
    if(ltirenorms.val() == "" ){
        s.push(ltirenorms);
    }
    <!--轮胎数量-->
    if(ltirenumber.val() == ""  || isNaN(ltirenumber.val()) || ltirenumber.val()<0){
        s.push(ltirenumber);
    }
    <!--层级-->
    if(ltopclass.val() == "" || isNaN(ltopclass.val()) || ltopclass.val()<0){
        s.push(ltopclass);
    }
    <!--轮辋-->
    if(lfelly.val() == "" ){
        s.push(lfelly);
    }




    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("savesuccess");
    }
    //处理不规则的边框样式
    $("#jname,#jpinpai,#jchexi,#jgonggao,#jqudongxingshi,#jzhengbeizhilaing,#jcarshenghight,#jcarshegnlong,#jcarshegnwidth,#jzhunqianymolive,#jedingzaimolive" +
        "#fmotorbrand,#fmotorxinghao,#fdisplacement,#fratedspeed,#feffluentstandard,#fmgqgatecount,#fcylindersnumber,#fcylindershape,#fmaxhp," +
        "#ffueltypes,#fseries,#fmaximumoutput,#fintakeform,#ftorque,#fmostrpm" +
        ",#scabtype,#squasiresidual,#sseatingarrangement,#ssleeperwidth,#ssscabtype" +
        ",#xsuspensionform,#xsplatenumber,#xyouxiangtankmaterial,#xmaxdesignspeed,#xsaddle,#xwheelbase,#xtankcapacity,#xminturningdiameter" +
        ",#xoverhang,#xrearoverhang,#xframenumber,#xvariablebrand,#hsteptronic,#hseries,#hvariablemodel,#hinvertedfilenumber" +
        ",#hforwardfilenumber,#htransmission,#hmaximumtorque,#hshiftdrive" +
        ",#cfrontaxletype,#cRearaxlemodel,#ctreadqh,#cpossibleload,#cRearaxleratio,#crim,#cmaxtorqueoutput,#callowableload" +
        ",#ltirebrand,#ltireseries,#ltirenorms,#ltirenumber,#ltopclass,#lfelly")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}

//会员积分设置
function interlset(){
    var s = [];
//    var oldintegralvalue= $(".Modalwindow").last().find("#oldintegralvalue");
    var newintegralvalue= $(".Modalwindow").last().find("#newintegralvalue");
    var adjustmentreason= $(".Modalwindow").last().find("#adjustmentreason");

    <!--轮辋-->
//    if(oldintegralvalue.val() == "" ){
//        s.push(oldintegralvalue);
//    }
    if(newintegralvalue.val() == "" ){
        s.push(newintegralvalue);
    }
    if(adjustmentreason.val() == "" ){
        s.push(adjustmentreason);
    }

    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("tipupdate");
    }
    //处理不规则的边框样式
    $("#newintegralvalue,#adjustmentreason")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}

//积分兑现设置
function intercount(){
    var s = [];
//    var interold= $(".Modalwindow").last().find("#interold");
    var internew= $(".Modalwindow").last().find("#internew");
    var interreson= $(".Modalwindow").last().find("#interreson");

//    if(interold.val() == "" ){
//        s.push(interold);
//    }
    if(internew.val() == "" ){
        s.push(internew);
    }
    if(interreson.val() == "" ){
        s.push(interreson);
    }

    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("affirmexchangeupdate");
    }
    //处理不规则的边框样式
    $("#internew,#interreson")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}


//整车积分
function  carinsercheck(){
    var s = [];
    var newmoneycar= $(".Modalwindow").last().find("#newmoneycar");
    var newmoneycarreson= $(".Modalwindow").last().find("#newmoneycarreson");

    if(newmoneycar.val() == "" ){
        s.push(newmoneycar);
    }
    if(newmoneycarreson.val() == "" ){
        s.push(newmoneycarreson);
    }

    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("quedingcarinsercheck");
    }
    //处理不规则的边框样式
    $("#newmoneycar,#newmoneycarreson")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}


//积分兑现设置
function intercount(){
    var s = [];
    var interold= $(".Modalwindow").last().find("#interold");
    var internew= $(".Modalwindow").last().find("#internew");
    var interreson= $(".Modalwindow").last().find("#interreson");

    if(interold.val() == "" ){
        s.push(interold);
    }
    if(internew.val() == "" ){
        s.push(internew);
    }
    if(interreson.val() == "" ){
        s.push(interreson);
    }

    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("affirmexchangeupdate");
    }
    //处理不规则的边框样式
    $("#interold,#internew,#interreson")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}


//整车积分 分类设置
function  carficationcheck(){
    var s = [];
    var ficationnewmoneycar= $(".Modalwindow").last().find("#ficationnewmoneycar");
    var ficationnewmoneycarreson= $(".Modalwindow").last().find("#ficationnewmoneycarreson");

    if(ficationnewmoneycar.val() == "" ){
        s.push(ficationnewmoneycar);
    }
    if(ficationnewmoneycarreson.val() == "" ){
        s.push(ficationnewmoneycarreson);
    }

    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("quedingcarficationcheck");
    }
    //处理不规则的边框样式
    $("#ficationnewmoneycar,#ficationnewmoneycarreson")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}

//保险积分
function  carintegralcheck(){
    var s = [];
    var integalnewmoney= $(".Modalwindow").last().find("#integalnewmoney");
    var integalnewreason= $(".Modalwindow").last().find("#integalnewreason");

    if(integalnewmoney.val() == "" ){
        s.push(integalnewmoney);
    }
    if(integalnewreason.val() == "" ){
        s.push(integalnewreason);
    }

    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("integraljfqueren");
    }
    //处理不规则的边框样式
    $("#integalnewmoney,#integalnewreason")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}


//服务积分
function  servicecheck(){
    var s = [];
    var servicenewmoney= $(".Modalwindow").last().find("#servicenewmoney");
    var servicenewreason= $(".Modalwindow").last().find("#servicenewreason");

    if(servicenewmoney.val() == "" ){
        s.push(servicenewmoney);
    }
    if(servicenewreason.val() == "" ){
        s.push(servicenewreason);

    }

    //处理提示语
    if(s.length>0) $(".tiptext").show();
    else {
        $(".tiptext").hide();
        OpenModalwindow("serviceattadqueren");
    }
    //处理不规则的边框样式
    $("#servicenewmoney,#servicenewreason")
        .css("border","1px solid #c2c2c2");

    for(var i=0;i< s.length;i++){
        $(s[i]).css("border","1px solid #d00505");
    }
}


//整车积分等的批量修改
   function batchuodate(){

       var s = [];
       var batchmoneypl= $(".Modalwindow").last().find("#batchmoneypl");
       var batchresonerpl= $(".Modalwindow").last().find("#batchresonerpl");

       if(batchmoneypl.val() == "" || isNaN(batchmoneypl.val()) || batchmoneypl.val()<0){
           s.push(batchmoneypl);
       }
       if(batchresonerpl.val() == "" ){
           s.push(batchresonerpl);

       }

       //处理提示语
       if(s.length>0) $(".tiptext").show();
       else {
           $(".tiptext").hide();
           OpenModalwindow("tipupdate");
       }
       //处理不规则的边框样式
       $("#batchmoneypl,#batchresonerpl")
           .css("border","1px solid #c2c2c2");

       for(var i=0;i< s.length;i++){
           $(s[i]).css("border","1px solid #d00505");
       }
   }