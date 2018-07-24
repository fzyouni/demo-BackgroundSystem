package com.test.demo.common.vo;

/**
 * vue 下拉框加载数据bean
 *
 * @author Ben
 * @create 2018-07-24 15:24
 **/
public class ComBoxData {
    /**
     * 页面展示值
     */
    private String label;
    /**
     * 实际获取值
     */
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
