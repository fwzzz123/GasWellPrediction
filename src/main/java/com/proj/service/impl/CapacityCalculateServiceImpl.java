package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.po.WellInfoPO;
import com.proj.mapper.CapacityCalculateMapper;
import com.proj.service.CapacityCalculateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class CapacityCalculateServiceImpl extends ServiceImpl<CapacityCalculateMapper, WellInfoPO>
        implements CapacityCalculateService {

    // 可定义一个公共的MathContext用于统一精度控制
    private static final MathContext MC = new MathContext(10, RoundingMode.HALF_UP);

    @Override
    public BigDecimal calculateSteadyStateCapacity(WellInfoPO wellInfoPO) {

        // 参数获取
        BigDecimal cUnit = wellInfoPO.getCUnit();     // 单位转换系数
        BigDecimal k = wellInfoPO.getK();             // 渗透率 (mD)
        BigDecimal h = wellInfoPO.getH();             // 储层厚度 (m)
        BigDecimal lambdaGAvg = wellInfoPO.getLambdaG(); // 平均气体流动性 (λ̃g)
        BigDecimal pE = wellInfoPO.getPE();           // 边界压力 (MPa)
        BigDecimal pBH = wellInfoPO.getPBH();         // 井底压力 (MPa)
        BigDecimal rE = wellInfoPO.getRE();           // 边界半径 (m)
        BigDecimal rW = wellInfoPO.getRW();           // 井筒半径 (m)
        BigDecimal fGAvg = wellInfoPO.getFGAvg();     // 平均气体压缩因子 (f̃g)
        BigDecimal phi = wellInfoPO.getPhi();         // 孔隙度 (ϕ)

        // 计算公式中的 ln(r_E / r_w)
        double logRatio = Math.log(rE.divide(rW, MC).doubleValue());

        // 第一部分：2π K h λ̃g * (p_E - p_BH) / ln(r_E / r_w)
        BigDecimal part1 = BigDecimal.valueOf(2 * Math.PI)
                .multiply(k)
                .multiply(h)
                .multiply(lambdaGAvg)
                .multiply(pE.subtract(pBH))
                .divide(BigDecimal.valueOf(logRatio), MC);

        // 第二部分：f̃g * π h ϕ * r_E^2 / [2(ln(r_E) - ln(r_w))]
        BigDecimal part2 = fGAvg
                .multiply(BigDecimal.valueOf(Math.PI))
                .multiply(h)
                .multiply(phi)
                .multiply(rE.pow(2))
                .divide(BigDecimal.valueOf(2 * logRatio), MC);

        // 总体产能计算
        return cUnit.multiply(part1.add(part2)).setScale(10, RoundingMode.HALF_UP);

    }
}
