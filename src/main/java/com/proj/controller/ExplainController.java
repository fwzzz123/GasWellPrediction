package com.proj.controller;

import com.proj.entity.po.WellExplanationsPO;
import com.proj.entity.vo.WellLogDataVO;
import com.proj.service.WellExplanationsPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/explain")
@CrossOrigin
public class ExplainController {
    @Autowired
    private WellExplanationsPOService explanationsPOService;

    @PostMapping("/save")
    public ResponseEntity<String> saveExplanations(@RequestBody Map<String,Object> data){
        try {
            explanationsPOService.saveExplanations(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok("保存成功");
    }
}
