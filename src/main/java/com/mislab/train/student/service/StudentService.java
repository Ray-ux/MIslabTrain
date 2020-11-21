package com.mislab.train.student.service;

import com.mislab.train.student.pojo.StuInfo;
import com.mislab.train.student.pojo.Student;

/**
 * @Author xhx
 * @Date 2020/11/3 17:13
 */
public interface StudentService {
    int addStudent(Student student);
    StuInfo queryById(String id);
    StuInfo loginCheck(String stuId,String pwd);
}
