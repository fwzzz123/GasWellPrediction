
@Override
public void insertWellLogFromParsedHeader(List<Map<String, Object>> parsedHeaders) {
    if (parsedHeaders == null || parsedHeaders.isEmpty()) {
        return;
    }

    for (Map<String, Object> header : parsedHeaders) {
        String fileName = (String) header.get("fileName");
        Map<String, Object> wellHeader = (Map<String, Object>) header.get("wellHeader");

        // 提取字段
        String wellId = fileName;
        String id = fileName.split("\\(")[0]; // 提取文件名部分
        Double startDepth = parseDepth((String) wellHeader.get("strt"));
        Double endDepth = parseDepth((String) wellHeader.get("stop"));
        Double step = parseStep((String) wellHeader.get("step"));

        // 创建 WellLogPO 对象
        WellLogPO wellLogPO = new WellLogPO();
        wellLogPO.setId(id);
        wellLogPO.setWellId(wellId);
        wellLogPO.setStartDepth(startDepth);
        wellLogPO.setEndDepth(endDepth);
        wellLogPO.setStep(step);
        wellLogPO.setCreateTime(LocalDateTime.now());
        wellLogPO.setUpdateTime(LocalDateTime.now());

        // 插入数据库
        wellLogMapper.insert(wellLogPO);
    }
}

/**
 * 解析深度字段（去除前缀 M 并转换为数值）
 * @param value 原始值
 * @return 解析后的数值
 */
private Double parseDepth(String value) {
    if (value == null || !value.startsWith("M")) {
        return null;
    }
    return Double.parseDouble(value.substring(1));
}

/**
 * 解析步长字段（去除前缀 M 并转换为数值）
 * @param value 原始值
 * @return 解析后的数值
 */
private Double parseStep(String value) {
    if (value == null || !value.startsWith("M")) {
        return null;
    }
    return Double.parseDouble(value.substring(1));
}
