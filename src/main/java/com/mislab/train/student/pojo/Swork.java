package com.mislab.train.student.pojo;

import java.util.Date;

public class Swork {
    private Integer sworkId;

    private Integer stuId;

    private Integer workId;

    private String src;

    private Date subday;

    private Integer score;

    private Integer status;

    public Integer getSworkId() {
        return sworkId;
    }

    public void setSworkId(Integer sworkId) {
        this.sworkId = sworkId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public Date getSubday() {
        return subday;
    }

    public void setSubday(Date subday) {
        this.subday = subday;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}