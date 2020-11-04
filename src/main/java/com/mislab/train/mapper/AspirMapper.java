package com.mislab.train.mapper;

import com.mislab.train.teacher.entity.Aspiration;

import java.util.List;

/**
 * @author 张烈文
 */
public interface AspirMapper {


    /**
     * 根据teaId获取老师名下所有课程
     * @param teaId
     * @return
     */
    List<Aspiration> selectByTeaId(Integer teaId);


    /**
     * 添加课程
     * @param aspiration
     * @return
     */
    int insertAspir(Aspiration aspiration);

    /**
     * 删除课程
     * @param aspirId
     * @return
     */
    int deleteByAspirId(Integer aspirId);

    /**
     * 通过方向Id获取
     * @param aspirId
     * @return
     */
    Aspiration selectByAspirId(Integer aspirId);

}
