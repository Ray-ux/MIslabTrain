package com.mislab.train.teacher;

import com.mislab.train.mapper.TeaMapper;
import com.mislab.train.mapper.WorkMapper;
import com.mislab.train.teacher.entity.Aspiration;
import com.mislab.train.teacher.entity.Teacher;
import com.mislab.train.teacher.entity.Work;
import com.mislab.train.teacher.service.AspirService;
import com.mislab.train.teacher.service.TeaService;
import com.mislab.train.teacher.service.WorkService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@MapperScan("com.mislab.train.mapper")
@SpringBootTest
public class TeaMapperTest {

    @Resource
    private TeaMapper teaMapper;

    @Resource
    private AspirService aspirService;

    @Autowired
    private WorkService workService;

    @Resource
    private WorkMapper workMapper;
    @Test
    public void test() {

        int i = teaMapper.insertOneTea(new Teacher("zlw", "123"));
        if (i == 1) {
            System.out.println("添加成功");
        }
    }

    @Test
    public void test1() {
        Teacher teacher = teaMapper.login("zlw", "123");
        System.out.println(teacher);

    }

    @Test
    public void test2() {

        aspirService.addAspiration(new Aspiration("安卓", 1, new Date()));
    }

    @Test
    public void test3() {
        Work work = new Work();
        work.setWorkContent("hello");
        work.setAspirId(1);
        work.setWorkName("数组");
        int i = workService.addWork(work);
        System.out.println(i);
        work.setWorkName("类");
        int k = workService.update(work);
        System.out.println(k);
        List<Work> works = workService.getWorksByAspirId(1);
        System.out.println(works.size());

    }
}
