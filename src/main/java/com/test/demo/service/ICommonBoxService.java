package com.test.demo.service;

import com.test.demo.common.vo.ComBoxData;

import java.util.List;

public interface ICommonBoxService {

    /**
     * 获取父级地区及以下的子集地区
     * @param areaName
     * @return
     */
    List<ComBoxData> getDistrictInfoByArea(String areaName);
}
