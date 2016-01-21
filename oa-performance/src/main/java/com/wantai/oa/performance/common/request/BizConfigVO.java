package com.wantai.oa.performance.common.request;

/**
 * (系数设置)请求对象
 *
 * @author maping.mp
 * @version $Id: BizConfigVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BizConfigVO {

    /** 事项编号*/
    private String  bizItem;

    /** 事件编号*/
    private String  bizEvent;

    /** 是否启用*/
    private boolean enable;

    public String getBizItem() {
        return bizItem;
    }

    public void setBizItem(String bizItem) {
        this.bizItem = bizItem;
    }

    public String getBizEvent() {
        return bizEvent;
    }

    public void setBizEvent(String bizEvent) {
        this.bizEvent = bizEvent;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
