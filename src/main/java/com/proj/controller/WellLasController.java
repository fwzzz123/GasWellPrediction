package com.proj.controller;

import com.proj.entity.WellLasInfo;
import com.proj.service.WellLasInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("wellLas")
public class WellLasController {
    @Autowired
    private WellLasInfoService wellLasInfoService;

    //查询测井信息（起始深度，步长等信息）
    @RequestMapping("/getWellLas")
    public List<WellLasInfo> getWellLas(){
        return wellLasInfoService.getWellLas();
    }

    //根据wellId查询测井信息（起始深度，步长等信息）
    @RequestMapping("/getWellLasByWellId")
    public List<WellLasInfo> getWellLasByWellId(@RequestParam("wellId") String wellId){
        return wellLasInfoService.getWellLasByWellId(wellId);
    }


}
