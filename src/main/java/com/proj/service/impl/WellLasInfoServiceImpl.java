package com.proj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.WellLasInfo;
import com.proj.mapper.WellLasInfoMapper;
import com.proj.mapper.WellMapper;
import com.proj.service.WellLasInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author L
* @description 针对表【Well_Las_Info】的数据库操作Service实现
* @createDate 2025-03-21 13:32:45
*/
@Service
public class WellLasInfoServiceImpl extends ServiceImpl<WellLasInfoMapper, WellLasInfo>
    implements WellLasInfoService{

    @Autowired
    private WellLasInfoMapper wellLasInfoMapper;

    @Autowired
    private WellMapper wellMapper;

    @Override
    public int savelas(Map<String, String> wellInfoMap) {
        WellLasInfo wellLasInfo = new WellLasInfo();
        BeanMap beanMap = BeanMap.create(wellLasInfo);
        for(Map.Entry<String,String> entry : wellInfoMap.entrySet()){
            if(beanMap.containsKey(entry.getKey())){
                beanMap.put(entry.getKey(),entry.getValue());
            }
        }

        try {
            wellLasInfoMapper.insert(wellLasInfo);
        }catch (DuplicateKeyException e){
            throw new RuntimeException("相同 well_id 及字段的记录已存在，无法重复添加");
        }

        return (int) wellLasInfo.getLasInfoId();
    }

    @Override
    public List<WellLasInfo> getWellLas() {
        return wellLasInfoMapper.selectList(null);
    }

    @Override
    public List<WellLasInfo> getWellLasByWellId(String wellId) {
        LambdaQueryWrapper<WellLasInfo> lambdaQuery = new LambdaQueryWrapper<>();
        lambdaQuery.eq(WellLasInfo::getWellId, wellId);
        return wellLasInfoMapper.selectList(lambdaQuery);
    }


}




