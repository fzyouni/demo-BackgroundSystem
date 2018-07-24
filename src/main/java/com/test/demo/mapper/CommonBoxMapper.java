package com.test.demo.mapper;

import com.test.demo.common.vo.ComBoxData;

import java.util.List;

/**
 * 下拉框数据数据库获取
 *
 * @author Ben
 * @create 2018-07-24 15:31
 **/
public interface CommonBoxMapper {
    /**
     * 根据地区获取到下一级所有地区信息（包括父节点）
     * @param areaName
     * @return
     */
    List<ComBoxData> getDistrictInfosByArea(String areaName);
}
