package com.wantai.oa.test.rule;

import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.rules.core.service.RuleService;
import com.wantai.oa.rules.core.service.fact.loader.FactLoader;
import com.wantai.oa.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by mapingmp on 16/1/10.
 */
public class RuleTest extends BaseTest {
    @Autowired
    private RuleService ruleService;

    @Autowired
    @Qualifier("roleBasedFactLoader")
    private FactLoader  ppjlFactLoader;

    @Test
    public void testFireRules() {
        String companyCode = "99999999999";
        String companyId = "1";
        ruleService.fireAllRules(companyCode, companyId);
    }

    @Test
    public void caculate() {
        RuleDo ruleDo = new RuleDo();
        ruleDo.addAttribute("role", "ppjl");
        ruleDo.setCompanyCode("99999999999");
        ruleDo.setCompanyId("1");
        List<SaleOrderDo> orders = ppjlFactLoader.load(ruleDo);

        System.out.println(orders);
    }
}
