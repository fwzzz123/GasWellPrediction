package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.po.WellInfoPO;

import java.math.BigDecimal;

public interface CapacityCalculateService extends IService<WellInfoPO> {

    BigDecimal calculateSteadyStateCapacity(WellInfoPO wellInfoPO);

}
