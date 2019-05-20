package com.xzb.mapper;

import com.xzb.pojo.InnerLetter;
import com.xzb.pojo.InnerLetterExample;
import java.util.List;

public interface InnerLetterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InnerLetter record);

    int insertSelective(InnerLetter record);

    List<InnerLetter> selectByExample(InnerLetterExample example);

    InnerLetter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InnerLetter record);

    int updateByPrimaryKey(InnerLetter record);
}