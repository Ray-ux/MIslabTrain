package com.mislab.train.student.pojo;

import java.util.Date;

public class Swork {
    private Integer sworkId;

    private String stuId;

    private Integer workId;

    private Integer aspirId;

    private String src;

    private Date subday;

    private Integer score;

    private Integer status;

    public Swork(Integer sworkId, String stuId, Integer workId, Integer aspirId, String src, Date subday) {
        this.sworkId = sworkId;
        this.stuId = stuId;
        this.workId = workId;
        this.aspirId = aspirId;
        this.src = src;
        this.subday = subday;
    }

    public Swork() {
    }

    public Integer getSworkId() {
        return sworkId;
    }

    public void setSworkId(Integer sworkId) {
        this.sworkId = sworkId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getAspirId() {
        return aspirId;
    }

    public void setAspirId(Integer aspirId) {
        this.aspirId = aspirId;
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