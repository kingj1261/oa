package com.wantai.oa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by mapingmp on 16/1/10.
 */
public class PrepareDataUtils extends BaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /** 测试数据准备*/
    private String       datas[] = new String[] {
            "insert into OA_BUSINESS_CONFIG values(1,'ABC',1,'GWJX','100000000000','00000001','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',1,1)",
            "insert into OA_BUSINESS_CONFIG values(2,'ABC',1,'GWJX','100000000000','00000002','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',1,2)",
            "insert into OA_BUSINESS_CONFIG values(3,'ABC',1,'GWJX','100000000000','00000003','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',1,3)",
            "insert into OA_BUSINESS_CONFIG values(4,'ABC',1,'GWJX','200000000000','00000004','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',2,1)",
            "insert into OA_BUSINESS_CONFIG values(5,'ABC',1,'GWJX','200000000000','00000005','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',2,2)",
            "insert into OA_BUSINESS_CONFIG values(6,'ABC',1,'GWJX','200000000000','00000006','100','156','true','CUSTOMER',now(),now(),'test',now(),now(),'system','system',2,3)" };

    @Test
    public void initData() throws Exception {
        Resource resource = new ClassPathResource("initdata.sql");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(),
            "utf-8"));

        String sql;
        while ((sql = reader.readLine()) != null) {
            if (sql.startsWith("--") || sql.startsWith("/*")) {
                continue;
            }
            jdbcTemplate.execute(sql.replace(";", ""));
        }

        reader.close();
    }
}
