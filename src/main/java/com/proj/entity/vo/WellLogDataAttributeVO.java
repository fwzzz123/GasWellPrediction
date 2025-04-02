package com.proj.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/1 下午1:10
 * @version 1.0
 */

@Data
@TableName("well_log_data_attribute")
public class WellLogDataAttributeVO {
   private Long id;

   private WellLogDataVO wellLogDataVO;
   private String attributeName;

   private String attributeValue;

   public WellLogDataAttributeVO() {}

    public WellLogDataAttributeVO(WellLogDataVO wellLogDataVO, String attributeName, String attributeValue) {
       this.wellLogDataVO = wellLogDataVO;
       this.attributeName = attributeName;
       this.attributeValue = attributeValue;
    }
}