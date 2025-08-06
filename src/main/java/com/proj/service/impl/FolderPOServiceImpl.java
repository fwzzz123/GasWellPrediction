package com.proj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.po.FolderPO;
import com.proj.entity.po.WellInfoPO;
import com.proj.service.FolderPOService;
import com.proj.mapper.FolderPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private WellInfoServiceImpl wellInfoService;
    @Override
    public void addFolder(String folderName) {
        FolderPO folderPO = new FolderPO();
        folderPO.setFolderName(folderName);
        folderPO.setCreatedTime(new Date());
        folderPO.setModifiedTime(new Date());
        folderPOMapper.insertOrUpdate(folderPO);
    }

    @Override
    public boolean existsByFolderName(String folderName) {
        return this.count(new LambdaQueryWrapper<FolderPO>()
                .eq(FolderPO::getFolderName, folderName)) > 0;
    }

    @Override
    public boolean removeBatchByFolderNames(List<String> folderNames) {
        return this.remove(new LambdaQueryWrapper<FolderPO>()
                .in(FolderPO::getFolderName, folderNames));
    }

    @Transactional
    @Override
    public boolean renameFolder(String oldFolderName, String newFolderName) {
        if (!existsByFolderName(oldFolderName)) {
            return false;
        }
        if (existsByFolderName(newFolderName)) {
            return false;
        }

        addFolder(newFolderName);

        // 查询是否存在相关的井数据
        boolean hasWellInfo = wellInfoService.count(new LambdaQueryWrapper<WellInfoPO>()
                .eq(WellInfoPO::getFolderName, oldFolderName)) > 0;

        if (hasWellInfo) {
            boolean updated = wellInfoService.update(new LambdaUpdateWrapper<WellInfoPO>()
                    .eq(WellInfoPO::getFolderName, oldFolderName)
                    .set(WellInfoPO::getFolderName, newFolderName));
            if (!updated) {
                throw new RuntimeException("更新井信息失败");
            }
        }


        return removeBatchByFolderNames(Arrays.asList(oldFolderName));
    }

}




