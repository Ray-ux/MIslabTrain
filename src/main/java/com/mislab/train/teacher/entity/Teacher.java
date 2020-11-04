package com.mislab.train.teacher.entity;

/**
 * @author 张烈文
 */
public class Teacher {

    private Integer teaId;
    private String teaAcount;
    private String password;

    public Teacher() {

    }

    public Teacher(String teaAcount, String password) {
        this.teaAcount = teaAcount;
        this.password = password;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaAcount() {
        return teaAcount;
    }

    public void setTeaAcount(String teaAcount) {
        this.teaAcount = teaAcount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "teaId=" + teaId +
                ", teaAcount='" + teaAcount + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
