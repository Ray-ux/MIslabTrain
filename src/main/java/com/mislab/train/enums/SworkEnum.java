package com.mislab.train.enums;

/**
 * @author 张烈文
 */

public enum SworkEnum {
    check_success(1, "作业已批改"),
    check_fail(0, "作业为批改"),
    ;
    private Integer code;
    private String message;

    SworkEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
