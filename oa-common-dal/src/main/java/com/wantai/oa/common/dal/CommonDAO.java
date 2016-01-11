/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 通用DAO
 * @author maping.mp
 * @version $Id: CommonDAO.java, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public interface CommonDAO {

    /**
     * 获得sqlSession对象
     * @return                      当前sql数据库连接对象
     * @throws      DataAccessException
     */
    SqlSession getCurrentSqlSession() throws DataAccessException;

    /**
     *
     * 插入数据
     * @param       statement       sql脚本
     * @param       parameter       sql参数
     * @return                      受影响行数
     * @throws      DataAccessException
     */
    int insert(String statement, Object parameter) throws DataAccessException;

    /**
     * 查询所有数据
     * @param       statement       sql脚本
     * @param       parameter       sql参数
     * @return                      受影响行数
     * @throws      DataAccessException
     */
    List<?> findAll(String statement, Object parameter) throws DataAccessException;

    /**
     * 分页查询
     * @param       statement       sql脚本
     * @param       parameter       sql参数
     * @param       pageNo          页码
     * @param       pageSize        每页记录条数
     * @return                      分页查询结果list
     * @throws      DataAccessException
     */
    List<?> findByPagination(String statement, Object parameter, int pageNo, int pageSize)
                                                                                          throws DataAccessException;

    /**
     *
     * @param       statement       sql脚本
     * @param       parameter       sql参数
     * @return                      单条数据查询结果
     * @throws      DataAccessException
     */
    Object selectOne(String statement, Object parameter) throws DataAccessException;

    /**
     *
     * @param       statement       sql脚本
     * @param       parameter       sql参数
     * @return                      受影响行数
     * @throws      DataAccessException
     */
    int update(String statement, Object parameter) throws DataAccessException;

    /**
     *
     * @param       statement       sql脚本
     * @param       parameter       sql参数
     * @return                      受影响行数
     * @throws      DataAccessException
     */
    int delete(String statement, Object parameter) throws DataAccessException;
}
