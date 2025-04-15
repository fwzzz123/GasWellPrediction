package com.proj.controller;

import com.proj.entity.po.ReservoirBasicInfoPO;
import com.proj.service.ReservoirBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("reservoir")
public class ReservoirController {
    @Autowired
    private ReservoirBasicInfoService reservoirBasicInfoService;
    //查询气藏信息
    @RequestMapping("/getReservoir")
    public List<ReservoirBasicInfoPO> getReservoirs(){
        return (reservoirBasicInfoService.getReservoirs());
    }

    //插入气藏，并做了插入气藏的冲突处理
    @RequestMapping("/insertReservoir")
    public String addReservoir(@RequestBody ReservoirBasicInfoPO reservoirBasicInfo) {
        try {
            int result = reservoirBasicInfoService.insertReservoirBasicInfo(reservoirBasicInfo);
            if (result == 0) {
                Integer generatedId = reservoirBasicInfo.getReservoirId();
                return "气藏信息插入成功！生成的气藏 ID 为: " + generatedId;
            } else {
                return "气藏信息插入失败！";
            }
        } catch (Exception e) {
            // 这里异常会被全局异常处理器捕获处理，此 catch 块可省略
            throw e;
        }
    }
}
