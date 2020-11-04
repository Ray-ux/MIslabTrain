package com.mislab.train.mapper;

import com.mislab.train.student.pojo.Swork;
import com.mislab.train.student.pojo.SworkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SworkMapper {
    long countByExample(SworkExample example);

    int deleteByExample(SworkExample example);

    int deleteByPrimaryKey(Integer sworkId);

    int insert(Swork record);

    int insertSelective(Swork record);

    List<Swork> selectByExample(SworkExample example);

    Swork selectByPrimaryKey(Integer sworkId);

    int updateByExampleSelective(@Param("record") Swork record, @Param("example") SworkExample example);

    int updateByExample(@Param("record") Swork record, @Param("example") SworkExample example);

    int updateByPrimaryKeySelective(Swork record);

    int updateByPrimaryKey(Swork record);
}