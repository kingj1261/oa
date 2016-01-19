package com.wantai.oa.test.rule;

import com.wantai.oa.rules.core.service.RuleService;
import com.wantai.oa.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mapingmp on 16/1/10.
 */
public class FactTest extends BaseTest {

    @Autowired
    private RuleService ruleService;

    @Test
    public void testFireRules() {

    }
}
