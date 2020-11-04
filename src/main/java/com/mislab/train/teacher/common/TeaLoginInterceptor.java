package com.mislab.train.teacher.common;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.mislab.train.teacher.entity.Teacher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author 张烈文
 */
public class TeaLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        response.setContentType("application/json; charset=utf-8");
            if (teacher == null) {
                Map<String, Object> modelMap = Result.fail("用户未登录!!");
                return false;
            }
        return true;
    }
}
