package com.mislab.train.teacher.service;

import com.mislab.train.teacher.entity.Teacher;
import org.springframework.stereotype.Service;

/**
 * @author 张烈文
 */
public interface TeaService {


    /**
     * 添加一名老师
     * @param teacher
     * @return
     */
    int addTeacher(Teacher teacher);

    /**
     * 登陆
     * @param teaAcount
     * @param password
     * @return
     */
    Teacher login(String teaAcount, String password);


    /**
     * 通过账户名查找用户是否存在
     * @param teaAcount
     * @return
     */
    Teacher queryByAcount(String teaAcount);
}
