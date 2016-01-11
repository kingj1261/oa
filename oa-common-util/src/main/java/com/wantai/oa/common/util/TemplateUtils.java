/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.util;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 模板渲染工具类
 * @author maping.mp
 * @version $Id: TemplateUtils.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class TemplateUtils {

    /** 日志*/
    private static Logger logger = Logger.getLogger(TemplateUtils.class);

    /**
     * 渲染模板
     * @param content       模板内容
     * @param data          数据
     * @return              渲染后的内容
     */
    public static String process(String content, Object data) {
        StringBuilder sb = new StringBuilder();
        try {
            Template template = new Template(null, new StringReader(content), null);
            StringWriter writer = new StringWriter();
            template.process(data, writer);
            sb.append(writer.toString());
        } catch (IOException e) {
            LoggerUtil.caughtException(logger, e);
        } catch (TemplateException te) {
            LoggerUtil.caughtException(logger, te);
        }
        return sb.toString();
    }
}
