package com.wantai.oa.test.utils;

import com.wantai.oa.common.util.TemplateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mapingmp on 16/1/10.
 */
public class TemplateUtilsTest extends Assert {

    @Test
    public void testRender() {
        String template = "hello ${name}!";
        Map<String, Object> data = new HashMap<>();
        data.put("name", "jack");
        assertEquals(TemplateUtils.process(template, data), "hello jack!");
    }
}
