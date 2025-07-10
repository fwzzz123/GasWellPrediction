package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbase8.util.KSQLException;
import com.proj.entity.dto.WellInfoDTO;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLasPO;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.entity.po.WellPO;
import com.proj.mapper.LASMapper;
import com.proj.mapper.WellInfoMapper;
import com.proj.mapper.WellLasInfoMapper;
import com.proj.mapper.WellMapper;
import com.proj.service.WellInfoService;
import com.proj.utils.exception.DuplicateFileNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author L
* @description 针对表【Well_Info】的数据库操作Service实现
* @createDate 2025-03-18 14:40:26
*/
@Service
public class WellInfoServiceImpl extends ServiceImpl<WellInfoMapper, WellInfoPO> implements WellInfoService{

    @Autowired
    private LASMapper lasMapper;
    @Autowired
    private WellInfoMapper wellInfoMapper;

    @Autowired
    private WellLasInfoMapper wellLasInfoMapper;

    @Autowired
    private WellMapper wellMapper;

    //这个函数不应该在这里。TODO mark
    @Override
    public void insertWellLAS(WellLasPO wellLasPO) {
        try{
            lasMapper.insertWellLAS(wellLasPO);
        } catch  (DataIntegrityViolationException e){
            if(e.getCause() instanceof KSQLException){
                KSQLException ksqlEx = (KSQLException) e.getCause();
                if (ksqlEx.getMessage().contains("unique_las_name")){
                    throw new DuplicateFileNameException("文件'" + wellLasPO.getName() + "'已存在");
                }
            }
            throw e;
        }
    }

    @Override
    public WellLasPO getById(Long id) {
        return lasMapper.getWellLASById(id);
    }

    public void updateWellIds() {
        int updatedRows = wellLasInfoMapper.updateWellIdInLasInfo();
        System.out.println("更新成功: " + updatedRows + " 行");
    }

    @Override
    public int insertMissingWells() {
        // 1. 获取 Well_Las_Info 表中的所有 WELL 名称
        List<String> wellNamesFromLasInfo = wellLasInfoMapper.getAllWellNames();

        // 2️. 获取 Well 表中的所有井名
        List<String> existingWellNames = wellMapper.getAllWellNames();

        // 3.  计算需要插入的井名
        List<String> wellsToInsert = wellNamesFromLasInfo.stream()
                .filter(wellName -> !existingWellNames.contains(wellName))
                .collect(Collectors.toList());

        // 4. 插入缺失的井数据
        int insertedCount = 0;
        for (String wellName : wellsToInsert) {
            WellPO wellPO = new WellPO();
            wellPO.setWellName(wellName);

            // 使用 ON CONFLICT 防止并发插入
            try {
                insertedCount += wellMapper.insertWell(wellPO);
            } catch (DataIntegrityViolationException e) {
                // 忽略重复插入错误
                System.out.println("井名已存在，跳过: " + wellName);
            }
        }
        return insertedCount;
    }



    @Override
    public boolean insert(WellInfoPO wellInfo) {
        wellInfoMapper.insert(wellInfo);
        return false;
    }

    @Override
    public WellInfoPO getByWellName(String wellName) {
        return wellInfoMapper.getByWellName(wellName);
    }

    @Override
    public void insertCurveMapping(List<WellLogCurveMappingPO> mappingList) {
        LocalDateTime now = LocalDateTime.now();
        for (WellLogCurveMappingPO mapping : mappingList) {
            mapping.setCreateTime(now);
            mapping.setUpdateTime(now);
            // 这里使用 Mapper 直接插入
            wellInfoMapper.insertCurveMapping(mapping);
        }
    }

    @Override
    public boolean existsByWellId(String wellId) {
        return wellInfoMapper.existsByWellId(wellId);
    }

    @Override
    public void createWellInfo(WellInfoPO wellInfo) {
        wellInfoMapper.insert(wellInfo);
    }

    @Override
    public void deleteWellInfo(String wellId) {
        wellInfoMapper.deleteByWellId(wellId);
    }

    @Override
    public void updateWellInfo(WellInfoPO wellInfo) {
        wellInfoMapper.updateByWellId(wellInfo);
    }

    @Override
    public WellInfoPO queryWellInfo(String wellId) {
        return wellInfoMapper.selectByWellId(wellId);
    }

    @Override
    public List<WellInfoPO> queryWellInfoList(List<String> wellIds) {
        return wellInfoMapper.selectBatchIds(wellIds);
    }

    @Override
    public boolean addWellInfo(WellInfoDTO dto) {
        WellInfoPO po = new WellInfoPO();
        po = convertToPO(dto);

        System.out.println("生成的 PO: " + po); // 👈 打印 PO 内容


        return wellInfoMapper.insert(po) > 0;

    }

