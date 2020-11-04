package com.mislab.train.teacher.service.Impl;

import com.mislab.train.mapper.WorkMapper;
import com.mislab.train.teacher.entity.Work;
import com.mislab.train.teacher.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 张烈文
 */
@Service
public class WorkServiceImpl implements WorkService {


    @Autowired
    private WorkMapper workMapper;
    @Override
    public int addWork(Work work) {
        if (work != null) {
            work.setCreateTime(new Date());
        }
        return workMapper.insertWork(work);
    }

    @Override
    public int update(Work work) {
        work.setUpdateTime(new Date());
        return workMapper.updateWork(work);
    }

    @Override
    public List<Work> getWorksByAspirId(Integer aspirId) {
        return workMapper.selectWorks(aspirId);
    }

    @Override
    public Work getWorkByWorkId(Integer workId) {
        return workMapper.selectWork(workId);
    }

    @Override
    public int removeWork(Integer workId) {
        return workMapper.deleteWork(workId);
    }

}
