package com.mislab.train.teacher.controller;

import com.mislab.train.mapper.AspirMapper;
import com.mislab.train.teacher.common.Result;
import com.mislab.train.teacher.entity.Aspiration;
import com.mislab.train.teacher.entity.Teacher;
import com.mislab.train.teacher.service.AspirService;
import com.mislab.train.teacher.service.TeaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张烈文
 */
@RestController
@RequestMapping("/teacher")
public class TeaController {
    @Resource
    private TeaService teaService;

    @Resource
    private AspirService aspirService;

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam("teaAcount") String teaA, @RequestParam("password") String pwd, HttpSession session) {
        Map<String, Object> modelMap = new HashMap<>();
        if (teaA.length() == 0 || pwd.length() == 0) {
            return Result.fail("用户名或密码不能为空");
        }
        Teacher teacher = teaService.login(teaA, pwd);
        List<Aspiration> aspirs = null;
        if (teacher!= null) {
            session.setAttribute("teacher", teacher);
            aspirs = aspirService.queryByTeaId(teacher.getTeaId());
            modelMap.put("aspir", aspirs);
        }else {
            return Result.fail("该用户名不存在");
        }
        return Result.success(modelMap, "登陆成功");
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Teacher teacher) {

        if (teacher.getTeaAcount().length()==0 || teacher.getTeaAcount().length()==0) {
            return Result.fail("输入的信息不能为空!!");
        }
        teaService.addTeacher(teacher);
        return Result.success();
    }

}
