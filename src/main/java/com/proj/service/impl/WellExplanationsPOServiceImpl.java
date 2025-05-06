package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.po.WellExplanationsPO;
import com.proj.service.WellExplanationsPOService;
import com.proj.mapper.WellExplanationsPOMapper;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author L
* @description 针对表【well_explanations】的数据库操作Service实现
* @createDate 2025-04-25 16:41:51
*/
@Service
public class WellExplanationsPOServiceImpl extends ServiceImpl<WellExplanationsPOMapper, WellExplanationsPO>
    implements WellExplanationsPOService{

    @Autowired
    private WellExplanationsPOMapper wellExplanationsPOMapper;

    @Override
    public void saveExplanations(Map<String, Object> data) {
        List<Map<String,Object>> log_data = (List<Map<String, Object>>) data.get("log_data");
        String wellId = (String) data.get("well_name");
        int logType = (int) data.get("log_type");
        List<WellExplanationsPO> wellExplanationsPOList = new ArrayList<>();

        for (Map<String,Object> map : log_data){
            wellExplanationsPOList.add(mapToEntity(map,wellId,logType));
        }
        this.saveBatch(wellExplanationsPOList);
        wellExplanationsPOList.clear();
    }
    public WellExplanationsPO mapToEntity(Map<String,Object> ExplainInfoMap,String wellId,int logType){
        WellExplanationsPO wellExplanationsPO = new WellExplanationsPO();
        BeanMap beanMap = BeanMap.create(wellExplanationsPO);
        beanMap.put("wellId",wellId);
        beanMap.put("logType",logType);
        for (Map.Entry<String,Object> entry : ExplainInfoMap.entrySet()){
            if(beanMap.containsKey(NamingUtils.toCamelCase(entry.getKey()))){
                if(entry.getKey().equals("oil_level") || entry.getKey().equals("lithology") || entry.getKey().equals("conclusion")){
                    beanMap.put(NamingUtils.toCamelCase(entry.getKey()),entry.getValue());
                }else {
                    beanMap.put(NamingUtils.toCamelCase(entry.getKey()),Double.valueOf(String.valueOf(entry.getValue())));
                }

            }
        }
        return wellExplanationsPO;
    }
}




