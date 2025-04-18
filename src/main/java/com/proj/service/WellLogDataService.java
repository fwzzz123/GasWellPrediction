package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.vo.WellLogDataVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author L
* @description 针对表【well_log_data】的数据库操作Service
* @createDate 2025-04-17 16:33:41
*/
public interface WellLogDataService extends IService<WellLogDataVO> {

    ResponseEntity<String> ac_mapping_savewelllogdata(List<MultipartFile> files);
}
