package com.mislab.train.student.service.iml;

import com.mislab.train.mapper.StudentMapper;
import com.mislab.train.student.pojo.StuInfo;
import com.mislab.train.student.pojo.Student;
import com.mislab.train.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xhx
 * @Date 2020/11/3 17:13
 */
@Service
public class StudentServiceIml implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Override
    public int addStudent(Student student) {
          return studentMapper.insert(student);
    }

    @Override
    public StuInfo queryById(String id) {
        StuInfo student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public StuInfo loginCheck(String stuId, String pwd) {
        StuInfo stuInfo = studentMapper.loginCheck(stuId,pwd);
        return stuInfo;
    }

}
