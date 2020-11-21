package com.mislab.train.student.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Author xhx
 * @Date 2020/11/13 20:36
 * @Return 文件上传工具类
 */
public class MultiFileUploadUtils {
    /**
     *  校验文件切片上传参数（字节流不能为空）
     * @param multiFileInfo：上传参数实体类
     * @return 判断是否文件切片上传，true；false：文件单体上传
     */
    public static Boolean checkMultiFilePremeter(MultiFileInfo multiFileInfo){
        if(multiFileInfo != null){
            if(multiFileInfo.getChunks() != null&&multiFileInfo.getChunk() != null&&multiFileInfo.getChunks()>1&&multiFileInfo.getChunk()>=0&&multiFileInfo.getChunks()>multiFileInfo.getChunk()){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     *
     * @param multiFileInfo
     * @return true:符合单文件上传参数格式；false，不符合单文件上传
     */
    public static Boolean checkSingFilePremeter(MultiFileInfo multiFileInfo){
        if(multiFileInfo!=null){
            if(multiFileInfo.getChunks()==null&&multiFileInfo.getChunk()==null){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * 保存文件到指定目录
     * @param file
     * @param targetFile
     * @throws Exception
     */
    public static void saveFile2DirPath(MultipartFile file, File targetFile)throws Exception{
        if(targetFile.createNewFile()){//creatNewFile方法语义？
            file.transferTo(targetFile);
        }
    }

    /**
     * 创建空目标文件
     * @param fileInfo
     * @param tempFile
     * @throws IOException
     */
    public static void readySpaceFile(MultiFileInfo fileInfo,File tempFile) throws IOException {
        RandomAccessFile targetSpaceFile = new RandomAccessFile(tempFile,"rws");//语义
        targetSpaceFile.setLength(fileInfo.getSize());
        System.out.println("创建文件:"+fileInfo.getSize());
        targetSpaceFile.close();
    }

    /**
     *  向空文件写入二进制数据
     * @param file
     * @param tempFile
     * @param fileInfo
     * @throws IOException
     */
    public static void spaceFileWriter(MultipartFile file,File tempFile,MultiFileInfo fileInfo) throws Exception {
        long totalSpace = tempFile.getTotalSpace();//获取该路径下分区大小
        RandomAccessFile raf = new RandomAccessFile(tempFile,"rw");//可以使用nio先把文件映射到内存
        BufferedInputStream sourceBuffer = new BufferedInputStream(file.getInputStream());
        Long startPointer = getFileWriterStartPointer(file,fileInfo);
        raf.seek(startPointer);
        byte[] bt = new byte[1024];
        int n = 0;
        try{
            while ((n=sourceBuffer.read()) != -1){
                raf.write(bt);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sourceBuffer != null){
                sourceBuffer.close();
            }
            if(raf != null){
                raf.close();
            }
        }
    }

    /**
     *  计算指针开始位置
     * @param file
     * @param fileInfo
     * @return
     * @throws Exception
     */
    synchronized public static Long getFileWriterStartPointer(MultipartFile file,MultiFileInfo fileInfo) throws Exception {
        //获取当前分片大小
        long chunkSize = file.getSize();
        //获取当前分片序列号
        Integer currentChunk = fileInfo.getChunk();
        //获取分片总数
        Integer allChunk = fileInfo.getChunks();
        //获取文件总大小
        Long allSize = fileInfo.getSize();
        if(currentChunk<(allChunk-1)){
            long stater = chunkSize*currentChunk;
            return stater;
        }else if(currentChunk == (allChunk-1)){
            long stater = allSize - chunkSize;
            return stater;
        }else {
            throw new Exception("分片参数异常");
        }
    }
}
