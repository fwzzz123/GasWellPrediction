package com.proj.lasTest;


import com.proj.service.WellLogDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WellLogDataServiceImplTest {

    @Autowired
    private WellLogDataService wellLogDataService;

    @BeforeEach
    public void setUp() {
        // 如果需要，可以在此处进行设置
    }

    @Test
    public void selectAllTableHeaders_ExcludesIdAndWellLogId() {
        List<String> headers = wellLogDataService.selectAllTableHeaders();

        // 验证 "id" 和 "wellLogId" 不在列表中
        assertFalse(headers.contains("id"), "Headers should not contain 'id'");
        assertFalse(headers.contains("wellLogId"), "Headers should not contain 'wellLogId'");

        // 验证其他字段名称在列表中
        assertTrue(headers.contains("curveName"), "Headers should contain 'curveName'");
        assertTrue(headers.contains("curveUnit"), "Headers should contain 'curveUnit'");
        assertTrue(headers.contains("curveType"), "Headers should contain 'curveType'");
        assertTrue(headers.contains("curveDescription"), "Headers should contain 'curveDescription'");
        assertTrue(headers.contains("curveData"), "Headers should contain 'curveData'");
    }
}
