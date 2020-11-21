package com.mislab.train.student.controller;

/**
 * @Author xhx
 * @Date 2020/11/14 12:54
 */
public class ErrorPremetersException extends Throwable {
    String s;
    public ErrorPremetersException(String s) {
        this.s = s;
    }
    public void print(){
        System.out.println(s);
    }
}
