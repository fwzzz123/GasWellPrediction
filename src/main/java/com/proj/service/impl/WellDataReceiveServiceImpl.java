package com.proj.service.impl;

import com.proj.service.WellDataReceiveService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 前端数据接收服务
 * @author fw
 * @date 2025/3/31 下午8:27
 * @version 1.0
 */
@Service
public class WellDataReceiveServiceImpl implements WellDataReceiveService {

    @Override
    public Map<String, String> processWellFormData(Map<String, String> wellInfoMap) {
        // 数据校验
        if (!wellInfoMap.containsKey("wellName") || wellInfoMap.get("wellName").isEmpty()) {
            throw new IllegalArgumentException("井名不能为空");
        }

        if (!wellInfoMap.containsKey("wellType") ||
                (!wellInfoMap.get("wellType").equals("水平") &&
                        !wellInfoMap.get("wellType").equals("定向") &&
                        !wellInfoMap.get("wellType").equals("直井"))) {
            throw new IllegalArgumentException("井类型无效");
        }

        if (!wellInfoMap.containsKey("wellCapacity")) {
            throw new IllegalArgumentException("井产能不能为空");
        }

        try {
            Double.parseDouble(wellInfoMap.get("wellCapacity"));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("井产能必须是数字");
        }

        // 预处理数据，例如去除空格、转换格式等
        Map<String, String> processedData = new HashMap<>(wellInfoMap);
        processedData.put("wellName", wellInfoMap.get("wellName").trim());
        processedData.put("gasReservoir", wellInfoMap.getOrDefault("gasReservoir", "未知气藏"));

        return processedData;
    }
}