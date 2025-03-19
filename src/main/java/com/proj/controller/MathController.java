package com.proj.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class MathController {

    private final RestTemplate restTemplate;

    public MathController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/calculateSquare")
    public ResponseEntity<String> calculateSquare(@RequestBody NumberRequest request) {
        try {
            System.out.println("Received request: " + request.getNumber());  // 打印请求数据
            String flaskUrl = "http://localhost:5000/square";
            ResponseEntity<SquareResponse> response = restTemplate.postForEntity(flaskUrl, request, SquareResponse.class);
            double result = response.getBody().getResult();
            return ResponseEntity.ok(Double.toString(result));
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常堆栈
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}

class NumberRequest {
    private int number;

    // getters and setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
class SquareResponse {
    private double result; // 改为 double 类型

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}