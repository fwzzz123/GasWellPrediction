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
        // 单位转换常数
        BigDecimal mDToD = BigDecimal.valueOf(0.001);  // 1mD → D
        BigDecimal MPaToPa = BigDecimal.valueOf(1E6);         // 1MPa → Pa

        // 参数获取并转换单位
        BigDecimal cUnit = wellInfoPO.getCUnit();
        BigDecimal k = wellInfoPO.getK().multiply(mDToD);    // 渗透率D
        BigDecimal h = wellInfoPO.getH();                       //储层厚度 (m)
        BigDecimal lambdaGAvg = wellInfoPO.getLambdaG();         // 平均气体流动性 (λ̃g)
        BigDecimal pE = wellInfoPO.getPE().multiply(MPaToPa);    // 边界压力 (Pa)
        BigDecimal pBH = wellInfoPO.getPBH().multiply(MPaToPa);  // 井底压力 (Pa)
        BigDecimal rE = wellInfoPO.getRE();                      // 边界半径 (m)
        BigDecimal rW = wellInfoPO.getRW();                       // 井筒半径 (m)
        BigDecimal fGAvg = wellInfoPO.getFGAvg();                   // 平均气体压缩因子 (f̃g)
        BigDecimal phi = wellInfoPO.getPhi();                         // 孔隙度 (ϕ)
        BigDecimal cG = wellInfoPO.getCG();                      // 气体压缩系数 (c_g),应为1/Pa
        BigDecimal sG = wellInfoPO.getSG();                      // 气体饱和度 (S_g)
        BigDecimal partialPGPartialT = wellInfoPO.getDpGdt(); // 压力对时间的偏导数应为Pa/s

        // 计算对数比
        double logRatio = Math.log(rE.divide(rW, MC).doubleValue());
        BigDecimal logRatioBD = BigDecimal.valueOf(logRatio);

        // 第一部分计算
        BigDecimal part1 = BigDecimal.valueOf(2 * Math.PI)
                .multiply(k)
                .multiply(h)
                .multiply(lambdaGAvg)
                .multiply(pE.subtract(pBH))
                .divide(logRatioBD, MC);

        // θ计算
        BigDecimal theta = phi.multiply(cG)
                .multiply(sG)
                .multiply(partialPGPartialT);

        // 第二部分计算
        BigDecimal part2 = cUnit.multiply(fGAvg)
                .multiply(BigDecimal.valueOf(Math.PI))
                .multiply(h)
                .multiply(theta)
                .multiply(rE.pow(2))
                .divide(BigDecimal.valueOf(2).multiply(logRatioBD), MC);

        // 总和计算
        BigDecimal totalCapacity = part1.add(part2);

        // 结果处理(单位转换)
        return totalCapacity.divide(BigDecimal.valueOf(1E4), MC)
                .setScale(10, RoundingMode.HALF_UP);
    }
}
