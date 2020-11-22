package com.mislab.train.student.service.iml;

import com.mislab.train.mapper.SworkMapper;
import com.mislab.train.student.service.FileManagerService;
import com.mislab.train.student.utils.MultiFileInfo;
import com.mislab.train.student.utils.MultiFileUploadUtils;
import com.mislab.train.student.utils.SHA256Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xhx
 * @Date 2020/11/14 12:18
 */
@Service
@Slf4j
public class FileManagerServiceIml implements FileManagerService {

    @Value("${filePath.tempWorkBasePath}")
    private String tempWorkPath;
    @Value("${filePath.saveFileBasePath}")
    private String saveFilePath;
    private ReentrantLock filetempLock = new ReentrantLock();
    @Autowired
    SworkMapper sworkMapper;

    /**
     * 分片上传
     * @param fileinfo 分片的具体信息
     * @param file 多媒体文件
     * @throws Exception
     */
    @Override
    public void saveMultiBurstFiletoDir(MultiFileInfo fileinfo, MultipartFile file) throws Exception {
        this.checkBaseDir(tempWorkPath);
        File tempFile = this.generateDirPathForcurrFile(fileinfo, "chunks");
        MultiFileUploadUtils.spaceFileWriter(file, tempFile, fileinfo);
    }

    @Override
    public void saveSingleFiletoDir(MultiFileInfo fileInfo, MultipartFile file) throws Exception {
        this.checkBaseDir(saveFilePath);
        File targetFile = this.generateDirPathForcurrFile(fileInfo, "single");
        MultiFileUploadUtils.saveFile2DirPath(file, targetFile);
    }

    @Override
    synchronized public File generateDirPathForcurrFile(MultiFileInfo fileinfo, String flag) throws Exception {
//        String fileName = fileinfo.getName();
//        String lastModifiedDate = fileinfo.getLastModifiedDate();
//        long fileSize = fileinfo.getSize();
//        String type = fileinfo.getType();
//        String id = fileinfo.getSworkId();
//        String extName = fileName.substring(fileName.lastIndexOf("."));
//        long timeStemp = System.currentTimeMillis();
        if ("single".equals(flag)) {
//            String fileNameSource = fileName + lastModifiedDate + fileSize + type + id + timeStemp;
//            String fileDirName = SHA256Util.getSHA256String(fileNameSource) + extName;
            String fileDirName = fileinfo.getName();
            File targetFile = new File(saveFilePath, fileDirName);
            while (targetFile.exists()) {
//                fileNameSource = fileNameSource + "1";
//                fileDirName = SHA256Util.getSHA256String(fileNameSource) + extName;
                targetFile = new File(fileDirName+"1");

            }
            return targetFile;

        } else if ("chunks".equals(flag)) {
//            String fileNameSource = fileSize + "_" + fileName + id + lastModifiedDate;

//            String fileDirName = tempWorkPath + "/" + SHA256Util.getSHA256String(fileNameSource) + extName + ".temp";
            String fileDirName = tempWorkPath+fileinfo.getName();
            File tempFile = new File(fileDirName);//禁用FileInfo.exists()类, 防止缓存导致并发问题
            if (!(tempFile.exists() && tempFile.isFile())) {
                filetempLock.lock();//上锁
                if (!(tempFile.exists() && tempFile.isFile())) {
                    MultiFileUploadUtils.readySpaceFile(fileinfo, tempFile);
                }
                filetempLock.unlock();//释放锁

            }
//            tempFile = new File(fileDirName);
            return tempFile;

        } else {
            throw new Exception("目标文件生成失败");
        }
    }

    @Override
    public void checkBaseDir(String baseDir) {
        File file = new File(baseDir);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    @Override
    public void MultiMergingChunks(String fileDirName) throws Exception {
//        String fileName = fileinfo.getName();
//        String lastModifiedDate = fileinfo.getLastModifiedDate();
//        long fileSize = fileinfo.getSize();
//        String id = fileinfo.getSworkId();
//        String extName = fileName.substring(fileName.lastIndexOf("."));
//        String fileNameSource = fileSize + "_" + fileName + id + lastModifiedDate;
//        String fileDirName = tempWorkPath + "/" + SHA256Util.getSHA256String(fileNameSource) + extName + ".temp";
//        String fileDirName= fileinfo.getName();
        File tempFile = new File(tempWorkPath+fileDirName);
        if (tempFile.exists() && tempFile.isFile()) {
            checkBaseDir(saveFilePath);
//            String targetDirName = saveFilePath + "/" + SHA256Util.getSHA256String(fileNameSource);
            String targetDirName = saveFilePath + fileDirName;
//            File targetFile = new File(targetDirName + extName);
            File targetFile = new File(targetDirName);
            //如果存在重名文件，则在后缀中加1
            while (targetFile.exists() && targetFile.isFile()) {
                targetDirName = targetDirName + "1";
                targetFile = new File(targetDirName );
//                targetFile = new File(targetDirName + extName);
            }
            System.out.println(targetFile.getAbsolutePath());
            if (tempFile.renameTo(targetFile)) {
                System.out.println("文件重命名成功!");
                //数据库操作
                //数据库操作
            } else {
                System.out.println("文件重命名失败!");
                throw new Exception("临时文件重命名失败");
            }
        }
    }
}
