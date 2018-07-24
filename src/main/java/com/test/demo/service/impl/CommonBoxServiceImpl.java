package com.test.demo.service.impl;

import com.test.demo.common.vo.ComBoxData;
import com.test.demo.mapper.CommonBoxMapper;
import com.test.demo.service.ICommonBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 下拉框的数据接口业务处理
 *
 * @author Ben
 * @create 2018-07-24 15:29
 **/
@Service
public class CommonBoxServiceImpl implements ICommonBoxService {

    @Autowired
    private CommonBoxMapper commonBoxMapper;

    @Override
    public List<ComBoxData> getDistrictInfoByArea(String areaName) {
        return commonBoxMapper.getDistrictInfosByArea(areaName);
    }
}
