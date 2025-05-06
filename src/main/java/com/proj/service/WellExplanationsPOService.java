package com.proj.service;

import com.proj.entity.po.WellExplanationsPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author L
* @description 针对表【well_explanations】的数据库操作Service
* @createDate 2025-04-25 16:41:51
*/
public interface WellExplanationsPOService extends IService<WellExplanationsPO> {

    void saveExplanations(Map<String, Object> data);
}
