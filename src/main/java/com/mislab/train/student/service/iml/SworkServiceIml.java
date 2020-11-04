package com.mislab.train.student.service.iml;

import com.mislab.train.mapper.SworkMapper;
import com.mislab.train.student.pojo.Swork;
import com.mislab.train.student.pojo.SworkExample;
import com.mislab.train.student.service.SworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xhx
 * @Date 2020/11/3 22:02
 */
@Service
public class SworkServiceIml implements SworkService {

    @Autowired
    SworkMapper sworkMapper;

    @Override
    public List<Swork> querySworkByStuId(int stuId) {
        SworkExample sworkExample = new SworkExample();
        sworkExample.createCriteria().andStuIdEqualTo(stuId);
        List<Swork> sworks = sworkMapper.selectByExample(sworkExample);
        return sworks;
    }

    @Override
    public Swork querySworkByWorkId(int workId) {
        return sworkMapper.selectByPrimaryKey(workId);
    }

    @Override
    public int addSwork(Swork swork) {
        return 0;
    }

    @Override
    public int correctSwork(int workId, int score) {
        return 0;
    }
}