    @Override
    public List<WellInfoDTO> convertToWellInfoDTOList(List<WellInfoPO> wellInfoPOs) {
        return wellInfoPOs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList()); // 替代 .toList()
    }

    @Override
    public WellInfoDTO convertToDTO(WellInfoPO po) {
        if (po == null) return null;
        WellInfoDTO dto = new WellInfoDTO();
        dto.setWellId(po.getWellId());
        dto.setReservoirId(po.getReservoirId());
        dto.setCapacity(po.getCapacity());
        dto.setWellType(po.getWellType());
        dto.setWellCoordinates(po.getWellCoordinates());
        dto.setSection(po.getSection());
        dto.setMudContent(po.getMudContent());
        dto.setCUnit(po.getCUnit());
        dto.setK(po.getK());
        dto.setH(po.getH());
        dto.setLambdaGAvg(po.getLambdaGAvg());
        dto.setPE(po.getPE());
        dto.setPBH(po.getPBH());
        dto.setRE(po.getRE());
        dto.setRW(po.getRW());
        dto.setFGAvg(po.getFGAvg());
        dto.setPhi(po.getPhi());
        dto.setLambdaWAvg(po.getLambdaWAvg());
        dto.setKRg(po.getKRg());
        dto.setMuG(po.getMuG());
        dto.setBG(po.getBG());
        dto.setCG(po.getCG());
        dto.setSG(po.getSG());
        dto.setDpGdt(po.getDpGdt());
        dto.setSW(po.getSW());
        dto.setDSWdt(po.getDSWdt());
        dto.setTheta(po.getTheta());
        return dto;
    }

    @Override
    public WellInfoPO convertToPO(WellInfoDTO dto) {
        WellInfoPO po = new WellInfoPO();
        po.setWellId(dto.getWellId());
        po.setReservoirId(dto.getReservoirId());
        po.setCapacity(dto.getCapacity());
        po.setWellType(dto.getWellType());
        po.setWellCoordinates(dto.getWellCoordinates());
        po.setSection(dto.getSection());
        po.setMudContent(dto.getMudContent());

        po.setCUnit(dto.getCUnit());
        po.setK(dto.getK());
        po.setH(dto.getH());
        po.setLambdaGAvg(dto.getLambdaGAvg());
        po.setPE(dto.getPE());
        po.setPBH(dto.getPBH());
        po.setRE(dto.getRE());
        po.setRW(dto.getRW());

        po.setFGAvg(dto.getFGAvg());
        po.setPhi(dto.getPhi());
        po.setLambdaWAvg(dto.getLambdaWAvg());
        po.setKRg(dto.getKRg());
        po.setMuG(dto.getMuG());
        po.setBG(dto.getBG());
        po.setCG(dto.getCG());
        po.setSG(dto.getSG());
        po.setDpGdt(dto.getDpGdt());
        po.setSW(dto.getSW());
        po.setDSWdt(dto.getDSWdt());
        po.setTheta(dto.getTheta());

        return po;
    }


    /*
    * @陈
    * 返回所有井名
    * */
    @Override
    public List<String> getAllWellIds() {
        return wellInfoMapper.selectAllWellIds();
    }



//这里有逻辑错误，在这个时候ID还没有被插入，所以不存在ID
//    @Override
//    public boolean saveCurveMappings(List<CurveMappingDTO> mappingList) {
//        if (mappingList == null || mappingList.isEmpty()) {
//            return false;
//        }
//
//        LocalDateTime now = LocalDateTime.now();
//        List<WellLogCurveMappingPO> allMappings = new ArrayList<>();
//
//        for (CurveMappingDTO fileMapping : mappingList) {
//            Long wellLogId = getWellLogIdByFileName(fileMapping.getFileName());
//            if (wellLogId == null) continue;
//
//            for (CurveMappingDTO.CurveDTO curve : fileMapping.getCurves()) {
//                WellLogCurveMappingPO mappingPO = new WellLogCurveMappingPO();
//                mappingPO.setWellLogId(wellLogId);
//                mappingPO.setLasCurveName(curve.getLasCurveName());
//                mappingPO.setStandardFieldName(curve.getStandardFieldName());
//                mappingPO.setCreateTime(now);
//                mappingPO.setUpdateTime(now);
//                allMappings.add(mappingPO);
//            }
//        }
//
//        if (!allMappings.isEmpty()) {
//            insertCurveMapping(allMappings);
//        }
//
//        return true;
//    }
//
//    @Override
//    public void insert(WellInfoPO wellInfo) {
//        wellInfoMapper.insert(wellInfo);
//    }
}




