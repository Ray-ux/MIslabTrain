package com.mislab.train.student.service;

import com.mislab.train.VO.StuWorkVO;
import com.mislab.train.student.pojo.Swork;

import java.util.Date;
import java.util.List;

/**
 * @Author xhx
 * @Date 2020/11/3 22:02
 */
public interface SworkService {
    List<Swork> querySworkByStuId(String stuId);
    Swork  querySworkByWorkId(int workId);
    int addSwork(Swork swork);
    int correctSwork(int sworkId,int score);
    List<Swork> findSwork(String stuId,int workId,int aspirId);
    int deleteSwork(Integer sw);
    List<StuWorkVO> queryByWorkId(Integer workId);
}
