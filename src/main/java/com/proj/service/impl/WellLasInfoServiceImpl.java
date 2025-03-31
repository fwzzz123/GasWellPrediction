package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.WellLasInfo;
import com.proj.service.WellLasInfoService;
import com.proj.mapper.WellLasInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

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

    @Override
    public int savelas(Map<String, String> wellInfoMap) {
        WellLasInfo wellLasInfo = new WellLasInfo();
        BeanMap beanMap = BeanMap.create(wellLasInfo);
        for(Map.Entry<String,String> entry : wellInfoMap.entrySet()){
            if(beanMap.containsKey(entry.getKey())){
                beanMap.put(entry.getKey(),entry.getValue());
            }
        }
        wellLasInfoMapper.insert(wellLasInfo);
        return (int) wellLasInfo.getLasInfoId();
    }


}




