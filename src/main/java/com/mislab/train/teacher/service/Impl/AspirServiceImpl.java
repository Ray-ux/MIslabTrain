package com.mislab.train.teacher.service.Impl;

import com.mislab.train.mapper.AspirMapper;
import com.mislab.train.teacher.entity.Aspiration;
import com.mislab.train.teacher.service.AspirService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 张烈文
 */
@Service
public class AspirServiceImpl implements AspirService {

    @Resource
    private AspirMapper aspirMapper;

    @Override
    public List<Aspiration> queryByTeaId(Integer teaId) {

        return aspirMapper.selectByTeaId(teaId);
    }

    @Override
    public int addAspiration(Aspiration aspiration) {
        aspiration.setCreateTime(new Date());
        return aspirMapper.insertAspir(aspiration);
    }

    @Override
    public int removeAspiration(Integer aspirId) {
        return aspirMapper.deleteByAspirId(aspirId);
    }

    @Override
    public Aspiration queryByAspirId(Integer aspirId) {
        return aspirMapper.selectByAspirId(aspirId);
    }

}
