package com.proj.lasTest;

import com.proj.controller.LASController;
import com.proj.entity.po.WellLasPO;
import com.proj.service.WellInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LASControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WellInfoService wellInfoService;

    @InjectMocks
    private LASController lasController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(lasController).build();
    }

    @Test
    public void uploadFile_SuccessfulUpload_ReturnsSuccessResponse() throws Exception {
        MultipartFile file = new MockMultipartFile("file", "test.las", MediaType.MULTIPART_FORM_DATA_VALUE, "test content".getBytes());
        WellLasPO wellLasPO = new WellLasPO();
        wellLasPO.setId(1L);

        doNothing().when(wellInfoService).insertWellLAS(any(WellLasPO.class));

        mockMvc.perform(multipart("/import/upload")
                        .file((MockMultipartFile) file))
                .andExpect(status().isOk())
                .andExpect(content().string("文件上传并存入数据库成功，井ID：" + wellLasPO.getId()));

        verify(wellInfoService, times(1)).insertWellLAS(any(WellLasPO.class));
    }

    @Test
    public void uploadFile_IOExceptionOccurs_ReturnsErrorResponse() throws Exception {
        MultipartFile file = new MockMultipartFile("file", "test.las", MediaType.MULTIPART_FORM_DATA_VALUE, "test content".getBytes());

        doThrow(new IOException("IO Exception")).when(wellInfoService).insertWellLAS(any(WellLasPO.class));

        mockMvc.perform(multipart("/import/upload")
                        .file((MockMultipartFile) file))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("文件上传失败: IO Exception"));

        verify(wellInfoService, times(1)).insertWellLAS(any(WellLasPO.class));
    }
}
