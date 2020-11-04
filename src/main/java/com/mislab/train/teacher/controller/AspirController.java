package com.mislab.train.teacher.controller;

import com.mislab.train.teacher.common.Result;
import com.mislab.train.teacher.entity.Aspiration;
import com.mislab.train.teacher.entity.Teacher;
import com.mislab.train.teacher.service.AspirService;
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
@RequestMapping("/aspir")
public class AspirController {

    @Resource
    private AspirService aspirService;

    @PostMapping("/add")
    public Map<String, Object> addAspiration(@RequestBody Aspiration aspiration, HttpSession session) {
        Map<String, Object> modelMap = new HashMap<>();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        aspiration.setTeaId(teacher.getTeaId());
        List<Aspiration> aspirations = null;
        if (aspirService.addAspiration(aspiration) == 1) {
            aspirations = aspirService.queryByTeaId(teacher.getTeaId());
        }
        modelMap.put("aspir", aspirations);
        return Result.success(modelMap, "创建成功");
    }


    @GetMapping("/getAll")
    public Map<String, Object> getAll(HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        Map<String, Object> modelMap = new HashMap<>();
        List<Aspiration> aspirations = aspirService.queryByTeaId(teacher.getTeaId());
        modelMap.put("aspir", aspirations);
        return Result.success(modelMap);
    }


    @GetMapping("/aspirId")
    public Map<String, Object> deleteByAspirId(@RequestParam("aspirId") Integer aspirId) {
        if (aspirService.removeAspiration(aspirId) == 1) {
            return Result.success();
        }
        return Result.fail("删除失败");
    }

}
