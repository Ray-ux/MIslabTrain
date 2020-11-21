package com.mislab.train.teacher.controller;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.mislab.train.VO.StuWorkVO;
import com.mislab.train.student.service.SworkService;
import com.mislab.train.teacher.common.Result;
import com.mislab.train.teacher.entity.Aspiration;
import com.mislab.train.teacher.entity.Work;
import com.mislab.train.teacher.service.AspirService;
import com.mislab.train.teacher.service.Impl.WebSocket;
import com.mislab.train.teacher.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张烈文
 */
@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;
    @Autowired
    private AspirService aspirService;

    @Autowired
    private SworkService sworkService;

    @Autowired
    private WebSocket webSocket;

    @GetMapping("/getAll")
    public Map<String, Object> addWork(Integer aspirId, HttpSession session) {
        Map<String, Object> modelMap = new HashMap<>();
        if (aspirId <= 0) {
            return Result.fail("传入的信息有误，请重传!!");
        }
        Aspiration aspiration = aspirService.queryByAspirId(aspirId);
        session.setAttribute("aspiration", aspiration);
        List<Work> works = workService.getWorksByAspirId(aspirId);
        modelMap.put("works", works);
        modelMap.put("aspiration", aspiration);
        return Result.success(modelMap);
    }

    @PostMapping("/add")
    public Map<String, Object> publishWork(@RequestBody Work work) {
        if (work == null) {
            return Result.fail("输入信息有误!!");
        }
        workService.addWork(work);
//        发送websocket消息
        JSON json = JSONUtil.parse(work);

        webSocket.sendMessage(json.toString());

        return Result.success();
    }

    @PostMapping("/update")
    public Map<String, Object> modifyWork(@RequestBody Work work) {
        workService.update(work);
        return Result.success();
    }

    @GetMapping("/get")
    public Map<String, Object> getByWorkId(@RequestParam("workId") Integer workId) {
        if (workId <= 0) {
            return Result.fail("传入的信息有误，请重传!!");
        }
        Map<String, Object> modelMap = new HashMap<>();
        Work work = workService.getWorkByWorkId(workId);
        modelMap.put("work", work);
        return Result.success(modelMap);
    }

    @GetMapping("/delete")
    public Map<String, Object> removeByWorkId(@RequestParam("workId") Integer workId) {
        if (workId <= 0) {
            return Result.fail("传入信息有误!!");
        }
        workService.removeWork(workId);
        return Result.success();
    }

    @GetMapping("check")
    public Map<String, Object> check(@RequestParam("workId")Integer workId) {
        Map<String, Object> modelMap = new HashMap<>();
        List<StuWorkVO> result = sworkService.queryByWorkId(workId);
        modelMap.put("subWork", result);
        return Result.success(modelMap);
    }

}
