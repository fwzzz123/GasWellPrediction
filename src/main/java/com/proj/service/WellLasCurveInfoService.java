package com.proj.service;

import com.proj.entity.po.WellLasCurveInfoPO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author L
* @description 针对表【Well_Las_Curve_Info】的数据库操作Service
* @createDate 2025-03-18 15:07:36
*/
public interface WellLasCurveInfoService extends IService<WellLasCurveInfoPO> {

    void savelas(MultipartFile file, String lasInfoId);

    List<WellLasCurveInfoPO> getCurveByLasInfoId(String lasInfoId);
}
