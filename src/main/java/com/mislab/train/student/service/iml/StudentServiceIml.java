package com.mislab.train.student.service.iml;

import com.mislab.train.mapper.StudentMapper;
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
    public void addStudent(Student student) {
          studentMapper.insert(student);
    }
}
