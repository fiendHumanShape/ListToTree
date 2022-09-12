package com.zfb.test;

import com.alibaba.fastjson.JSON;
import com.zfb.entity.TreeEntity;
import com.zfb.uilt.ListToTreeUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于测试
 */
public class TestListToTree {
    public static void main(String[] args) {
        final String filePath = "D:/filePath";//文件路径
        File file = new File(filePath);
        //开始文件格式数据的封装
        List<TreeEntity> folderList = new ArrayList<TreeEntity>();
        ListToTreeUtil.findFileFolder(folderList, file);

        //处理对应的id
        Integer id = 0;
        for (TreeEntity entity : folderList) {
            entity.setId(id.toString());
            id++;
        }
        //对应Pid
        for (TreeEntity entity : folderList) {
            for (TreeEntity entity1 : folderList) {
                File file1 = new File(entity1.getFilePath());
                if (entity.getFilePath().equals(file1.getParent())) {
                    entity1.setParentId(entity.getId());
                }
            }
        }


        List<TreeEntity> nodeTree = ListToTreeUtil.buildTree(folderList, "-1");//-1表示第一层
        //转成JSON数据
        System.out.println(JSON.toJSONString(nodeTree));
    }
}
