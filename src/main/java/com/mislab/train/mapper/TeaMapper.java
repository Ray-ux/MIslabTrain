package com.mislab.train.mapper;

import com.mislab.train.teacher.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 张烈文
 */
@Mapper
public interface TeaMapper {
    /**
     * 教师登陆
     * @param teaAcount
     * @param password
     * @return
     */
    Teacher login(String teaAcount, String password);

    /**
     * 教师注册
     * @param teacher
     * @return
     */
    int insertOneTea(Teacher teacher);


    /**
     * 通过账户查找用户是否存在
     * @param name
     * @return
     */
    Teacher selectByAcount(String name);
}
