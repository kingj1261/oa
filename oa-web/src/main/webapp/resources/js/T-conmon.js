/**
 * Created by Administrator on 2015/11/26.
 */
//列表切换  操作和业务流程
function CaoZuo(){
    $(".T-LiBg").click(function(){
        $(".T-tableJL").show()
        $(".T-LiuC").hide();
        $(".T-LiBg").css("background","#0abade").css("color","#ffffff");
        $(".T-YeBTN").css("background","#fff").css("color","#4a4a4a")
    })
}
function Yewu(){
    $(".T-YeBTN").click(function(){
        $(".T-tableJL").hide();
        $(".T-LiuC").show();
        $(".T-YeBTN").css("background","#0abade").css("color","#ffffff");
        $(".T-LiBg").css("background","#fff").css("color","#4a4a4a").extendClass("T-LiBg")
    })
}
//验证 页面上的验证
function nonnull(){
    $("input[type='text']").each(function(index,item){
        var val = $(this).data('valid');
        if(val=='nonull') {
            if ($(this).val() == "") {
                $(this).css("borderColor", "red");
                $(".tishi").show();
                return true;
            } else {
                $(this).css("border", "1px solid #d9d9d9");
                $(".tishi").hide();
            }
        }else if(val=='number'){
            var reg=/^[0-9]{1,10}$/;
            if($(this).val()=="" || !reg.test($(this).val())){
                $(this).css("borderColor","red");
                $(".tishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tishi").hide();
            }
        }else if(val=="phone"){
            var phone=/^[0-9]{7,11}$/;
            if($(this).val()=="" || !phone.test($(this).val())){
                $(this).css("borderColor","red");
                $(".tishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tishi").hide();
            }
        }else if(val=="money"){
            var money=/^\d+(\.\d{1,2})?$/;
            if($(this).val()=="" || !money.test($(this).val())){
                $(this).css("borderColor","red");
                $(".tishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tishi").hide();
            }
        }else if(val=="email"){
            var email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if($(this).val()=="" || !email.test($(this).val())){
                $(this).css("borderColor","red");
                $(".tishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tishi").hide();
            }
        }
    });
}
//验证 弹框上的验证
function tannonnull(){
    $("input[type='text']").each(function(index,item){
        var val = $(this).data('valid');
        if(val=='tannonull') {
            if($(this).val()==""){
                $(this).css("border","1px solid red");
                $(".tantishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tantishi").hide();
            }
        }else if(val=='tannumber'){
            var reg=/^[0-9]{1,10}$/;
            if($(this).val()=="" || !reg.test($(this).val())){
                $(this).css("border","1px solid red");
                $(".tantishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tantishi").hide();
            }
        }else if(val=="tanphone"){
            var phone=/^[0-9]{7,11}$/;
            if($(this).val()=="" || !phone.test($(this).val())){
                $(this).css("border","1px solid red");
                $(".tantishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tantishi").hide();
            }
        }else if(val=="tanmoney"){
            var money=/^\d+(\.\d{1,2})?$/;
            if($(this).val()=="" || !money.test($(this).val())){
                $(this).css("border","1px solid red");
                $(".tantishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tantishi").hide();
            }
        }else if(val=="tanemail"){
            var email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if($(this).val()=="" || !email.test($(this).val())){
                $(this).css("border","1px solid red");
                $(".tantishi").show();
                return true;
            }else{
                $(this).css("border","1px solid #d9d9d9");
                $(".tantishi").hide();
            }
        }
    });
}

//验证码倒计时
var wait=60;
function DaoTime(o) {
    $(".daoTime").css("background","#7d7d7d")
    if (wait == 0) {
        o.removeAttribute("disabled");
        o.value="重新获取";
        $(".daoTime").css("background"," #02c057")
        wait = 60;
    } else {
        o.setAttribute("disabled", true);
        o.value="重新获取(" + wait + ")";
        wait--;
        setTimeout(function() {
                DaoTime(o)
            }, 1000)
    }
}
