package com.mislab.train.teacher.service.Impl;

import com.mislab.train.mapper.TeaMapper;
import com.mislab.train.teacher.entity.Teacher;
import com.mislab.train.teacher.service.TeaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 张烈文
 */
@Service
public class TeaServiceImpl implements TeaService {

    @Resource
    private TeaMapper teaMapper;

    @Override
    public int addTeacher(Teacher teacher) {
        if (teacher == null) {
            return 0;
        }
        return teaMapper.insertOneTea(teacher);
    }

    @Override
    public Teacher login(String teaAcount, String password) {

        return teaMapper.login(teaAcount, password);
    }

    @Override
    public Teacher queryByAcount(String teaAcount) {
        return teaMapper.selectByAcount(teaAcount);
    }

}
