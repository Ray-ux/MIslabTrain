package com.mislab.train.student.controller;

import com.mislab.train.student.service.FileManagerService;
import com.mislab.train.student.utils.MultiFileInfo;
import com.mislab.train.student.utils.MultiFileUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author xhx
 * @Date 2020/11/13 20:35
 */
@Controller
@Slf4j
public class UploadController {


//    /**
//     *
//     *
//     * @return 返回处理结果，请求头200:成功,500:失败
//     * @throws Exception
//     */
//    @RequestMapping(value = "/")
//    public String uploaderView(HttpServletRequest request) throws Exception {
//        HttpSession session = request.getSession();
//        System.out.println(session);
//        return "redirect:/index.html";
//    }
}
