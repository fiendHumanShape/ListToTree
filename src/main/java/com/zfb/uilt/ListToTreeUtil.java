package com.zfb.uilt;

import com.zfb.entity.TreeEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangFengBo
 * start
 * 1.将电脑目录中文件读取到并转换成list形式
 * 2.从list形式转换为树结构形式
 * 3.树结构转换为json形式
 * end
 */
public class ListToTreeUtil {

    /**
     * @param folderList 封装文件夹信息
     * @param uploadFile 读取文件目录的路径
     */
    public static void findFileFolder(List<TreeEntity> folderList, File uploadFile) {
        if (folderList.size() == 0) {
            TreeEntity record = new TreeEntity();
            record.setFileName(uploadFile.getName());
            record.setFilePath(uploadFile.getPath());
            record.setParentId("-1");
            folderList.add(record);
        }
        if (uploadFile.isDirectory()) {
            File[] files = uploadFile.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    TreeEntity record = new TreeEntity();
                    record.setFilePath( file.getPath());
                    record.setFileName(file.getName());
                    folderList.add(record);
                }
                findFileFolder(folderList, file);
            }
        }
    }


    /**
     * 将数据转换成树结构
     * */
    public static List<TreeEntity> buildTree(List<TreeEntity> list, String pid){
        List<TreeEntity> tree=new ArrayList<TreeEntity>();
        for(TreeEntity node:list){
            if(node.getParentId().equals(pid)){
                tree.add(findChild(node,list));
            }
        }
        return tree;
    }

    static TreeEntity findChild(TreeEntity node, List<TreeEntity> list){
        for(TreeEntity n:list){
            if(n.getParentId().equals(node.getId())){
                if(node.getChildren() == null){
                    node.setChildren(new ArrayList<TreeEntity>());
                }
                node.getChildren().add(findChild(n,list));
            }
        }
        return node;
    }



}
