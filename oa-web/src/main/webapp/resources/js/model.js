/**
 * 通用模型定义
 *
 */

/**
 * 绩效管理-通用设置json对象
 */

function BasicModel(workYearSalary,maxSalaryPerMonth,socailBasic,socailPercent,gjjBasic,gjjPercent){
    this.workYearSalary=workYearSalary;
    this.maxSalaryPerMonth=maxSalaryPerMonth;
    this.socailBasic=socailBasic;
    this.socailPercent=socailPercent;
    this.gjjBasic=gjjBasic;
    this.revenueVOList=[];
    this.gjjPercent=gjjPercent;
    this.addRevenue=function(fromValue,toValue,ratio,deducts){
        this.revenueVOList.push(new Revenue(fromValue,toValue,ratio,deducts));
    }

    this.addRevenueModel=function(revenue){
        this.revenueVOList.push(revenue);
    }

    this.validate=function(){

    }
}

/**
 * 税率设置
 */
function Revenue(fromValue,toValue,ratio,deducts){
    this.fromValue=fromValue;
    this.toValue=toValue;
    this.ratio=ratio;
    this.deducts=deducts;
    this.validate=function(){
        if(fromValue==""||toValue==""||ratio==""||deducts==""){
            return false;
        }
        return true;
    }
}