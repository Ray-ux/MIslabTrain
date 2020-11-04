package com.mislab.train.mapper;

import com.mislab.train.teacher.entity.Work;

import java.util.List;

/**
 * @author 张烈文
 */
public interface WorkMapper {


    /**
     * 添加一个作业
     * @param work
     * @return
     */
    int insertWork(Work work);

    /**
     * 查询某个课程下的所有作业
     * @param aspirId
     * @return
     */
    List<Work> selectWorks(Integer aspirId);

    /**
     * 修改某个作业
     *
     * @param work
     * @return
     */
    int updateWork(Work work);


    /**
     * 查询workId对应的作业情况
     * @param workId
     * @return
     */
    Work selectWork(Integer workId);

    /**
     * 删除一个作业
     * @param workId
     * @return
     */
    int deleteWork(Integer workId);
}
