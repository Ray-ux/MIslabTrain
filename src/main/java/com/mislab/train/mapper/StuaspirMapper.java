package com.mislab.train.mapper;

import com.mislab.train.student.pojo.StuaspirExample;
import com.mislab.train.student.pojo.StuaspirKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuaspirMapper {
    long countByExample(StuaspirExample example);

    int deleteByExample(StuaspirExample example);

    int deleteByPrimaryKey(StuaspirKey key);

    int insert(StuaspirKey record);

    int insertSelective(StuaspirKey record);

    List<StuaspirKey> selectByExample(StuaspirExample example);

    int updateByExampleSelective(@Param("record") StuaspirKey record, @Param("example") StuaspirExample example);

    int updateByExample(@Param("record") StuaspirKey record, @Param("example") StuaspirExample example);
}