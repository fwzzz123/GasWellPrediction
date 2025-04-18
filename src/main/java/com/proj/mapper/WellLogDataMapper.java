package com.proj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.vo.WellLogDataVO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author L
* @description 针对表【well_log_data】的数据库操作Mapper
* @createDate 2025-04-17 16:33:41
* @Entity com.proj.entity.WellLogData
*/
@Mapper
public interface WellLogDataMapper extends BaseMapper<WellLogDataVO> {

}




