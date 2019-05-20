package com.xzb.mapper;

import com.xzb.pojo.Lost;
import com.xzb.pojo.LostExample;
import java.util.List;

public interface LostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lost record);

    int insertSelective(Lost record);

    List<Lost> selectByExample(LostExample example);

    Lost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);
}