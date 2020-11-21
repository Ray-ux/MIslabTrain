package com.mislab.train.student.service.iml;

import com.mislab.train.VO.StuWorkVO;
import com.mislab.train.mapper.SworkMapper;
import com.mislab.train.student.pojo.Swork;
import com.mislab.train.student.pojo.SworkExample;
import com.mislab.train.student.service.SworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<Swork> querySworkByStuId(String stuId) {
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
       return sworkMapper.insert(swork);
    }

    @Override
    public int correctSwork(int sworkId, int score) {
        return sworkMapper.updateSwork(score,sworkId);
    }

    @Override
    public List<Swork> findSwork(String stuId, int workId, int aspirId) {
        SworkExample sworkExample = new SworkExample();
        sworkExample.createCriteria().andStuIdEqualTo(stuId).andWorkIdEqualTo(workId).andAspirIdEqualTo(aspirId);
        List<Swork> sworks = sworkMapper.selectByExample(sworkExample);
        return sworks;
    }

    @Override
    public int deleteSwork(Integer sw) {
        int i = sworkMapper.deleteByPrimaryKey(sw);
        return i;
    }

    @Override
    public List<StuWorkVO> queryByWorkId(Integer workId) {
        return sworkMapper.selectByWorkId(workId);
    }


}
