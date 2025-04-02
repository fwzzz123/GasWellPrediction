package com.proj.service;

import java.util.Map;

public interface WellDataStorageService {
    int saveWell(Map<String, String> wellInfoMap);
}