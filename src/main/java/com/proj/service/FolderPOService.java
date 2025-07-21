package com.proj.service;

import com.proj.entity.po.FolderPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author L
* @description 针对表【Folder】的数据库操作Service
* @createDate 2025-07-11 15:04:56
*/
public interface FolderPOService extends IService<FolderPO> {

    void addFolder(String folderName);

    boolean existsByFolderName(String folderName);

    boolean removeBatchByFolderNames(List<String> folderNames);

    public boolean renameFolder(String oldFolderName, String newFolderName);
}
