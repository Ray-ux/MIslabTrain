package com.mislab.train.teacher.service;

import com.mislab.train.teacher.entity.Work;

import java.util.List;

/**
 * @author 张烈文
 */
public interface WorkService {

    /**
     * 发布作业
     * @param work
     * @return
     */
    int addWork(Work work);


    /**
     * 修改作业
     * @param work
     * @return
     */
    int update(Work work);

    /**
     * 获取某个课程下的所有作业
     *
     * @param aspirId
     * @return
     */
    List<Work> getWorksByAspirId(Integer aspirId);

    /**
     * 查看某个作业的详情
     * @param workId
     * @return
     */
    Work getWorkByWorkId(Integer workId);

    /**
     * 删除一个作业
     * @param workId
     * @return
     */
    int removeWork(Integer workId);
}
