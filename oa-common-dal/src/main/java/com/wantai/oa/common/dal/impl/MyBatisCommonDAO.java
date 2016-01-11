/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.impl;

import com.wantai.oa.common.dal.CommonDAO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 通用DAO对象
 *
 * @author maping.mp
 * @version $Id: MyBatisCommonDAO.java, v 0.1 2015-1-04 下午10:34:12 maping.mp Exp $
 */
public class MyBatisCommonDAO extends SqlSessionDaoSupport implements CommonDAO {

    @Override
    public SqlSession getCurrentSqlSession() throws DataAccessException {
        return getSqlSession();
    }

    @Override
    public int insert(String statement, Object parameter) throws DataAccessException {
        return getCurrentSqlSession().insert(statement, parameter);
    }

    @Override
    public List<?> findAll(String statement, Object parameter) throws DataAccessException {
        return getCurrentSqlSession().selectList(statement, parameter);
    }

    @Override
    public List<?> findByPagination(String statement, Object parameter, int pageNo, int pageSize)
                                                                                                 throws DataAccessException {
        int start = (pageNo - 1) * pageSize;
        int offset = pageNo * pageSize;
        return getCurrentSqlSession()
            .selectList(statement, parameter, new RowBounds(start, offset));
    }

    @Override
    public Object selectOne(String statement, Object parameter) throws DataAccessException {
        return getCurrentSqlSession().selectOne(statement, parameter);
    }

    @Override
    public int update(String statement, Object parameter) throws DataAccessException {
        return getCurrentSqlSession().update(statement, parameter);
    }

    @Override
    public int delete(String statement, Object parameter) throws DataAccessException {
        return getCurrentSqlSession().delete(statement, parameter);
    }
}
