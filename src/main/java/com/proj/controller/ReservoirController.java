package com.proj.controller;

import com.proj.entity.ReservoirBasicInfo;
import com.proj.service.ReservoirBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public List<ReservoirBasicInfo> getReservoirs(){
        return (reservoirBasicInfoService.getReservoirs());
    }
}
