package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.po.FolderPO;
import com.proj.service.FolderPOService;
import com.proj.mapper.FolderPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
* @author L
* @description 针对表【Folder】的数据库操作Service实现
* @createDate 2025-07-11 15:04:56
*/
@Service
public class FolderPOServiceImpl extends ServiceImpl<FolderPOMapper, FolderPO>
    implements FolderPOService{

    @Autowired
    private FolderPOMapper folderPOMapper;
    @Override
    public void addFolder(String folderName) {
        FolderPO folderPO = new FolderPO();
        folderPO.setFolderName(folderName);
        folderPO.setCreatedTime(new Date());
        folderPO.setModifiedTime(new Date());
        folderPOMapper.insertOrUpdate(folderPO);
    }
}




