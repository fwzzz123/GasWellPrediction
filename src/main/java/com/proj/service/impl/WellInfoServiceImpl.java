package com.proj.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbase8.util.KSQLException;
import com.proj.entity.dto.WellInfoDTO;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLasPO;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.mapper.LASMapper;
import com.proj.mapper.WellInfoMapper;
import com.proj.mapper.WellLasInfoMapper;
import com.proj.service.WellInfoService;
import com.proj.utils.exception.DuplicateFileNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

    //不该在这个service
    @Override
    public WellLasPO getById(Long id) {
        return lasMapper.getWellLASById(id);
    }

    //不该在这个service
    public void updateWellIds() {
        int updatedRows = wellLasInfoMapper.updateWellIdInLasInfo();
        System.out.println("更新成功: " + updatedRows + " 行");
    }



    @Override
    public boolean insert(WellInfoPO wellInfo) {
        wellInfoMapper.insert(wellInfo);
        return false;
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
    public ResponseEntity<String> deleteWellInfo(String wellId) {
        // 使用 MyBatis Plus 的 remove 方法删除
        boolean success = this.removeById(wellId);

        if (success) {
            return ResponseEntity.ok("1"); // 表示删除成功
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("0"); // 表示未找到该记录
        }
    }

    @Override
    public boolean updateWellInfo(WellInfoPO wellInfo) {
        if (wellInfo == null || wellInfo.getWellId() == null) {
            return false;
        }

        UpdateWrapper<WellInfoPO> updateWrapper = new UpdateWrapper<WellInfoPO>()
                .eq("well_id", wellInfo.getWellId());

        boolean hasUpdateFields = false;

        // 获取所有字段（包括父类）
        List<Field> fields = new ArrayList<>();
        Class<?> clazz = wellInfo.getClass();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(wellInfo);

                if (value != null && !"wellId".equals(field.getName())) {
                    String columnName = field.getName(); // 默认使用字段名

                    // 检查是否包含 @TableField 注解
                    if (field.isAnnotationPresent(com.baomidou.mybatisplus.annotation.TableField.class)) {
                        com.baomidou.mybatisplus.annotation.TableField tableField =
                                field.getAnnotation(com.baomidou.mybatisplus.annotation.TableField.class);

                        // 如果有自定义列名，则使用它
                        if (!tableField.value().isEmpty()) {
                            columnName = tableField.value();
                        } else {
                            // 否则使用默认的驼峰转下划线逻辑
                            columnName = StringUtils.camelToUnderline(field.getName());
                        }
                    } else {
                        // 如果没有 @TableField 注解，默认驼峰转下划线
                        columnName = StringUtils.camelToUnderline(field.getName());
                    }

                    updateWrapper.set(columnName, value);
                    hasUpdateFields = true;
                }
            } catch (IllegalAccessException ignored) {
            }
        }

        return hasUpdateFields && wellInfoMapper.update(null, updateWrapper) > 0;
    }

    // 辅助方法：驼峰转下划线
    public static String camelToUnderline(String str) {
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    // 获取类及其父类的所有字段（包括私有字段）
    private Field[] getAllFields(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {
            Field[] superFields = getAllFields(superClass);
            Field[] combined = Arrays.copyOf(declaredFields, declaredFields.length + superFields.length);
            System.arraycopy(superFields, 0, combined, declaredFields.length, superFields.length);
            return combined;
        }
        return declaredFields;
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
//        dto.setReservoirId(po.getReservoirId());
        dto.setCapacity(po.getCapacity());
        dto.setWellType(po.getWellType());
        dto.setMudContent(po.getMudContent());
        dto.setCUnit(po.getCUnit());
        dto.setK(po.getK());
        dto.setH(po.getH());
        dto.setLambdaGAvg(po.getLambdaGAvg());
        dto.setPE(po.getPE());
        dto.setPBh(po.getPBH());
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
        dto.setFolderName(po.getFolderName());

        dto.setLogPorosity(po.getLogPorosity());
        dto.setEffectiveHorizontalLength(po.getEffectiveHorizontalLength());

        dto.setC1Content(po.getC1Content());
        dto.setC2Content(po.getC2Content());
        dto.setC3Content(po.getC3Content());
        dto.setC4PlusContent(po.getC4PlusContent());
        dto.setCO2COntent(po.getCO2Content());
        dto.setN2Content(po.getN2Content());
        dto.setTemperature(po.getTemperature());


        return dto;
    }

    @Override
    public WellInfoPO convertToPO(WellInfoDTO dto) {
        WellInfoPO po = new WellInfoPO();
        po.setWellId(dto.getWellId());
        po.setCapacity(dto.getCapacity());
        po.setWellType(dto.getWellType());
        po.setMudContent(dto.getMudContent());

        po.setCUnit(dto.getCUnit());
        po.setK(dto.getK());
        po.setH(dto.getH());
        po.setLambdaGAvg(dto.getLambdaGAvg());
        po.setPE(dto.getPE());
        po.setPBH(dto.getPBh());
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

        po.setFolderName(dto.getFolderName());

        // 新增字段
        po.setLogPorosity(dto.getLogPorosity());
        po.setEffectiveHorizontalLength(dto.getEffectiveHorizontalLength());
        po.setC1Content(dto.getC1Content());
        po.setC2Content(dto.getC2Content());
        po.setC3Content(dto.getC3Content());
        po.setC4PlusContent(dto.getC4PlusContent());
        po.setCO2Content(dto.getCO2COntent());
        po.setN2Content(dto.getN2Content());
        po.setTemperature(dto.getTemperature());
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




