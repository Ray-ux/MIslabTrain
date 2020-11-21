package com.mislab.train.mapper;

import com.mislab.train.VO.StuWorkVO;
import com.mislab.train.student.pojo.Swork;
import com.mislab.train.student.pojo.SworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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

    int updateSwork(int score, Integer sworkId);

    List<StuWorkVO> selectByWorkId(Integer workId);
}