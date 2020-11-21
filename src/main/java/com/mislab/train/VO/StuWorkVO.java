package com.mislab.train.VO;


import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.Date;

/**
 * @author 张烈文
 */
@Data
public class StuWorkVO {

    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学生年级
     */
    private String stuGrade;
    /**
     * 提交作业状态
     */
    private Integer status;
    /**
     * 提交作业的路径
     */
    private String src;

    /**
     * 提交作业的时间
     */
    private Date subday;
}

