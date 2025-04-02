package com.proj.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/1 下午12:48
 * @version 1.0
 */
@Data
@TableName("well_log_data")
public class WellLogDataVO {
   private Long id;

    //关联的测井数据
   private WellLogVO wellLogVO;

   private Double depth;

   private List<WellLogDataAttributeVO> attributes;

   public WellLogDataVO(){}

   public WellLogDataVO(WellLogVO wellLogVO, Double depth) {
       this.wellLogVO = wellLogVO;
       this.depth = depth;
   }
}