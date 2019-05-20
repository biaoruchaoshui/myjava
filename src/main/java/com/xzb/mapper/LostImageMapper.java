package com.xzb.mapper;

import com.xzb.pojo.LostImage;
import com.xzb.pojo.LostImageExample;
import java.util.List;

public interface LostImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LostImage record);

    int insertSelective(LostImage record);

    List<LostImage> selectByExample(LostImageExample example);

    LostImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LostImage record);

    int updateByPrimaryKey(LostImage record);
}