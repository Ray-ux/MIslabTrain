package com.mislab.train.student.service;

import com.mislab.train.student.utils.MultiFileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Author xhx
 * @Date 2020/11/13 21:37
 */
public interface FileManagerService {
    void saveMultiBurstFiletoDir(MultiFileInfo fileinfo, MultipartFile file) throws Exception;

    void saveSingleFiletoDir(MultiFileInfo fileInfo, MultipartFile file) throws Exception;

    File generateDirPathForcurrFile(MultiFileInfo file, String flag) throws Exception;

    void checkBaseDir(String baseDir);

    void MultiMergingChunks(MultiFileInfo fileInfo) throws Exception;


}
