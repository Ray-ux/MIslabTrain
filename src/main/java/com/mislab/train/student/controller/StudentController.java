package com.mislab.train.student.controller;

import com.mislab.train.student.service.StudentService;
import com.mislab.train.student.service.SworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhx
 * @Date 2020/11/3 17:31
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    SworkService sworkService;

    @RequestMapping("/add")
    // id生成？
    public void addStudent(){
        System.out.println(sworkService.querySworkByWorkId(1));
        System.out.println(sworkService.querySworkByStuId(23));
    }
}
