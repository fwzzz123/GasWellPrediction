package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.WellLasInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
/**
* @author L
* @description 针对表【Well_Las_Info】的数据库操作Service
* @createDate 2025-03-21 13:32:45
*/
public interface WellLasInfoService extends IService<WellLasInfo> {

    String savelas(MultipartFile file);

    List<WellLasInfo> getWellLas();

    List<WellLasInfo> getWellLasByWellId(String wellId);

    public List<Map<String, Object>> parseWellHeader(List<MultipartFile> files);

    public List<Map<String, Object>> parseCurveHeader(List<MultipartFile> files);

    void insertWellLogFromParsedHeader(List<MultipartFile> files);

}
