package com.zfb.entity;

import java.util.List;

/**
 * @author zhangFengBo
 * 树形结构实体类
 * 对应关系parentId的父级是id
 */
public class TreeEntity {
    String id;
    String parentId;
    String fileName;
    String filePath;

    public List<TreeEntity> getChildren() {
        return children;
    }

    public void setChildren(List<TreeEntity> children) {
        this.children = children;
    }

    List<TreeEntity> children;

    public String getParentId() {
        return parentId;
    }

    public TreeEntity(String id, String parentId, String fileName, String filePath) {
        this.id = id;
        this.parentId = parentId;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public TreeEntity() {

    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
