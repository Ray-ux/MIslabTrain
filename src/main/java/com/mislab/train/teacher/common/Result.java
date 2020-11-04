package com.mislab.train.teacher.common;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 对返回结果的封装
 * @author 张烈文
 */
public class Result {

    private static Map<String, Object> map = new HashMap<>();

    /**
     * 注册成功时返回的信息
     * @param data
     * @param Msg
     * @return
     */
    public static Map<String,Object> success(Object data, String Msg) {
        map.put("code", 200);
        map.put("Msg", Msg);
        map.put("data", data);
        return map;
    }


    /**
     * 注册成功时，有时不需要其它提示信息
     * @param data
     * @return
     */
    public static Map<String, Object> success(Object data) {
        return success(data, "操作成功");
    }


    /**
     * 有时只需要返回操作成功的信息
     * @return
     */
    public static Map<String, Object> success() {
        return Result.success(null);
    }


    /**
     * 注册失败时，返回的信息
     * @param Msg
     * @return
     */
    public static Map<String,Object> fail(String Msg) {
        map.put("code", 0);
        map.put("Msg", Msg);
        map.put("data", null);
        return map;
    }


}
