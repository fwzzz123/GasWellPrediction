package com.proj.controller;

import com.proj.entity.po.WellExplanationsPO;
import com.proj.entity.vo.WellLogDataVO;
import com.proj.service.WellExplanationsPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/explain")
@CrossOrigin
public class ExplainController {
    @Autowired
    private WellExplanationsPOService explanationsPOService;

    @PostMapping("/save")
    public Map<String, Object> saveExplanations(@RequestBody Map<String,Object> data){
        System.out.println(data);
        Map<String, Object> response = new HashMap<>();
        try {
            explanationsPOService.saveExplanations(data);
        }catch (Exception e){
            response.put("code", 1);
            e.printStackTrace();
            return response;
        }
        response.put("code", 0);
        return response;
    }
    @GetMapping("/hello")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String helloHttps() {
        return "Hello, this is a protected resource for ADMIN only!";
    }
}
