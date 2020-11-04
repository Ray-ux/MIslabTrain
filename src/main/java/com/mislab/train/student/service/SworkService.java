package com.mislab.train.student.service;

import com.mislab.train.student.pojo.Swork;

import java.util.List;

/**
 * @Author xhx
 * @Date 2020/11/3 22:02
 */
public interface SworkService {
    List<Swork> querySworkByStuId(int stuId);

    Swork  querySworkByWorkId(int workId);
    int addSwork(Swork swork);
    int correctSwork(int workId,int score);
}
