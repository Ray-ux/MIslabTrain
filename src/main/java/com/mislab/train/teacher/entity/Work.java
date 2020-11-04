package com.mislab.train.teacher.entity;

import java.util.Date;

/**
 * @author 张烈文
 */
public class Work {
    private Integer workId;
    private String workName;
    private String workContent;
    private Date deadline;
    private Date createTime;
    private Date updateTime;
    private Integer aspirId;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAspirId() {
        return aspirId;
    }

    public void setAspirId(Integer aspirId) {
        this.aspirId = aspirId;
    }
}
