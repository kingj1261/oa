package com.wantai.oa.test.rule;

import com.wantai.oa.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by mapingmp on 16/1/18.
 */
public class DataGenerator extends BaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void insertData() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource sqls[] = resolver.getResources("classpath:sql/*.sql");
        for (Resource resource : sqls) {
            executeSQL(resource);
        }
    }

    private void executeSQL(Resource resource) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuilder sql = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {

            if (line.startsWith("--") || line.startsWith("/**")) {
                continue;
            }

            sql.append(line);

            if (sql.length() > 0 && sql.charAt(sql.length() - 1) == ';') {
                jdbcTemplate.execute(sql.deleteCharAt(sql.length() - 1).toString());
                sql.setLength(0);
            }
        }
    }
}
