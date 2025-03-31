package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.WellLasInfo;

import java.util.Map;
/**
* @author L
* @description 针对表【Well_Las_Info】的数据库操作Service
* @createDate 2025-03-21 13:32:45
*/
public interface WellLasInfoService extends IService<WellLasInfo> {

    int savelas(Map<String, String> wellInfoMap);

}
