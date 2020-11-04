package com.mislab.train.teacher.service;

import com.mislab.train.teacher.entity.Aspiration;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.List;

public interface AspirService {


    /**
     * 根据teaId获取老师名下所有课程
     * @param teaId
     * @return
     */
    List<Aspiration> queryByTeaId(Integer teaId);

    /**
     * 添加课程
     * @param aspiration
     * @return
     */
    int addAspiration(Aspiration aspiration);


    /**
     * 删除课程
     * @param aspirId
     * @return
     */
    int removeAspiration(Integer aspirId);

    /**
     * 通过Id获取方向信息
     * @param aspirId
     * @return
     */
    Aspiration queryByAspirId(Integer aspirId);
}

