package com.proj.utils;

public class NamingUtils {

    // 将下划线命名转换为驼峰命名
    public static String toCamelCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean nextUpperCase = false;

        for (char ch : input.toCharArray()) {
            if (ch == '_') {
                nextUpperCase = true;  // 下划线后的字母转为大写
            } else {
                if (nextUpperCase) {
                    result.append(Character.toUpperCase(ch));  // 转换成大写
                    nextUpperCase = false;
                } else {
                    result.append(Character.toLowerCase(ch));  // 保持小写
                }
            }
        }

        return result.toString();
    }
}

