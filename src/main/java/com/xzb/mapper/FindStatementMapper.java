package com.xzb.mapper;

import com.xzb.pojo.FindStatement;
import com.xzb.pojo.FindStatementExample;
import java.util.List;

public interface FindStatementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FindStatement record);

    int insertSelective(FindStatement record);

    List<FindStatement> selectByExample(FindStatementExample example);

    FindStatement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FindStatement record);

    int updateByPrimaryKey(FindStatement record);
}