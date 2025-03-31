package com.proj.entity;

/**
 * @description: 设计抽象类AbstractData，用于给侧边栏数据进行继承，规定数据格式
 * @author fw
 * @date 2025/3/30 下午10:29
 * @version 1.0
 */
/**
 * 抽象测井数据类，每种测井参数（AC、GR等）都继承它
 */
public abstract class AbstractData {
    protected double depth; // 深度 (DEPT)，主键
    protected double value; // 具体测井值

    public AbstractData(double depth, double value) {
        this.depth = depth;
        this.value = value;
    }

    public double getDepth() {
        return depth;
    }

    public double getValue() {
        return value;
    }

    public abstract String getType(); // 让子类返回具体类型
}