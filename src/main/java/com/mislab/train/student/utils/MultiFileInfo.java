package com.mislab.train.student.utils;

import lombok.Data;

import java.io.File;

/**
 * @Author xhx
 * @Date 2020/11/13 20:37
 * @return 大文件上传实体类
 */
@Data
public class MultiFileInfo {
//    private String sworkId;//文件ID
    private String name;//文件名称
//    private String type;//文件类型
//    private String lastModifiedDate;//文件最后一次修改时间
    private Long size;//文件总大小
    private Integer chunk;//当前分片序列号
    private Integer chunks;//分片总数
    private Long allSize;

    public MultiFileInfo(String name, Long size, Integer chunk, Integer chunks, Long allSize) {
        this.name = name;
        this.size = size;
        this.chunk = chunk;
        this.chunks = chunks;
        this.allSize = allSize;
    }

//    private File fileChunk;//文件临时分片
//    private Boolean saved = false;//分片是否保存成功

//    public MultiFileInfo(String sworkId, String name, String type, String lastModifiedDate, Long size) {
//        this.sworkId = sworkId;
//        this.name = name;
//        this.type = type;
//        this.lastModifiedDate = lastModifiedDate;
//        this.size = size;
//    }
//
//    public String getSworkId() {
//        return sworkId;
//    }
//
//    public void setSworkId(String sworkId) {
//        this.sworkId = sworkId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(String lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public Long getSize() {
//        return size;
//    }
//
//    public void setSize(Long size) {
//        this.size = size;
//    }
//
//    public Integer getChunk() {
//        return chunk;
//    }
//
//    public void setChunk(Integer chunk) {
//        this.chunk = chunk;
//    }
//
//    public Integer getChunks() {
//        return chunks;
//    }
//
//    public void setChunks(Integer chunks) {
//        this.chunks = chunks;
//    }
//
//    public File getFileChunk() {
//        return fileChunk;
//    }
//
//    public void setFileChunk(File fileChunk) {
//        this.fileChunk = fileChunk;
//    }
//
//    public Boolean getSaved() {
//        return saved;
//    }
//
//    public void setSaved(Boolean saved) {
//        this.saved = saved;
//    }
//
//    @Override
//    public String toString() {
//        return "MultiFileInfo{" +
//                "sworkId='" + sworkId + '\'' +
//                ", name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", lastModifiedDate='" + lastModifiedDate + '\'' +
//                ", size=" + size +
//                ", chunk=" + chunk +
//                ", chunks=" + chunks +
//                ", fileChunk=" + fileChunk +
//                ", saved=" + saved +
//                '}';
//    }
}
