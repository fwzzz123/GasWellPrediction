package com.proj.service;


import java.util.Map;

public interface WellDataReceiveService {
    Map<String, String> processWellFormData(Map<String, String> wellInfoMap);
}