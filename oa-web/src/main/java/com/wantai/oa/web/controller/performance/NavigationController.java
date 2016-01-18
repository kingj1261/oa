package com.wantai.oa.web.controller.performance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Desc: 公共导航控制器
 * Date: 2016-01-17
 * Time: 11:21
 * author: weiquan
 * Created by IntelliJ IDEA.
 */
@Controller
public class NavigationController {

    /**
     * 绩效管理--绩效基础设置
     */
    @RequestMapping(value = "/performance/set", method = RequestMethod.GET)
    public String setBase() {
        return "info/info_setbase";
    }

    /**
     * 绩效管理--绩效系数设置
     */
    @RequestMapping(value = "/performance/setfactor", method = RequestMethod.GET)
    public String setFactor() {
        return "info/info_setfactor";
    }

    /**
     * 绩效管理--岗位奖金设置
     */
    @RequestMapping(value = "/performance/setbonus", method = RequestMethod.GET)
    public String setBonus() {
        return "info/info_setbonus";
    }

    /**
     * 绩效管理--岗位奖金设置--特殊人员查询
     */
    @RequestMapping(value = "/performance/bonus/special", method = RequestMethod.GET)
    public String findBonusSpecial() {
        return "info/info_special";
    }

    /**
     * 绩效管理--岗位奖金设置--编辑
     */
    @RequestMapping(value = "/performance/bonus/special/edit", method = RequestMethod.GET)
    public String editBonusSpecial() {
        return "info/info_seteits";
    }

    /**
     * 绩效管理--岗位提成设置
     */
    @RequestMapping(value = "/performance/setpush", method = RequestMethod.GET)
    public String setPush() {
        return "info/info_setpush";
    }

    /**
     * 绩效管理--岗位提成设置--特殊人员查询
     */
    @RequestMapping(value = "/performance/setpush/special", method = RequestMethod.GET)
    public String findSetPushSpecial(/*@RequestParam("type") String type, Model model*/) {
        return "info/info_special_1";
    }

    /**
     * 绩效管理--岗位提成设置--编辑
     */
    @RequestMapping(value = "/performance/setpush/special/edit", method = RequestMethod.GET)
    public String editSetPushSpecial() {
        return "info/info_seteits_1";
    }

    /**
     * 绩效管理--岗位绩效设置
     */
    @RequestMapping(value = "/performance/seteffect", method = RequestMethod.GET)
    public ModelAndView setEffect(@RequestParam("key") String key, Model model) {
        ModelAndView mv = new ModelAndView("info/info_seteffect");
        //搜索模块
        mv.addObject(key);
        return mv;
    }

    /**
     * 绩效管理--督办扣款设置
     */
    @RequestMapping(value = "/performance/oversee/deductions", method = RequestMethod.GET)
    public String overseeDeductions() {
        return "info/info_oversee_deductions";
    }

    /**
     * 绩效管理--工资设置查询
     */
    @RequestMapping(value = "/performance/setsalary/find", method = RequestMethod.GET)
    public String findSetSalary() {
        return "info/info_setsalary";
    }

    /**
     * 绩效管理--工资统计
     */
    @RequestMapping(value = "/performance/salarystat", method = RequestMethod.GET)
    public String salaryStat() {
        return "info/info_salarystat";
    }


    /**
     * 我的绩效--我的工资构成
     */
    @RequestMapping(value = "/mine/setsalary", method = RequestMethod.GET)
    public String mineSetSalary() {
        return "info/info_setsalary";
    }

    /**
     * 我的绩效--我的奖金标准
     */
    @RequestMapping(value = "/mine/bonus", method = RequestMethod.GET)
    public String mineBonus() {
        return "info/info_minebonus";
    }

    /**
     * 我的绩效--我的提成标准
     */
    @RequestMapping(value = "/mine/push", method = RequestMethod.GET)
    public String minePush() {
        return "info/info_minepush";
    }

    /**
     * 我的绩效--我的督办扣款标准
     */
    @RequestMapping(value = "/mine/oversee", method = RequestMethod.GET)
    public String mineOversee() {
        return "info/info_Oversee_standard";
    }

    /**
     * 我的绩效--我的工资
     */
    @RequestMapping(value = "/mine/salary", method = RequestMethod.GET)
    public String mineSalary() {
        return "info/info_minesalary";
    }

    /**
     * 统计分析--工资报表
     */
    @RequestMapping(value = "/report/salary", method = RequestMethod.GET)
    public String reportSalary() {
        return "info/info_salaryreport";
    }

    /**
     * 统计分析--工资统计
     */
    @RequestMapping(value = "/report/salarystat", method = RequestMethod.GET)
    public String reportStat() {
        return "info/info_salarystat";
    }


    /*====================================督办提醒=======================================*/

    /**
     * 督办提醒--督办列表
     */
    @RequestMapping(value = "/remind/list", method = RequestMethod.GET)
    public String remindList() {
        return "remind/remind_list";
    }

    /**
     * 督办提醒--提醒列表
     */
    @RequestMapping(value = "/remind/superlist", method = RequestMethod.GET)
    public String remindSuperlist() {
        return "remind/remind_list";
    }

    /**
     * 督办提醒--消息列表
     */
    @RequestMapping(value = "/remind/measslist", method = RequestMethod.GET)
    public String remindMeassList() {
        return "remind/remind_measslist";
    }

    /**
     * 督办提醒--督办设置
     */
    @RequestMapping(value = "/remind/setbus", method = RequestMethod.GET)
    public String remindSetbus() {
        return "remind/remind_setbus";
    }

    /**
     * 督办提醒--提醒设置
     */
    @RequestMapping(value = "/remind/setrem", method = RequestMethod.GET)
    public String remindSetrem() {
        return "remind/remind_setrem";
    }

    /**
     * 督办提醒--提醒统计
     */
    @RequestMapping(value = "/remind/report", method = RequestMethod.GET)
    public String remindReport() {
        return "remind/remind_tool";
    }

}
