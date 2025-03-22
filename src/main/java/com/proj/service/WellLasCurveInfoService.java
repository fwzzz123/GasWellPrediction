package com.proj.service;

import com.proj.entity.WellLasCurveInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
* @author L
* @description 针对表【Well_Las_Curve_Info】的数据库操作Service
* @createDate 2025-03-18 15:07:36
*/
public interface WellLasCurveInfoService extends IService<WellLasCurveInfo> {

    void savelas(MultipartFile file, int lasInfoId);
}
