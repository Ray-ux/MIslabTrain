package com.mislab.train.student.pojo;

public class StuaspirKey {
    private String stuId;

    private Integer aspirId;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getAspirId() {
        return aspirId;
    }

    public void setAspirId(Integer aspirId) {
        this.aspirId = aspirId;
    }
}