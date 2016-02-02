package com.wantai.oa.test.salary;

import com.wantai.oa.performance.common.SalaryService;
import com.wantai.oa.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by mapingmp on 16/1/10.
 */
public class SalaryServiceTest extends BaseTest {

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private JdbcTemplate  jdbcTemplate;

    @Test
    public void testCaculateSalary() {
        jdbcTemplate.execute("delete from oa_salary_details");
        String companyCode = "99999999999";
        String companyId = "1";
        salaryService.caculateSalary(companyCode, companyId);
    }
}
