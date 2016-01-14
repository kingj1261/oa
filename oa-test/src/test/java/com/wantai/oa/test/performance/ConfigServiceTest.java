package com.wantai.oa.test.performance;

import com.wantai.oa.biz.shared.vo.BizEventVO;
import com.wantai.oa.biz.shared.vo.BizItemVO;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.common.lang.constants.Constants;
import com.wantai.oa.common.lang.enums.UnitEnum;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.RatioRequest;
import com.wantai.oa.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mapingmp on 16/1/10.
 */
public class ConfigServiceTest extends BaseTest {

    @Autowired
    private ConfigService configService;

    @Autowired
    private JdbcTemplate  jdbcTemplate;

    /** 测试数据准备*/
    private String        datas[] = new String[] {
            "insert into OA_BUSINESS_CONFIG values(1,'ABC',1,'GWJX','100000000000','00000001','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',1,1,'大类1','测试1')",
            "insert into OA_BUSINESS_CONFIG values(2,'ABC',1,'GWJX','100000000000','00000002','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',1,2,'大类1','测试2')",
            "insert into OA_BUSINESS_CONFIG values(3,'ABC',1,'GWJX','100000000000','00000003','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',1,3,'大类1','测试3')",
            "insert into OA_BUSINESS_CONFIG values(4,'ABC',1,'GWJX','200000000000','00000004','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',2,1,'大类2','测试1')",
            "insert into OA_BUSINESS_CONFIG values(5,'ABC',1,'GWJX','200000000000','00000005','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',2,2,'大类2','测试2')",
            "insert into OA_BUSINESS_CONFIG values(6,'ABC',1,'GWJX','200000000000','00000006','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',2,3,'大类2','测试3')" };

    @Test
    public void testAddSubConfig() {
        jdbcTemplate.execute("delete from oa_sub_business_config");
        RatioRequest request = new RatioRequest();
        request.setId(1L);
        request.setBusinessConfigId(1L);
        request.setSubEventCode("1000000");
        request.setValue("10");
        request.setFromValue("0");
        request.setToValue("100");
        request.setUnit(UnitEnum.CNY.getCode());
        request.setOperator(Constants.SYSTEM);
        request.setLastModifiedOperator(Constants.SYSTEM);

        RatioRequest request1 = new RatioRequest();
        request1.setId(2L);
        request1.setBusinessConfigId(1L);
        request1.setSubEventCode("1000000");
        request1.setValue("10");
        request1.setFromValue("0");
        request1.setToValue("100");
        request1.setUnit(UnitEnum.CNY.getCode());
        request1.setOperator(Constants.SYSTEM);
        request1.setLastModifiedOperator(Constants.SYSTEM);

        List<RatioRequest> requests = new ArrayList<>();
        requests.add(request);
        requests.add(request1);
        configService.addConfig(requests);
        assertTrue(jdbcTemplate.queryForInt("select count(*) from OA_SUB_BUSINESS_CONFIG") == 2);
    }

    @Test
    public void prepareData() {
        jdbcTemplate.execute("delete from oa_business_config");
        for (String data : datas) {
            jdbcTemplate.execute(data);
        }
    }

    @Test
    public void testQueryConfigs() {
        jdbcTemplate.execute("delete from oa_business_config");
        for (String data : datas) {
            jdbcTemplate.execute(data);
        }
        List<ConfigVO> configs = configService.queryConfigs("ABC", 1, "GWJX");
        assertNotNull(configs);
        assertTrue(configs.size() == 1);

        ConfigVO configVO = configs.get(0);
        assertNotNull(configVO);
        assertEquals(configVO.getConfigType(), "GWJX");

        Set<BizItemVO> items = configVO.getBizItems();
        assertTrue(items.size() == 2);

        items.forEach(item -> {
            List<BizEventVO> eventVOs = item.getBizEvents();
            assertTrue(eventVOs.size() == 3);
        });

        jdbcTemplate.execute("delete from oa_business_config");
    }
}
