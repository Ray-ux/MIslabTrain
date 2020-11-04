package com.mislab.train.teacher.entity;

import java.util.Date;

/**
 * @author 张烈文
 */
public class Aspiration {
    private Integer aspirId;
    private String aspirName;
    private Integer aspirCount;
    private Integer teaId;
    private Date createTime;


    public Aspiration() {

    }

    public Aspiration(String aspirName, Integer teaId, Date createTime) {
        this.aspirName = aspirName;
        this.teaId = teaId;
        this.createTime = createTime;
    }

    public Integer getAspirId() {
        return aspirId;
    }

    public void setAspirId(Integer aspirId) {
        this.aspirId = aspirId;
    }

    public String getAspirName() {
        return aspirName;
    }

    public void setAspirName(String aspirName) {
        this.aspirName = aspirName;
    }

    public Integer getAspirCount() {
        return aspirCount;
    }

    public void setAspirCount(Integer aspirCount) {
        this.aspirCount = aspirCount;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
