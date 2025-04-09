package com.proj.controller;

import com.proj.entity.WellLasCurveInfo;
import com.proj.service.WellLasCurveInfoService;
import com.proj.service.WellLasInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curve")
@CrossOrigin
public class CurveController {
    @Autowired
    private WellLasInfoService wellLasInfoService;

    @Autowired
    private WellLasCurveInfoService wellLasCurveInfoService;

    //根据lasInfoId外键查询curve信息
    @RequestMapping("getCurveByLasInfoId")
    public List<WellLasCurveInfo> getCurveByLasInfoId(@RequestParam("lasInfoId") int lasInfoId){
        return wellLasCurveInfoService.getCurveByLasInfoId(lasInfoId);
    }
}
