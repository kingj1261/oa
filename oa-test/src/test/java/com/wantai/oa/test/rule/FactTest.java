package com.wantai.oa.test.rule;

import com.wantai.oa.rules.core.service.RuleService;
import com.wantai.oa.rules.core.service.fact.FactService;
import com.wantai.oa.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mapingmp on 16/1/10.
 */
public class FactTest extends BaseTest {
    @Autowired
    private FactService factService;

    @Autowired
    private RuleService ruleService;

    @Test
    public void testFireRules() {
        List datas = factService.loadFactDatas(ruleService.findAllRules().iterator().next());
        assertNotNull(datas);
        assertTrue(datas.size() == 1);
    }
}
